package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import metier.Client;

public class Dao implements IDao {

	@Override
	public void ajouterClient(Client c) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = DaoConnexion.getConnection();
			//3- créer la requête
			/*PreparedStatement ps = conn.prepareStatement("INSERT INTO Client(nom,prenom) VALUES ('"+
			c.getNom()+"','"+c.getPrenom()+"')");*/
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Client(nom,prenom,couleuryeux,age) VALUES (?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getCouleurYeux());
			ps.setInt(4, c.getAge());
			//4- executer la requête
			ps.executeUpdate();
			//5- présenter les résultats
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6- fermer la connexion
			DaoConnexion.closeConnection();
		}
	}

	@Override
	public void modifierClient(int id, String nom, String prenom, int age) {
		try {
			Connection conn = DaoConnexion.getConnection();
			//3- créer la requête
			PreparedStatement ps = conn.prepareStatement("UPDATE Client SET nom = ? , prenom = ?, age =?  where id = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, id);
			//4- executer la requête
			ps.executeUpdate();
			//5- présenter les résultats
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6- fermer la connexion
			DaoConnexion.closeConnection();
		}


	}

	@Override
	public void supprimerClient(int id) {
		try {
			Connection conn = DaoConnexion.getConnection();
			//3- créer la requête
			PreparedStatement ps = conn.prepareStatement("DELETE from Client where id = ?");
			ps.setInt(1, id);
			//4- executer la requête
			ps.executeUpdate();
			//5- présenter les résultats
			
			//6- fermer la connexion
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6- fermer la connexion
			DaoConnexion.closeConnection();
		}


	}

	@Override
	public Collection<Client> listerClients() {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			Connection conn = DaoConnexion.getConnection();
			//3- créer la requête
			PreparedStatement ps = conn.prepareStatement("select * from client");
			//4- executer la requête
			ResultSet rs= ps.executeQuery();
			//5- présenter les résultats
			while(rs.next())
			{
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
				c.setAge(rs.getInt("age"));
				cl.add(c);
			}
			//6- fermer la connexion
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6- fermer la connexion
			DaoConnexion.closeConnection();
		}
		return cl;
	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			
			Connection conn = DaoConnexion.getConnection();
			//3- créer la requête
			PreparedStatement ps = conn.prepareStatement("select * from client where nom like ?");
			ps.setString(1, "%"+mc+"%");
			//4- executer la requête
			ResultSet rs= ps.executeQuery();
			//5- présenter les résultats
			while(rs.next())
			{
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
				c.setAge(rs.getInt("age"));
				cl.add(c);
			}
			//6- fermer la connexion
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6- fermer la connexion
			DaoConnexion.closeConnection();
		}
		return cl;
	}

	@Override
	public Client chercherClient(int id) {
		// TODO Auto-generated method stub
				Client c = new Client();
				try {
					Connection conn = DaoConnexion.getConnection();
					//3- créer la requête
					PreparedStatement ps = conn.prepareStatement("select * from client where id = ?");
					ps.setInt(1, id);
					//4- executer la requête
					ResultSet rs= ps.executeQuery();
					//5- présenter les résultats
						rs.next();
						c.setId(rs.getInt("id"));
						c.setNom(rs.getString("nom"));
						c.setPrenom(rs.getString("prenom"));
						c.setCouleurYeux(rs.getString("couleuryeux"));
						c.setAge(rs.getInt("age"));
					
					//6- fermer la connexion
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					//6- fermer la connexion
					DaoConnexion.closeConnection();
				}
				return c;
	}

}
