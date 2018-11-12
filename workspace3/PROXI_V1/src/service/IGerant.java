package service;

import java.util.Collection;

import metier.Client;
import metier.Gerant;

public interface IGerant {

	public Collection<Client> realiserAudit(Gerant gerant);
	
}
