package technology.grameen.gk.health.api.projection;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class EmployeeSyncResponseObject {

    private String Message;

    private Boolean IsSuccess;

    private Boolean ContinueProcess;

    private String ReturnCode;

    private String ReturnMessage;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getSuccess() {
        return IsSuccess;
    }

    public void setSuccess(Boolean success) {
        IsSuccess = success;
    }

    public Boolean getContinueProcess() {
        return ContinueProcess;
    }

    public void setContinueProcess(Boolean continueProcess) {
        ContinueProcess = continueProcess;
    }

    public String getReturnCode() {
        return ReturnCode;
    }

    public void setReturnCode(String returnCode) {
        ReturnCode = returnCode;
    }

    public String getReturnMessage() {
        return ReturnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        ReturnMessage = returnMessage;
    }
}
