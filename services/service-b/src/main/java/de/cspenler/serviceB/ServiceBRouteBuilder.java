package de.cspenler.serviceB;

import de.cspenler.model.serviceB.ServiceBContainer;
import de.cspenler.model.serviceB.ServiceBRequest;
import de.cspenler.model.serviceB.ServiceBResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceBRouteBuilder extends RouteBuilder {

    final static Logger LOG = LoggerFactory.getLogger(ServiceBRouteBuilder.class);

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

        rest("/service-b")
            .post("read")
                .bindingMode(RestBindingMode.json)
                .type(ServiceBRequest.class)
                .outType(ServiceBResponse.class)
                .produces("plain/text")
                .route()
                    .log("processing service-b...")
                    .convertBodyTo(ServiceBContainer.class)
                    .inOut("direct-vm:interface-b")
                    .setBody(simple("${body.response}"));
    }
}
