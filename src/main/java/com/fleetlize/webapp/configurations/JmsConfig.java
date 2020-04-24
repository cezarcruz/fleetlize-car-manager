package com.fleetlize.webapp.configurations;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    @Bean
    public ConnectionFactory receiverActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
            new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");

        return activeMQConnectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(receiverActiveMQConnectionFactory());
        factory.setPubSubDomain(true);

        return factory;
    }


}
