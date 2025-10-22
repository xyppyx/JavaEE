package top.xyppyx.data;

import top.xyppyx.model.Food;

import java.io.IOException;
import java.util.List;

/**
 * 数据提取策略接口
 * 作为html/api/json等不同数据提取策略的统一接口
 */
public interface DataExtractorStrategy {

    /**
     * 提取数据的方法
     */
    void extractData(String source) throws IOException;

    /**
     * 获取内存中数据
     */
    List<Food> getData();
}
