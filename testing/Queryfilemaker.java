
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
        String[] testdatanames = new String[n];
        String[] writtentoq = new String[n];
        Random rand = new Random();
        int num = 0;
        int z;
        int count = 0;
        try{
            
            PrintWriter writerd = new PrintWriter("testdata", "UTF-8");
            PrintWriter writerq = new PrintWriter("queries.txt", "UTF-8");
            
            for (int i = 0; i < n; i++){
                num = rand.nextInt(10000);
                writerd.println(names[num]);
                testdatanames[count]=(names[num]);
                count++;
            }
            
            writerd.close();
            
            if(n != 1){
                
                z = n/2;
                
            }
            else{
               z = 1; 
            }
            
            count = 0;
            
            while(count!=z){
                
                num = rand.nextInt(n);
                if(Arrays.asList(writtentoq).contains(testdatanames[num].substring(testdatanames[num].lastIndexOf("|")+1))){
                    System.out.print("z");
                }
                else{
                    
                writerq.println(testdatanames[num].substring(testdatanames[num].lastIndexOf("|")+1));
                writtentoq[count] = testdatanames[num].substring(testdatanames[num].lastIndexOf("|")+1);
                count++;
                
                }                 
            } 

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
