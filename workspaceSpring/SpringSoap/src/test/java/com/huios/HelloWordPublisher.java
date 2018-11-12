package com.huios;

import javax.xml.ws.Endpoint;

import com.huios.service.HelloWordImpl;

public class HelloWordPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Endpoint.publish("http://localhost:9999/ws/hello", new HelloWordImpl());
	}

}
