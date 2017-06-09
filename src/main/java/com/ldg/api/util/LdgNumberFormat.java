package com.ldg.api.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by LiuDongguang on 2017/6/9.
 */
public class LdgNumberFormat {
    private final static  DecimalFormat formater_int_floor = new DecimalFormat();
    static {
        formater_int_floor.setMaximumFractionDigits(0);
        formater_int_floor.setGroupingSize(0);
        formater_int_floor.setRoundingMode(RoundingMode.FLOOR);
    }

    /**
     * 去掉小数点，不进行四舍五入
     * @param num
     * @return
     */
    public final static int formatDoubleToInt_floor(Double num){
       return  Integer.valueOf(formater_int_floor.format(num));
    }
}
