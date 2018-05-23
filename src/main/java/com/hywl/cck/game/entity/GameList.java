package com.hywl.cck.game.entity;

import java.io.Serializable;
import java.util.Date;

public class GameList implements Serializable {
    private String gameId;

    private Integer gameType;

    private String gameName;

    private String gameLogo;

    private String gameDescription;

    private String gameLink;

    private String gameImages;

    private String gamePlay;

    private String gamePackage;

    private Date createTime;

    private Date modifyTime;

    private String createBy;


    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameLogo() {
        return gameLogo;
    }

    public void setGameLogo(String gameLogo) {
        this.gameLogo = gameLogo;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameLink() {
        return gameLink;
    }

    public void setGameLink(String gameLink) {
        this.gameLink = gameLink;
    }

    public String getGameImages() {
        return gameImages;
    }

    public void setGameImages(String gameImages) {
        this.gameImages = gameImages;
    }

    public String getGamePlay() {
        return gamePlay;
    }

    public void setGamePlay(String gamePlay) {
        this.gamePlay = gamePlay;
    }

    public String getGamePackage() {
        return gamePackage;
    }

    public void setGamePackage(String gamePackage) {
        this.gamePackage = gamePackage;
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
        this.createBy = createBy;
    }
}