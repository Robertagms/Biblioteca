package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			 Usuario umUsuario = new Usuario();
			 // acao
			 umUsuario = ObtemUsuario.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("Não deve falhar");
		}
	}
	
	@Test
	public void CT02CadastrarUsuarioComRaInvalido_branco() {
		try {
			// cenario
			 Usuario umUsuario = new Usuario();
			 // acao
			 umUsuario = ObtemUsuario.comRaInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarUsuarioComRaInvalido_nulo() {
		try {
			// cenario
			 Usuario umUsuario = new Usuario();
			 // acao
			 umUsuario = ObtemUsuario.comRaInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarUsuarioComNomeInvalido_branco() {
		try {
			// cenario
			 Usuario umUsuario = new Usuario();
			 // acao
			 umUsuario = ObtemUsuario.comNomeInvalido_branco();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}
	
	@Test
	public void CT05CadastrarUsuarioComNomeInvalido_nulo() {
		try {
			// cenario
			 Usuario umUsuario = new Usuario();
			 // acao
			 umUsuario = ObtemUsuario.comNomeInvalido_nulo();
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome inválido", e.getMessage());
		}
	}
		
	@Test
	public void CT06RetornaRa() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("2040481613012");
		assertEquals("2040481613012", usuario.getRa());
	}
	
	@Test
	public void CT07RetornaNome() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Roberta Da Silva Gomes");
		assertEquals("Roberta Da Silva Gomes", usuario.getNome());
	}
		
}
