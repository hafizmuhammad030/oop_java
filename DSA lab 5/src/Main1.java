import java.util.Scanner;
class Song {
    String title;
    String artist;
    int duration;
    int likingScore;
    Song next;
    Song prev;

    Song(String title, String artist, int duration, int likingScore) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.likingScore = likingScore;
    }
}

class PlaylistManager {
    private Song head = null;
    private Song tail = null;

    public void addAtStart(String title, String artist, int duration, int score) {
        Song newSong = new Song(title, artist, duration, score);
        if (head == null) {
            head = tail = newSong;
        } else {
            newSong.next = head;
            head.prev = newSong;
            head = newSong;
        }
        System.out.println("Song added at start.");
    }

    public void addAtEnd(String title, String artist, int duration, int score) {
        Song newSong = new Song(title, artist, duration, score);
        if (head == null) {
            head = tail = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
        System.out.println("Song added at end.");
    }

    public void addByLikingScore(String title, String artist, int duration, int score) {
        Song newSong = new Song(title, artist, duration, score);
        if (head == null || head.likingScore > score) {
            addAtStart(title, artist, duration, score);
            return;
        }

        Song current = head;
        while (current.next != null && current.next.likingScore <= score) {
            current = current.next;
        }

        newSong.next = current.next;
        newSong.prev = current;

        if (current.next != null) {
            current.next.prev = newSong;
        } else {
            tail = newSong;
        }

        current.next = newSong;
        System.out.println("Song added by liking score.");
    }

    public void deleteDislikedSongs() {
        Song current = head;

        while (current != null) {
            if (current.likingScore <= 3) {
                Song toDelete = current;
                current = current.next;

                if (toDelete.prev != null) {
                    toDelete.prev.next = toDelete.next;
                } else {
                    head = toDelete.next;
                }

                if (toDelete.next != null) {
                    toDelete.next.prev = toDelete.prev;
                } else {
                    tail = toDelete.prev;
                }

                System.out.println("Removed disliked song: " + toDelete.title);
            } else {
                current = current.next;
            }
        }
    }

    public void traverseForward() {
        Song current = head;
        System.out.println("Playlist (Forward):");
        while (current != null) {
            printSong(current);
            current = current.next;
        }
    }

    public void traverseBackward() {
        Song current = tail;
        System.out.println("Playlist (Backward):");
        while (current != null) {
            printSong(current);
            current = current.prev;
        }
    }

    public void sortByDuration() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Song current = head;
            while (current.next != null) {
                if (current.duration > current.next.duration) {
                    swapSongData(current, current.next);
                    swapped = true;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);

        System.out.println("Playlist sorted by duration.");
    }

    public void sortByLikingScore() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Song current = head;
            while (current.next != null) {
                if (current.likingScore > current.next.likingScore) {
                    swapSongData(current, current.next);
                    swapped = true;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);

        System.out.println("Playlist sorted by liking score.");
    }

    public void searchSong(String title) {
        Song current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Found song:");
                printSong(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Song not found.");
    }

    private void swapSongData(Song a, Song b) {
        String tempTitle = a.title;
        String tempArtist = a.artist;
        int tempDuration = a.duration;
        int tempScore = a.likingScore;

        a.title = b.title;
        a.artist = b.artist;
        a.duration = b.duration;
        a.likingScore = b.likingScore;

        b.title = tempTitle;
        b.artist = tempArtist;
        b.duration = tempDuration;
        b.likingScore = tempScore;
    }

    private void printSong(Song song) {
        System.out.println("Title: " + song.title + ", Artist: " + song.artist + ", Duration: " + song.duration + "s, Score: " + song.likingScore);
    }
}


public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistManager playlist = new PlaylistManager();

        while (true) {
            System.out.println("\n--- Playlist Menu ---");
            System.out.println("1. Add Song at Start");
            System.out.println("2. Add Song at End");
            System.out.println("3. Add Song by Liking Score");
            System.out.println("4. Delete Disliked Songs (score <= 3)");
            System.out.println("5. Traverse Forward");
            System.out.println("6. Traverse Backward");
            System.out.println("7. Sort by Duration");
            System.out.println("8. Sort by Liking Score");
            System.out.println("9. Search Song by Title");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            String title, artist;
            int duration, score;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    artist = scanner.nextLine();
                    System.out.print("Enter duration (seconds): ");
                    duration = scanner.nextInt();
                    System.out.print("Enter liking score (1-10): ");
                    score = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) playlist.addAtStart(title, artist, duration, score);
                    else if (choice == 2) playlist.addAtEnd(title, artist, duration, score);
                    else playlist.addByLikingScore(title, artist, duration, score);
                    break;

                case 4:
                    playlist.deleteDislikedSongs();
                    break;

                case 5:
                    playlist.traverseForward();
                    break;

                case 6:
                    playlist.traverseBackward();
                    break;

                case 7:
                    playlist.sortByDuration();
                    break;

                case 8:
                    playlist.sortByLikingScore();
                    break;

                case 9:
                    System.out.print("Enter song title to search: ");
                    title = scanner.nextLine();
                    playlist.searchSong(title);
                    break;

                case 10:
                    System.out.println("Exiting playlist.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

