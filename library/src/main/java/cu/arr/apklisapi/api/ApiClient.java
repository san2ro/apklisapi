package cu.arr.apklisapi.api;

import cu.arr.apklisapi.api.models.ApklisResponse;
import cu.arr.apklisapi.api.models.ApklisUrlResponse;
import cu.arr.apklisapi.api.requests.ApklisUrlRequest;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("application/{packageName}")
    Single<ApklisResponse> getAppInfo(@Path("packageName") String packageName);

    @POST("release/get_url/")
    Single<ApklisUrlResponse> getUrl(@Body ApklisUrlRequest body);
}
