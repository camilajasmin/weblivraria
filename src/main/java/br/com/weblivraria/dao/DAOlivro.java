package br.com.weblivraria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.weblivraria.dominio.LIVRO;
import br.com.weblivraria.dominio.USER;

public class DAOlivro extends Conexao implements CRUDLivraria<LIVRO> {

	@Override
	public String cadastrar(LIVRO dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "insert into LIVRO(TITULOlivro,GENEROlivro,SINOPSElivro,AUTORlivro,PRECOlivro,CAPAlivro)values(?,?,?,?,?,?)";
				//Preparar a consulta para a execução
				pst= con.prepareStatement(sql);
				//Passagem dos parâmetros para a consulta
				pst.setString(1,dados.getTITULOlivro());
				pst.setString(2,dados.getGENEROlivro());
				pst.setString(3,dados.getSINOPSElivro());
				pst.setString(4,dados.getAUTORlivro());
				pst.setDouble(5,dados.getPRECOlivro());
				pst.setString(6,dados.getCAPAlivro());
				
				if(pst.executeUpdate() > 0) {
					msg = "Cadastro realizado";
				}
				else {
					msg = "Não foi possível cadastrar";
				}
				
			}
			else {
				msg= "Não foi possível estabelecer conexão com o banco";
			}
			
			}
			catch(SQLException se){
				msg = "Erro ao tentar cadastrar"+se.getMessage();
		}
			catch(Exception e) {
				msg = "Erro inesperado"+e.getMessage();
			
		}
			finally {
				fecharConexao();
		}
		return msg;
	
	}

	@Override
	public List<LIVRO> listar() {
		List<LIVRO> lista = new ArrayList<LIVRO>();
		try{
			if(abrirConexao()) {
				String sql = "Select * from LIVRO order by IDlivro desc";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				
				/*
				 *  O comando acima faz com que o resultado da consulta(select) serja atribuído ao rs(ResultSet).
				 *  Ele recebe todos os dados, mas não de forma organizada.
				 *  Para criar a lista de usuário, nós aplicamos o comando while para verificar se há conteúdo 
				 *  em rs, em caso afirmativo passamos os dados para um novo objeto usuário e depois adicionamos 
				 *  a uma lista de novos usuarios. Esta lista será retornada con todos os usuarios do banco*/
				
				while(rs.next()) {
					LIVRO liv = new LIVRO();
					liv.setIDlivro(rs.getInt(1));
					liv.setTITULOlivro(rs.getString(2));
					liv.setGENEROlivro(rs.getString(3));
					liv.setSINOPSElivro(rs.getString(4));
					liv.setAUTORlivro(rs.getString(5));
					liv.setPRECOlivro(rs.getDouble(6));
					liv.setCAPAlivro(rs.getString(7));
					
					lista.add(liv);
					
					
				}
				}
				else {
					 new Exception("Não foi possível estabelecer a conexão com o banco");
				}
		}
		catch(Exception se) {
			new Exception ("Erro na consulta");
		 }
		return lista;
		}

	@Override
	public LIVRO pesquisar(LIVRO dados) {
		LIVRO liv = null;
		try{
			if(abrirConexao()) {
				String sql = "Select * from LIVRO where IDlivro = ? or TITULOlivro = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, dados.getIDlivro());
				pst.setString(2, dados.getTITULOlivro());
				
				rs = pst.executeQuery();
				
				
				
				/*
				 *  O comando acima faz com que o resultado da consulta(select) serja atribuído ao rs(ResultSet).
				 *  Ele recebe todos os dados, mas não de forma organizada.
				 *  Para criar a lista de usuário, nós aplicamos o comando while para verificar se há conteúdo 
				 *  em rs, em caso afirmativo passamos os dados para um novo objeto usuário e depois adicionamos 
				 *  a uma lista de novos usuarios. Esta lista será retornada con todos os usuarios do banco*/
				
				if(rs.next()) {
					liv = new LIVRO();
					liv.setIDlivro(rs.getInt(1));
					liv.setTITULOlivro(rs.getString(2));
					liv.setGENEROlivro(rs.getString(3));
					liv.setSINOPSElivro(rs.getString(4));
					liv.setAUTORlivro(rs.getString(5));
					liv.setPRECOlivro(rs.getDouble(6));
					liv.setCAPAlivro(rs.getString(7));
					
					
					
				}
				}
				else {
					 new Exception("Não foi possível estabelecer a conexão com o banco");
				}
		}
		catch(SQLException se) {
			new Exception("Erro na consulta "+se.getMessage());
		}
		catch(Exception e) {
			new Exception("Erro inesperado. "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		
		return liv;
		}


	@Override
	public String atualizar(LIVRO dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "update livro set titulo=?,genero=?,sinopse=?,autor=?,preco=?,capa=? where IDlivro=?";
				
				//Preparar a consulta para a execução
				pst= con.prepareStatement(sql);
				
				//Passagem dos parâmetros para a consulta
				pst.setString(1,dados.getTITULOlivro());
				pst.setString(2,dados.getGENEROlivro());
				pst.setString(3,dados.getSINOPSElivro());
				pst.setDouble(4,dados.getPRECOlivro());
				pst.setString(5,dados.getCAPAlivro());
				pst.setInt(6, dados.getIDlivro());
				
				if(pst.executeUpdate() > 0) {
					msg  = "Atualização realizada";
				 }
				else {
					msg = "Não foi possível atualizar";
				}
				
			}
			else {
				msg= "Não foi possível estabelecer conexão com o banco";
			 }
			
		}
			catch(SQLException se){
				msg = "Erro ao tentar atualizar"+se.getMessage();
		    }
			catch(Exception e) {
				msg = "Erro inesperado"+e.getMessage();
			
		}
			finally {
				fecharConexao();
		}
		return null;
	}

	@Override
	public String apagar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


