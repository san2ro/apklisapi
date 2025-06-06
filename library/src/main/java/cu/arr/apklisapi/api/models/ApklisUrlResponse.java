package cu.arr.apklisapi.api.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class ApklisUrlResponse {

    @SerializedName("url")
    public String url;

    public ApklisUrlResponse(String url) {
        this.url = url;
    }

    public String getDownloadUrl() {
        return url;
    }
}
