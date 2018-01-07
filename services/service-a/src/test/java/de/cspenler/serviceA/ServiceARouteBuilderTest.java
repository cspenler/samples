package de.cspenler.serviceA;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.cspenler.model.serviceA.ServiceAContainer;
import de.cspenler.model.serviceA.ServiceARequest;
import de.cspenler.model.serviceA.ServiceAResponse;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class ServiceARouteBuilderTest extends CamelSpringTestSupport {

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/context-test.xml");
    }

    @Test
    public void test() throws Exception {
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct-vm:interface-a")
                    .process(e -> {
                        ServiceAResponse response = e.getIn().getBody(ServiceAContainer.class).getResponse();
                        response.setResponseValue("mockAResponse");
                    });
            }
        });
        ServiceARequest request = new ServiceARequest();
        request.setId("id1");
        request.setRequestValue("testValue");
        ObjectMapper om = new ObjectMapper();
        String jsonRequest = om.writeValueAsString(request);
        template.sendBody("undertow:http://localhost:8080/service-a/read", request);
    }
}
