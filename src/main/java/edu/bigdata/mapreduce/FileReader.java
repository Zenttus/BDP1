package edu.bigdata.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;


public class FileReader {

    public static void main(String[] args){

        String fileName = "";
        URI fileUri = URI.create(fileName);

        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());

        InputStream dataIn = null;

        try {
            FileSystem hdfs = FileSystem.get(fileUri, conf);
            Path path = new Path(fileUri);
            long bytesToRead = hdfs.getFileStatus(path).getLen();
            System.out.println("Bytes to Read: " + bytesToRead);

            dataIn = hdfs.open(path);
            IOUtils.copyBytes(dataIn, System.out, bytesToRead, false);

        }catch (Exception e){
            System.out.println("boom a lo ziquitraque");
            System.out.println(e);

        } finally {
            IOUtils.closeStream(dataIn);
        }

    }
}
