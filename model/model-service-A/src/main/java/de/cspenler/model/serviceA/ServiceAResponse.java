package de.cspenler.model.serviceA;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ServiceAResponse implements Serializable {

    private String id;
    private String responseValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("responseValue", responseValue)
                .toString();
    }
}
