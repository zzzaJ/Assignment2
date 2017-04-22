
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Queryfilemaker {
    
    public static String[] loadDataToArray(){
        
        String[] names = new String[10000];
        int count = 0;
        
        try{
            
            Scanner scanf = new Scanner(new File("testdataOri"));
            
            while (scanf.hasNextLine()){
                
                String line = scanf.nextLine();
                names[count] = line;
                count++;
                
                }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString());
            
        }
        
       return names;
        
    }
    
    public static void makeQueryFile(int n){
        
        String[] names = loadDataToArray();
        Random rand = new Random();
        int num = 0;
        int z;
        try{
            
            PrintWriter writerd = new PrintWriter("testdata", "UTF-8");
            PrintWriter writerq = new PrintWriter("queries.txt", "UTF-8");
            
            for (int i = 0; i < n; i++){
                num = rand.nextInt(10000);
                writerd.println(names[num]);
                                
            }
            
            writerd.close();
            Scanner scanf = new Scanner(new File("testdata"));
            
            if(n != 1){
                
                z = n/2;
                
            }
            else{
               z = 1; 
            }
            
            for (int i = 0; i < z; i++ ){
                num = rand.nextInt(n);
                String line = scanf.nextLine();
                String name = line.substring(line.lastIndexOf("|")+1);
                writerq.println(names[num].substring(names[num].lastIndexOf("|")+1));
                                
            } 
            
            scanf.close();
            writerq.close();
        }
        catch (IOException e) {
            
            }    
    }
    
    public static void main (String []args){
        
        Scanner reader = new Scanner(System.in);
        System.out.println("How many data itmes (queries = half that) in the file: ");
        int n = reader.nextInt();
        makeQueryFile(n);
      
    }
    
}
