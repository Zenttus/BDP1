package mapreduce.jsonReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Mapper;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class ScreenNameMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

    private Text word = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Configuration conf = context.getConfiguration();
        String keyword = conf.get("keyword");
        JSONParser parser = new JSONParser();
        String[] tuple = value.toString().split("\\n");
        try {
            for(int i=0; i<tuple.length; i++){
                JSONObject obj = (JSONObject) parser.parse(tuple[i]);
                if(conf.get("secondKeyValue") == null){
                    word.set(((JSONObject) obj.get(keyword)).get(conf.get("secondKeyValue")).toString());
                }else {
                    word.set(obj.get(keyword).toString());
                }
                context.write(word, new IntWritable(1));
            }
        }catch(Exception e){
            System.out.println("BOOM");
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
