package cu.arr.apklisapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.UrlRequest;
import androidx.annotation.NonNull;
import cu.arr.apklisapi.api.ApiRetrofit;
import cu.arr.apklisapi.api.models.ApklisResponse;

import cu.arr.apklisapi.api.models.ApklisUrlResponse;
import cu.arr.apklisapi.api.requests.ApklisUrlRequest;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Apklis {

    private static final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @FunctionalInterface
    public interface Callback<T, U> {
        void call(T t, U u);
    }

    public static void checkUpdate(
            Context c,
            Callback<ApklisResponse, ApklisUrlResponse> onSuccess,
            Callback<Throwable, Void> onError) {

        Disposable disposable =
                ApiRetrofit.auth()
                        .getAppInfo(c.getPackageName())
                        .subscribeOn(Schedulers.io())
                        .flatMapObservable(
                                infoApp -> {
                                    if (infoApp.getLastRelease().getVersionCode()
                                            > versionCode(c)) {
                                        return ApiRetrofit.auth()
                                                .getUrl(
                                                        new ApklisUrlRequest(
                                                                infoApp.getLastRelease()
                                                                        .getSHA256()))
                                                .toObservable()
                                                .map(
                                                        urlResponse ->
                                                                new Pair<>(infoApp, urlResponse));
                                    } else {
                                        return Observable.empty();
                                    }
                                })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                pair -> onSuccess.call(pair.first, pair.second),
                                error -> onError.call(error, null));

        compositeDisposable.add(disposable);
    }

    public static void stopCheckUpdate() {
        compositeDisposable.clear();
    }

    @SuppressWarnings("deprecation")
    public static int versionCode(@NonNull Context context) {
        try {
            PackageInfo info =
                    context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static class Pair<F, S> {
        final F first;
        final S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
