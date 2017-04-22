import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestBinarySearchTree {

    BinarySearchTree bst1;
    BinarySearchTree bst2;
    BinarySearchTree bst3;
    BinarySearchTree bst4;
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before public void setUp(){
        
       bst1 = new BinarySearchTree();
       bst2 = new BinarySearchTree();
       bst3 = new BinarySearchTree();
       bst4 = new BinarySearchTree();
       System.setOut(new PrintStream(outContent));
        
    }
    
    @Test public void testAddNodes(){ //Test to determine if an added node is actually added by searching for it 
        
        bst1.addNode("aTestName", "aTestEntry");
        bst1.addNode("bTestName", "bTestEntry");
        bst1.addNode("cTestName", "cTestEntry");
        assertEquals("cTestEntry", bst1.findNode("cTestName"));
        
    }
    
    @Test public void testSearchNodesNotFound(){ //Test to determine if non-existing node is not found when searched for
        
        bst2.addNode("aTestName", "aTestEntry");
        bst2.addNode("bTestName", "bTestEntry");
        bst2.addNode("cTestName", "cTestEntry");
        assertNotEquals("dTestEntry", bst1.findNode("dTestName"));
        
    }
    
    @Test public void testSearchNodesFound(){ //Test to determine if existing node can be found when searched for
        
        bst3.addNode("aTestName", "aTestEntry");
        bst3.addNode("bTestName", "bTestEntry");
        bst3.addNode("cTestName", "cTestEntry");
        assertEquals("bTestEntry", bst3.findNode("bTestName"));
        
    }
    
    @Test public void testInOrderPrint(){ //Test to determine if inOrder traversal is working as expected
        
       bst4.addNode("aTestName", "aTestEntry");
       bst4.addNode("bTestName", "bTestEntry");
       bst4.addNode("cTestName", "cTestEntry"); 
       bst4.inOrderTraverseTree(bst4.root);
       assertEquals("aTestEntry\nbTestEntry\ncTestEntry", outContent.toString());
       
    }
    
    

    
}
