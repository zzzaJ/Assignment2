/**
 * The DirectoryNode contains a name key and telephone directory entry value.
 * It is used as the datatype for a binary search tree and a linear array 
 * in the ElectronicTelephoneDirectory project for applications PrintIt, SearchIt
 * and SearchItLinear.
 * 
 * @author talajross
 * @version 1.0
 * @since 2017-04-06
 */

public class DirectoryNode implements Comparable<DirectoryNode>
    {
    //Instance Variables:
    private String key;         //name from data entry
    private String value;       //whole data entry - "<address>|<number>|<full name>"
    
    //Constructors:
    /**
     * Initializes a DirectoryNode object containing the String entry as its value
     * and the name section of the string entry as its key.
     * It is assumed that the String entry is of the format:
     * "address|telephone_number|name".
     * If the String entry is of format "name", then the name is entered as both
     * the key and the value.
     * 
     * @param entry A telephone directory entery of format: "address|telephone_number|name"  
     */
    public DirectoryNode(String entry)
        {
        this.value= entry;
        int div= entry.lastIndexOf("|");    //find the the division index between number and name
        this.key= entry.substring(div+1);     //key=name which is everything after div index
        }
    
    /**
     * Accessor method which returns the key.
     * 
     * @return Returns the key from DirectoryNode.
     */
    public String getKey()
        {
        return key;
        }
    
    /**
     * Accessor method which returns the value.
     * 
     * @return Returns value from DirectoryNode.
     */
    public String getValue()
        {
        return value;
        }
    
    //Print Method:
    /**
     * Returns a String representation of the DirectoryNode object in 
     * format:"address|telephone_number|name" 
     * 
     * @return the value of the DirectoryNode object in format:"address|telephone_number|name"
     */
    public String toString()
        {
        return value;   
        }
            
    //Compare Method:
    /**
     * Compares two DirectoryNodes' keys lexicographically,
     * returning a negative int if this Node is lexicographically less than
     * other, a positive if this Node is lexicographically more greater than
     * other, and zero if they are lexicographically equal.
     * 
     * @param other The DirectoryNode that is being compared to this DirectoryNode.
     * @return the int comparison value for comparison between two DirectoryNodes' keys lexicographically.
     */
    public int compareTo(DirectoryNode other)
        {
        return this.key.compareTo(other.key);
        }
          
    }
