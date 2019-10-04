package repository;

import java.util.concurrent.TimeUnit;

import acs.castac.ricsvil.mrmadom3.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "https://ghibliapi.herokuapp.com";
    //Where we are going, we dont need security stuff

    private static final boolean DEBUG = true;
    private static final int READ_TIMEOUT = 10;

    //I am (security) stuff.
    private static final HttpLoggingInterceptor sHTTP_LOGGING_INTERCEPTOR =
            new HttpLoggingInterceptor().setLevel
                    (HttpLoggingInterceptor.Level.BODY );


    private static OkHttpClient.Builder sHBuilder = new OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(sHTTP_LOGGING_INTERCEPTOR);

    private static OkHttpClient sOkHttpClient = sHBuilder.build();

    private static Retrofit.Builder sRetroBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit sRetrofit = sRetroBuilder.client(sOkHttpClient).build();

    public static <S> S createService(Class<S> serviceClass){
        return sRetrofit.create(serviceClass);
    }

}
