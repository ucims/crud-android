package www.heartfilia.com.madun.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by heartfilia on 03/02/2018.
 */

public class RetroServer {
    private static final String base_url = "http://192.168.43.15/madun2/crud/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
