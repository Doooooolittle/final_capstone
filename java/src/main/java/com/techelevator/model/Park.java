package com.techelevator.model;

public class Park {
    private int parkId;
    private String parkName;
    private String parkBannerPhoto;
    private String shortDesc;
    private String longDesc;
    private String address;
    private String longitude;
    private String latitude;
    private String siteUrl;
    private String mapLocation;
    private String region;

    public Park() {
    }

    public Park(
            int parkId,
            String parkName,
            String parkBannerPhoto,
            String shortDesc,
            String longDesc,
            String address,
            String longitude,
            String latitude,
            String siteUrl,
            String mapLocation,
            String region
    ){
        this.parkId = parkId;
        this.parkName = parkName;
        this.parkBannerPhoto = parkBannerPhoto;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.siteUrl = siteUrl;
        this.mapLocation = mapLocation;
        this.region = region;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getParkBannerPhoto() {
        return parkBannerPhoto;
    }

    public void setParkBannerPhoto(String parkBannerPhoto) {
        this.parkBannerPhoto = parkBannerPhoto;
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
