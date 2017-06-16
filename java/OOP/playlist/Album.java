import java.util.ArrayList;

/**
 * Created by canoc on 6/15/17.
 */
public class Album {

    private ArrayList<Song> songList = new ArrayList<>();
    private String albumName = "";

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setAlbumName(String newAlbumName) {
        this.albumName = newAlbumName;
    }

    public ArrayList<Song> getSongList() {
        return this.songList;
    }

    public boolean addSong(Song song) {
        String newSongTitle = song.getSongTitle();
        for (int i = 0; i < this.songList.size(); i++) {
            if (this.songList.get(i).getSongTitle().equals(newSongTitle)) {
                return false;
            }
        }
        this.songList.add(song);
        return true;
    }

    public Song getSong(String songTitle) {
        for (int i = 0; i < songList.size(); i++) {
            Song currSong = songList.get(i);
            if (currSong.getSongTitle().equals(songTitle)) {
                return currSong;
            }
        }
        return null;
    }
}
