package top.xyppyx;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import top.xyppyx.constant.*;
import top.xyppyx.data.DataExtractorStrategy;
import top.xyppyx.data.HtmlDataExtractor;
import top.xyppyx.model.Food;
import top.xyppyx.service.control.IControlService;
import top.xyppyx.service.display.IDisplayService;
import top.xyppyx.service.order.IOrderService;
import top.xyppyx.service.report.IReportService;
import top.xyppyx.service.control.ControlService;
import top.xyppyx.service.display.DisplayService;
import top.xyppyx.service.order.OrderService;
import top.xyppyx.service.report.ReportService;

/**
 * 用户交互系统类
 * 封装了数据获取，展示，下单，报告生成，用户交互等功能
 */
public class MainSystem {

    //服务组件
    private DataExtractorStrategy dataExtractor;
    private final IControlService controlService;
    private final IDisplayService displayService;
    private final IOrderService orderService;
    private final IReportService reportService;

    //成员变量
    private List<Food> foodList;
    private Map<String, Food> foodMap;
    private final List<String> dataSources;
    private final List<String> foodTypes;
    private final List<String> options;
    private final List<String> sortOptions;
    private final List<String> sortOrders;

    //内部操作类型枚举
    private enum OperationType {
        VIEW_MENU,
        PLACE_ORDER,
        GENERATE_REPORT,
        EXIT_SYSTEM;

        public static List<String> getAllTypes() {
            List<String> types = new ArrayList<>();
            for (OperationType type : OperationType.values()) {
                switch (type) {
                    case VIEW_MENU:
                        types.add("浏览菜单");
                        break;
                    case PLACE_ORDER:
                        types.add("下单");
                        break;
                    case GENERATE_REPORT:
                        types.add("生成报告");
                        break;
                    case EXIT_SYSTEM:
                        types.add("退出系统");
                        break;
                    default:
                        break;
                }
            }
            return types;
        }
    }

    public MainSystem() {
        this.controlService = new ControlService();
        this.displayService = new DisplayService();
        this.orderService = new OrderService();
        this.reportService = new ReportService();
        this.dataSources = List.of("本地html文件");
        this.foodTypes = FoodType.getAllTypes();
        this.options = OperationType.getAllTypes();
        this.sortOptions = List.of("默认顺序", "按热量排序", "按价格排序");
        this.sortOrders = List.of("升序", "降序");
    }

    /**
     * 系统运行主循环
     */
    public void run() {
        controlService.showPrompt("欢迎来到 Garfield Restaurant！\n");
        //选择数据来源
        chooseDataSource();

        //主操作循环
        while(true) {
            //选择操作类型
            controlService.showOptions("请选择操作：", options);
            int optChoice = controlService.getUserChoice(options.size());

            switch(optChoice) {
                case 1://浏览菜单
                    //选择食物类型
                    controlService.showOptions("请选择食物类型：", foodTypes);
                    int foodTypeChoice = controlService.getUserChoice(foodTypes.size());
                    FoodType foodType = FoodType.getByCode(foodTypeChoice);

                    //选择排序方式
                    controlService.showOptions("请选择排序方式：", sortOptions);
                    int sortOptionChoice = controlService.getUserChoice(sortOptions.size());
                    SortOpt sortOpt = SortOpt.getByCode(sortOptionChoice);

                    //选择排序方向
                    boolean isAsc = true;
                    if (sortOpt != SortOpt.DEFAULT) {
                        controlService.showOptions("请选择排序方向：", sortOrders);
                        isAsc = controlService.getUserChoice(sortOrders.size()) == 1;
                    }

                    //按要求显示菜单
                    displayService.displayFoodList(foodList, foodType, sortOpt, isAsc);

                    break;
                case 2://下单
//                    controlService.showPrompt("请输入您要下单的食物名称,按下回车结尾\n输入 'done' 完成下单：");
//                    orderService.
                    break;
                case 3://生成报告

                    break;
                case 4:
                    //退出系统
                    controlService.showPrompt("感谢使用 Garfield Restaurant 系统，祝您生活愉快！");
                    return;
                default:
                    controlService.showPrompt("无效选项，请重新选择。");
                    break;
            }
        }
    }

    /**
     * 选择数据来源
     */
    private void chooseDataSource() {

        controlService.showOptions("请选择数据来源(目前只支持html)：", dataSources);
        int dataSourceChoice = controlService.getUserChoice(dataSources.size());
        switch (dataSourceChoice) {
            case 1:
                this.dataExtractor = new HtmlDataExtractor();
                break;
            default:
                break;
        }

        //提取数据
        try {
            dataExtractor.extractData(Constant.FOOD_DATA_FILE);
        } catch (Exception e) {
            controlService.showPrompt("数据提取失败，系统退出。");
            return;
        }
        foodList = dataExtractor.getData();
        foodMap = foodList
                .stream()
                .collect(
                    Collectors.toMap(Food::getName, food -> food)
                );
        controlService.showPrompt("数据提取成功！共有 " + foodList.size() + " 种食物可供选择。\n");
    }
}
