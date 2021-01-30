package academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // No need to include @Component annotation because @Configuration includes @Component

public class AppConfig {

    // == bean methods ==
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
