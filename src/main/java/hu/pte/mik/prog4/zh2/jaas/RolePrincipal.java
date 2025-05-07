package hu.pte.mik.prog4.zh2.jaas;

import java.security.Principal;

public class RolePrincipal implements Principal {

    private final String name;
    public RolePrincipal( final String name ) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
