package de.cspenler.interfaceB;

import org.apache.camel.builder.RouteBuilder;

public class InterfaceBRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("direct-vm:interface-b")
            .log("interface b")
            .enrich("direct:backendB", new BAggregationStrategy());

        from("direct:backendB")
            .bean(BackendBService.class, "invoke");
    }
}
