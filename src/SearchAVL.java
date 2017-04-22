
import java.io.File;
import java.util.Scanner;

public class SearchAVL {
   
    public static AVLTree<DirectoryNode> loadData(){
        
        AVLTree<DirectoryNode> avl = new AVLTree(); //initialising a Binary Search Tree object
        
        try{
            
            Scanner scanf = new Scanner(new File("testdata"));
            
            while (scanf.hasNextLine()){ //loop through each line (entry) in the testdata file 
                
                String line = scanf.nextLine();
                               
                avl.insert(new DirectoryNode(line));//creation and addition to tree of a node (key = full name, data = full entry/line from testdata)
                
            }
            
           scanf.close(); 
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); //print the exception to the screen if encountered
            
        }
        
        return avl;
            
    }
    
    public static void search(){
        
        AVLTree<DirectoryNode> avl = loadData(); // instantiate a BST with data from testdata file using loadData() method from above.
                        
        try{
            
            Scanner scanf = new Scanner(new File("queries.txt"));
                     
            while (scanf.hasNextLine()){ // loop through each line (a single name (query)) in queries 
                
                String line = scanf.nextLine();
                                
                BinaryTreeNode<DirectoryNode> found = avl.find(new DirectoryNode(line)); //searching for the node with key equal to a line in querries (each line is a full name)
                
                if(found!=null){
                    
                    System.out.println(found.data.getValue()); // printing out the full entry contained in String returned
                    
                }
                else{
                    
                    System.out.println("Not found"); // printing not found to show that the query was not found in the Binary Search Tree
                    
                }
            }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); // printing the exception obtained, if an exception is encountered at all
            
        }
        
    }
    
    public static void main(String[] args){
        
        search();

    }
    
}



