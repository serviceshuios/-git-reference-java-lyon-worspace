package sn.objis.vente.dvd.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import javax.sql.DataSource;

public class ConnectionMySQLDatasourceJNDI {

	private static String url = "jdbc:mysql://localhost:3306/formation";
	private static String user = "root";
	private static String password = "";
	private static String driver = "com.mysql.jdbc.Driver";

	private static Connection connection;

	public static Connection getInstance() {

		if (connection == null) {

			try {
				/* Etape N°1: Initialisation du contexte */

				System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

				InitialContext ic = new InitialContext();

				/* Etape N°2: Création d'une référence sur la DataSource */

				Reference ref = new Reference("javax.sql.DataSource", "org.apache.commons.dbcp.BasicDataSourceFactory",
						null);
				
				ref.add(new StringRefAddr("dataSourceName", "jdbc/cpds"));

				ref.add(new StringRefAddr("driverClassName", driver));

				ref.add(new StringRefAddr("url", url));

				ref.add(new StringRefAddr("username", user));

				ref.add(new StringRefAddr("password", password));

				// Etape N°3: Liaison de la DataSource au contexte

				ic.rebind("jdbc/MaDataSource", ref);

				/*
				 * Une fois ce lien créé, il ne vous reste plus qu'à récupérer
				 * la DataSource comme ceci :
				 */

				/*
				 * Etape N°4: Récupération de la DataSource à partir du contexte
				 */

				Context ctx = new InitialContext();
				DataSource source = (DataSource) ctx.lookup("jdbc/MaDataSource");

				// Etape N°5: Récupération d'une Connection

				connection = source.getConnection();

				System.out.println("Connexion avec la BD reussie !");
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return connection;

	}
}
