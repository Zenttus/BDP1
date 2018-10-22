package mapreduce.jsonReader;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

public class Main {

    public static void main(String[] args) throws Exception{
        if(args.length < 3){
            System.err.println("Missing args: arg1=InputPath, arg2=OutputPath, arg3=JsonField, arg4=JsonSubField(optional)");

            System.exit(-1);
        }

        JobConf conf = new JobConf(Main.class);
        conf.set("keyValue",args[2]);
        if(args.length == 4){
            conf.set("secondKeyValue", args[3]);
        }

        Job job = new Job(conf);
        job.setJarByClass(mapreduce.jsonReader.Main.class);
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
