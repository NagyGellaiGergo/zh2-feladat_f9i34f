package hu.pte.mik.prog4.zh2.entity;

import java.util.Objects;

public class RoleEntity {

    private Long id;
    private String code;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(code);
        result = 31 * result + Objects.hashCode(description);
        return result;
    }
}
