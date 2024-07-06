package br.com.teksystem.biblioteca.dto;

import br.com.teksystem.biblioteca.model.Categoria;
import br.com.teksystem.biblioteca.model.Livro;

import java.util.Date;

public record LivroExibicaoDTO(
        Long idLivro,
        String titulo,
        String autor,
        String descricao,
        Date anoDeLancamento,
        Long quantidade,
        Long quantidadeDisponivel,
        Categoria categoria
) {
    public LivroExibicaoDTO(Livro livro) {
        this(
                livro.getIdLivro(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getDescricao(),
                livro.getAnoDeLancamento(),
                livro.getQuantidade(),
                livro.getQuantidadeDisponivel(),
                livro.getCategoria()
        );
    }
}
