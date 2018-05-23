package com.hywl.cck.user.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private String userInfoId;//用户信息ID

    private String sex;//性别

    private String mobileNumber;//手机号码

    private String nickname;//昵称

    private String nicknameInitials;//昵称首字母

    private String headImage;//头像

    private String personalitySign;//个性签名

    private String accountId;//账号ID

    private String birthdayYear;//生日（年）

    private String birthdayMonth;//生日（月）

    private String birthdayDay;//生日（日）

    private Boolean isEnable;//是否启用

    private String payPassword;//支付密码

    private String idCardFrontImg;//身份证正面

    private String idCardContraryImg;//身份证反面

    private Boolean isApprove;//是否认证

    private Double totalAmount;//总金额

    private Double totalGlod;//总金币

    private Boolean isEnter;//是否入驻

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    private String createBy;//创建者

    private String ringLetterName;//环信账号

    private String ringLetterPwd;//环信密码

    public String getRingLetterName() {
        return ringLetterName;
    }

    public void setRingLetterName(String ringLetterName) {
        this.ringLetterName = ringLetterName;
    }

    public String getRingLetterPwd() {
        return ringLetterPwd;
    }

    public void setRingLetterPwd(String ringLetterPwd) {
        this.ringLetterPwd = ringLetterPwd;
    }

    private static final long serialVersionUID = 1L;

    public UserInfo() {
        super();
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getNicknameInitials() {
        return nicknameInitials;
    }

    public void setNicknameInitials(String nicknameInitials) {
        this.nicknameInitials = nicknameInitials == null ? null : nicknameInitials.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    public String getPersonalitySign() {
        return personalitySign;
    }

    public void setPersonalitySign(String personalitySign) {
        this.personalitySign = personalitySign == null ? null : personalitySign.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(String birthdayYear) {
        this.birthdayYear = birthdayYear == null ? null : birthdayYear.trim();
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth == null ? null : birthdayMonth.trim();
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay == null ? null : birthdayDay.trim();
    }


    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getIdCardFrontImg() {
        return idCardFrontImg;
    }

    public void setIdCardFrontImg(String idCardFrontImg) {
        this.idCardFrontImg = idCardFrontImg == null ? null : idCardFrontImg.trim();
    }

    public String getIdCardContraryImg() {
        return idCardContraryImg;
    }

    public void setIdCardContraryImg(String idCardContraryImg) {
        this.idCardContraryImg = idCardContraryImg == null ? null : idCardContraryImg.trim();
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalGlod() {
        return totalGlod;
    }

    public void setTotalGlod(Double totalGlod) {
        this.totalGlod = totalGlod;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getApprove() {
        return isApprove;
    }

    public void setApprove(Boolean approve) {
        isApprove = approve;
    }

    public Boolean getEnter() {
        return isEnter;
    }

    public void setEnter(Boolean enter) {
        isEnter = enter;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}