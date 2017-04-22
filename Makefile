JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: HelloMessage.class HelloWorld2.class

default: $(CLASSES)

clean:
	rm *.class
