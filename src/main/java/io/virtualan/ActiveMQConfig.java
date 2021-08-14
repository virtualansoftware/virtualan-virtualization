package io.virtualan;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
@ConditionalOnProperty(havingValue="true", name="enable.amq")
public class ActiveMQConfig {

    @Bean
    @Order(1)
    public Queue queue() {
        return new ActiveMQQueue("virtualan.input");
    }

}