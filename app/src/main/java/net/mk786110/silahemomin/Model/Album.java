package net.mk786110.silahemomin.Model;

public class Album {
    private String name;
    private int numOfSongs;
    private int thumbnail;
    private String molana_image;

    public Album() {
    }

    public Album(String name, String molana_image) {
        this.name = name;
        this.molana_image=molana_image;
    }

    public String getMolana_image() {
        return molana_image;
    }

    public void setMolana_image(String molana_image) {
        this.molana_image = molana_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
