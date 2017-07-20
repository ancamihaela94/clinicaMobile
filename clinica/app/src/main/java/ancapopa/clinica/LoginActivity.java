package ancapopa.clinica;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ancapopa.clinica.http.Api;
import ancapopa.clinica.http.methods.Cities;
import ancapopa.clinica.http.methods.Clinics;
import ancapopa.clinica.model.CitiesResponse;
import ancapopa.clinica.model.ClinicsResponse;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Cities citiesService = (new Api()).getCitiesService();
        Call<CitiesResponse> citiesCall = citiesService.listCities();
        Log.d("CLINICA","Something");
        citiesCall.enqueue(new Callback<CitiesResponse>() {

            @Override
            public void onResponse(Response<CitiesResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - cities call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - cities call","Error");
            }
        });

        Clinics clinicsService = (new Api()).getClinicsService();
        Call<ClinicsResponse> clinicsCall = clinicsService.listClinics();
        Log.d("CLINICA","Something");
        clinicsCall.enqueue(new Callback<ClinicsResponse>() {

            @Override
            public void onResponse(Response<ClinicsResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - clinics call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - clinics call","Error");
            }
        });
    }
}
