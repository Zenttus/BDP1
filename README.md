# Big Data Project 1
This is the first project assignment for the Big Data course from the University of Puerto Rico, Mayaguez. The goal is to run a series of MapReduce task using the Hadoop environment.
## Setting up
To be able to use the code you will need to have a Hadoop environment. A quick way to set up one is to use google cloud, which is the method that I mainly used to develop(Instruction to set up [here](https://medium.com/google-cloud/launch-a-hadoop-cluster-in-90-seconds-or-less-in-google-cloud-dataproc-b3acc1c02598). You can also use AWS or configure Hadoop in your own hardware(which might be tedious).
## Running
Once Hadoop is ready, clone this repository on your master node.
```
git clone https://github.com/Zenttus/BDP1
```
Then download some tweets(in [this](https://github.com/Zenttus/BDP1/blob/master/extras/tweetformat.json) format) and upload it to the hdfs.
```
hdfs dfs –mkdir –p HDFS_PATH_OF_TWEETS
hdfs dfs -put TWEETS_FILE HDFS_PATH_OF_TWEETS
```
You are now set to run the demo. Once the demo script is executed it will do a series of MapReduce.
```
chmod +x demo.sh
./demo.sh HDFS_PATH_OF_TWEETS HDF_PATH_FOR_RESULTS
```
Note: The demo will not run correctly if there's already a folder in the hdfs for the output. After every run you can change the HDF_PATH_FOR_RESULTS or you can delete it with the following:
```
hdfs dfs -rm -r HDF_PATH_FOR_RESULTS
```
### Individual MapReduce
In the folder /jars there's the jar files for each mapreduce in case that you want to test them separately.
## Visuals
> Coming soon
