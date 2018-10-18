echo "MAPREDUCE DEMO INITIATED...$1 $2"
echo "Finding and counting words..."
hadoop jar ./jars/words.jar mapreduce.words.Main $1 $2/words
hadoop jar ./jars/getTotal.jar mapreduce.getTotal.Main $2/words/part-r-00001 $2/words/total
echo "DONE"
echo "Finding key words..."
hadoop jar ./jars/keyWords.jar mapreduce.keywords.Main $1 $2/keywords
echo "DONE"
echo "Finding screen Names..."
hadoop jar ./jars/screenNames.jar mapreduce.screenname.Main $1 $2/screenNames
hadoop jar ./jars/getTotalKeys.jar mapreduce.getTotalKeys.Main $2/screenNames/part-r-00001 $2/screenNames/total
echo "FINISHED"
