package hu.pte.mik.prog4.zh2.repository;

import hu.pte.mik.prog4.zh2.entity.FoodEntity;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository extends Repository {

    private static final Logger LOGGER = Logger.getLogger( FoodRepository.class );

    public FoodEntity save(FoodEntity food) {
        throw new UnsupportedOperationException();
    }

    public FoodEntity update(FoodEntity food) {
        try (Connection conn = this.getConnection(); PreparedStatement stmt = conn.prepareStatement("UPDATE food SET restaurant_name, food_name, price WHERE ID = ?")){
            stmt.setString(1, food.getRestaurantName());
            stmt.setString(2, food.getFoodName());
            stmt.setString(3, food.getPrice());

            stmt.executeUpdate();

            return this.findById(food.getId());
        }catch (SQLException e) {
            LOGGER.error("Adathozzáférési hiba: " + e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (NamingException e) {
            LOGGER.error("Valamilyen hiba történt: " + e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public FoodEntity findById(Long id) {
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT ID, restaurant_name, food_name, price FROM food WHERE ID = ?")){

            stmt.setLong(1, id);

            ResultSet rs =stmt.executeQuery();

            rs.next();

            return this.mapFood(rs);

        }catch (SQLException e) {
            LOGGER.error("Adathozzáférési hiba: " + e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (NamingException e) {
            LOGGER.error("Valamilyen hiba történt: " + e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public List<FoodEntity> listAll() {
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs =
                    stmt.executeQuery("SELECT ID, restaurant_name, food_name, price FROM food");

            List<FoodEntity> foods = new ArrayList<>();
            while(rs.next()){
            foods.add(this.mapFood(rs));
            }

            return foods;
        }catch (SQLException e) {
            LOGGER.error("Adathozzáférési hiba: " + e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (NamingException e) {
            LOGGER.error("Valamilyen hiba történt: " + e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private FoodEntity mapFood(ResultSet rs) throws SQLException {
        FoodEntity food = new FoodEntity();
        food.setId(rs.getLong("ID"));
        food.setRestaurantName(rs.getString("restaurant_name"));
        food.setFoodName(rs.getString("food_name"));
        food.setPrice(rs.getString("price"));
        return food;
    }

}
