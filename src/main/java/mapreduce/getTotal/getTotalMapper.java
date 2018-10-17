package mapreduce.getTotal;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class getTotalMapper extends Mapper<LongWritable, Text, Text, IntWritable>  {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String cols[] = value.toString().split("\\s");
        String quantity = cols[1];
        context.write(new Text("Total"), new IntWritable(Integer.parseInt(quantity)) );

    }
}