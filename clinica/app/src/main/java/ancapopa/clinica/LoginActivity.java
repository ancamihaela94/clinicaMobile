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
import ancapopa.clinica.http.methods.Appointments;
import ancapopa.clinica.http.methods.Cities;
import ancapopa.clinica.http.methods.Clinics;
import ancapopa.clinica.http.methods.Medics;
import ancapopa.clinica.http.methods.Records;
import ancapopa.clinica.http.methods.Sections;
import ancapopa.clinica.model.AppointmentsResponse;
import ancapopa.clinica.model.CitiesResponse;
import ancapopa.clinica.model.ClinicsResponse;
import ancapopa.clinica.model.MedicsResponse;
import ancapopa.clinica.model.RecordsResponse;
import ancapopa.clinica.model.Section;
import ancapopa.clinica.model.SectionsResponse;
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

        Sections sectionsService = (new Api()).getSectionsService();
        Call<SectionsResponse> sectionsCall = sectionsService.listSections();
        Log.d("CLINICA","sections call");
        sectionsCall.enqueue(new Callback<SectionsResponse>() {

            @Override
            public void onResponse(Response<SectionsResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - sections call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - sections call","Error");
            }
        });


        Records recordsService = (new Api()).getRecordsService();
        Call<RecordsResponse> recordsCall = recordsService.getRecordsByUserId(3);
        Log.d("CLINICA","records call");
        recordsCall.enqueue(new Callback<RecordsResponse>() {

            @Override
            public void onResponse(Response<RecordsResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - records call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - records call","Error");
            }
        });


        Sections sectionService = (new Api()).getSectionsService();
        Call<SectionsResponse> sectionsByClinicId = sectionService.getSectionsByClinicId(9);
        Log.d("CLINICA","section by clinic id call");
        sectionsByClinicId.enqueue(new Callback<SectionsResponse>() {

            @Override
            public void onResponse(Response<SectionsResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - section call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - section call","Error");
            }
        });



        Medics medicsService = (new Api()).getMedicsService();
        Call<MedicsResponse> medicsResponseCall = medicsService.listMedics(16,1);
        Log.d("CLINICA","medic call");
        medicsResponseCall.enqueue(new Callback<MedicsResponse>() {

            @Override
            public void onResponse(Response<MedicsResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - medic call ",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - medic call","Error");
            }
        });


        Appointments appointmentService = (new Api()).getAppointmentsService();
        Call<AppointmentsResponse> appointmentsByUser = appointmentService.getAppointmentsByUserId(3);
        Log.d("CLINICA","appointments call");
        appointmentsByUser.enqueue(new Callback<AppointmentsResponse>() {

            @Override
            public void onResponse(Response<AppointmentsResponse> response, Retrofit retrofit) {
                Log.d("CLINICA - appointments call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - appointments call","Error");
            }
        });



    }
}
