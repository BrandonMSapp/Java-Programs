import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Driver extends Graph {

    public static void main(String[] args) {
        String inputFile = args[0];
        readFile(inputFile);
        loadVertices(stringArrays);
        loadEdges(stringArrays);
        numVertices();
        zeroInbound();
        selfEdges();
        zeroOutbound();
        heaviestWeight();
        
    }
    static ArrayList<String []> stringArrays = new ArrayList<String []>();
    
    private static void readFile(String file) 
    {
        
        
        String line = "";
        try {

            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            while ((line = br.readLine()) != null) {
                String [] lines;
                lines = line.split("\n");
                for(int i = 0; i < lines.length; i++)
                {
                    String [] currLine = lines[i].split(",");
                    stringArrays.add(currLine);
                }
               
            }
            br.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

}



