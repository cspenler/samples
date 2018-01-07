package de.cspenler.interfaceB;

import de.cspenler.model.serviceB.ServiceBContainer;
import org.apache.camel.Body;

public class BackendBService {
    public String invoke(@Body ServiceBContainer container) {
        return new StringBuilder("backend-b-result-for-input:")
                .append(container.getRequest().getRequestValue()).toString();
    }
}
