package de.cspenler.serviceB;

import de.cspenler.model.serviceB.ServiceBContainer;
import de.cspenler.model.serviceB.ServiceBRequest;
import de.cspenler.model.serviceB.ServiceBResponse;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;

@Converter
public final class TypeConverter {

    private TypeConverter() {

    }

    @Converter
    public static ServiceBContainer convertToContainer(ServiceBRequest request, Exchange exchange) {
        ServiceBContainer container = new ServiceBContainer();
        container.setRequest(request);
        container.setResponse(new ServiceBResponse());
        container.getResponse().setId(request.getId());
        return container;
    }
}