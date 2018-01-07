package de.cspenler.serviceA;

import de.cspenler.model.serviceA.ServiceAContainer;
import de.cspenler.model.serviceA.ServiceARequest;
import de.cspenler.model.serviceA.ServiceAResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class ServiceARouteBuilder extends RouteBuilder {

    final static Logger LOG = LoggerFactory.getLogger(ServiceARouteBuilder.class);

    public void configure() throws Exception {
        restConfiguration()
            .component("{{rest.component:servlet}}")
            .port(8080);

        onException(Exception.class)
            .process(e -> {
                LOG.error("Body: " + e.getIn().getBody());
                LOG.error("Exception: ", e.getProperty(Exchange.EXCEPTION_CAUGHT));
            })
            .handled(true);

        rest("/service-a")
            .post("read")
                .bindingMode(RestBindingMode.json)
                .type(ServiceARequest.class)
                .outType(ServiceAResponse.class)
                .produces("plain/text")
                .route()
                    .log("processing service-a...")
                    .convertBodyTo(ServiceAContainer.class)
                    .inOut("direct-vm:interface-a")
                    .setBody(simple("${body.response}"));
    }
}
