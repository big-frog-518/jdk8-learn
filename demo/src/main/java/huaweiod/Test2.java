package huaweiod;

import java.util.Scanner;

/**
 * @Author: ZhengJinxu
 * @Date: 2022/6/23 12:17
 */
public class Test2 {
    /**
     * 【N进制减法】
     * 实现一个基于字符串的N机制的减法。
     * 需要对输入的两个字符串按照给定的N进制进行减法操作，输出正负符号和表示结果的字符串。
     * 输入描述:
     * 输入：三个参数。
     * 第一个参数是整数形式的进制N值，N值范围为大于等于2、小于等于35。
     * 第二个参数为被减数字符串；
     * 第三个参数为减数字符串。有效的字符包括09以及小写字母az，字符串有效字符个数最大为100个字符，另外还有结尾的\0。
     * 限制：
     * 输入的被减数和减数，除了单独的0以外，不能是以0开头的字符串。
     * 如果输入有异常或计算过程中有异常，此时应当输出-1表示错误。
     * 输出描述:
     * 输出：2个。
     * 其一为减法计算的结果，-1表示出错，0表示结果为整数，1表示结果为负数。
     * 其二为表示结果的字符串。
     * 示例1:
     * 输入
     * 2 11 1
     * 输出
     * 0 10
     * 说明
     * 按二进制计算 11 -1 ，计算正常，0表示符号为正数，结果为10
     * 示例2:
     * 输入
     * 8 07 1
     * 输出
     * -1
     * 说明
     * 按8进制，检查到减数不符合非0前导的要求，返回结果为-1，没有其他结果内容。
     * ————————————————
     * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/csfun1/article/details/124362254
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int jinzhi = Integer.parseInt(split[0]);
        // 前缀校验
        if (split[1].length() != 1 && split[1].startsWith("0") || split[2].length() != 1 && split[2].startsWith("0")) {
            System.out.println("-1");
            return;
        }
        // 后缀校验
        if (split[1].endsWith("/0")) {
            split[1] = split[1].substring(0, split[1].length() - 2);
        }
        if (split[2].endsWith("/0")) {
            split[2] = split[2].substring(0, split[2].length() - 2);
        }
        // 减数
        int num1 = 0;
        // 被减数
        int num2 = 0;
        // 输出结果
        int result = 0;
        try {
            // 转成n进制
            num1 = Integer.parseInt(split[1], jinzhi);
            num2 = Integer.parseInt(split[2], jinzhi);
            result = num1 - num2;
        } catch (Exception e) {
            System.out.println("-1");
            return;
        }
        if (result > 0) {
            System.out.println(0 + " ");
        } else {
            System.out.println(1 + " ");
        }
        // 输出n进制结果
        System.out.println(Integer.toString(result, jinzhi));
    }
}
