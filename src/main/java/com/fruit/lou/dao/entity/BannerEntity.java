package com.fruit.lou.dao.entity;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-03-01 15:35
 */
public class BannerEntity {
    private Integer id;

    /**
     * 1-视频
     * 0-图片
     */
    private int fileType;

    private String name;

    private String note;

    private String pic;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
