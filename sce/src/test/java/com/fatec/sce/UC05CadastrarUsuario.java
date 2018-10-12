package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {

	// Retorna Ra

	@Test
	public void CT02RetornaRa() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("2040481613012");
		assertEquals("2040481613012", usuario.getRa());
	}
	
	@Test
	public void CT03RetornaNome() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Roberta Da Silva Gomes");
		assertEquals("Roberta Da Silva Gomes", usuario.getNome());
	}
	
	@Test
	public void CT04validarObjetoIgualThis() {
		// cenario
		Usuario usuario = new Usuario();
		assertTrue(usuario.equals(usuario));
	}
	
	@Test
	public void CT05validarObjetoNulo() {
		// cenario
		Usuario usuario = new Usuario();
		assertFalse(usuario.equals(null));
	}
	
}
