import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String args[]){

        String csvFile = args[0];
        String filePath = args[1];
        String h1 = args[2];
        String h2 = args[3];
        try {
            File file = new File(filePath);
                FileWriter fw = new FileWriter(file);
                CSVWriter writer = new CSVWriter(fw);
                BufferedReader br = new BufferedReader(new FileReader(csvFile));
                String st;

                String[] data = {"",""};
                String[] header = { h1, h2 };
                writer.writeNext(header);
                while ((st = br.readLine()) != null) {
                    data[0] = st.split("\\s")[0];
                    data[1] = st.split("\\s")[1];
                    writer.writeNext(data);
                }

                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


    }
}
