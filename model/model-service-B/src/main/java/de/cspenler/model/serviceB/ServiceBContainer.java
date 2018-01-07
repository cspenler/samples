package de.cspenler.model.serviceB;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ServiceBContainer implements Serializable {

    private ServiceBRequest request;
    private ServiceBResponse response;

    public ServiceBRequest getRequest() {
        return request;
    }

    public void setRequest(ServiceBRequest request) {
        this.request = request;
    }

    public ServiceBResponse getResponse() {
        return response;
    }

    public void setResponse(ServiceBResponse response) {
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
