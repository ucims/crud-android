package www.heartfilia.com.madun.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import www.heartfilia.com.madun.model.ResponsModel;

/**
 * Created by heartfilia on 04/02/2018.
 */

public interface ApiRequestPengumuman {

    @FormUrlEncoded
    @POST("insert_berita.php")
    Call<ResponsModel> sendPengumuman(@Field("tanggal") String tanggal,
                                      @Field("isi") String isi,
                                      @Field("jenis") String jenis,
                                      @Field("judul") String judul);
    @GET("view_berita.php")
    Call<ResponsModel> getPengumuman();

    @FormUrlEncoded
    @POST("update_berita.php")
    Call<ResponsModel> updateBerita(@Field("id_berita") String id_berita,
                                    @Field("tanggal") String tanggal,
                                    @Field("isi") String isi,
                                    @Field("jenis") String jenis,
                                    @Field("judul") String judul);

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponsModel> deleteBerita(@Field("id_berita") String id_berita);


}
