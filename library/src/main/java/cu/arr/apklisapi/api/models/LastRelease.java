package cu.arr.apklisapi.api.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class LastRelease {

    @SerializedName("developer")
    public String developer;

    @SerializedName("version_name")
    public String versionName;

    @SerializedName("package_name")
    public String package_name;

    @SerializedName("version_sdk_name")
    public String version_sdk_name;

    @SerializedName("version_target_sdk_name")
    public String version_target_sdk_name;

    @SerializedName("version_code")
    public int versionCode;

    @SerializedName("app_name")
    public String appName;

    @SerializedName("changelog")
    public String changelog;

    @SerializedName("size")
    public long size;

    @SerializedName("sha256")
    public String sha;

    @SerializedName("version_sdk")
    public int version_sdk;

    @SerializedName("version_target_sdk")
    public int version_target_sdk;

    public String getDeveloper() {
        return developer;
    }

    public String getAppPackageName() {
        return package_name;
    }

    public String getVersionSDKName() {
        return version_sdk_name;
    }

    public String getVersionTargetSDKName() {
        return version_target_sdk_name;
    }

    public String getVersionName() {
        return versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public String getAppName() {
        return appName;
    }

    public String getChangelog() {
        return changelog;
    }

    public long getLongSize() {
        return size;
    }

    public String getSHA256() {
        return sha;
    }

    public int getVersionSDK() {
        return version_sdk;
    }

    public int getVersionTargetSDK() {
        return version_target_sdk;
    }
}
