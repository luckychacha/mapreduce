package FindBaidu;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FindBaiduReducer extends Reducer<Sougou, NullWritable, Text, NullWritable> {

    @Override
    protected void reduce(Sougou key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        Iterator i$ = values.iterator();

        while(i$.hasNext()) {
//        for (NullWritable value : values) {
            context.write(new Text(
                    key.getDatetime()
                    + ":" + key.getUserid()
                    + ":" + key.getSearchkwd()
                    + ":" + key.getRetorder()
                    + ":" + key.getCliorder()
                    + ":" + key.getCliurl()
            ), NullWritable.get());
            i$.next();
        }

    }
}
