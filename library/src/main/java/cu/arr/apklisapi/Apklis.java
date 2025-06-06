package cu.arr.apklisapi;

import cu.arr.apklisapi.api.ApiRetrofit;
import cu.arr.apklisapi.api.models.ApklisResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Apklis {

    private static final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @FunctionalInterface
    public interface Callback<T> {
        void call(T t);
    }

    public static void checkUpdate(
            String appPackageName,
            Callback<ApklisResponse> onSuccess,
            Callback<Throwable> onError) {

        Disposable disposable =
                ApiRetrofit.auth()
                        .getAppInfo(appPackageName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(onSuccess::call, onError::call);

        compositeDisposable.add(disposable);
    }

    public static void stopCheckUpdate() {
        compositeDisposable.clear();
    }
}
