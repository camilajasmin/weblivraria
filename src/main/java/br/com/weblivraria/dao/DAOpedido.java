package br.com.weblivraria.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.weblivraria.dominio.PEDIDO;

public class DAOpedido extends Conexao implements CRUDLivraria<PEDIDO> {

	@Override
	public String cadastrar(PEDIDO dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql="insert into PEDIDO (IDuser, TOTALpedido) values(?,?)";
				pst = con.prepareStatement(sql);
			    pst.setInt(1, dados.getIDUser());
				pst.setDouble(2, dados.getTOTALpedido());
				if(pst.executeUpdate()>0) {
					msg = "Pedido Efetuado";
					
				}
				else {
					msg = "Pedido não efetuado";
				}
			}
			else {
				msg = "Não foi possível estabelecer a conexão com o banco";
			}
			
		} catch (SQLException se) {
			msg = "Erro na consulta" + se.getMessage();
		} catch(Exception e) {
			msg = "Erro inesperado" +e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}

	@Override
	public List<PEDIDO> listar() {
		
		return null;
	}

	@Override
	public PEDIDO pesquisar(PEDIDO dados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar(PEDIDO dados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apagar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
