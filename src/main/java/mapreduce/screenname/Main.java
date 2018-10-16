package mapreduce.screenname;

import edu.bigdata.mapreduce.TweetsMapper;
import edu.bigdata.mapreduce.TweetsReducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {

    public static void main(String[] args) throws Exception{
        if(args.length != 2){
            System.err.println("Te faltan args(input path y output path).");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(edu.bigdata.mapreduce.TweetsCounter.class);
        job.setJobName("Screen Name Counter");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(ScreenNameMapper.class);
        job.setReducerClass(ScreenNameReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true)? 0:1);
    }

}
