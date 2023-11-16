/*SPRING INITIALIZER : DEPENDANCE ACTIVEMQ5*/

//rajouter ca au pom

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-json</artifactId> 
</dependency>

//manipuler donnees json


//

    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

        public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all auto-configured defaults to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some settings if necessary.
        return factory;
    }



//

curl -u admin:admin -XPOST -d "body={\"to\":\"info@example.com\",\"body\":\"Curl Queue Hello\"}" -d "_type=be.hepl.activemq.Email" -d "priority=high" http://localhost:8161/api/message/mailbox?type=queue
Message sent


