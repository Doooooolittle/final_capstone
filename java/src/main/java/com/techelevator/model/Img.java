package com.techelevator.model;

public class Img {
    private int imgId;
    private int castleId;
    private String imgName;
    private String imgPath;

    public Img(){
    }
    public Img(int imgId, int castleId, String imgName, String imgPath) {
        this.imgId = imgId;
        this.castleId = castleId;
        this.imgName = imgName;
        this.imgPath = imgPath;
    }
    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getCastleId() {
        return castleId;
    }

    public void setCastleId(int castleId) {
        this.castleId = castleId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
