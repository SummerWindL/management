package com.hywl.cck.sys.entity;

import java.io.Serializable;
import java.util.Date;

/***
 * 系统-轮播信息表
 * @author xiao
 *
 */
public class SysCarouselInfo implements Serializable {
    private String sysCarouselId;//轮播图片ID

    private String sysHomeInfoId;//主页信息ID

    private String imageAddress;//地址

    private String linkId;//资源

    private Date createTime;//创建时间

    private Date modifyTime;//修改时间

    private String createBy;//创建者
    
    //------------------------------------------
    
    private String homeInfoType;//主页轮播表 的信息类型
    

    public String getHomeInfoType() {
		return homeInfoType;
	}

	public void setHomeInfoType(String homeInfoType) {
		this.homeInfoType = homeInfoType;
	}

	private static final long serialVersionUID = 1L;

    public SysCarouselInfo() {
        super();
    }

    public String getSysCarouselId() {
        return sysCarouselId;
    }

    public void setSysCarouselId(String sysCarouselId) {
        this.sysCarouselId = sysCarouselId == null ? null : sysCarouselId.trim();
    }

    public String getSysHomeInfoId() {
        return sysHomeInfoId;
    }

    public void setSysHomeInfoId(String sysHomeInfoId) {
        this.sysHomeInfoId = sysHomeInfoId == null ? null : sysHomeInfoId.trim();
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress == null ? null : imageAddress.trim();
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId == null ? null : linkId.trim();
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