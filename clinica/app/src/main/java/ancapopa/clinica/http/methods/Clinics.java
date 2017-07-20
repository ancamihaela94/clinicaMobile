package ancapopa.clinica.http.methods;

import ancapopa.clinica.model.CitiesResponse;
import ancapopa.clinica.model.ClinicsResponse;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by anca.popa on 7/20/2017.
 */
public interface Clinics {
    @GET("/api/clinics")
    Call<ClinicsResponse> listClinics();

}