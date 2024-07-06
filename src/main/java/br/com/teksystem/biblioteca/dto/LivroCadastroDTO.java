package br.com.teksystem.biblioteca.dto;

import br.com.teksystem.biblioteca.model.Categoria;

import java.util.Date;

public record LivroCadastroDTO(
        Long idLivro,
        String titulo,
        String autor,
        String descricao,
        Date anoDeLancamento,
        Long quantidade,
        Long quantidadeDisponivel,
        Categoria categoria
) {
}
