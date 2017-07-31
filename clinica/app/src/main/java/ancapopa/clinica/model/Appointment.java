package ancapopa.clinica.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anca.popa on 7/20/2017.
 */
public class Appointment {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("medic_id")
    @Expose
    private String medic_id;

    @SerializedName("clinic_id")
    @Expose
    private String clinic_id;

    @SerializedName("section_id")
    @Expose
    private String section_id;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("status")
    @Expose
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMedic_id() {
        return medic_id;
    }

    public void setMedic_id(String medic_id) {
        this.medic_id = medic_id;
    }

    public String getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(String clinic_id) {
        this.clinic_id = clinic_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String clinic_id) {
        this.section_id = section_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatus() { return status; }

    public void setStatus (Integer status) {
        this.status = status;
    }


}