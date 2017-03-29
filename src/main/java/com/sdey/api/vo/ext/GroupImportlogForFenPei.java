package com.sdey.api.vo.ext;

/**
 * Created by liudo on 2017/3/22 0022.
 */
public class GroupImportlogForFenPei {
    private String importDateStr;
    private Integer count;

    public String getImportDateStr() {
        return importDateStr;
    }

    public void setImportDateStr(String importDateStr) {
        this.importDateStr = importDateStr;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GroupImportlogForFenPei{" +
                "importDateStr='" + importDateStr + '\'' +
                ", count=" + count +
                '}';
    }
}
