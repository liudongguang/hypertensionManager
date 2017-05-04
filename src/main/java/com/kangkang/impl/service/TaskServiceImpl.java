package com.kangkang.impl.service;

import com.kangkang.api.po.Tempimages;
import com.kangkang.api.service.TaskService;
import com.kangkang.impl.mapper.TempimagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

import java.io.File;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/3.
 */
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TempimagesMapper tempimagesDao;

    @Override
    public void delImgs() {
        List<Tempimages> delList = tempimagesDao.getDelImages();
        delList.forEach(item -> {
            tempimagesDao.deleteByPrimaryKey(item.getUid());
            String realPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(item.getImagepath());
            File delFile=new File(realPath);
            delFile.delete();
        });
    }
}
