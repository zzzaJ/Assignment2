
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class TestSearchAVL {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before public void setUp(){
        
       System.setOut(new PrintStream(outContent));
        
    }
    
    @After public void cleanUp(){
        
        System.setOut(null);
        
    }
    
    @Test public void testloadData(){ //Test to determine if loadData works correctly 
                                      
        AVLTree<DirectoryNode> avl = SearchAVL.loadData();
        avl.inOrder();
        String out = "aaddress|atelephone|aname\nbaddress|btelephone|bname\ncaddress|ctelephone|cname\ndaddress|dtelephone|dname\n";
        assertEquals(out, outContent.toString());
    }
    
    @Test public void testsearch(){ //Test to determine if search works correctly 
                   
        //outContent = new ByteArrayOutputStream();
        SearchAVL.search();
        String out = "daddress|dtelephone|dname\naaddress|atelephone|aname\n";
        assertEquals(out, outContent.toString());
    }
    
    @Test public void testdeletes(){ //Test to determine if deletes works correctly 
         
        //outContent = new ByteArrayOutputStream();
        SearchAVL.deletes();
	
        String out = "baddress|btelephone|bname\ncaddress|ctelephone|cname\n";
        assertEquals(out, outContent.toString());
    }
    
}
