package de.cspenler.interfaceA;

import org.apache.camel.builder.RouteBuilder;

public class InterfaceARouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("direct-vm:interface-a")
            .log("interface a")
            .enrich("direct:backendA", new AAggregationStrategy());

        from("direct:backendA")
            .bean(BackendADAO.class, "getValue");
    }
}
