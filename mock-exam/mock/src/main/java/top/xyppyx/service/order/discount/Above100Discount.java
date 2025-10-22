//package top.xyppyx.service.order.discount;
//
//import java.math.BigDecimal;
//
//import top.xyppyx.service.order.discount.DiscountStrategy;
//
//public class Above100Discount implements DiscountStrategy {
//
//    private static final String DESCRIPTION = "满$100减$50";
//
//    @Override
//    public boolean isApplicable(BigDecimal initPrice) {
//        return initPrice.compareTo(BigDecimal.valueOf(100)) >= 0;
//    }
//}
