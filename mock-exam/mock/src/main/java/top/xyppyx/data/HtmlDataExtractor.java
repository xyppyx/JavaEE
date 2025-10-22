package top.xyppyx.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import top.xyppyx.model.*;
import top.xyppyx.constant.FoodType;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HTML数据提取策略实现
 */
public class HtmlDataExtractor implements DataExtractorStrategy {

    private final List<Food> foods = new ArrayList<>();

    /**
     * 提取HTML数据的方法
     * @param source 数据源(html文件路径)
     */
    @Override
    public void extractData(String source) throws IOException {

        try {

            Document doc = Jsoup.parse(new File(source), "utf8");

            Elements pizzas = doc.getElementsByClass("pizza");
            extractFoodItems(pizzas, FoodType.PIZZA);

            Elements fries = doc.getElementsByClass("french-fries");
            extractFoodItems(fries, FoodType.FRIES);

            Elements chickens = doc.getElementsByClass("fried-chicken");
            extractFoodItems(chickens, FoodType.CHICKEN);
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw e;
        }
    }

    /**
     * 从elements中提取具体食物项的方法
     * @param items element列表
     * @param foodType 食物类型
     */
    private void extractFoodItems(Elements items, FoodType foodType) {

        for (var item : items) {
            //获取图片url
            String img = item.getElementsByTag("img").attr("src");
            //获取名称
            String name = item.getElementsByTag("h2").text();
            //获取价格
            BigDecimal price = new BigDecimal(item.getElementsByClass("price").text().substring(1));
            //获取特征
            String features = item.getElementsByClass("features").text().substring(10);
            //获取重量与热量
            Double weight = null;
            Double calories = null;
            //其他信息
            Double radius = null;
            String thickness = null;
            String spiciness = null;

            Elements paragraphs = item.getElementsByTag("p");
            for(var p : paragraphs) {
                String text = p.text();
                if(text.startsWith("Calories:")) {
                    calories = Double.parseDouble(text.substring(10, text.length() - 5).trim());
                }else if(text.startsWith("Weight:")) {
                    weight = Double.parseDouble(text.substring(8, text.length() - 1).trim());
                }else if(text.startsWith("Radius:")) {
                    radius = Double.parseDouble(text.substring(8, text.length() - 7).trim());
                }else if(text.startsWith("Thickness:")) {
                    thickness = text.substring(11).trim();
                }else if(text.startsWith("Spiciness:")) {
                    spiciness = text.substring(11).trim();
                }
            }

            Food food = switch (foodType) {
                case FoodType.PIZZA -> new Pizza(name, weight, price, features, calories, img, radius);
                case FoodType.FRIES -> new Fries(name, weight, price, features, calories, img, thickness);
                case FoodType.CHICKEN -> new Chicken(name, weight, price, features, calories, img, spiciness);
                default -> new Food(name, FoodType.ALL, weight, price, features, calories, img);
            };

            foods.add(food);
        }
    }

    /**
     * 获取提取的数据的方法
     * @return 食物列表
     */
    @Override
    public List<Food> getData() {

        return foods;
    }
}
