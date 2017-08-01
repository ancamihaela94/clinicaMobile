package ancapopa.clinica.http.methods;

import ancapopa.clinica.model.Login;
import ancapopa.clinica.model.User;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by anca.popa on 7/20/2017.
 */
public interface Logins {
    @POST("/api/login")
    @FormUrlEncoded
    Call<User> login(@Body Login login);

}