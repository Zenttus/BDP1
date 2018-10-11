package edu.bigdata.mapreduce;

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

public class TweetsMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String tweetText;

        JSONParser parser = new JSONParser();
        String[] tuple = value.toString().split("\\n");
        try {
            for(int i=0; i<tuple.length; i++){
                JSONObject obj = (JSONObject) parser.parse(tuple[i]);
                tweetText = obj.get("text").toString();
                context.write(new Text(tweetText), new IntWritable(1));
            }
        }catch(Exception e){
            System.out.println("BOOM");
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
