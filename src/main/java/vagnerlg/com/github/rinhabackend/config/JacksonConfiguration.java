package vagnerlg.com.github.rinhabackend.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.featuresToDisable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
    }
}