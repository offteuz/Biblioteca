package br.com.teksystem.biblioteca.repository;

import br.com.teksystem.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    public Livro findByTitulo(String titulo);
    public Livro findByAutor(String autor);
    public Livro findByCategoria(String categoria);

}
