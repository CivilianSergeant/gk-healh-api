package technology.grameen.gk.health.api.responses;

import technology.grameen.gk.health.api.entity.Patient;

public class PatientCreationResponse implements IResponse {
    int status;
    String message;
    Patient patient =null;

    public PatientCreationResponse(int status, String message){
        this.status = status;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
