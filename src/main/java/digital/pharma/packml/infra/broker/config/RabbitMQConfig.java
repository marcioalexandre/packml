package digital.pharma.packml.infra.broker.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${infra.config.rabbitmq.queue}")
    String queue;

    @Value("${infra.config.rabbitmq.exchange}")
    String exchange;

    @Value("${infra.config.rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    Queue queue(){
        return new Queue(queue, false);
    }

    @Bean
    DirectExchange exchange(){
        return new DirectExchange(exchange);
    }
}
