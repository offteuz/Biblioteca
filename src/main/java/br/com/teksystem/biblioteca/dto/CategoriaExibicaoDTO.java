package br.com.teksystem.biblioteca.dto;

import br.com.teksystem.biblioteca.model.Categoria;

public record CategoriaExibicaoDTO(
        Long idCategoria,
        String nome
) {
    public CategoriaExibicaoDTO(Categoria categoria) {
        this(
                categoria.getIdCategoria(),
                categoria.getNome()
        );
    }
}
