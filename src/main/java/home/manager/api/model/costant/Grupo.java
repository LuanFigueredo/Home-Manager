package home.manager.api.model.costant;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Grupo {
    PATRIMONIO("PATRIMONIO"),
    MERCADO("MERCADO"),
    FARMACIA("FARMACIA");

    private final String descricao;

    Grupo(String descricao) {
        this.descricao = descricao;
    }

    public static Grupo fromString(String text) {
        for (Grupo grupo : Grupo.values()) {
            if (grupo.name().equalsIgnoreCase(text)) {
                return grupo;
            }
        }
        throw new IllegalArgumentException("Nenhum enum constante encontrado com o nome " + text);
    }
}
