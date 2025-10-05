class Songs
{
    private String title;
    private int playCount;

    public Songs(String title) {
        this.title = title;
        this.playCount = 0;
    }

    public void incrementPlayCount() {
        playCount++;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }
}
public class Song {
    public static void main(String[] args) {
        Songs song = new Songs("Imagine");

        song.incrementPlayCount();
        System.out.println("Title: " + song.getTitle() + ", Play Count: " + song.getPlayCount());

        song.incrementPlayCount();
        System.out.println("Title: " + song.getTitle() + ", Play Count: " + song.getPlayCount());

        song.incrementPlayCount();
        System.out.println("Title: " + song.getTitle() + ", Play Count: " + song.getPlayCount());
}
}
