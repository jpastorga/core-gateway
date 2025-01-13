package com.example.config;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {

    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                // Configuraciones previas al inicio de Camel
                context.setTracing(false);  // Deshabilita el trazado de Camel para producción (opcional)
                context.getShutdownStrategy().setTimeout(10);  // Configura tiempo de espera al apagar
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                // Lógica personalizada después de que la aplicación haya iniciado (opcional)
            }
        };
    }
}
