package top.xyppyx.service.display;

import top.xyppyx.constant.*;

import java.util.List;
import java.util.ArrayList;
import top.xyppyx.model.Food;

public class DisplayService implements IDisplayService {

    /**
     * 展示排序后的食物列表
     * @param type 食物类型
     * @param sortBy 排序依据（calories, prices），为null则按默认顺序
     * @param isAsc 是否升序排列
     */
    @Override
    public void displayFoodList(List<Food> foodList, FoodType type, SortOpt sortBy, boolean isAsc) {

        System.out.printf("---- %s 菜单 ----\n", type);

        List<Food> filteredList = new ArrayList<>(foodList.stream()
                .filter(food -> type == FoodType.ALL || food.getType() == type)
                .toList());

        switch(sortBy) {
            case SortOpt.CALORIES:
                filteredList.sort((f1, f2) -> isAsc ? f1.getCalories().compareTo(f2.getCalories()) : f2.getCalories().compareTo(f1.getCalories()));
                break;
            case SortOpt.PRICES:
                filteredList.sort((f1, f2) -> isAsc ? f1.getPrice().compareTo(f2.getPrice()) : f2.getPrice().compareTo(f1.getPrice()));
                break;
            default:
                break;
        }

        for (Food food : filteredList) {
            System.out.println("-------------------");
            food.printInfo();
        }

        System.out.println("-------------------");
    }
}
