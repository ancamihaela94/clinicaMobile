package ancapopa.clinica.http;

import ancapopa.clinica.http.methods.Cities;
import ancapopa.clinica.http.methods.Clinics;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


/**
 * Created by anca.popa on 7/20/2017.
 */
public class Api {

    Retrofit retrofit;

    public Api() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Cities getCitiesService() {
        return retrofit.create(Cities.class);
    }

    public Clinics getClinicsService() {
        return retrofit.create(Clinics.class);
    }



}
