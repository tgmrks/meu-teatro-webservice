package br.com.meuteatrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EspetaculoDAO {



	public ArrayList<Espetaculo> buscaTodosEspetaculo(){
		
		ArrayList<Espetaculo> lista = new ArrayList<Espetaculo>();
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarTodos = "SELECT * FROM mt_espetaculo";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Espetaculo esp = new Espetaculo();
				esp.setId_usuario(rSet.getInt(1));
				esp.setId_t(rSet.getInt(2));
				esp.setId_e(rSet.getInt(3));
				esp.setTitulo(rSet.getString(4));
				esp.setDescricao(rSet.getString(5));
				esp.setClassificacao(rSet.getString(6));
				esp.setData_hora(rSet.getString(7));
				esp.setImagem(rSet.getBytes(8));
				esp.setEntrada(rSet.getString(9));
				esp.setLink_externo(rSet.getString(10));
//				esp.setData_cadastro(rSet.getString(11));
//				esp.setAtivo(rSet.getInt(12));	
				
				lista.add(esp);
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public ArrayList<Espetaculo> buscaEspetaculoPorCidade(String cidade){
		
		ArrayList<Espetaculo> lista = new ArrayList<Espetaculo>();
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarTodos = "SELECT * FROM mt_espetaculo E INNER JOIN mt_cia T ON E.id_t = T.id_t AND T.cidade = ? ";
						
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
			ppStm.setString(1, cidade);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Espetaculo esp = new Espetaculo();
				esp.setId_usuario(rSet.getInt(1));
				esp.setId_t(rSet.getInt(2));
				esp.setId_e(rSet.getInt(3));
				esp.setTitulo(rSet.getString(4));
				esp.setDescricao(rSet.getString(5));
				esp.setClassificacao(rSet.getString(6));
				esp.setData_hora(rSet.getString(7));
				esp.setImagem(rSet.getBytes(8));
				esp.setEntrada(rSet.getString(9));
				esp.setLink_externo(rSet.getString(10));
//				esp.setData_cadastro(rSet.getString(11));
//				esp.setAtivo(rSet.getInt(12));			
				
				lista.add(esp);
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lista.isEmpty()){
		
			Espetaculo esp = new Espetaculo();
			esp.setId_usuario(0);
			esp.setId_t(0);
			esp.setId_e(0);
			esp.setTitulo("null");
			esp.setDescricao("null");
			esp.setClassificacao("null");
			esp.setData_hora("null");
			esp.setEntrada("null");
			esp.setLink_externo("null");
//			esp.setData_cadastro("null");
//			esp.setAtivo(0);
			
			String foto = "iVBORw0KGgoAAAANSUhEUgAAABUAAAAVCAYAAACpF6WWAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAd9JREFUeNqMVcFxwjAQxB7/YypI6MBUAKkAuwNTQeBBvsA3PGwqsKnATgU4FQQqiFMBLiF7nlXm8ACWZm6EJd1qtdoTzqCnrd5XC3RrxHj3sasHFs3tAQwI6COSgWVzkHhBXyKWYNIQTEBiAgq7A0FHNmxdshCAC8B+EN/ym4A54hVAKcHfbJh67CP2Afsl4mSYs5Vq3gq0AUDFRK1pxjnZ5IxY2II2ZFABJKR2LVPEp4xzbW17UR6TJoiUrEZqvr7hiAxr5n2gwibD4hdKoP0pLae2AU8VY26KfitydRwjpwxdDOZklHS0lO8ZouDwhKcaU5qMjmldQ8eIi3xP3XaByZibyO5DxUJYit5zjAlgRGYyPiXGiX3hdNjFLIJUjUvyURh09L5Vge1FO53BhLYxVfRMho36/uWl+t3qQv5GZLqqffpxRL/OyHzLx2RDr5qiWAPkSCDTJOfLeXCUKY897FSWliUwjqHuUuKR90CikypdUxiV2YB9pda3jw/Gy7ugkgSgmkeq+PDIg1NS1yfEXnTlhqF5Q9yeijvQ7D6tllNnea3OBAzoWSmEUj8o91pKAEmKeJHLju4F3fJfuo7F30nIRNF4TwBfuaPiho01qLrZRFWPucg9ZblqfwIMAEGT66tVya5MAAAAAElFTkSuQmCC";
			byte[] byteFoto = foto.getBytes();
			esp.setImagem(byteFoto);
			
			lista.add(esp);
		}
		
		return lista;
	}
	
public ArrayList<Espetaculo> buscaEspetaculoPorTeatro(int id_t){
		
		ArrayList<Espetaculo> lista = new ArrayList<Espetaculo>();
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarTodos = "SELECT * FROM mt_espetaculo WHERE id_t = ? ";
						
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
			ppStm.setInt(1, id_t);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Espetaculo esp = new Espetaculo();
				esp.setId_usuario(rSet.getInt(1));
				esp.setId_t(rSet.getInt(2));
				esp.setId_e(rSet.getInt(3));
				esp.setTitulo(rSet.getString(4));
				esp.setDescricao(rSet.getString(5));
				esp.setClassificacao(rSet.getString(6));
				esp.setData_hora(rSet.getString(7));
				esp.setImagem(rSet.getBytes(8));
				esp.setEntrada(rSet.getString(9));
				esp.setLink_externo(rSet.getString(10));
//				esp.setData_cadastro(rSet.getString(11));
//				esp.setAtivo(rSet.getInt(12));
				
				lista.add(esp);
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lista.isEmpty()){
		
			Espetaculo esp = new Espetaculo();
			esp.setId_usuario(0);
			esp.setId_t(0);
			esp.setId_e(0);
			esp.setTitulo("null");
			esp.setDescricao("null");
			esp.setClassificacao("null");
			esp.setData_hora("null");
			esp.setEntrada("null");
			esp.setLink_externo("null");
//			esp.setData_cadastro("null");
//			esp.setAtivo(0);
			
			String foto = "iVBORw0KGgoAAAANSUhEUgAAABUAAAAVCAYAAACpF6WWAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAd9JREFUeNqMVcFxwjAQxB7/YypI6MBUAKkAuwNTQeBBvsA3PGwqsKnATgU4FQQqiFMBLiF7nlXm8ACWZm6EJd1qtdoTzqCnrd5XC3RrxHj3sasHFs3tAQwI6COSgWVzkHhBXyKWYNIQTEBiAgq7A0FHNmxdshCAC8B+EN/ym4A54hVAKcHfbJh67CP2Afsl4mSYs5Vq3gq0AUDFRK1pxjnZ5IxY2II2ZFABJKR2LVPEp4xzbW17UR6TJoiUrEZqvr7hiAxr5n2gwibD4hdKoP0pLae2AU8VY26KfitydRwjpwxdDOZklHS0lO8ZouDwhKcaU5qMjmldQ8eIi3xP3XaByZibyO5DxUJYit5zjAlgRGYyPiXGiX3hdNjFLIJUjUvyURh09L5Vge1FO53BhLYxVfRMho36/uWl+t3qQv5GZLqqffpxRL/OyHzLx2RDr5qiWAPkSCDTJOfLeXCUKY897FSWliUwjqHuUuKR90CikypdUxiV2YB9pda3jw/Gy7ugkgSgmkeq+PDIg1NS1yfEXnTlhqF5Q9yeijvQ7D6tllNnea3OBAzoWSmEUj8o91pKAEmKeJHLju4F3fJfuo7F30nIRNF4TwBfuaPiho01qLrZRFWPucg9ZblqfwIMAEGT66tVya5MAAAAAElFTkSuQmCC";
			byte[] byteFoto = foto.getBytes();
			esp.setImagem(byteFoto);
			
			lista.add(esp);
		}
		
		return lista;
	}
	
	public Espetaculo buscaEspetaculoPorID(int id){
		
		Espetaculo esp = null;
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarID = "SELECT * FROM mt_espetaculo WHERE id_e = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarID);
			ppStm.setInt(1, id);
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				
				esp = new Espetaculo();
				esp.setId_usuario(rSet.getInt(1));
				esp.setId_t(rSet.getInt(2));
				esp.setId_e(rSet.getInt(3));
				esp.setTitulo(rSet.getString(4));
				esp.setDescricao(rSet.getString(5));
				esp.setClassificacao(rSet.getString(6));
				esp.setData_hora(rSet.getString(7));
				esp.setImagem(rSet.getBytes(8));
				esp.setEntrada(rSet.getString(9));
				esp.setLink_externo(rSet.getString(10));
//				esp.setData_cadastro(rSet.getString(11));
//				esp.setAtivo(rSet.getInt(12));
			}
			else{
				
				    esp = new Espetaculo();
				    esp.setId_usuario(0);
					esp.setId_t(0);
					esp.setId_e(0);
					esp.setTitulo("null");
					esp.setDescricao("null");
					esp.setClassificacao("null");
					esp.setData_hora("null");
					esp.setEntrada("null");
					esp.setLink_externo("null");
//					esp.setData_cadastro("null");
//					esp.setAtivo(0);
					
					String foto = "iVBORw0KGgoAAAANSUhEUgAAABUAAAAVCAYAAACpF6WWAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAd9JREFUeNqMVcFxwjAQxB7/YypI6MBUAKkAuwNTQeBBvsA3PGwqsKnATgU4FQQqiFMBLiF7nlXm8ACWZm6EJd1qtdoTzqCnrd5XC3RrxHj3sasHFs3tAQwI6COSgWVzkHhBXyKWYNIQTEBiAgq7A0FHNmxdshCAC8B+EN/ym4A54hVAKcHfbJh67CP2Afsl4mSYs5Vq3gq0AUDFRK1pxjnZ5IxY2II2ZFABJKR2LVPEp4xzbW17UR6TJoiUrEZqvr7hiAxr5n2gwibD4hdKoP0pLae2AU8VY26KfitydRwjpwxdDOZklHS0lO8ZouDwhKcaU5qMjmldQ8eIi3xP3XaByZibyO5DxUJYit5zjAlgRGYyPiXGiX3hdNjFLIJUjUvyURh09L5Vge1FO53BhLYxVfRMho36/uWl+t3qQv5GZLqqffpxRL/OyHzLx2RDr5qiWAPkSCDTJOfLeXCUKY897FSWliUwjqHuUuKR90CikypdUxiV2YB9pda3jw/Gy7ugkgSgmkeq+PDIg1NS1yfEXnTlhqF5Q9yeijvQ7D6tllNnea3OBAzoWSmEUj8o91pKAEmKeJHLju4F3fJfuo7F30nIRNF4TwBfuaPiho01qLrZRFWPucg9ZblqfwIMAEGT66tVya5MAAAAAElFTkSuQmCC";
					byte[] byteFoto = foto.getBytes();
					esp.setImagem(byteFoto);				
				
				return esp;
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return esp;
	}
	
	
		public ArrayList<Agenda> buscaAgenda(int id){
			
			ArrayList<Agenda> lista = new ArrayList<Agenda>();
			
			try {
				Connection conn = ConectaMySql.obtemConexao();
				
				String queryBuscarAgenda = "SELECT * FROM mt_agenda WHERE id_e = ? ";
							
				PreparedStatement ppStm = conn.prepareStatement(queryBuscarAgenda);
				ppStm.setInt(1, id);
				
				ResultSet rSet = ppStm.executeQuery();
				
				while(rSet.next()){
					Agenda agd = new Agenda();
					agd.setId_a(rSet.getInt(1));
					agd.setDia(rSet.getInt(2));
					agd.setMes(rSet.getInt(3));
					agd.setAno(rSet.getInt(4));
					agd.setHora(rSet.getString(5));
					agd.setId_e(rSet.getInt(6));
					
					lista.add(agd);
				}
				
				conn.close();
				
			} catch (Exception e) { //melhor pratica: catch (SQLException e)
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(lista.isEmpty()){
			
				Agenda agd = new Agenda();
				agd.setId_a(0);
				agd.setDia(0);
				agd.setMes(0);
				agd.setAno(0);
				agd.setHora("null");
				agd.setId_e(0);
								
				lista.add(agd);
			}
			
			return lista;
		}

}
