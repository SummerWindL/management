package com.hywl.cck.direct.dto;

/**
 * @Author: yzw
 * @Description: 直播间主页显示的信息
 * @Date: Create in 14:34 2017/11/10
 */
public class DirIndexDto {

    // 直播间id
    private String roomInfoId;

    // 主播昵称
    private String anchorNickname;

    // 主播头像
    private String anchorHeadImages;

    // 主播收到的总金币
    private Double totalGlod;
    
    //直播间热度
    private Integer totalPeople;
    
    

    public Integer getTotalPeople() {
		return totalPeople;
	}

	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
	}

	public String getRoomInfoId() {
        return roomInfoId;
    }

    public void setRoomInfoId(String roomInfoId) {
        this.roomInfoId = roomInfoId;
    }

    public String getAnchorNickname() {
        return anchorNickname;
    }

    public void setAnchorNickname(String anchorNickname) {
        this.anchorNickname = anchorNickname;
    }

    public String getAnchorHeadImages() {
        return anchorHeadImages;
    }

    public void setAnchorHeadImages(String anchorHeadImages) {
        this.anchorHeadImages = anchorHeadImages;
    }

    public Double getTotalGlod() {
        return totalGlod;
    }

    public void setTotalGlod(Double totalGlod) {
        this.totalGlod = totalGlod;
    }
}