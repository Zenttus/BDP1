package mapreduce.words;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.*;

import java.io.IOException;
import java.util.StringTokenizer;

public class WordsMapper2 extends Mapper<LongWritable, Text, Text, IntWritable>{

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println(value);
        String[] tuple = value.toString().split("\\n");
        for(String line : tuple){
            context.write(new Text("Total"), new IntWritable(Integer.parseInt(line.split(" ")[1])) );
        }
    }

}
