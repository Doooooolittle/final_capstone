package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class Castle {
    private int castleId;
    private String castleName;
    private String castleBannerPhoto;
    private String shortDesc;
    private String longDesc;
    private String address;
    private String longitude;
    private String latitude;
    private String siteUrl;
    private String mapLocation;
    private String region;

    public Castle() {
    }

    public Castle(
            int castleId,
            String castleName,
            String castleBannerPhoto,
            String shortDesc,
            String longDesc,
            String address,
            String longitude,
            String latitude,
            String siteUrl,
            String mapLocation,
            String region
    ) {
        this.castleId = castleId;
        this.castleName = castleName;
        this.castleBannerPhoto = castleBannerPhoto;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.siteUrl = siteUrl;
        this.mapLocation = mapLocation;
        this.region = region;
    }

    public int getCastleId() {
        return castleId;
    }

    public void setCastleId(int castleId) {
        this.castleId = castleId;
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

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}