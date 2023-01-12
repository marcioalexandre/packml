package digital.pharma.packml.infra.broker.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired
    RabbitTemplate template;
    @Value("${infra.config.rabbitmq.queue}")
    private String queue;
    @Value("${infra.config.rabbitmq.exchange}")
    private String exchange;
    @Value("${infra.config.rabbitmq.routing-key}")
    private String routingKey;

    @Scheduled
    public void send(String message){
        template.convertAndSend(exchange, routingKey, message);
    }

}
