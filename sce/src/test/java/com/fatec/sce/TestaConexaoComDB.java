package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.ConfiguraDB;
import com.fatec.sce.model.FabricaDeConexoes;

public class TestaConexaoComDB {
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com
	 * configuracao valida Pré-condição - a configuracao default da fabrica de
	 * conexoes é valida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// cenario
		FabricaDeConexoes fabrica;
		// acao
		fabrica = new FabricaDeConexoes();
		// verificacao
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de
	 * acesso invalida Pré-condição - a senha cadastrada é "aluno"
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "x"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com usuario invalido
	 * Pré-condição - o usuário válido é "root"
	 */
	@Test
	public void quandoConectaComUsuarioInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root1"; //usuario invalido
		String senha = "x"; //senha invalida
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root1'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com driver invalido
	 * Pré-condição - o drive válido é "com.mysql.jdbc.Driver"
	 */
	@Test
	public void quandoConectaComDriverInvalido_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver1"; //driver invalido
		String usuario = "root"; //usuario valido
		String senha = ""; //senha valida
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.lang.ClassNotFoundException: com.mysql.jdbc.Driver1");
		}
	}
	
	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com URL invalida
	 * Pré-condição - a URL válida é "jdbc:mysql://localhost:3306/biblioteca"
	 */
	@Test
	public void quandoConectaComURLInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3308/biblioteca";
		String driver = "com.mysql.jdbc.Driver"; //driver valido
		String usuario = "root"; //usuario valido
		String senha = ""; //senha valido
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure\n" + 
					"\nThe last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.");
		}
	}
}
