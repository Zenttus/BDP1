import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

// **********THIS CLASS IS NOT USE**********
public class Main {
    public static void main(String args[]){

        String Words = args[0];
        String Keywords = args[1];
        String ScreenNames = args[2];
        String MessagesPerUser = args[3];

        TsvParserSettings settings = new TsvParserSettings();
        TsvParser parser = new TsvParser(settings);
       // List<String[]> allRows = parser.parseAll();


    }
}
