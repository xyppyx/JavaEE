package top.xyppyx.service.control;

import java.util.List;
import java.util.Scanner;

public class ControlService implements IControlService {

    /**
     * 打印提示词
     * @param prompt
     */
    @Override
    public void showPrompt(String prompt) {
        System.out.println(prompt);
    }

    /**
     * 打印可选项
     * @param prompt 提示信息
     * @param options 可选项列表
     */
    @Override
    public void showOptions(String prompt, List<String> options) {
        System.out.println(prompt);
        for(int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, options.get(i));
        }
    }

    /**
     * 获取用户选择
     * @param maxOption 最大选项数
     * @return 用户选择的选项编号
     */
    public int getUserChoice(int maxOption) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 1 || choice > maxOption) {
            System.out.print("请输入选项编号: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > maxOption) {
                    System.out.println("无效选项，请重新输入。");
                }
            } else {
                System.out.println("无效输入，请输入数字。");
                scanner.next(); // 清除无效输入
            }
        }
        return choice;
    }
}
