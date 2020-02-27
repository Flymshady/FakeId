package cz.cellar.fakeid.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface UINameService {
        @GET("users/{user}/repos")
        Call<FakeId> ext();

}
