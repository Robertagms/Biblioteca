package com.fatec.sce;

import com.fatec.sce.model.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario usuario = new Usuario();
		usuario.setNome("Roberta Da Silva Gomes");
		usuario.setRa("2040481613012");
		return usuario;
	}

	public static Usuario comRaInvalido_branco() {
		Usuario usuario = new Usuario();
		usuario.setNome("Roberta Da Silva Gomes");
		usuario.setRa("");
		return usuario;
	}
	
	public static Usuario comRaInvalido_nulo() {
		Usuario usuario = new Usuario();
		usuario.setNome("Roberta Da Silva Gomes");
		usuario.setRa(null);
		return usuario;
	}
	
	public static Usuario comNomeInvalido_branco() {
		Usuario usuario = new Usuario();
		usuario.setNome("");
		usuario.setRa("2040481613012");
		return usuario;
	}
	
	public static Usuario comNomeInvalido_nulo() {
		Usuario usuario = new Usuario();
		usuario.setNome(null);
		usuario.setRa("2040481613012");
		return usuario;
	}
}
