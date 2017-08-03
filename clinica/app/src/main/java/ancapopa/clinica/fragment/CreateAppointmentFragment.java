package ancapopa.clinica.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ancapopa.clinica.R;
import ancapopa.clinica.http.Api;
import ancapopa.clinica.http.methods.Appointments;
import ancapopa.clinica.http.methods.Cities;
import ancapopa.clinica.http.methods.Clinics;
import ancapopa.clinica.model.Appointment;
import ancapopa.clinica.model.AppointmentsResponse;
import ancapopa.clinica.model.CitiesResponse;
import ancapopa.clinica.model.City;
import ancapopa.clinica.model.Clinic;
import ancapopa.clinica.model.ClinicsResponse;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by anca.popa on 27/07/2017.
 */

public class CreateAppointmentFragment extends Fragment {

    City selectedCity = null;
    Clinic selectedClinic = null;
    Spinner citySpinner = null;
    Spinner clinicsSpinner = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment_create, container, false);
        citySpinner = (Spinner) view.findViewById(R.id.cities_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                selectedCity = (City) adapterView.getItemAtPosition(pos);
                populateClinics();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedCity = null;
            }
        });

        clinicsSpinner = (Spinner) view.findViewById(R.id.clinics_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        clinicsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                selectedClinic = (Clinic) adapterView.getItemAtPosition(pos);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedClinic = null;
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Cities citiesService = (new Api()).getCitiesService();
        Call<CitiesResponse> citiesCall = citiesService.listCities();
        Log.d("CLINICA","Something");
        citiesCall.enqueue(new Callback<CitiesResponse>() {

            @Override
            public void onResponse(Response<CitiesResponse> response, Retrofit retrofit) {

                List<City> results = new ArrayList<>();
                results.add((new City()).setName("--Alege--"));
                results.addAll(response.body().getData());

                ArrayAdapter<City> adapter =
                        new ArrayAdapter<City>(getContext(), android.R.layout.simple_spinner_dropdown_item, results);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                citySpinner.setAdapter(adapter);
                //response.body().getData().;
                Log.d("CLINICA - cities call",String.valueOf(response.body().getStatus()));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("CLINICA - cities call","Error");
            }
        });








//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        spinner.set


    }

    public void populateClinics(){
        if(selectedCity != null && selectedCity.getId() != null) {
            Clinics clinicsService = (new Api()).getClinicsService();
            Call<ClinicsResponse> clinicsCall = clinicsService.listClinicsByCityId(selectedCity.getId());
            Log.d("CLINICA","Something");
            clinicsCall.enqueue(new Callback<ClinicsResponse>() {

                @Override
                public void onResponse(Response<ClinicsResponse> response, Retrofit retrofit) {
                    List<Clinic> results = new ArrayList<>();
                    results.add((new Clinic()).setName("--Alege--"));
                    results.addAll(response.body().getData());

                    ArrayAdapter<Clinic> adapter =
                            new ArrayAdapter<Clinic>(getContext(), android.R.layout.simple_spinner_dropdown_item, results);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    clinicsSpinner.setAdapter(adapter);
                    //response.body().getData().;
                    Log.d("CLINICA - clinics call",String.valueOf(response.body().getStatus()));
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("CLINICA - clinics call","Error");
                }
            });
        } else {
            List<Clinic> results = new ArrayList<>();
            results.add((new Clinic()).setName("--Alege orasul--"));

            ArrayAdapter<Clinic> adapter =
                    new ArrayAdapter<Clinic>(getContext(), android.R.layout.simple_spinner_dropdown_item, results);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            clinicsSpinner.setAdapter(adapter);
        }

    }


}
