package io.virtualan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootApplication
@ComponentScan(basePackages = {"io.virtualan", "io.virtualan.configuration"})
@EmbeddedKafka(partitions = 1, controlledShutdown = false, brokerProperties = {
        "listeners=PLAINTEXT://localhost:9092", "port=9092",
        "log.dir=target/kafka-logs"})
public class Virtualization implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Virtualization.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }

}