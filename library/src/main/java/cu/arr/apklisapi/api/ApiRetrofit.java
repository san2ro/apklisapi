package cu.arr.apklisapi.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    private static Retrofit retrofit =
            new Retrofit.Builder()
                    .baseUrl("https://api.apklis.cu/v3/")
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    public static ApiClient auth() {
        return retrofit.create(ApiClient.class);
    }
}
