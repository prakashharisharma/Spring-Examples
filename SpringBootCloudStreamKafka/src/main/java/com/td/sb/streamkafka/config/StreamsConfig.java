package com.td.sb.streamkafka.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.td.sb.streamkafka.stream.GreetingsStreams;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
