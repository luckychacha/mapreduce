package MoveColumn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.Job;

public class MoveColumn {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Job job = Job.getInstance();
        job.setJobName("app-0906");
        job.setJarByClass(MoveColumn.class);
        Path input = new Path("hdfs://node01:8020/sougou.50w.utf8");
        FileInputFormat.setInputPaths(job, input);
        Path output = new Path("hdfs://node01:8020/sougouOut");
        FileOutputFormat.setOutputPath(job, output);

        job.setMapperClass(MoveColumnMap.class);
        job.setMapOutputKeyClass(Sougou.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setReducerClass(MoveColumnReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        if (fs.exists(output)) {
            fs.delete((output), true);
        }
        job.setNumReduceTasks(1);
        job.waitForCompletion(true);
    }
}
