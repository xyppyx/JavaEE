package top.xyppyx.service.control;

import java.util.List;

/**
 * 系统控制服务接口
 */
public interface IControlService {


    /**
     * 打印提示词
     * @param prompt
     */
    void showPrompt(String prompt);

    /**
     * 打印可选项
     * @param prompt 提示信息
     * @param options 可选项列表
     */
    void showOptions(String prompt, List<String> options);

    /**
     * 获取用户选择
     * @param maxOption 最大选项数
     * @return 用户选择的选项编号
     */
    int getUserChoice(int maxOption);
}
