package com.huios.ClientJavaRESTMaven;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		URI uri = UriBuilder.fromUri("http://localhost:8085/TPWSREST").build();
		WebResource service = client.resource(uri);
		//WebResource path = service.path("banque").path("test");
		WebResource path = service.path("banque").path("infos");
		String res = path.get(String.class);
		System.out.println(res);
	}

}
