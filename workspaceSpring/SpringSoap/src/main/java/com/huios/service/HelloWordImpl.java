package com.huios.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.huios.service.HelloWorld")
public class HelloWordImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		// TODO Auto-generated method stub

		return "Hello World JAX-WS " + name;
	}

}
