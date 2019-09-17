package MoveColumn;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MoveColumnMap extends Mapper<LongWritable, Text, Sougou, NullWritable> {
    @Override
    public void map(LongWritable longWritable, Text text, Context context) throws IOException, InterruptedException {
        String[] arr = text.toString().split("\t");
        if (arr.length == 6 && arr[5].endsWith(".html")) {

            context.write(new Sougou(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]), NullWritable.get());
        }
    }
}
