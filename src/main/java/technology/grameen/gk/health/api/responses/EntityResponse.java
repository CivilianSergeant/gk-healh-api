package technology.grameen.gk.health.api.responses;

public class EntityResponse implements IResponse {
    private int status;
    private Object object;

    public EntityResponse(int status, Object object) {
        this.status = status;
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
