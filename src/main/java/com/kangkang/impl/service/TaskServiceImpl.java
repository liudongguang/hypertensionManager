package com.kangkang.impl.service;

import com.kangkang.api.service.TaskService;
import com.kangkang.impl.mapper.TempimagesMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/3.
 */
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TempimagesMapper tempimagesDao;
    @Override
    public void delImgs() {
        List<Integer> delList=tempimagesDao.getDelImages();
        delList.forEach(item->{
            tempimagesDao.deleteByPrimaryKey(item);
        });
    }
}
