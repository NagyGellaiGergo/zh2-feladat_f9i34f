package hu.pte.mik.prog4.zh2.repository;

import hu.pte.mik.prog4.zh2.entity.RoleEntity;
import hu.pte.mik.prog4.zh2.entity.UserEntity;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository extends Repository {

    private static final Logger LOGGER = Logger.getLogger(RoleRepository.class);

    public List<RoleEntity> findRolesByUser(Long id) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement("" + "SELECT r.ID, r.code, r.description FROM role r JOIN user_role ur on r.ID = ur.user_id"
                     + "JOIN user u on u.ID = ur.user_id WHERE u.ID = ?");) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            List<RoleEntity> roles = new ArrayList<>();
            while (rs.next()) {
                RoleEntity role = new RoleEntity();
                role.setId(rs.getLong("ID"));
                role.setCode(rs.getString("code"));
                role.setDescription(rs.getString("description"));
                roles.add(role);
            }
            return roles;
        } catch (
                SQLException e) {
            LOGGER.error("Adathozzáférési hiba: " + e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (
                NamingException e) {
            LOGGER.error("Valamilyen hiba történt: " + e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }
}
