package br.com.meuteatrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TeatroDAO {
	
public int inserirTeatro(Teatro teatro){
	 	
		try {
			Connection conn = ConectaMySql.obtemConexao();
																 //	1   2     3    4   5   6   7   8
														   //id_t,nome,razao,cnpj,end,city,uf,cep,tel	
			String queryInserir = "INSERT INTO mt_cia VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement ppStm = conn.prepareStatement(queryInserir, Statement.RETURN_GENERATED_KEYS);
			ppStm.setString(1, teatro.getNome_teatro());
			ppStm.setString(2, teatro.getRazao_social());
			ppStm.setString(3, teatro.getCnpj());			
			ppStm.setString(4, teatro.getEndereco());
			ppStm.setString(5, teatro.getCidade());
			ppStm.setString(6, teatro.getUf());			
			ppStm.setString(7, teatro.getCep());
			ppStm.setString(8, teatro.getTel());
			
			int affectedRows = ppStm.executeUpdate();
			//conn.close(); 
			
			if(affectedRows == 0){
				return -1;
			}
			
	
			try (ResultSet generatedKeys = ppStm.getGeneratedKeys()) {
				if(generatedKeys.next()){
					return (int) generatedKeys.getLong(1);
				}
				else{
					return -1;
				}
			}
			catch(Exception e){
				e.printStackTrace();
				return -1;
			}
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return -1;
		}
		
	}

	public boolean excluirTeatro(int id){
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryExcluir = "DELETE FROM mt_cia WHERE id_t = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryExcluir);
			ppStm.setInt(1, id);
			ppStm.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
public boolean atualizarTeatro(Teatro teatro){
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			//String queryAtualizar = "UPDATE teatro SET nome = ?, idade = ? WHERE id = ?";
			//ANTIGO//String queryAtualizar = "UPDATE teatro SET nome_teatro = ?, endereco = ?, cidade = ?, uf = ? WHERE id_t = ?";
			String queryAtualizar = "UPDATE mt_cia SET nome_teatro = ?, razao_social = ?, cnpj = ?, endereco = ?, cidade = ?, uf = ?, cep = ?, telefone = ? WHERE id_t = ?";	
						
			PreparedStatement ppStm = conn.prepareStatement(queryAtualizar);
			ppStm.setString(1, teatro.getNome_teatro());
			ppStm.setString(2, teatro.getRazao_social());
			ppStm.setString(3, teatro.getCnpj());			
			ppStm.setString(4, teatro.getEndereco());
			ppStm.setString(5, teatro.getCidade());
			ppStm.setString(6, teatro.getUf());			
			ppStm.setString(7, teatro.getCep());
			ppStm.setString(8, teatro.getTel());
			ppStm.setInt(9, teatro.getId_t());
			ppStm.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	public ArrayList<Teatro> buscaTodosTeatro(){
		
		ArrayList<Teatro> lista = new ArrayList<Teatro>();
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarTodos = "SELECT * FROM mt_cia";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Teatro ttr = new Teatro();
				ttr.setId_t(rSet.getInt(1));
				ttr.setNome_teatro(rSet.getString(2));
				ttr.setRazao_social(rSet.getString(3));
				ttr.setCnpj(rSet.getString(4));
				ttr.setEndereco(rSet.getString(5));
				ttr.setCidade(rSet.getString(6));
				ttr.setUf(rSet.getString(7));
				ttr.setCep(rSet.getString(8));
				ttr.setTel(rSet.getString(9));
				
				lista.add(ttr);
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public ArrayList<Teatro> buscaTeatroPorCidade(String cidade){
		
		ArrayList<Teatro> lista = new ArrayList<Teatro>();
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarTodos = "SELECT * FROM mt_cia WHERE cidade = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);
			ppStm.setString(1, cidade);
			
			ResultSet rSet = ppStm.executeQuery();
			
//			if (rSet.toString().equals("anyType{}")){
//			    strings.add("");
//			}
			
			while(rSet.next()){
				Teatro ttr = new Teatro();
				ttr.setId_t(rSet.getInt(1));
				ttr.setNome_teatro(rSet.getString(2));
				ttr.setRazao_social(rSet.getString(3));
				ttr.setCnpj(rSet.getString(4));
				ttr.setEndereco(rSet.getString(5));
				ttr.setCidade(rSet.getString(6));
				ttr.setUf(rSet.getString(7));
				ttr.setCep(rSet.getString(8));
				ttr.setTel(rSet.getString(9));
				
				lista.add(ttr);
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lista.isEmpty()){
		
			Teatro ttr = new Teatro();
			ttr.setId_t(0);
			ttr.setNome_teatro("null");
			ttr.setRazao_social("null");
			ttr.setCnpj("null");
			ttr.setEndereco("null");
			ttr.setCidade(cidade);
			ttr.setUf("null");
			ttr.setCep("null");
			ttr.setTel("null");
			
			lista.add(ttr);
		}
		
		return lista;
	}
	
	public Teatro buscaTeatroPorID(int id){
		
		Teatro ttr = null;
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryBuscarID = "SELECT * FROM mt_cia WHERE id_t = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarID);
			ppStm.setInt(1, id);
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				
				ttr = new Teatro();
				ttr.setId_t(rSet.getInt(1));
				ttr.setNome_teatro(rSet.getString(2));
				ttr.setRazao_social(rSet.getString(3));
				ttr.setCnpj(rSet.getString(4));
				ttr.setEndereco(rSet.getString(5));
				ttr.setCidade(rSet.getString(6));
				ttr.setUf(rSet.getString(7));
				ttr.setCep(rSet.getString(8));
				ttr.setTel(rSet.getString(9));
			}
			else{
				
				ttr = new Teatro();				
				ttr.setId_t(0);
				ttr.setNome_teatro("null");
				ttr.setRazao_social("null");
				ttr.setCnpj("null");
				ttr.setEndereco("null");
				ttr.setCidade("null");
				ttr.setUf("null");
				ttr.setCep("null");
				ttr.setTel("null");
				
				return ttr;
			}
			
			conn.close();
			
		} catch (Exception e) { //melhor pratica: catch (SQLException e)
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ttr;
	}
	



}
