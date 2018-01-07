package de.cspenler.model.serviceB;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ServiceBRequest implements Serializable {

    private String id;
    private String requestValue;

    public ServiceBRequest() {
    }

    public ServiceBRequest(String id, String requestValue) {
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
