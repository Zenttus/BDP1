package mapreduce.words;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {

    public static void main(String[] args) throws Exception{
        if(args.length != 3){
            System.err.println("Missing args(input path(1), words output path(2), total words output path(3)).");
            System.exit(-1);
        }

        Job job1 = new Job();
        job1.setJarByClass(mapreduce.words.Main.class);
        job1.setJobName("Word Counter");

        FileInputFormat.addInputPath(job1, new Path(args[0]));
        FileOutputFormat.setOutputPath(job1, new Path(args[1]));

        job1.setMapperClass(mapreduce.words.WordsMapper.class);
        job1.setReducerClass(mapreduce.words.WordsReducer.class);

        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(IntWritable.class);

        Job job2 = new Job();
        job2.setJarByClass(mapreduce.words.Main.class);
        job2.setJobName("Total Word Counter");

        FileInputFormat.addInputPath(job2, new Path(args[1]));
        FileOutputFormat.setOutputPath(job2, new Path(args[2]));

        job2.setMapperClass(mapreduce.words.WordsMapper2.class);
        job2.setReducerClass(mapreduce.words.WordsReducer2.class);

        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(IntWritable.class);

        System.exit(job2.waitForCompletion(true)? 0:1);
    }

}

