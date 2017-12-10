package de.cspenler.serviceA;

import de.cspenler.model.serviceA.ServiceARequest;
import de.cspenler.model.serviceA.ServiceAResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import java.util.UUID;

public class ServiceARouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        restConfiguration()
            .component("undertow")
            .port(8080);

        rest("/service-a")
            .get("read")
                .bindingMode(RestBindingMode.json)
                .type(ServiceARequest.class)
                .outType(ServiceAResponse.class)
                .produces("plain/text")
                .route();
    }
}
