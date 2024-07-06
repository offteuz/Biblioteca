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
            sequenceName = "seq_livro",
            allocationSize = 1)
    @Column(name = "id_livro")
    private Long idLivro;

    private String titulo;
    private String autor;
    private String descricao;

    @Column(name = "ano_lancamento")
    private Date anoDeLancamento;

    private Long quantidade;

    @Column(name = "quantidade_disponivel")
    private Long quantidadeDisponivel;

    @ManyToOne
    @JoinColumn(
            name = "id_categoria",
            referencedColumnName = "id_categoria")
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