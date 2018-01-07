package de.cspenler.model.serviceA;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class ServiceARequestTest {

    @Test
    public void marshal() throws Exception {
        ObjectMapper om = new ObjectMapper();
        ServiceARequest request = new ServiceARequest("id", "value");
        System.out.println(om.writeValueAsString(request));
    }

    @Test
    public void unmarshal() throws Exception {
        ObjectMapper om = new ObjectMapper();
        ServiceARequest request = om.readValue("{\"id\":\"test-id\"}", ServiceARequest.class);
        Assert.assertEquals("test-id", request.getId());
    }
}
