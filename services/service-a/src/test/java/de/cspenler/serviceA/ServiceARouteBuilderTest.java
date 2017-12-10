package de.cspenler.serviceA;

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
        Thread.sleep(1 * 60 * 1000);
        assertTrue(true);
    }
}
