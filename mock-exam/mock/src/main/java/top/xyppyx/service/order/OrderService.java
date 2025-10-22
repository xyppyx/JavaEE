package top.xyppyx.service.order;

import top.xyppyx.model.Food;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 订单处理服务实现类
 */
public class OrderService implements IOrderService {

    private List<Food> order = new ArrayList<>();

    /**
     * 创建订单
     */
    public void createOrder(Map<String, Food> foodMap) {

        while(true){
            System.out.println("请输入您要点的菜品名称（输入 done 结束点餐）：");
            String input = System.console().readLine().trim();

            if(input.equalsIgnoreCase("done")) {
                break;
            }

            if(foodMap.containsKey(input)) {
                Food food = foodMap.get(input);
                order.add(food);
                System.out.println("已添加到订单: " + food.getName() + " - $" + food.getPrice());
            } else {
                System.out.println("菜品不存在，请重新输入。");
            }
        }
    }

    /**
     * 计算订单总价
     * @return 订单总价
     */
    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0");

        for(Food food : order) {
            if(food.getName().equals("Margherita Pizza")) {
                BigDecimal discountPrice = food.getPrice().multiply(new BigDecimal("0.5"));
                totalPrice = totalPrice.add(discountPrice);
            } else {
                totalPrice = totalPrice.add(food.getPrice());
            }
        }

        if(totalPrice.compareTo(new BigDecimal("100")) > 0) {
            totalPrice = totalPrice.subtract(new BigDecimal("50"));
        }

        return totalPrice;
    }
}
