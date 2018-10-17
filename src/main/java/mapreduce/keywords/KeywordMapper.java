package mapreduce.keywords;



import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Pattern;

public class KeywordMapper extends Mapper<LongWritable, Text, Text, IntWritable>  {

    private String keyWords = "[Tt]rump [Ff]lu [Zz]ika [Dd]iarrhea [Ee]bola [Hh]eadache [Mm]easles";

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Pattern pattern;
        String cols[] = value.toString().split("\\s");
        String word = cols[0];
        String quantity = cols[1];
        for(String w : keyWords.split("\\s")){
             pattern = Pattern.compile(w);
            if(pattern.matcher(value.toString()).find()){
                context.write(new Text(word), new IntWritable(Integer.parseInt(quantity)) );
                break;
            }
        }

    }
}