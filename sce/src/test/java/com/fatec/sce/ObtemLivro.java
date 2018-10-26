package com.fatec.sce;

import com.fatec.sce.model.Livro;

public class ObtemLivro {
	public static Livro comDadosValidos() {
		Livro livro = new Livro();
		livro.setIsbn("121213");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		return livro;
	}

	public static Livro comISBNInvalido_branco() {
		Livro livro = new Livro();
		livro.setIsbn("");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		return livro;
	}

	public static Livro comISBNInvalido_nulo() {
		Livro livro = new Livro();
		livro.setIsbn(null);
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		return livro;
	}
	
	public static Livro comTituloInvalido_branco() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("");
		livro.setAutor("Pressman");
		return livro;
	}

	public static Livro comTituloInvalido_nulo() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo(null);
		livro.setAutor("Pressman");
		return livro;
	}
	
	public static Livro comAutorInvalido_branco() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("");
		return livro;
	}

	public static Livro comAutorInvalido_nulo() {
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor(null);
		return livro;
	}
}