package serveur;

import javax.xml.ws.Endpoint;

import ws.BanqueService;

public class ServeurWS {

	public static void main(String[] args) {
		// 1- création du serveur
		String url="http://localhost:8585/";
		// 2- publication du webservice
		Endpoint.publish(url, new BanqueService());
		System.out.println(url);
	}

}
