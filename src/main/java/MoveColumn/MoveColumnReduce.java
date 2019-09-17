package MoveColumn;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MoveColumnReduce extends Reducer<Sougou, NullWritable, Text, NullWritable> {

    @Override
    protected void reduce(Sougou key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
//        Iterator<NullWritable> iterator = values.iterator();
        for (NullWritable value : values) {
            context.write(new Text(
                    key.getKeyword()
                    + ":" + key.getUserid()
                    + ":" + key.getDateTime()
                    + ":" + key.getCliOrder()
                    + ":" + key.getRetOrder()
                    + ":" + key.getCliUrl()),
                    NullWritable.get());
        }
    }
}
