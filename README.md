#Big Data Project 1
This is the first project assignment for the Big Data class from the University of Puerto Rico, Mayaguez. The goal of this is to run a series of MapReduce task using the Hadoop environment.
## Setting up
To be able to use the code in this repo you will need to have a Hadoop environment set. A quick way to set up one is to use google cloud, which is the method that I mainly used to develop(Instruction to set up [here]https://medium.com/google-cloud/launch-a-hadoop-cluster-in-90-seconds-or-less-in-google-cloud-dataproc-b3acc1c02598). You can also use AWS or configure Hadoop in your own hardware(which might be tedious).
## Running
Once have is Hadoop ready, clone this repository on your master node.
```
git clone https://github.com/Zenttus/BDP1
```
Then download some tweets(in [this]https://github.com/Zenttus/BDP1/blob/master/extras/tweetformat.json format) and upload it to the hdfs.
```
hdfs dfs –mkdir –p /user/tweetsfolder
hdfs dfs -put TWEETS-FILE /user/tweetsfolder
```
You are now set to run the demo. Once the demo script is executed it will do a series of MapReduce, once it's done there will be a .... file with a visual representation of the data from the tweets.
## Visuals Examples
