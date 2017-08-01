package ancapopa.clinica.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anca.popa on 7/20/2017.
 */
public class Login {

    @SerializedName("id")
    @Expose
    private String user;

    @SerializedName("name")
    @Expose
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

}