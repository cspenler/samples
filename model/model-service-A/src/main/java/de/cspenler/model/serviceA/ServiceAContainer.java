package de.cspenler.model.serviceA;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ServiceAContainer implements Serializable {

    private ServiceARequest request;
    private ServiceAResponse response;

    public ServiceARequest getRequest() {
        return request;
    }

    public void setRequest(ServiceARequest request) {
        this.request = request;
    }

    public ServiceAResponse getResponse() {
        return response;
    }

    public void setResponse(ServiceAResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("request", request)
                .append("response", response)
                .toString();
    }
}
