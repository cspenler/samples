package de.cspenler.serviceA;

import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

public class ServiceARouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        rest("/uuid")
                .produces("plain/text")
            .get("create")
                .route()
                .process(e -> {
                    e.getOut().setBody(UUID.randomUUID().toString());
                });
    }
}
