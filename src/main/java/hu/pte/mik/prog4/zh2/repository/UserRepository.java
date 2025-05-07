package hu.pte.mik.prog4.zh2.repository;

import hu.pte.mik.prog4.zh2.entity.UserEntity;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends Repository {

    private static final Logger LOGGER = Logger.getLogger( UserRepository.class );

    public UserEntity findByUsername(String username) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT ID, username, password FROM user WHERE username = ?")){
            stmt.setString( 1, username );

            ResultSet rs = stmt.executeQuery();

            rs.next();

            UserEntity user = new UserEntity();
            user.setId(rs.getLong("ID"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            return user;
        }catch (SQLException e) {
            LOGGER.error("Adathozzáférési hiba: " + e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (NamingException e) {
            LOGGER.error("Valamilyen hiba történt: " + e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
