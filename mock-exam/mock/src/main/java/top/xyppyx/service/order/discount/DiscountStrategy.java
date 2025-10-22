package top.xyppyx.service.order.discount;

import java.math.BigDecimal;

public interface DiscountStrategy {

    /**
     * 检查折扣策略是否适用
     * @return 是否适用
     */
    boolean isApplicable();

    /**
     * 应用折扣策略
     * @param initPrice 初始价格
     * @return 折后价格
     */
    BigDecimal applyDiscount(BigDecimal initPrice);

    /**
     * 获取折扣策略描述
     * @return 折扣策略描述
     */
    String getDescription();
}
