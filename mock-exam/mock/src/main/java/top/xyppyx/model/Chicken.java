package top.xyppyx.model;

import top.xyppyx.constant.FoodType;

import java.math.BigDecimal;

/**
 * fried-chicken炸鸡类
 */
public class Chicken extends Food {

    /**
     * 炸鸡辣度
     */
    private String spiciness;

    /**
     * 打印食品信息
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("辣度: " + spiciness);
    }

    public Chicken(String name, Double weight, BigDecimal price, String features, Double calories, String image, String spiciness) {
        super(name, FoodType.CHICKEN, weight, price, features, calories, image);
        this.spiciness = spiciness;
    }

    public String getSpiciness() {
        return spiciness;
    }

    public void setSpiciness(String spiciness) {
        this.spiciness = spiciness;
    }
}
