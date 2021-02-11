package technology.grameen.gk.health.api.responses;

import technology.grameen.gk.health.api.entity.Patient;

public class PatientCreationResponse implements IResponse {
    int status;
    String msg;
    Patient patient =null;

    public PatientCreationResponse(int status, String msg){
        this.status = status;
        this.msg = msg;
    }

    public PatientCreationResponse(int status, Patient patient){
        this.status = status;
        this.patient = patient;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
