package ancapopa.clinica.http.methods;

import ancapopa.clinica.model.AppointmentsResponse;
import ancapopa.clinica.model.RecordsResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by anca.popa on 7/20/2017.
 */
public interface Appointments {
    @GET("/api/user-appointments/{id}")
    Call<AppointmentsResponse> getAppointmentsByUserId(@Path("id") int id);

}