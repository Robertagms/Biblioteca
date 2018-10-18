package com.fatec.sce.model;

public class Livro {
	private String isbn;
	private String titulo;
	private String autor;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn == "" | isbn == null) {
			throw new RuntimeException("ISBN inválido");
		}
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == "" | titulo == null) {
			throw new RuntimeException("Titulo inválido");
		}
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == "" | autor == null) {
			throw new RuntimeException("Autor inválido");
		}
		this.autor = autor;
	}
}
