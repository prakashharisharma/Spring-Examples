package com.td.sb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.td.sb.config.ActiveMQConfig.ORDER_QUEUE;

import com.td.sb.model.Order;

@Service
public class OrderService {

	private static Logger log = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(Order myMessage) {
		log.info("sending with convertAndSend() to queue <" + myMessage + ">");
		jmsTemplate.convertAndSend(ORDER_QUEUE, myMessage);
		jmsTemplate.setPriority(myMessage.getPriority());
	}
}
