package home.manager.api.model.item.mercado.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
//@Table(name="mercado")
//@Entity(name="mercado")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Mercado {
    private int id;
    private String nome;
    private Double preço;
    private int categoriaId;
    private int marcaId;
    private Date dataValidade;
    private int quantidade;

}
