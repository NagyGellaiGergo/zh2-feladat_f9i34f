package hu.pte.mik.prog4.zh2.repository;

import hu.pte.mik.prog4.zh2.entity.RoleEntity;
import hu.pte.mik.prog4.zh2.entity.UserEntity;

import java.util.List;

public class RoleRepository extends Repository {

    public List<RoleEntity> findRolesByUser(UserEntity userEntity) {
        throw new UnsupportedOperationException();
    }

}
