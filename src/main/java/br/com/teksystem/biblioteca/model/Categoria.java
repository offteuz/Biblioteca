package br.com.teksystem.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_categoria")
public class Categoria {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_categoria")
    @SequenceGenerator(
            name = "seq_categoria",
            sequenceName = "seq_categoria")
    @Column(name = "id_categoria")
    public Long idCategoria;

    public String nome;

}
