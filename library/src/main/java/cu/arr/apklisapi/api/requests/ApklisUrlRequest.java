package cu.arr.apklisapi.api.requests;
import androidx.annotation.Keep;

@Keep
public class ApklisUrlRequest {

    private String sha256;

    public ApklisUrlRequest(String sha256) {
        this.sha256 = sha256;
    }
}
