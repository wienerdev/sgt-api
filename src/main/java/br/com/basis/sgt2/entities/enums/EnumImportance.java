package br.com.basis.sgt2.entities.enums;

        import lombok.AllArgsConstructor;
        import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumImportance {

    IMPORTANT("Importante"), ESSENTIAL("Essential"), REASONABLE("Reasonable");

    private String description;

}