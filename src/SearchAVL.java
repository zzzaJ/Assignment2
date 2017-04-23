import java.io.File;
import java.util.Scanner;
/**
* SearchAVL class which handles the running of all static methods.
* The Search AVL application handles the initialisation of an AVL tree,
* the inserting of telephone directory data into the tree from the testdata data file,
* the searching of specified queries read from a query file (printing the found entries)
* and the subsequent deleting of the specified queries.
*
* @author  Dino Bossi
* @version 1.0
* @since   2016-19-04
*/
public class SearchAVL {
   
    
   /**
   * This method is used to load the data into an AVL tree. The method reads the
   * contents of testdata, adding each entry into the tree, returning the fully populated 
   * AVL tree
   * 
   * @return AVLTree This method returns an AVL tree object
   */
    public static AVLTree<DirectoryNode> loadData(){
        
        
        AVLTree<DirectoryNode> avl = new AVLTree(); //initialising an AVL Tree object
        
        try{
            
            Scanner scanf = new Scanner(new File("testdata"));
            
            while (scanf.hasNextLine()){ //loop through each line (entry) in the testdata file 
                
                String line = scanf.nextLine();
                               
                avl.insert(new DirectoryNode(line));//creation and addition to tree of a node (key = full name, data = full entry/line from testdata)
                
            }
            
           scanf.close(); // closing the scanner object 
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); //print the exception to the screen if encountered
            
        }
        
        
        return avl; //returning of the populated avl tree
            
    }
    
   /**
   * This method is used to search for queries in an AVL tree. The method reads the
   * contents of queries.txt, searching for each entry in the tree, printing the entry if it is found
   * and Not Found if it is not found. 
   * 
   * The method does not return anything, but simply prints the result of each search to the screen
   */ 
    public static void search(){
        
        AVLTree<DirectoryNode> avl = loadData(); // instantiate an AVL tree with data from testdata file using loadData() method from above.
                        
        try{
            
            Scanner scanf = new Scanner(new File("queries.txt"));
                     
            while (scanf.hasNextLine()){ // loop through each line (a single name (query)) in queries 
                
                String line = scanf.nextLine();
                                
                BinaryTreeNode<DirectoryNode> found = avl.find(new DirectoryNode(line)); //searching for the node with key equal to a line in queries (each line is a full name)
                
                if(found!=null){
                    
                    System.out.println(found.data.getValue()); // printing out the full entry contained in the BinaryTreeNode object found
                    
                }
                else{
                    
                    System.out.println("Not found"); // printing not found to show that the query was not found in the AVL tree
                    
                }
            }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); // printing the exception obtained, if an exception is encountered at all
            
        }
        
                
    }
    
   /**
   * This method is used to delete nodes from an AVL tree. The method reads the
   * contents of queries.txt, deleting each node in the tree with the specified name-key (from queries.txt)
   * 
   * The method does not return anything, and is used solely for the purpose of experimentation.
   */
    public static void deletes(){
        
      AVLTree<DirectoryNode> avl = loadData(); // instantiate an AVL tree with data from testdata file using loadData() method from above.
               
        try{
            
            Scanner scanf = new Scanner(new File("queries.txt"));
            
            while (scanf.hasNextLine()){ // loop through each line (a single name (query)) in queries 
                
                String line = scanf.nextLine();
                                
                avl.delete(new DirectoryNode("|" + line)); //delete each node which has a name-key equal to that from the queries
                
            }
  
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); // printing the exception obtained, if an exception is encountered at all
            
        }
        
    }
    /**
   * This main method is used to run the search and delete methods, indirectly calling the loadData method.
   */
    public static void main(String[] args){
        
        search();
        deletes();

    }
    
}
