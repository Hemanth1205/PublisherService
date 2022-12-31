package com.publisher.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PublisherRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		// <from uri="timer://foo?repeatCount=1"/>
	from("quartz://timerName?cron=0/15 * * * * ? *")
	.log("sending message")
	.setBody(simple("hello"))
	.to("kafka:com.topic.publish");
	
	//quartz://timerName?cron=expression
		
	}

}
