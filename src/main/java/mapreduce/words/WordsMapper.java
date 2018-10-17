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

public class WordsMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

    private Text word = new Text();
    private String stopWords = "a about above after again against all am an and any are as at " +
            "be because been before being below between both but by " +
            "could did do does doing down during " +
            "each few for from further had has have having her here hers herself him himself his how I if in into is it " +
            "its itself let me more most my myself nor of on once only or other ought our ours ourselves out over own " +
            "same she should so some such than that the their them themselves then there these they this those " +
            "through to too under until up very was we were what when where which while who whom why with would you " +
            "http "
            ;
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        boolean needToSkip = false;

        JSONParser parser = new JSONParser();
        String[] tuple = value.toString().split("\\n");
        try {
            for(int i=0; i<tuple.length; i++){
                JSONObject obj = (JSONObject) parser.parse(tuple[i]);
                StringTokenizer itr = new StringTokenizer(obj.get("text").toString());
                while(itr.hasMoreTokens()){
                    word.set(itr.nextToken());
                    for(String stopWord : stopWords.split("\\s")){
                        if(word.toString().contains(stopWord)) {
                            needToSkip = true;
                            break;
                        }
                    }
                    if(!needToSkip) {
                        context.write(word, new IntWritable(1));
                    }
                }
            }
        }catch(Exception e){
            System.out.println("BOOM");
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
