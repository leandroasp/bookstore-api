package me.urbanize.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.urbanize.bookstore.domain.Categoria;
import me.urbanize.bookstore.domain.Livro;
import me.urbanize.bookstore.repositories.CategoriaRepository;
import me.urbanize.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografia");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Robert Martin", "Loren ipsum", cat1);
		Livro l3 = new Livro(null, "Matrix", "Robert Martin", "Loren ipsum", cat2);
		Livro l4 = new Livro(null, "Star Wars", "Robert Martin", "Loren ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Robert Martin", "Loren ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
