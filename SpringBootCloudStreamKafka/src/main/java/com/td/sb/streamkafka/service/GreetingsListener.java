package com.td.sb.streamkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.td.sb.streamkafka.model.Greetings;
import com.td.sb.streamkafka.stream.GreetingsStreams;

@Component
public class GreetingsListener {
	
	private static final Logger log = LoggerFactory.getLogger(GreetingsListener.class);
	
    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Received greetings: {}", greetings);
    }
}
