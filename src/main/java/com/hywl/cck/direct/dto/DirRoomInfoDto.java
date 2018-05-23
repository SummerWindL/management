package com.hywl.cck.direct.dto;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 16:40 2017/11/9
 */
public class DirRoomInfoDto {

    private String  roomInfoId;
    private Double dirRoomLng;
    private Double dirRoomLat;
    private Integer totalPeople;
    private Double distance;

    public String getRoomInfoId() {
        return roomInfoId;
    }

    public void setRoomInfoId(String roomInfoId) {
        this.roomInfoId = roomInfoId;
    }

    public Double getDirRoomLng() {
        return dirRoomLng;
    }

    public void setDirRoomLng(Double dirRoomLng) {
        this.dirRoomLng = dirRoomLng;
    }

    public Double getDirRoomLat() {
        return dirRoomLat;
    }

    public void setDirRoomLat(Double dirRoomLat) {
        this.dirRoomLat = dirRoomLat;
    }

    public Integer getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(Integer totalPeople) {
        this.totalPeople = totalPeople;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}