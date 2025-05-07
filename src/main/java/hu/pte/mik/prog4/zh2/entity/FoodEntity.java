package hu.pte.mik.prog4.zh2.entity;

import java.util.Objects;

public class FoodEntity {

    private Long id;
    private String restaurantName;
    private String foodName;
    private String price;

    public FoodEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public FoodEntity(Long id, String restaurantName, String foodName, String price) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.foodName = foodName;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(foodName, that.foodName) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(restaurantName);
        result = 31 * result + Objects.hashCode(foodName);
        result = 31 * result + Objects.hashCode(price);
        return result;
    }
}
