package de.cspenler.model.serviceA;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ServiceARequest implements Serializable {

    private String id;
    private String requestValue;

    public ServiceARequest() {
    }

    public ServiceARequest(String id, String requestValue) {
        this.id = id;
        this.requestValue = requestValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("requestValue", requestValue)
            .toString();
    }
}
