package wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountMain {

    static {
        System.setProperty("HADOOP_USER_NAME", "hadoop");
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException, InterruptedException {
        if (args.length !=2 || args == null) {
            System.exit(0);
        }

        Configuration configuration = new Configuration();
//        configuration.set("mapreduce.job.jar", "/Users/leixinxin/Sites/mapreduce/target/mapreduce-1.0-SNAPSHOT.jar");


        Job job = Job.getInstance(configuration, WordCountMain.class.getSimpleName());

        job.setJarByClass(WordCountMain.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(WordCountMap.class);

        job.setReducerClass(WordCountReduce.class);

        job.setOutputKeyClass(Text.class);

        job.setOutputValueClass(IntWritable.class);

        job.waitForCompletion(true);
    }
}
