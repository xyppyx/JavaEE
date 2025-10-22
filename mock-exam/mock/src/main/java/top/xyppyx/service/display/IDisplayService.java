package top.xyppyx.service.display;

import java.util.List;

import top.xyppyx.constant.*;
import top.xyppyx.model.Food;

/**
 * 展示食物列表接口
 */
public interface IDisplayService {

    /**
     * 展示排序后的食物列表
     * @param foodList 食物列表
     * @param type 食物类型
     * @param sortBy 排序依据（calories, prices），为null则按默认顺序
     * @param isAsc 是否升序排列
     */
    void displayFoodList(List<Food> foodList, FoodType type, SortOpt sortBy, boolean isAsc);
}
