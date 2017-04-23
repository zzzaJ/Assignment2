import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class TestDirectoryNode {

    DirectoryNode a;
    DirectoryNode c;
    DirectoryNode b;
    
    
    @Before public void setUp(){
        
       a = new DirectoryNode("aaddress|atelephone|aname");
       b = new DirectoryNode("baddress|btelephone|bname");
       c = new DirectoryNode("caddress|ctelephone|cname");
        
    }
    
    @After public void cleanUp(){
        
        System.setOut(null);
        
    }
    
    @Test public void testgetKey(){ //Test to determine if loadData works correctly 
                                      
        
        assertEquals(a.getKey(), "aname");
    }
    
    @Test public void testgetValue(){ //Test to determine if search works correctly 
                   
      
        assertEquals(b.getValue(), "baddress|btelephone|bname");
    }
    
    @Test public void testtoSring(){ //Test to determine if deletes works correctly 
         
        assertEquals(c.toString(), "caddress|ctelephone|cname");
        
    }
    
}
