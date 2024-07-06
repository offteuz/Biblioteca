package br.com.teksystem.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "t_categoria")
public class Categoria {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_categoria")
    @SequenceGenerator(
            name = "seq_categoria",
            sequenceName = "seq_categoria",
            allocationSize = 1)
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

}