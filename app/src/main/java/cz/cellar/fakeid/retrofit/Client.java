package cz.cellar.fakeid.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Client {
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if(retrofit!=null){
            return retrofit;
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("https://uinames.com")
              //  .baseUrl("https://uinames.com/api/?ext")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit;
    }

}
