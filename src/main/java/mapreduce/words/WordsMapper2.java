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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsMapper2 extends Mapper<LongWritable, Text, Text, IntWritable>{

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Pattern p = Pattern.compile("\\+\\d$");
        Matcher m = p.matcher(value.toString());
        m.find();
        context.write(new Text("Total"), new IntWritable(Integer.parseInt(m.group())) );
    }

}
