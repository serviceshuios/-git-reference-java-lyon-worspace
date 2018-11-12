package presentation;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import metier.Compte;

public class Lanceur {

	public static void main(String[] args) throws Exception {
		System.out.println("initialisation du Contexte JAXB");
		JAXBContext context = JAXBContext.newInstance(Compte.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Compte cp = (Compte) unmarshaller.unmarshal(new File("comptes.xml"));
		
		System.out.println(cp);
	}
}
