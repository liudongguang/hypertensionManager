package com.kangkang.api.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_users")
public class TUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    /**
     * 绑定的设备号
     */
    private String sn;

    /**
     * 绑定的设备IMEI
     */
    private String imei;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 融云id
     */
    private String rongid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 注册手机号
     */
    private String registphone;

    /**
     * 融云token
     */
    private String rytoken;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像
     */
    private String headimageurl;

    /**
     * 地址
     */
    private String address;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在省份
     */
    private String province;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取绑定的设备号
     *
     * @return sn - 绑定的设备号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置绑定的设备号
     *
     * @param sn 绑定的设备号
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取绑定的设备IMEI
     *
     * @return imei - 绑定的设备IMEI
     */
    public String getImei() {
        return imei;
    }

    /**
     * 设置绑定的设备IMEI
     *
     * @param imei 绑定的设备IMEI
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登陆密码
     *
     * @return password - 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登陆密码
     *
     * @param password 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取融云id
     *
     * @return rongid - 融云id
     */
    public String getRongid() {
        return rongid;
    }

    /**
     * 设置融云id
     *
     * @param rongid 融云id
     */
    public void setRongid(String rongid) {
        this.rongid = rongid;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取注册手机号
     *
     * @return registphone - 注册手机号
     */
    public String getRegistphone() {
        return registphone;
    }

    /**
     * 设置注册手机号
     *
     * @param registphone 注册手机号
     */
    public void setRegistphone(String registphone) {
        this.registphone = registphone;
    }

    /**
     * 获取融云token
     *
     * @return rytoken - 融云token
     */
    public String getRytoken() {
        return rytoken;
    }

    /**
     * 设置融云token
     *
     * @param rytoken 融云token
     */
    public void setRytoken(String rytoken) {
        this.rytoken = rytoken;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取头像
     *
     * @return headimageurl - 头像
     */
    public String getHeadimageurl() {
        return headimageurl;
    }

    /**
     * 设置头像
     *
     * @param headimageurl 头像
     */
    public void setHeadimageurl(String headimageurl) {
        this.headimageurl = headimageurl;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取微信昵称
     *
     * @return nickname - 微信昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置微信昵称
     *
     * @param nickname 微信昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取微信openid
     *
     * @return openid - 微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信openid
     *
     * @param openid 微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所在省份
     *
     * @return province - 所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省份
     *
     * @param province 所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }
}