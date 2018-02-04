package de.cspenler.serviceB;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.cspenler.model.serviceB.ServiceBContainer;
import de.cspenler.model.serviceB.ServiceBRequest;
import de.cspenler.model.serviceB.ServiceBResponse;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class ServiceBRouteBuilderTest extends CamelSpringTestSupport {

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/context-test.xml");
    }

    @Test
    public void test() throws Exception {
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct-vm:interface-b")
                    .process(e -> {
                        ServiceBResponse response = e.getIn().getBody(ServiceBContainer.class).getResponse();
                        response.setResponseValue("mockBResponse");
                    });
            }
        });
        ServiceBRequest request = new ServiceBRequest();
        request.setId("id1");
        request.setRequestValue("testValue");
        ObjectMapper om = new ObjectMapper();
        String jsonRequest = om.writeValueAsString(request);
        template.sendBody("undertow:http://localhost:8080/service-b/read", request);
    }
}
