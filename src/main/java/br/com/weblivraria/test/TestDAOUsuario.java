package br.com.weblivraria.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.weblivraria.dao.DAOUsuario;
import br.com.weblivraria.dominio.USER;

public class TestDAOUsuario {
	// Vamos realizar o teste de todos os métodos que etsão na classe DAOUsuario.
	
	
	// Vamos começão testando o cadastro do usuário
	@Test
	public void testCadastroUsuario() {
		// Realizar a instância da classe Usuarios e aplicar dados
		// fictícios para cadastrar. Esta técnica é chamadas de dados mokados
	USER us = new USER();
	us.setNomeuser("pedro");
	us.setSENHAuser("123");
	us.setEMAILuser("pedroPP@gmail.com");
	us.setTELEFONEuser("11-94344-3333");
	us.setNOMECOMPLETOuser("Pedro Pereira");
	us.setCPFuser("844.534.333-55");
	
	// Instância da classe DAOUsuario
	DAOUsuario daous= new DAOUsuario();
	assertEquals("Cadastro realizado", daous.cadastrar(us));
	}
}
