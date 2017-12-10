package de.cspenler.interfaceA;

import de.cspenler.model.serviceA.ServiceAContainer;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AAggregationStrategy implements AggregationStrategy {

    private final static Logger LOG = LoggerFactory.getLogger(AAggregationStrategy.class);

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        ServiceAContainer container = oldExchange.getIn().getBody(ServiceAContainer.class);
        container.getResponse().setResponseValue(newExchange.getIn().getBody(String.class));
        LOG.info("aggregated response: {}", container.getResponse().toString());
        return oldExchange;
    }
}
