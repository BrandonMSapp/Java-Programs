
//Brandon Sapp
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Application extends Decoder {

    public static void main(String[] args) {
        String inputFile = args[0];
        String patternFile = args[1];
        readTimingPattern(timingVals, patternFile);
        readInputVals(inputVals, inputFile);
        output = decode(inputVals, timingVals);
        printOutput();
        outputCSV();
    }

    static Queue output = new Queue();
    static Queue inputVals = new Queue();
    static Hashtable<String, Integer> timingVals = 
            new Hashtable<String, Integer>();

    private static void readTimingPattern(Hashtable<String, Integer> map,
            String patternFile) {
        String[] tableVals = new String[6];
        int code = -1;
        String line = "";
        String SplitBy = ",";
        String[] timing;
        try {

            FileReader file = new FileReader(patternFile);
            BufferedReader br = new BufferedReader(file);

            while ((line = br.readLine()) != null) {
                timing = line.split(SplitBy);
                for (int i = 0; i < timing.length - 1; i++) {
                    tableVals[i] = timing[i];
                }

                code = Integer.parseInt(timing[timing.length - 1]);
                map.put(Arrays.toString(tableVals), code);
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

    private static void readInputVals(Queue queue, String inputFile) {
        String line = "";
        String SplitBy = ",";
        String[] values;
        try {
            FileReader file = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(file);

            while ((line = br.readLine()) != null) {
                values = line.split(SplitBy);
                for (int i = 0; i < values.length; i++) {
                    queue.loadValue(Integer.valueOf(values[i]));
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

    private static void printOutput() {
        for (int i = 0; i < output.size(); i++) {
            if (i == output.size() - 1) {
                System.out.print(output.retrieve(i));
            } else {
                System.out.print(output.retrieve(i) + ",");
            }
        }
    }

    private static void outputCSV() {
        try {
            FileWriter writer = new FileWriter("decoderoutput.txt");
            for (int i = 0; i < output.size(); i++) {
                if (i == output.size() - 1) {
                    writer.append(Integer.toString(output.retrieve(i)));
                } else {
                    writer.append(Integer.toString(output.retrieve(i)));
                    writer.append(",");
                }
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
