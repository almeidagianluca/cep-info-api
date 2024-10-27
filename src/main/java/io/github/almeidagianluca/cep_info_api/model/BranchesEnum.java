package io.github.almeidagianluca.cep_info_api.model;

import java.util.Arrays;

public enum BranchesEnum {
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    BELO_HORIZONTE("Belo Horizonte"),
    RECIFE("Recife");

    private final String name;

    BranchesEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean hasBranchInCity(String city) {
        return Arrays.stream(BranchesEnum.values()).anyMatch(branch -> branch.getName().equals(city));
    }
}
