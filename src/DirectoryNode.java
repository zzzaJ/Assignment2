/**
 * DirectoryNode class which holds entry data as well as the name-key.
 * Datatype used for the AVL tree nodes
 */
public class DirectoryNode implements Comparable<DirectoryNode>{

    private String key;//String key which holds the full name of the entry     
    private String value; //String value which holds the full entry: address|telephone number|full name      
    
    /**
     * Initializes a DirectoryNode object.
     * The DirectoryNode object will be initialized using the full entry.
     * Since the format of the entry is always the same, we need not take 2 parameters for the key and entry.
     * Thus just the entry is given and the key taken from it.
     * 
     * @param entry an entry taken from the datafile in the assumed format  
     */
    public DirectoryNode(String entry){
            
            this.value= entry; //setting value to the full entry
            this.key= entry.substring(entry.lastIndexOf("|")+1);//using substring to obtain the full name and set it as the key.
            
    }
    
    /**
     * Acessor method to get the node's key.
     * 
     * @return Returns the key (full name) of a DirectoryNode
     */
    public String getKey(){
            
            return key; //returns key
            
    }
    
    /**
     * Accessor method which returns the value, which is the full entry.
     * 
     * @return Returns the full entry of the DirectoryNode.
     */
    public String getValue(){

        return value; //retunrs value 

    }
    
    /**
     * Returns the value string, whcih is in the orignal (address|telephone number|fullname) format. 
     * NB the method is very similiar to the getValue() method, however is just used to override the toString method
     * and so that the value can be easily printed
     * @return Returns the value attribute 
     */
    public String toString(){
        
        return value;  //retunrs the value of the Directory node
        
    }
            
    /**
     * Comparison of two DirectoryNode keys alphabetically. 
     * Returns a postive 1 if the 'other' node is alphabetically ahead of the primary node,
     * zero if the keys are equal and a negative 1 if the 'other' is behind the primary node
     * 
     * @param other The DirectoryNode whcih is being compared to the primary ndoe
     * @return the integer value representing the alphabetical order of the 2 nodes
     */
    public int compareTo(DirectoryNode other){
        
        return this.key.compareTo(other.key); //returns the value returnecd from the compareTo method from implemented class comparible
        
    }    
    
}