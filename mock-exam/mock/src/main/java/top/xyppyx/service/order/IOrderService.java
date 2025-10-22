package top.xyppyx.service.order;

import java.math.BigDecimal;
import java.util.Map;

import top.xyppyx.model.Food;

/**
 * 订单处理服务接口
 */
public interface IOrderService {

    /**
     * 创建订单
     */
    void createOrder(Map<String, Food> foodMap);

    /**
     * 计算订单总价
     * @return 订单总价
     */
    BigDecimal calculateTotalPrice();
}
