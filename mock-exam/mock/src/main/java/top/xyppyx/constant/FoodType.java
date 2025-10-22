package top.xyppyx.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 食物类型枚举
 */
public enum FoodType {

    ALL(1),
    PIZZA(2),
    FRIES(3),
    CHICKEN(4);

    private final int code;

    FoodType(int code) {
        this.code = code;
    }

    /**
     * 根据 code 获取对应的 FoodType
     * @param code 要查找的整数 code
     * @return 匹配的 FoodType，如果未找到则throw IllegalArgumentException
     */
    public static FoodType getByCode(int code) {
        for (FoodType type : FoodType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown food code: " + code);
    }

    /**
     * 获取所有食物类型名称的方法
     * @return 食物类型名称列表
     */
    public static List<String> getAllTypes() {
        List<String> types = new ArrayList<>();
        for (FoodType type : FoodType.values()) {
            types.add(type.name());
        }
        return types;
    }
}
