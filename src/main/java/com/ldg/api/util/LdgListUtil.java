package com.ldg.api.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liudo on 2017/3/22 0022.
 */
public class LdgListUtil {
    /**
     * 平分list  多余的放到单个的list中
     */
    public static  <T> List<List<T>> splitList(List<T> sList, int num) {
        List<List<T>> eList = new ArrayList<>();
        List<T> gList;
        int pingfenNum = (sList.size()) / num;
        int pingfenYuShu = (sList.size()) % num;

        int j;
        int temp=0;
        for (int i = 0; i < num; i++) {
            gList = new ArrayList<>();
            for (j = temp; j < (pingfenNum + temp); j++) {
                gList.add(sList.get(j));
            }
            temp = j;
            eList.add(gList);
        }
        if (pingfenYuShu != 0) {
            gList = new ArrayList<>();
            for (int  i= temp; i < sList.size(); i++) {
                gList.add(sList.get(i));
            }
            eList.add(gList);
        }
        return eList;
    }
    /**
     * 平分list  最后多余的几个放到最后list中
     */
    public static <T> List<List<T>> splitListForWork(List<T> sList, int num) {
        List<List<T>> eList = new ArrayList<>();
        List<T> gList;
        int pingfenNum = (sList.size()) / num;
        int pingfenYuShu = (sList.size()) % num;
        int j;
        int temp=0;
        for (int i = 0; i < num; i++) {
            gList = new ArrayList<>();
            for (j = temp; j < (pingfenNum + temp); j++) {
                gList.add(sList.get(j));
            }
            temp = j;
            /////最后一次
            if(i==num-1){
                if (pingfenYuShu != 0) {
                    for (int  jk= temp; jk < sList.size(); jk++) {
                        gList.add(sList.get(jk));
                    }
                }
            }
            eList.add(gList);
        }
        return eList;
    }
}
