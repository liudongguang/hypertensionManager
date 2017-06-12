package com.kangkang.api.util;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/6/9.
 */
public class ReportCalculate {
    /**
     * 求编译系数
     * @param numData
     * @param avg
     * @return
     */
    public static double calculateBianYiXishu(List<Integer> numData, int avg) {
        int size = numData.size();
        int[] t3 = {0};
        numData.forEach(item -> {
            int t1 = item - avg;
            int t2 = t1 * t1;
            t3[0] += t2;
        });
        double t4 = t3[0] * 1.0 / size;
        return Math.sqrt(t4)/avg;
    }


}
