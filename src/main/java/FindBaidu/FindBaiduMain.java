package FindBaidu;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FindBaiduMain {

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("mapreduce.map.output.compress",
                "true");
        configuration.set("mapreduce.map.output.compress.codec",
                "org.apache.hadoop.io.compress.BZip2Codec");
        configuration.set("mapreduce.output.fileoutputformat.compress",
                "true");
        configuration.set("mapreduce.output.fileoutputformat.compress.codec",
                "org.apache.hadoop.io.compress.BZip2Codec");


        FileSystem fileSystem = FileSystem.get(configuration);

        Job job = Job.getInstance();
        job.setJobName("FIndBaidu");
        job.setJarByClass(FindBaiduMain.class);

        Path input = new Path("hdfs://node01:8020/sougou.50w.utf8");
        FileInputFormat.setInputPaths(job, input);

        Path output = new Path("hdfs://node01:8020/baiduOut");
        FileOutputFormat.setOutputPath(job, output);

        job.setMapperClass(FindBaiduMapper.class);
        job.setMapOutputKeyClass(Sougou.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setReducerClass(FindBaiduReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        if (fileSystem.exists(output)) {
            fileSystem.delete(output, true);
        }

        job.setPartitionerClass(CustomPartition.class);
        job.setNumReduceTasks(4);
        job.waitForCompletion(true);

    }

    public static class CustomPartition extends Partitioner<Sougou, NullWritable> {

        public int getPartition(Sougou sougou, NullWritable nullWritable, int i) {
            int partitionId = (int) Math.floor(Math.random() * 100) % 4;
            System.out.println(partitionId);
            return partitionId;
        }
    }
}
