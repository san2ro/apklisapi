package cu.arr.apklisapi.api.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class ApklisResponse {

    @SerializedName("size")
    public String size;

    @SerializedName("rating")
    public String rating;

    @SerializedName("icon")
    public String icon;

    @SerializedName("download_count")
    public String download_count;

    @SerializedName("beta")
    public boolean beta;

    @SerializedName("last_release")
    public LastRelease lastRelease;

    public String getSize() {
        return size;
    }

    public String getRating() {
        return rating;
    }

    public String getIconUrl() {
        return icon;
    }

    public String getDownloadCount() {
        return download_count;
    }

    public boolean isBeta() {
        return beta;
    }

    public LastRelease getLastRelease() {
        return lastRelease;
    }
}
