import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by canoc on 6/15/17.
 */
public class Playlist {
    private String name = "";
    private LinkedList<Song> songList = new LinkedList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public LinkedList<Song> getSongList() {
        return this.songList;
    }

    public boolean containsSong(Album album, String songTitle) {
        ListIterator<Song> iter = this.songList.listIterator();

        while (iter.hasNext()) {
            Song nextSong = iter.next();

            if(nextSong.getAlbum() == album && nextSong.getSongTitle().equals(songTitle)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSong(Album album, String songTitle) {
        Song song = album.getSong(songTitle);
        if (song != null && !this.containsSong(album, songTitle)) {
            System.out.println("Adding " + songTitle + " to playlist...");
            this.songList.add(song);
            return true;
        }
        return false;
    }

    public boolean removeSong(Album album, String songTitle) {
        ListIterator<Song> iter = this.songList.listIterator();

        while(iter.hasNext()) {
            Song currSong = iter.next();
            if(currSong.getAlbum() == album && currSong.getSongTitle() == songTitle) {
                iter.remove();
                return true;
            }
        }

        return false;
    }

    public void listSongs() {
        ListIterator<Song> iter = this.songList.listIterator();

        int i = 0;
        System.out.println(this.getName() + " Playlist:");
        while(iter.hasNext()) {
            Song song = iter.next();
            System.out.print("" + ++i + ": "+ song.getSongTitle());
            if (song.getAlbum() != null) {
                System.out.print(" - " + song.getAlbum().getAlbumName());
            }
            System.out.println();
        }
    }

}
