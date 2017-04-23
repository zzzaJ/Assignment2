BIN = bin
SRC = src
TEST = test
DOC = doc

runtests = java -cp .:/home/dino/cs2001f/Assignment2/Assignment2/bin:/home/dino/cs2001f/JUnit/junit-4.12.jar:/home/dino/cs2001f/JUnit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestSearchAVL TestDirectoryNode

JAVAC = javac
JFLAGS = -g -d $(BIN) -cp $(BIN):$(JUNIT)
LIB = lib
TOOLS = $(LIB)/tools
CLI = $(LIB)/cli/commons-cli-1.3.1.jar
ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar

DOCFILES = ./src/SearchAVL.java ./src/DirectoryNode.java 

JUNIT =/home/dino/cs2001f/JUnit/junit-4.12.jar:/home/dino/cs2001f/JUnit/hamcrest-core-1.3.jar
JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:

vpath %.java $(SRC):$(TEST)

vpath %.class $(BIN):$(TEST)

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

CLASSES = BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class  BinarySearchTree.class \
	  DirectoryNode.class AVLTree.class SearchAVL.class TestSearchAVL.class TestDirectoryNode.class

classes: $(CLASSES:.java=.class)

#The following creates the .class files for the tests and moves them to \test\. so that the tests can run with pre-specified testdata and queries files, in order to test functionality.

test_class: classes TestSearchAVL.class \
	    TestDirectoryNode.class
	mv ./bin/Test*.class ./test/

test: test_class
	$(runtests)

doc: $(BIN)
	javadoc -d $(DOC) -cp $(BIN) $(DOCFILES)  

jacoco.exec: test_class
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(BIN):$(JUNIT) org.junit.runner.JUnitCore TestSearchAVL TestDirectoryNode

report: jacoco.exec
	java -cp $(BIN):$(TEST):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

clean:
	rm -rf $(BIN)/*.class $(DOC)/* $(TEST)/*.class
