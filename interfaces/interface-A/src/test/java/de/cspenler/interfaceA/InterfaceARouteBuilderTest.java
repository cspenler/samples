package de.cspenler.interfaceA;

import de.cspenler.model.serviceA.ServiceAContainer;
import de.cspenler.model.serviceA.ServiceARequest;
import de.cspenler.model.serviceA.ServiceAResponse;
import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterfaceARouteBuilderTest extends CamelSpringTestSupport {

    @Test
    public void test() throws Exception {
        ServiceAContainer container = new ServiceAContainer();
        ServiceARequest request = new ServiceARequest();
        ServiceAResponse response = new ServiceAResponse();

        container.setRequest(request);
        container.setResponse(response);
        Exchange exchange = createExchangeWithBody(container);
        template.send("direct-vm:interface-a", exchange);
        assertTrue(response.getResponseValue().contains("backend-a:"));
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/context-test.xml");
    }
}
