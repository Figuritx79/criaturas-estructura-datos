package mx.edu.utez.criaturasestructuradatos.utils;

public class ReponseObject {
    private String message;
    private Type typeResponse;
    private Object result;

    public ReponseObject(Object result, String message, Type typeResponse) {
        this.result = result;
        this.message = message;
        this.typeResponse = typeResponse;
    }

    public ReponseObject(String message, Type typeResponse) {
        this.message = message;
        this.typeResponse = typeResponse;
    }

    public ReponseObject(String message, Type typeResponse, Object result) {
        this.message = message;
        this.typeResponse = typeResponse;
        this.result = result;
    }

    public ReponseObject() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getTypeResponse() {
        return typeResponse;
    }

    public void setTypeResponse(Type typeResponse) {
        this.typeResponse = typeResponse;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
