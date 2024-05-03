package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Visit {

    private int castleId;
    private Integer visitId;
    private String username;
    private LocalDate visitDate;
    private String castleName;
    private String castleBannerPhoto;
    private String shortDesc;
    private String region;
    public Visit(){
    };

    public Visit(int castleId, Integer visitId, String username, LocalDate visitDate, String castleName, String castleBannerPhoto, String shortDesc, String region) {
        this.castleId = castleId;
        this.visitId = visitId;
        this.username = username;
        this.visitDate = visitDate;
        this.castleName = castleName;
        this.castleBannerPhoto = castleBannerPhoto;
        this.shortDesc = shortDesc;
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCastleId() {
        return castleId;
    }

    public void setCastleId(int castleId) {
        this.castleId = castleId;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getCastleName() {
        return castleName;
    }

    public void setCastleName(String castleName) {
        this.castleName = castleName;
    }

    public String getCastleBannerPhoto() {
        return castleBannerPhoto;
    }

    public void setCastleBannerPhoto(String castleBannerPhoto) {
        this.castleBannerPhoto = castleBannerPhoto;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
