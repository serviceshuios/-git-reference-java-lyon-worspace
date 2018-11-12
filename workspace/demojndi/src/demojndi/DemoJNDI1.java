package demojndi;

import java.sql.Connection;

import sn.objis.vente.dvd.utils.ConnectionMySQLDatasourceJNDI;

public class DemoJNDI1 {
public static void main(String[] args) {
	Connection cn = ConnectionMySQLDatasourceJNDI.getInstance();
}
}
