package mapreduce.keywords;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {

    public static void main(String[] args) throws Exception{
        if(args.length != 2){
            System.err.println("Missing args: arg1=InputPath, arg2=OutputPath");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(mapreduce.words.Main.class);
        job.setJobName("KeyWords Counter");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(mapreduce.keywords.KeywordMapper.class);
        job.setReducerClass(mapreduce.keywords.KeywordReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.waitForCompletion(true);
        System.exit(job.waitForCompletion(true)? 0:1);
    }

}

