package service;

import javax.inject.Inject;

import dao.IDao;
import metier.Client;

public class ServiceImpl implements Iservice {

	@Inject
	private IDao dao;
	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

}
