package com.hywl.cck.direct.entity;

import java.util.Date;

/***
 * 直播礼物信息表
 * @author xiao
 *
 */
public class DirGiftInfo {
    private String giftInfoId;//直播礼物信息ID

    private String giftImage;//礼物图片

    private Double giftGold;//礼物金币

    private Double giftRmb;//礼物对应的人民币

    private String giftState;//状态

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    private String createBy;//创建者

    public String getGiftInfoId() {
        return giftInfoId;
    }

    public void setGiftInfoId(String giftInfoId) {
        this.giftInfoId = giftInfoId == null ? null : giftInfoId.trim();
    }

    public String getGiftImage() {
        return giftImage;
    }

    public void setGiftImage(String giftImage) {
        this.giftImage = giftImage == null ? null : giftImage.trim();
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

    public String getGiftState() {
        return giftState;
    }

    public void setGiftState(String giftState) {
        this.giftState = giftState == null ? null : giftState.trim();
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