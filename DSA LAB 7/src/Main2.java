import java.util.Scanner;

class Song {
    String title;
    String artist;
    String duration;

    public Song(String title, String artist, String duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String toString() {
        return "\"" + title + "\" by " + artist + " (" + duration + ")";
    }
}

class CircularQueue {
    private Song[] playlist;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        playlist = new Song[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }


    public void enqueue(Song song) {
        if (isFull()) {
            System.out.println("Playlist is full. Cannot add new song.");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        playlist[rear] = song;
        size++;
        System.out.println("Song added: " + song);
    }


    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Playlist is empty. No song to remove.");
            return;
        }
        System.out.println("Removed song: " + playlist[front]);
        if (size == 1) { // Only one song
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
    }


    public void skipNext() {
        if (isEmpty()) {
            System.out.println("Playlist is empty. No song to skip.");
            return;
        }
        front = (front + 1) % capacity;
        System.out.println("Skipped to next song: " + playlist[front]);
    }


    public void showCurrentSong() {
        if (isEmpty()) {
            System.out.println("No current song. Playlist is empty.");
        } else {
            System.out.println("Currently playing: " + playlist[front]);
        }
    }


    public void showUpcomingSongs() {
        if (isEmpty()) {
            System.out.println("No upcoming songs. Playlist is empty.");
            return;
        }
        System.out.println("Upcoming songs:");
        int i = (front + 1) % capacity;
        int count = 0;
        while (count < size - 1) {
            System.out.println("- " + playlist[i]);
            i = (i + 1) % capacity;
            count++;
        }
    }


    public void displayPlaylist() {
        if (isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Full Playlist:");
        int i = front;
        int count = 0;
        while (count < size) {
            System.out.println((count + 1) + ". " + playlist[i]);
            i = (i + 1) % capacity;
            count++;
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularQueue playlist = new CircularQueue(5);

        while (true) {
            System.out.println("\nMusic Playlist Manager");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove currently playing song");
            System.out.println("3. Skip to next song");
            System.out.println("4. Show current song");
            System.out.println("5. Show upcoming songs");
            System.out.println("6. Display full playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter song title: ");
                String title = scanner.nextLine();
                System.out.print("Enter artist name: ");
                String artist = scanner.nextLine();
                System.out.print("Enter song duration (e.g., 3:45): ");
                String duration = scanner.nextLine();

                Song newSong = new Song(title, artist, duration);
                playlist.enqueue(newSong);

            } else if (choice == 2) {
                playlist.dequeue();

            } else if (choice == 3) {
                playlist.skipNext();

            } else if (choice == 4) {
                playlist.showCurrentSong();

            } else if (choice == 5) {
                playlist.showUpcomingSongs();

            } else if (choice == 6) {
                playlist.displayPlaylist();

            } else if (choice == 7) {
                System.out.println("Exiting Music Playlist Manager. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
