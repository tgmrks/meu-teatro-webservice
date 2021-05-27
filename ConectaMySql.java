package br.com.meuteatrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySql {
	
//--REMOTE AWS CONNECTION--
//	private static final String serverName = "ec2-xx-xxx-xx-xxx.sa-east-1.compute.amazonaws.com:3306";
//	private static final String serverName = "xxx.xxx.xxx.xxx:3306";
//	private static final String databaseName = "meuteatro";
//	private static final String USER = "meuteatro";
//	private static final String SENHA = "xxxxxxxxxxxxx";
  
//--INSIDE SERVER CONNECTION--
	private static final String serverName = "localhost";
	private static final String databaseName = "meuteatro";
	private static final String USER = "meuteatro";
	private static final String SENHA = "xxxxxxxxxxxxx";
	
//--LOCAL CONNECTION FOR TEST--
//	private static final String serverName = "localhost";
//	private static final String databaseName = "meuteatro";
//	private static final String USER = "root";
//	private static final String SENHA = "";
	
	private static final String URL = "jdbc:mysql://" + serverName + "/" + databaseName;
	
		//gera a conexão com o banco de dados
		public static Connection obtemConexao() throws SQLException{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return DriverManager.getConnection(URL, USER, SENHA);
			
		}

}
