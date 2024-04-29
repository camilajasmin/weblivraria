package br.com.weblivraria.dao;

import java.lang.reflect.Executable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.weblivraria.dominio.USER;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

public class DAOUsuario extends Conexao implements CRUDUsuario<USER>{

	@Override
	public String cadastrar(USER dados) {
		String msg = "";
		// Vamos tentar cadastrar o usuário, caso dê erro este será capturado e tratado (try catch)
		
		try { 
			// Verificar se a conexão com o banco de dados foi aberta ou não.
			// Caso tenha sido aberta, iremos usar os comando se sql para 
			// realizar o cadastro do usuário. Senão, iremos exibir ume mensagem 
			// para o usuário de que não foi possível a comunicação com o 
		    // banco de dados.
			if(abrirConexao()) {
				String sql = "insert into USER(NOMEuser, SENHAuser, EMAILuser,TELEFONEuser,NOMECOMPLETOuser,CPFuser) values(?,?,?,?,?,?)";
				// Preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				// passagem dos dados aos parâmetros da consulta, ou seja,
				// cada ponto de interrogação receberá um dado correspondente
				// a um campo bela
				pst.setString(1, dados.getNomeuser());
				pst.setString(2, dados.getSENHAuser());
				pst.setString(3, dados.getEMAILuser());
				pst.setString(4, dados.getTELEFONEuser());
				pst.setString(5, dados.getNOMECOMPLETOuser());
				pst.setString(6, dados.getCPFuser());
				
				if(pst.executeUpdate() > 0) {msg = "Cadastro realizado";}
				else {msg = "Não foi possível cadastrar";}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados";
			}
			
		} 
		catch(SQLException se){
			msg = "Erro no Cadastro"+se.getMessage();
			
		}
		catch(Exception e) {
			msg = "Erro inesperado" + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}

	@Override
	public List<USER> listar() {
		List<USER> lista = new ArrayList<USER>();
		
		try{
			if(abrirConexao()) {
				String sql = "Select * from USER";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				
				/*
				 *  O comando acima faz com que o resultado da consulta(select) serja atribuído ao rs(ResultSet).
				 *  Ele recebe todos os dados, mas não de forma organizada.
				 *  Para criar a lista de usuário, nós aplicamos o comando while para verificar se há conteúdo 
				 *  em rs, em caso afirmativo passamos os dados para um novo objeto usuário e depois adicionamos 
				 *  a uma lista de novos usuarios. Esta lista será retornada con todos os usuarios do banco*/
				
				while(rs.next()) {
					USER us = new USER();
					us.setIDuser(rs.getInt(1));
					us.setNomeuser(rs.getString(2));
					us.setSENHAuser(rs.getString(3));
					us.setEMAILuser(rs.getString(4));
					us.setTELEFONEuser(rs.getString(5));
					us.setNOMECOMPLETOuser(rs.getString(6));
					us.setCPFuser(rs.getString(7));
					
					lista.add(us);
					
					
				}}
				else {
					throw new Exception("Não foi possível estabelecer a conexão com o banco");
				}
			}
		catch(SQLException se){
			new Exception("Erro na Consulta"+se.getMessage());
		}
		catch(Exception e ) {
			new Exception("Erro Inesperado"+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		
		return lista;
	}

	@Override
	public USER pesquisar(USER dados) {
		USER us = new USER();
		
		try{
			if(abrirConexao()) {
				String sql = "Select * from USER where IDUser=?";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				
				if(rs.next()) {
					
					us.setIDuser(rs.getInt(1));
					us.setNomeuser(rs.getString(2));
					us.setSENHAuser(rs.getString(3));
					us.setEMAILuser(rs.getString(4));
					us.setTELEFONEuser(rs.getString(5));
					us.setNOMECOMPLETOuser(rs.getString(6));
					us.setCPFuser(rs.getString(7));
					
					
				}}
				else {
					throw new Exception("Não foi possível estabelecer a conexão com o banco");
				}
			}
		catch(SQLException se){
			new Exception("Erro na Consulta"+se.getMessage());
		}
		catch(Exception e ) {
			new Exception("Erro Inesperado"+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		
		return null;
	}

	@Override
	public String atualizar(USER dados) {
		String msg = "";
		//vamos tentar atualizar o usuário e caso dê erro, este será
		//capturado e tratado
		try {
			//verificar se a conexão com o banco de dados foi aberta ou não
			//caso tenha sido aberta, iremos executar os comandos de sql
			//para cadastrar o usuario. Senão, iremos exibir uma mensagem 
			//para o usuário de que não foi possível estabelecer comunicação
			//com o banco de dados
			if(abrirConexao()) {
				String sql = "update usuario set NOMEuser=?,EMAILuser=?,TELEFONEuser=?,NOMECOMPLETOuser=? where IDUse=?";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				//passagem dos dados aos parâmetros da consulta, ou seja, 
				//cada ponto de interrogação irá receber um dado correspondente 
				//a um campo da tabela
				pst.setString(1,dados.getNomeuser());
				pst.setString(2, dados.getEMAILuser());
				pst.setString(3,dados.getTELEFONEuser());
				pst.setString(4, dados.getNOMECOMPLETOuser());
				pst.setInt(5, dados.getIDUser());
				
				//executar a consulta e verificar se o retorno da execução
				//é maior que 0(zero)
				if(pst.executeUpdate() > 0) {
					msg = "Atualização realizada";
				}
				else {
					msg = "Não foi possível atualizar";
				}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao atualizar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}

	@Override
	public boolean login(USER dados) {
    boolean auth = true;
		
		try{
			if(abrirConexao()) {
				String sql = "Select NOMEuser, SENHAuser, EMAILuser, CPFuser from USER where NOMEuser=? or EMAILuser=? or CPFuser=? and SENHAuser=?";
				pst = con.prepareStatement(sql);
				pst.setString(1, dados.getNomeuser());
				pst.setString(2, dados.getSENHAuser());
				pst.setString(3, dados.getEMAILuser());
				pst.setString(4, dados.getCPFuser());
				
				rs = pst.executeQuery();
				
				if(!rs.next()) {
					auth = false;
					}
				}
				else {
					throw new Exception("Não foi possível estabelecer a conexão com o banco");
				}
			}
		catch(SQLException se){
			auth = false;
			new Exception("Erro na Consulta"+se.getMessage());
		}
		catch(Exception e ) {
			auth = false;
			new Exception("Erro Inesperado"+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		
		
		return auth;
	}

	@Override
	public String alterarSenha(USER dados) {
		String msg = "";
		//vamos tentar atualizar o usuário e caso dê erro, este será
		//capturado e tratado
		try {
			//verificar se a conexão com o banco de dados foi aberta ou não
			//caso tenha sido aberta, iremos executar os comandos de sql
			//para atualizar o usuario. Senão, iremos exibir uma mensagem 
			//para o usuário de que não foi possível estabelecer comunicação
			//com o banco de dados
			if(abrirConexao()) {
				String sql = "update usuario set senha=? where idusuario=?";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				//passagem dos dados aos parâmetros da consulta, ou seja, 
				//cada ponto de interrogação irá receber um dado correspondente 
				//a um campo da tabela
				pst.setString(1,dados.getSENHAuser());
				pst.setInt(2, dados.getIDUser());
				
				//executar a consulta e verificar se o retorno da execução
				//é maior que 0(zero)
				if(pst.executeUpdate() > 0) {
					msg = "Atualização realizada";
				}
				else {
					msg = "Não foi possível atualizar";
				}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao atualizar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}

	@Override
	public String apagar(Integer id) {
		String msg = "";
		//vamos tentar deletar o usuário e caso dê erro, este será
		//capturado e tratado
		try {
			//verificar se a conexão com o banco de dados foi aberta ou não
			//caso tenha sido aberta, iremos executar os comandos de sql
			//para deletar o usuario. Senão, iremos exibir uma mensagem 
			//para o usuário de que não foi possível estabelecer comunicação
			//com o banco de dados
			if(abrirConexao()) {
				String sql = "delete from USER where IDUser=?";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				//passagem dos dados aos parâmetros da consulta, ou seja, 
				//cada ponto de interrogação irá receber um dado correspondente 
				//a um campo da tabela
				pst.setInt(1,id);				
				
				//executar a consulta e verificar se o retorno da execução
				//é maior que 0(zero)
				if(pst.executeUpdate() > 0) {
					msg = "Usuário apagado";
				}
				else {
					msg = "Não foi possível apagar";
				}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco de dados";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao apagar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		
		return msg;
	}

	

	}
	



