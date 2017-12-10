package de.cspenler.serviceUUID;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

public class ServiceARouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        restConfiguration()
            .component("undertow")
            .port(8080);

        rest("/uuid")
                .produces("plain/text")
            .get("create")
                .route()
                .process(e -> {
                    e.getOut().setBody(UUID.randomUUID().toString());
                })
                .setHeader(Exchange.CONTENT_TYPE, constant("plain/text"));
    }
}
