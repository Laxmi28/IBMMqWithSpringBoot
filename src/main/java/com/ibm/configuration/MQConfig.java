package com.ibm.configuration;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

@Configuration
public class MQConfig {

    @Value("${ibm.mq.queue-manager}")
    private String queueManager;

    @Value("${ibm.mq.connName}")
    private String connectionName;

    @Value("${ibm.mq.channel}")
    private String channel;

    @Value("${ibm.mq.user}")
    private String user;

    @Value("${ibm.mq.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() throws JMSException {
        MQConnectionFactory factory = new MQConnectionFactory();
        factory.setQueueManager(queueManager);
        factory.setChannel(channel);
        factory.setConnectionNameList(connectionName);
        factory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
        factory.setStringProperty(WMQConstants.USERID, user);
        factory.setStringProperty(WMQConstants.PASSWORD, password);
        return factory; // jakarta.jms.ConnectionFactory
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-3");
        return factory;
    }
}
