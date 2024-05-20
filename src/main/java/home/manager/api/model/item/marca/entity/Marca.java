package home.manager.api.model.item.marca.entity;

import home.manager.api.model.item.costant.Grupo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="marca")
@Entity(name="marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", length = 255)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name= "grupo")
    private Grupo grupo;
}
