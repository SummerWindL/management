package com.hywl.cck.direct.entity;

import java.util.Date;

/***
 * 金币兌换ID
 * @author xiao
 *
 */
public class DirGoldRmb {
    private String giftGoldId;//兌换表ID

    private Double giftGold;//金币

    private Double giftRmb;//人民币

    private Integer gradeVip;//VIP等级

    private String integral;//积分

    private String allIntegral;//总积分

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    private String createBy;//创建者

    public String getGiftGoldId() {
        return giftGoldId;
    }

    public void setGiftGoldId(String giftGoldId) {
        this.giftGoldId = giftGoldId == null ? null : giftGoldId.trim();
    }

    public Double getGiftGold() {
        return giftGold;
    }

    public void setGiftGold(Double giftGold) {
        this.giftGold = giftGold;
    }

    public Double getGiftRmb() {
        return giftRmb;
    }

    public void setGiftRmb(Double giftRmb) {
        this.giftRmb = giftRmb;
    }

    public Integer getGradeVip() {
        return gradeVip;
    }

    public void setGradeVip(Integer gradeVip) {
        this.gradeVip = gradeVip;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral == null ? null : integral.trim();
    }

    public String getAllIntegral() {
        return allIntegral;
    }

    public void setAllIntegral(String allIntegral) {
        this.allIntegral = allIntegral == null ? null : allIntegral.trim();
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