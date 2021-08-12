package io.virtualan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class KafkaConfig {

    private int kafkaPort;

    private int zkPort;

    @Bean
    public EmbeddedKafkaBroker broker() throws IOException {
        ServerSocket ss = ServerSocketFactory.getDefault().createServerSocket(9092);
        this.kafkaPort = ss.getLocalPort();
        ss.close();

        EmbeddedKafkaBroker embeddedKafkaBroker = new EmbeddedKafkaBroker(1, false);
        embeddedKafkaBroker.kafkaPorts(this.kafkaPort);
        //embeddedKafkaBroker.brokerProperty("log.dir", "target/kafka-logs");
        return embeddedKafkaBroker;

    }

}