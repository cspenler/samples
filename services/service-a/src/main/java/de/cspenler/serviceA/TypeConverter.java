package de.cspenler.serviceA;

import de.cspenler.model.serviceA.ServiceAContainer;
import de.cspenler.model.serviceA.ServiceARequest;
import de.cspenler.model.serviceA.ServiceAResponse;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;

@Converter
public final class TypeConverter {

    private TypeConverter() {

    }

    @Converter
    public static ServiceAContainer convertToContainer(ServiceARequest request, Exchange exchange) {
        ServiceAContainer container = new ServiceAContainer();
        container.setRequest(request);
        container.setResponse(new ServiceAResponse());
        container.getResponse().setId(request.getId());
        return container;
    }
}