import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Playlist TDE = new Playlist("TDE");
    private static ArrayList<Album> albumList = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        Album CTRL = new Album("CTRL");
        Album DAMN = new Album("DAMN");

        Song CTRLSong1 = new Song("Supermodel", "3:01");
        CTRLSong1.setAlbum(CTRL);
        Song CTRLSong2 = new Song("Love Galore", "4:35");
        CTRLSong2.setAlbum(CTRL);
        Song CTRLSong3 = new Song("Normal Girl", "4:14");
        CTRLSong3.setAlbum(CTRL);
        Song CTRLSong4 = new Song("Same", "4:14");
        CTRLSong4.setAlbum(CTRL);

        CTRL.addSong(CTRLSong1);
        CTRL.addSong(CTRLSong2);
        CTRL.addSong(CTRLSong3);

        Song DAMNSong1 = new Song("DNA.", "3:06");
        DAMNSong1.setAlbum(DAMN);
        Song DAMNSong2 = new Song("LOVE.", "3:33");
        DAMNSong2.setAlbum(DAMN);
        Song DAMNSong3 = new Song("XXX", "4:14");
        DAMNSong3.setAlbum(DAMN);
        Song DAMNSong4 = new Song("Same", "4:14");
        DAMNSong4.setAlbum(DAMN);

        DAMN.addSong(DAMNSong1);
        DAMN.addSong(DAMNSong2);
        DAMN.addSong(DAMNSong3);

        albumList.add(CTRL);
        albumList.add(DAMN);

        TDE.addSong(CTRL, "Supermodel");
        TDE.addSong(DAMN, "DNA.");

        runPlaylist();
    }

    public static void showOptions() {
        System.out.println("0 - Quit \n" +
                "1 - Play Next Song\n" +
                "2 - Play Previous Song\n" +
                "3 - Replay Current Song\n" +
                "4 - Show List of Songs\n" +
                "5 - Add a song\n" +
                "6 - Remove a song\n" +
                "7 - Show Options");
    }

    public static void addSong(String albumName, String songTitle) {
        boolean checkSongExistence = false;

        for (int i = 0; i < albumList.size(); i++) {
            Album currAlbum = albumList.get(i);
            if (currAlbum.getAlbumName().equals(albumName)) {
                if (currAlbum.getSong(songTitle) != null) {
                    TDE.addSong(currAlbum, songTitle);
                    System.out.println("Song added to playlist!");
                } else {
                    System.out.println("Song already in playlist!");
                }
                checkSongExistence = true;
            }
        }

        if (!checkSongExistence) {
            System.out.println("The requested song to be added does not exist in any current albums.");
        }
    }

    public static boolean removeSong(String albumName, String songTitle) {

//        for (int i = 0; i < albumList.size(); i++) {
//            Album currAlbum = albumList.get(i);
//            if (currAlbum.getAlbumName().equals(albumName)) {
//                if (currAlbum.getSong(songTitle) != null) {
//                    return true;
//                }
//            }
//        }
        LinkedList<Song> songList = TDE.getSongList();
        ListIterator<Song> removeIter = songList.listIterator();

        while(removeIter.hasNext()) {
            Song currSong = removeIter.next();
            if(currSong.getAlbum().getAlbumName().equals(albumName) && currSong.getSongTitle().equals(songTitle)) {
                removeIter.remove();
                System.out.println("Song removed!");
                return true;
            }
        }

        System.out.println("The requested song to be removed does not exist in any current albums.");
        return false;
    }

    public static void playSong(Song song) {
        System.out.print("Playing " + song.getSongTitle());
        Album album = song.getAlbum();
        if (album != null) {
            System.out.print(" - " + album.getAlbumName() + "\n");
        }
    }

    public static void runPlaylist() {
        boolean run = true;
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Playlist Manager");
        showOptions();
        ListIterator<Song> iter = TDE.getSongList().listIterator();
        boolean forward = true;

        while(run) {
            int nextCommand = in.nextInt();

            switch(nextCommand) {
                case 0:
                    run = false;
                    break;
                case 1:
                    if(iter.hasNext() && forward) {
                        playSong(iter.next());
                    } else if (iter.hasNext() && !forward) {
                        forward = true;
                        iter.next();
                        playSong(iter.next());
                    } else {
                        if(forward) {
                            playSong(iter.previous());
                            iter.previous();
                            forward = false;
                        } else {
                            iter.next();
                            playSong(iter.next());
                            forward = true;
                        }
                    }
                    break;
                case 2:
                    if(iter.hasPrevious() && forward == false) {
                        playSong(iter.previous());
                    } else if(iter.hasPrevious() && forward == true) {
                        forward = false;
                        iter.previous();
                        playSong(iter.previous());
                    } else {
                        if(forward) {
                            playSong(iter.next());
                            forward = false;
                        }
                        else if(!forward) {
                            playSong(iter.next());
                            iter.previous();
                        }
                    }
                    break;
                case 3:
                    if(forward == true) {
                        playSong(iter.previous());
                        forward = false;
                    } else {
                        playSong(iter.next());
                        forward = true;
                    }
                    break;
                case 4:
                    TDE.listSongs();
                    break;
                case 5:
                    System.out.println("Enter title of song you want to add to playlist: ");
                    String songTitle = in.next();
                    System.out.println("Enter album of song: ");
                    String albumTitle = in.next();
                    addSong(albumTitle, songTitle);
                    break;
                case 6:
                    System.out.println("Enter title of song you want to remove from playlist: ");
                    String songToRemove = in.next();
                    System.out.println("Enter album of song you want to remove from playlist: ");
                    String albumOfSongToRemove = in.next();
                    removeSong(albumOfSongToRemove, songToRemove);
                    break;
                case 7:
                    showOptions();
                default:
                    System.out.println("Not a command, exiting program!");
                    run = false;
                    break;
            }
        }

    }

}
