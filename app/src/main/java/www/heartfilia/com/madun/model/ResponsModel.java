package www.heartfilia.com.madun.model;

import java.util.List;

/**
 * Created by heartfilia on 04/02/2018.
 */

public class ResponsModel {
    String kode, pesan;
    List<DataModel>result;

    public List<DataModel> getResult() {
        return result;
    }

    public void setResult(List<DataModel> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
