import java.util.LinkedList;

class Song{
    String title;
    String artist;
    int duration;


    public Song(int duration,String title,String artist)
    {
        this.duration = duration;
        this.artist = artist;
        this.title = title;


    }

}
class Playlist{
    LinkedList<Song> playlist = new LinkedList<>();

    public void addSong(Song song){
        playlist.add(song);
    }

    public void removeSong (Song song){
        playlist.remove(song);
    }


}