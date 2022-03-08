package leetcode.editor.cn.doc;

/**
 * 背包问题
 *
 * @author zhangguodong
 * @since 2022/3/8 15:16
 */
public class PackageProblem {
    static int[] weight = {1, 3, 4};   //各个物品的重量
    static int[] value = {15, 20, 30}; //对应的价值
    static int bagWeight = 4;          //背包最大能放下多少重的物品

    public static void main(String[] args) {
        bags_problem_1(weight, value, bagWeight);
        bags_problem_2(weight, value, bagWeight);
    }

    /**
     * 0-1背包问题母代码(二维)
     */
    public static void bags_problem_2(int[] weight, int[] value, int bagWeight) {
        // 二维数组：状态定义:dp[i][j]表示从0-i个物品中选择不超过j重量的物品的最大价值
        int[][] dp = new int[weight.length + 1][bagWeight + 1];

        // 初始化:第一列都是0，第一行表示只选取0号物品最大价值
        for (int j = bagWeight; j >= weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        // weight数组的大小 就是物品个数
        for (int i = 1; i < weight.length; i++) {// 遍历物品(第0个物品已经初始化)
            for (int j = 0; j <= bagWeight; j++) {// 遍历背包容量
                //背包容量已经不足以拿第i个物品了
                if (j < weight[i]) {
                    //最大价值就是拿第i-1个物品的最大价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //背包容量足够拿第i个物品,可拿可不拿：拿了最大价值是前i-1个物品扣除第i个物品的 重量的最大价值加上i个物品的价值
                    //不拿就是前i-1个物品的最大价值,两者进行比较取较大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[weight.length - 1][bagWeight]);
    }

    /**
     * 0-1背包问题母代码(一维)
     */
    public static void bags_problem_1(int[] weight, int[] value, int bagWeight) {
        // 初始化
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            // 遍历背包容量(一定要逆序)
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]); //不取或者取第i个
            }
        }
        System.out.println(dp[bagWeight]);
    }
}
