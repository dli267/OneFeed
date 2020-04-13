package com.example.onefeed;

public class Post {
    private String account;
    private String imageURL;
    private String desc;
    private int numLikes;
    private int numComments;

    public Post(String account, String URL, String desc, int numLikes, int numComments) {
        this.account = account;
        this.imageURL = URL;
        this.desc = desc;
        this.numLikes = numLikes;
        this.numComments = numComments;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String URL) {
        this.imageURL = URL;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNumLikes() {
        return numLikes;
    }
    public void getNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumComments() {
        return numComments;
    }
    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }
}
