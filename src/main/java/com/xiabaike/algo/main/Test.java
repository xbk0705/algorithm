package com.xiabaike.algo.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author xiabaike <xiabaike@kuaishou.com>
 * Created on 2022-01-28
 */
public class Test {

    // 计算个人所得税：https://www.gerensuodeshui.cn/
    public static void main(String[] args) {
        int xinzi = 0;
        //
        double yanglao = wuxian(xinzi, 0.08, 2);
        double shiye = wuxian(xinzi, 0.005, 2);
        double yiliao = wuxian(xinzi, 0.02, 2) + 3;
        double gongjijin = wuxian(xinzi, 0.12, 0);
        double shebao = yanglao + shiye + yiliao + gongjijin;
        double zhihou = xinzi - shebao;
        System.out.println("养老：" + yanglao);
        System.out.println("失业：" + shiye);
        System.out.println("医疗：" + yiliao);
        System.out.println("公积金：" + gongjijin);
        System.out.println("========");
        System.out.println("社保公积金：" + shebao);
    }

    private static double wuxian(int xinzi, double bili, int scale) {
        BigDecimal bigDecimal;
        if (xinzi > 28221) {
            bigDecimal = BigDecimal.valueOf(28221);
        } else {
            bigDecimal = BigDecimal.valueOf(xinzi);
        }
        BigDecimal re = bigDecimal.multiply(BigDecimal.valueOf(bili)).setScale(scale, RoundingMode.HALF_UP);
        return re.doubleValue();
    }

}
