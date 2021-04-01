package technology.grameen.gk.health.api.projection;

public class EmployeeSyncResponseObject {

    private String Message;

    private Boolean IsSuccess;

    private Boolean ContinueProcess;

    private String ReturnCode;

    private String ReturnMessage;

    public EmployeeSyncResponseObject(){}

    public EmployeeSyncResponseObject(String message, Boolean isSuccess, Boolean continueProcess, String returnCode, String returnMessage) {
        Message = message;
        IsSuccess = isSuccess;
        ContinueProcess = continueProcess;
        ReturnCode = returnCode;
        ReturnMessage = returnMessage;
    }

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
