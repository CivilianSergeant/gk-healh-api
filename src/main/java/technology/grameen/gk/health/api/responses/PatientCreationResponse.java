package technology.grameen.gk.health.api.responses;

import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientSearchResult;
import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;

public class PatientCreationResponse implements IResponse {
    int status;
    String message;
    Object patient =null;

    public PatientCreationResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    public PatientCreationResponse(int status, PatientSearchResult patient){
        this.status = status;
        this.patient = patient;
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

    public Object getPatient() {
        return patient;
    }

    public void setPatient(PatientInvoiceDetail patient) {
        this.patient = patient;
    }
}
