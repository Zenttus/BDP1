package mapreduce.keywords;



import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class KeywordMapper extends Mapper<LongWritable, Text, Text, IntWritable>  {

    private String keyWords = "Trump trump Flu flu Zika zika Diarrhea diarrhea Ebola ebola Headache headache Measles measles";//TODO This can be done better with regex

    private Text word = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        JSONParser parser = new JSONParser();
        String[] tuple = value.toString().split("\\n");
        try {
            for(int i=0; i<tuple.length; i++){
                JSONObject obj = (JSONObject) parser.parse(tuple[i]);
                StringTokenizer itr = new StringTokenizer(obj.get("text").toString());
                while(itr.hasMoreTokens()){
                    word.set(itr.nextToken());
                    for(String stopWord : keyWords.split("\\s")){
                        if(word.toString().contains(stopWord)) {
                            context.write(new Text(stopWord), new IntWritable(1));
                        }
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