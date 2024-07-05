package br.com.teksystem.biblioteca.repository;

import br.com.teksystem.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
