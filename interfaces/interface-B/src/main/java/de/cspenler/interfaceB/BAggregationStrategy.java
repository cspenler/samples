package de.cspenler.interfaceB;

import de.cspenler.model.serviceB.ServiceBContainer;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BAggregationStrategy implements AggregationStrategy {

    private final static Logger LOG = LoggerFactory.getLogger(BAggregationStrategy.class);

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        ServiceBContainer container = oldExchange.getIn().getBody(ServiceBContainer.class);
        container.getResponse().setResponseValue(newExchange.getIn().getBody(String.class));
        LOG.info("aggregated response: {}", container.getResponse().toString());
        return oldExchange;
    }
}
