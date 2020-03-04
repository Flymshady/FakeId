package cz.cellar.fakeid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cz.cellar.fakeid.retrofit.Client;
import cz.cellar.fakeid.retrofit.FakeId;
import cz.cellar.fakeid.retrofit.UINameService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView avatar;
    TextView name;
    TextView sex;
    TextView country;
    TextView phone;
    TextView email;
    TextView bDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avatar= findViewById(R.id.avatar);
        name= findViewById(R.id.name);
       sex= findViewById(R.id.sex);
       country= findViewById(R.id.country);
        phone= findViewById(R.id.phone);
       email= findViewById(R.id.email);
        bDate= findViewById(R.id.bDate);

        UINameService http = Client.getClient().create(UINameService.class);

        http.ext().enqueue(new Callback<FakeId>() {
            @Override
            public void onResponse(Call<FakeId> call, Response<FakeId> response) {
                if(!response.isSuccessful()){
                    //error
                    return;
                }else{
                  FakeId fakeId=  response.body();
                  assert fakeId != null;

                  name.setText(fakeId.getName());
                    sex.setText(fakeId.getGender());
                    country.setText(fakeId.getRegion());
                    phone.setText(fakeId.getPhone());
                    email.setText(fakeId.getEmail());
                    bDate.setText(fakeId.getBirthday().getDmy());

                    Picasso.get().load(fakeId.getPhoto()).into(avatar);
                }
            }

            @Override
            public void onFailure(Call<FakeId> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
