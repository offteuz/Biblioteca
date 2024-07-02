package br.com.teksystem.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "t_livro")
public class Livro {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_livro")
    @SequenceGenerator(
            name = "seq_livro",
            sequenceName = "livro")
    @Column(name = "id_livro")
    public Long idLivro;

    public String titulo;
    public String autor;
    public String descricao;

    @Column(name = "ano_lancamento")
    public Date anoDeLancamento;

    public Long quantidade;

    @Column(name = "quantidade_disponivel")
    public Long quantidadeDisponivel;

    @ManyToOne
    private Categoria categoria;

    public Livro(String titulo, String autor) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("O titulo do livro deve ser infomaado!");
        }
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("O Autor do livro deve ser informado!");
        }
        this.titulo = titulo;
        this.autor = autor;
    }

}