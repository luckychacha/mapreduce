package MoveColumn;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Sougou implements WritableComparable<Sougou> {

    private String dateTime;
    private String userid;
    private String keyword;
    private String retOrder;
    private String cliOrder;
    private String cliUrl;

    public String getDateTime() {
        return dateTime;
    }

    public String getUserid() {
        return userid;
    }

    @Override
    public String toString() {
        return "Sougou{" +
                "dateTime='" + dateTime + '\'' +
                ", userid='" + userid + '\'' +
                ", keyword='" + keyword + '\'' +
                ", retOrder='" + retOrder + '\'' +
                ", cliOrder='" + cliOrder + '\'' +
                ", cliUrl='" + cliUrl + '\'' +
                '}';
    }

    public Sougou(String dateTime, String userid, String keyword, String retOrder, String cliOrder, String cliUrl) {
        this.dateTime = dateTime;
        this.userid = userid;
        this.keyword = keyword;
        this.retOrder = retOrder;
        this.cliOrder = cliOrder;
        this.cliUrl = cliUrl;
    }

    public Sougou() {
    }

    public String getKeyword() {
        return keyword;
    }

    public String getRetOrder() {
        return retOrder;
    }

    public String getCliOrder() {
        return cliOrder;
    }

    public String getCliUrl() {
        return cliUrl;
    }

    public int compareTo(Sougou o) {
        return 0;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.dateTime);
        dataOutput.writeUTF(this.userid);
        dataOutput.writeUTF(this.keyword);
        dataOutput.writeUTF(this.retOrder);
        dataOutput.writeUTF(this.cliOrder);
        dataOutput.writeUTF(this.cliUrl);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.dateTime = dataInput.readUTF();
        this.userid = dataInput.readUTF();
        this.keyword = dataInput.readUTF();
        this.retOrder = dataInput.readUTF();
        this.cliOrder = dataInput.readUTF();
        this.cliUrl = dataInput.readUTF();
    }
}
