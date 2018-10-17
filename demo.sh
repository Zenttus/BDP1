echo "MAPREDUCE DEMO INITIATED..."
echo "Finding and counting words..."
hadoop jar /jars/words.jar $0 $1/words
hadoop jar /jars/getTotal.jar $1/words/part-r-00001 $1/words/total
echo "DONE"
echo "Finding key words..."
hadoop jar /jars/keyWords.jar $0 $1/keywords
echo "DONE"
echo "Finding screen Names..."
hadoop jar /jars/screenNames.jar $0 $1/screenNames
hadoop jar /jars/getTotalKeys.jar $1/screenNames/part-r-00001 $1/screenNames/total
echo "FINISHED"
