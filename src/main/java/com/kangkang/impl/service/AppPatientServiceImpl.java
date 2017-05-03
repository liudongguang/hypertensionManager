package com.kangkang.impl.service;

import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.AppPatientService;
import com.kangkang.api.vo.GetHomePhotoAddressRs;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.MyAsingleRecordRs;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.SysLunboimgsMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.util.RequestFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/28.
 */
@Service
public class AppPatientServiceImpl implements AppPatientService {

    @Autowired
    private SysLunboimgsMapper lunboImgeDao;

    @Autowired
    private AcceptkkdataMapper kkDataDao;
    @Autowired
    private TUsersMapper userDao;
    @Override
    public List<GetHomePhotoAddressRs> getHomePhotoAddress() {
        return lunboImgeDao.selectAllImges();
    }

    @Override
    public List<MyAsingleRecordRs> getAsingleRecord(Integer uid) {
        return kkDataDao.getAsingleRecord(uid);
    }

    @Override
    public TUsers getPatientUserById(Integer uid) {
        return userDao.getPatientUserById(uid);
    }

    @Override
    public TUsers modifyUserInfo(HttpServletRequest request, TUsers user)  throws Exception {
        List<MultipartFile> filelist= RequestFileUtil.getUploadFile(request);
        if(filelist!=null&&filelist.size()!=0){
            System.out.println(filelist.size());
            String savePath= RequestFileUtil.saveToComputer(filelist,request,"patientsHeadimgs");
            user.setHeadimageurl(savePath);
        }
        System.out.println(user);
        userDao.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public int updateUserPhone(GetVerificationCodeParam param) {
        return userDao.updateUserPhone(param);
    }
}
