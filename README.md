# myscala test
# test tortoisegit
export HADOOP_HOME=/home/hadoop-2.9
export SPARK_HOME=/home/spark
if [ `$HADOOP_HOME/bin/hadoop fs -ls|grep myscala|wc -l` -gt 0 ]; then
  $HADOOP_HOME/bin/hadoop fs -rm  myscala*.jar
fi
$HADOOP_HOME/bin/hadoop fs -put ./target/*.jar /user/root/
$SPARK_HOME/bin/spark-submit --master spark://node1:7077 --deploy-mode cluster --class com.fact.spark.rdd.SimpleApp hdfs://hhjcluster/user/root/myscala-1.0-SNAPSHOT.jar
======================================
======================================