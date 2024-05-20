package home.manager.api.model.item.patrimonio.entity;

import home.manager.api.model.item.categoria.entity.Categoria;
import home.manager.api.model.item.marca.entity.Marca;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "patrimonio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Column
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria fk_categoria;

    @ManyToOne
    @JoinColumn(name = "fk_marca")
    private Marca fk_marca;

    @Column
    private int quantidade;

}
