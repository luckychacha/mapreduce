package FindBaidu;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Sougou implements WritableComparable {

    private String datetime;

    @Override
    public String toString() {
        return "Sougou{" +
                "datetime='" + datetime + '\'' +
                ", userid='" + userid + '\'' +
                ", searchkwd='" + searchkwd + '\'' +
                ", retorder='" + retorder + '\'' +
                ", cliorder='" + cliorder + '\'' +
                ", cliurl='" + cliurl + '\'' +
                '}';
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSearchkwd() {
        return searchkwd;
    }

    public void setSearchkwd(String searchkwd) {
        this.searchkwd = searchkwd;
    }

    public String getRetorder() {
        return retorder;
    }

    public void setRetorder(String retorder) {
        this.retorder = retorder;
    }

    public String getCliorder() {
        return cliorder;
    }

    public void setCliorder(String cliorder) {
        this.cliorder = cliorder;
    }

    public String getCliurl() {
        return cliurl;
    }

    public void setCliurl(String cliurl) {
        this.cliurl = cliurl;
    }

    private String userid;
    private String searchkwd;
    private String retorder;
    private String cliorder;
    private String cliurl;


    public Sougou() {

    }

    public Sougou(String datetime,
                  String userid,
                  String searchkwd,
                  String retorder,
                  String cliorder,
                  String cliurl) {
        this.datetime = datetime;
        this.userid = userid;
        this.searchkwd = searchkwd;
        this.retorder = retorder;
        this.cliorder = cliorder;
        this.cliurl = cliurl;
    }

    public int compareTo(Object o) {
        return 0;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.datetime);
        dataOutput.writeUTF(this.userid);
        dataOutput.writeUTF(this.searchkwd);
        dataOutput.writeUTF(this.retorder);
        dataOutput.writeUTF(this.cliorder);
        dataOutput.writeUTF(this.cliurl);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.datetime = dataInput.readUTF();
        this.userid = dataInput.readUTF();
        this.searchkwd = dataInput.readUTF();
        this.retorder = dataInput.readUTF();
        this.cliorder = dataInput.readUTF();
        this.cliurl = dataInput.readUTF();

    }
}
