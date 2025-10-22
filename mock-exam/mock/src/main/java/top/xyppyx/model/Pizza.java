package top.xyppyx.model;

import top.xyppyx.constant.FoodType;

import java.math.BigDecimal;

/**
 * 披萨类
 */
public class Pizza extends Food {

    /**
     * 披萨尺寸（单位：英寸）
     */
    private Double radius;

    /**
     * 打印食品信息
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("尺寸: " + radius + " inches");
    }

    public Pizza(String name, Double weight, BigDecimal price, String features, Double calories, String image, Double radius) {
        super(name, FoodType.PIZZA, weight, price, features, calories, image);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
