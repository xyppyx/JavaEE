package top.xyppyx.model;

import java.math.BigDecimal;

import top.xyppyx.constant.*;

/**
 * 食品父类
 */
public class Food {

    /**
     * 食品名称
     */
    private String name;

    /**
     * 食品类型
     */
    private FoodType type;

    /**
     * 食品重量（单位：克）
     */
    private Double weight;

    /**
     * 食品价格（单位：$）
     */
    private BigDecimal price;

    /**
     * 食品特点
     */
    private String features;

    /**
     * 食品热量（单位：千卡）
     */
    private Double calories;

    /**
     * 食品图片链接（URL）
     */
    private String image;

    /**
     * 打印食品信息
     */
    public void printInfo() {
        System.out.println("食品名: " + name);
        System.out.println("食品类型: " + type);
        System.out.println("价格: $" + price);
        System.out.println("重量: " + weight + " g");
        System.out.println("热量: " + calories + " kcal");
        System.out.println("特点: " + features);
        System.out.println("图片URL: " + image);
    }

    public Food(String name, FoodType type, Double weight, BigDecimal price, String features, Double calories, String image) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.features = features;
        this.calories = calories;
        this.image = image;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
