package de.cspenler.interfaceB;

import de.cspenler.model.serviceB.ServiceBContainer;
import de.cspenler.model.serviceB.ServiceBRequest;
import de.cspenler.model.serviceB.ServiceBResponse;
import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterfaceBRouteBuilderTest  extends CamelSpringTestSupport {

    @Test
    public void test() throws Exception {
        ServiceBContainer container = new ServiceBContainer();
        ServiceBRequest request = new ServiceBRequest();
        request.setRequestValue("foo");
        ServiceBResponse response = new ServiceBResponse();

        container.setRequest(request);
        container.setResponse(response);
        Exchange exchange = createExchangeWithBody(container);
        template.send("direct-vm:interface-b", exchange);
        assertTrue(response.getResponseValue().contains("backend-b-result-for-input:foo"));
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/context-test.xml");
    }
}
