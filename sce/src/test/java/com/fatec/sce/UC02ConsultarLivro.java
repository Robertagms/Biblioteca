package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.DAOFactory;
import com.fatec.sce.model.ILivroDAO;
import com.fatec.sce.model.Livro;

public class UC02ConsultarLivro {
	@Test
	public void CT01CadastrarLivro_com_sucesso() {
		// cenario
		Livro umLivro = ObtemLivro.comDadosValidos(); //Pegando um objeto do tipo livro com dados válidos
		Livro resultadoObtido = null; //Criei um outro nulo, não aponta pra ninguém
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL); //Estabeleci a conexão
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		// acao
		livroDAO.adiciona(umLivro); //Adicino o objeto com paramento livro
		resultadoObtido = livroDAO.consulta(umLivro.getIsbn()); //Me devolve um objeto
		// verificacao
		assertTrue(resultadoObtido.equals(umLivro)); //O resultado obtido é igual a um livro?
		livroDAO.exclui(umLivro.getIsbn());
	}
}