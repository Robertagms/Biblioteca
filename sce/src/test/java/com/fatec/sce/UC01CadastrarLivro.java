package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.DAOFactory;

import com.fatec.sce.model.ILivroDAO;

import com.fatec.sce.model.Livro;

import com.fatec.sce.model.LivroDAO;

public class UC01CadastrarLivro {
	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com dados
	 * válidos.
	 */
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("Não deve falhar");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com ISBN
	 * em branco.
	 */
	@Test
	public void CT02CadastrarLivroComISBN_em_branco() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comISBNInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com ISBN
	 * nulo.
	 */
	@Test
	public void CT03CadastrarLivroComISBN_nulo() {
		try {
			// cenario
			Livro umLivro = new Livro();
			// acao
			umLivro = ObtemLivro.comISBNInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com
	 * Titulo em branco.
	 */
	@Test
	public void CT04CadastrarLivroComTitulo_em_branco() {
		// cenario
		Livro livro = new Livro();

		try {
			// acao
			livro = ObtemLivro.comTituloInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com
	 * Titulo nulo.
	 */
	@Test
	public void CT05CadastrarLivroComTitulo_nulo() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro = ObtemLivro.comTituloInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com Autor
	 * em branco.
	 */
	@Test
	public void CT06CadastrarLivroComAutor_em_branco() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro = ObtemLivro.comAutorInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de livro com Autor
	 * nulo.
	 */
	@Test
	public void CT07CadastrarLivroComAutor_nulo() {
		// cenario
		Livro livro = new Livro();
		try {
			// acao
			livro = ObtemLivro.comAutorInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor inválido", e.getMessage());
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de um livro com
	 * sucesso para Titulo (getTitulo).
	 */
	@Test
	public void CT08CadastrarLivro_com_sucesso_Titulo() {
		// cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		assertEquals("Engenharia de Software", livro.getTitulo());
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de um livro com
	 * sucesso para ISBN (getIsbn).
	 */
	@Test
	public void CT09CadastrarLivro_com_sucesso_ISBN() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		assertEquals("121212", livro.getIsbn());
	}

	/**
	 * Objetivo: verificar o comportamento do sistema no cadastro de um livro com
	 * sucesso para Autor (getAutor).
	 */
	@Test
	public void CT10CadastrarLivro_com_sucesso_Autor() {
		// cenario
		Livro livro = new Livro();
		livro.setAutor("Pressman");
		livro.setTitulo("Engenharia de Software");
		assertEquals("Pressman", livro.getAutor());
	}

	@Test
	public void CT11CadastrarLivro_com_sucesso() {
		// cenario
		Livro umLivro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		// acao
		int codigoRetorno = livroDAO.adiciona(umLivro);
		// verificacao
		assertEquals(1, codigoRetorno);
		livroDAO.exclui(umLivro.getIsbn()); // Volto o ambiente para o estado anterior
	}

	@Test
	public void CT12CadastrarLivroComISBNCadastrado() {
		// cenario
		Livro umLivro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		try {
			// acao
			livroDAO.adiciona(umLivro);
			livroDAO.adiciona(umLivro);
			// verificacao
		} catch (RuntimeException e) {
			assertEquals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '121213' for key 'PRIMARY'", e.getMessage());
		}
		livroDAO.exclui(umLivro.getIsbn());
	}
}