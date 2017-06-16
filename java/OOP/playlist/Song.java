public class Song {

    private String songTitle = "";
    private String duration = "";
    private Album album = null;

    public Song(String songTitle, String duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    public String getSongTitle() {
        return this.songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
