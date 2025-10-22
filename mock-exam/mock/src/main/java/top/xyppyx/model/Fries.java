package top.xyppyx.model;

import top.xyppyx.constant.FoodType;

import java.math.BigDecimal;

/**
 * french-fries薯条类
 */
public class Fries extends Food {

    /**
     * 薯条粗细
     */
    private String thickness;

    /**
     * 打印食品信息
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("粗细: " + thickness);
    }

    public Fries(String name, Double weight, BigDecimal price, String features, Double calories, String image, String thickness) {
        super(name, FoodType.FRIES, weight, price, features, calories, image);
        this.thickness = thickness;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }
}
