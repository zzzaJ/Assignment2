import java.io.File;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

/** 
 *Provides methods to load data from file into Binary Search Tree and search for specific nodes, using 
 *the keys provided in a query file
 *@author Dino Bossi
 */
public class SearchIt {
      
    /**
     *method to load telephone directory data from testdata file into a Binary Search Tree 
     */
    public static BinarySearchTree loadData(){
        
        Instant start = Instant.now();
        
        BinarySearchTree bst = new BinarySearchTree(); //initialising a Binary Search Tree object
        
        try{
            
            Scanner scanf = new Scanner(new File("testdata"));
            
            while (scanf.hasNextLine()){ //loop through each line (entry) in the testdata file 
                
                String line = scanf.nextLine();
                               
                bst.addNode(line.substring(line.lastIndexOf("|")+1), line);//creation and addition to tree of a node (key = full name, data = full entry/line from testdata)
                
            }
            
           scanf.close(); 
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); //print the exception to the screen if encountered
            
        }
        
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken for Insertion: "+ timeElapsed.toMillis() +" milliseconds");
        
        return bst;
            
    }
    
    /**
     *method to search for items in a Binary Search Tree containing testdata data which match specific queries in a query file
     *The method does not return anything, but rather prints each found entry on the screen and a message if an entry is not matched with a query
     */   
    public static void search(){
        
        
        
        BinarySearchTree bst = loadData(); // instantiate a BST with data from testdata file using loadData() method from above.
        
        Instant start = Instant.now();
        
        try{
            
            Scanner scanf = new Scanner(new File("queries.txt"));
            
            while (scanf.hasNextLine()){ // loop through each line (a single name (query)) in queries 
                
                String line = scanf.nextLine();
                                
                String returned = bst.findNode(line); //searching for the node with key equal to a line in querries (each line is a full name)
                
                if(returned!=null){
                    
                    System.out.println(returned); // printing out the full entry contained in String returned
                    
                }
                else{
                    
                    System.out.println("Not found"); // printing not found to show that the query was not found in the Binary Search Tree
                    
                }
            }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); // printing the exception obtained, if an exception is encountered at all
            
        }
        
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken for Searching: "+ timeElapsed.toMillis() +" milliseconds");
        
    }
    
    public static void deletes(){
        
        BinarySearchTree bst = loadData(); // instantiate a BST with data from testdata file using loadData() method from above.
        
        Instant start = Instant.now();
        
        try{
            
            Scanner scanf = new Scanner(new File("queries.txt"));
            
            while (scanf.hasNextLine()){ // loop through each line (a single name (query)) in queries 
                
                String line = scanf.nextLine();
                                
                Boolean fnd = bst.remove(line); //searching for the node with key equal to a line in querries (each line is a full name)
                
            }
            
            bst.inOrderTraverseTree(bst.root);
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); // printing the exception obtained, if an exception is encountered at all
            
        }
        
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken for Deleting: "+ timeElapsed.toMillis() +" milliseconds");
        
   
    }
    
    public static void main(String[] args){
        
        search();
        deletes();

    }
    
}
