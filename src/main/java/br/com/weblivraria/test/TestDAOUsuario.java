package br.com.weblivraria.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.weblivraria.dao.DAOUsuario;
import br.com.weblivraria.dominio.USER;

public class TestDAOUsuario {
	// Vamos realizar o teste de todos os métodos que etsão na classe DAOUsuario.
	
	
	// Vamos começão testando o cadastro do usuário
//	@Test
//	public void testCadastroUsuario() {
//		// Realizar a instância da classe Usuarios e aplicar dados
//		// fictícios para cadastrar. Esta técnica é chamadas de dados mokados
//	USER us = new USER();
//	us.setNomeuser("carina");
//	us.setSENHAuser("7787");
//	us.setEMAILuser("carina.ec@gmail.com");
//	us.setTELEFONEuser("11-94344-3333");
//	us.setNOMECOMPLETOuser("Carina Bianca");
	//	us.setCPFuser("443.555.223.-11");
	//	
//	// Instância da classe DAOUsuario
//	DAOUsuario daous= new DAOUsuario();
//	assertEquals("Cadastro realizado", daous.cadastrar(us));
//	}

	
	
	@Test 
	public void testListar() {
		DAOUsuario daous = new DAOUsuario();
		List<USER> resultado = new ArrayList<USER>();
		assertEquals(resultado, daous.listar());
		
	}}
	
//	@Test
//	public void testalterarSenha() {
//		USER us = new USER();
//		us.setSENHAuser("12345");
//		us.setIDuser(2);
//		DAOUsuario daous = new DAOUsuario();
//		assertEquals("Atualiazção realizada", daous.alterarSenha(us));
//	}
//}
