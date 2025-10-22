package top.xyppyx.constant;

import java.util.List;
import java.util.ArrayList;

public enum SortOpt {

    DEFAULT(1),
    CALORIES(2),
    PRICES(3);

    private final int code;

    SortOpt(int code) {
        this.code = code;
    }

    /**
     * 根据 code 获取对应的 FoodType
     * @param code 要查找的整数 code
     * @return 匹配的 SortOpt，如果未找到则throw IllegalArgumentException
     */
    public static SortOpt getByCode(int code) {
        for (SortOpt type : SortOpt.values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown sort code: " + code);
    }

    /**
     * 获取所有排序选项名称的方法
     * @return 排序选项名称列表
     */
    public static List<String> getAllSortOpts() {
        List<String> types = new ArrayList<>();
        for (SortOpt type : SortOpt.values()) {
            types.add(type.name());
        }
        return types;
    }
}
