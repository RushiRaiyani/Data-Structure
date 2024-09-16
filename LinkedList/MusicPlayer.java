// Write a program to simulate music player application using suitable data 
// structure. There is no estimation about number of music files to be managed by 
// the music player. Your program should support all the basic music player 
// operations to play and manage the playlist.
package LinkedList;

import java.util.Scanner;

class MyLinkedList {
    class Node {
        String value;
        Node link;

        public Node(String value) {
            this.value = value;
            this.link = null;
        }
    }

    Node first = null;
    Node current = null;
    Node prevCurrent = null;

    public void insertAtLast(String value) {
        Node newNode = new Node(value);
        Node save = first;
        if (first == null) {
            first = newNode;
        } else {
            while (save.link != null) {
                save = save.link;
            }
            save.link = newNode;
        }
        System.out.println("Added successfully");
    }

    public void displaySong(String value) {
        Node save = first;
        current = first;
        prevCurrent = null;
        if (save == null) {
            System.out.println("Playlist is empty");
        } else {
            while (save != null && !save.value.equals(value)) {
                save = save.link;
                prevCurrent = current;// current will help when we want to access next song
                current = current.link;// prev will help when we want to access previous song
            }
            if (save == null) {
                System.out.println("Song does not exist in playlist");
            } else {
                System.out.println("Song " + save.value + " is currently playing");
            }
        }
    }

    public void displaySongNext() {
        if (current == null) {
            System.out.println("No song is currently playing");
        } else if (current.link == null) {
            System.out.println("No next song available");
        } else {
            System.out.println("Now Playing song: " + current.link.value);
            current = current.link;
        }
    }

    public void displaySongPrev() {
        if (current == first) {
            System.out.println("No previous song available");
        } else if (current == null) {
            System.out.println("No song is currently playing");
        } else {
            System.out.println("Now Playing song: " + prevCurrent.value);
            current = prevCurrent;
            prevCurrent = first;// after giving prev song,we reinitialize pre
            // now it prev and current is same,in case when current was 2nd node,we have
            // maked prevVurrent null, as no song is now present before it
            if (prevCurrent == current) {
                prevCurrent = null;
                return;
            }
            // prev is first, so we are moving to node which is before current and thuss
            // reassinging node pointer of prev
            while (prevCurrent.link != current && prevCurrent.link != current) {
                prevCurrent = prevCurrent.link;
            }
        }
    }

    public void display() {
        Node save = first;
        if (save == null) {
            System.out.println("PlayList is empty");
        } else {
            while (save != null) {
                System.out.print(save.value + " ");
                save = save.link;
            }
            System.out.println("");
        }
    }

    public void deleteSpecificNode(String value) {
        Node save = first, prev = null;
        if (save.value.equals(value)) {
            first = first.link;
            return;
        }
        while (save != null && !save.value.equals(value)) {
            prev = save;
            save = save.link;
        }
        if (save == null) {
            System.out.println("Song you want to delete does not found");
            return;
        }
        prev.link = save.link;
    }

}

public class MusicPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        boolean isbreak = true;
        int temp = 0;
        while (isbreak) {
            System.out.println("Enter 1 to create a PLaylist");
            System.out.println("Enter 2 to Add Song");
            System.out.println("Enter 3 to play a song");
            System.out.println("Enter 4 to play previous song");
            System.out.println("Enter 5 to to play next song");
            System.out.println("Enter 6 to display Playlist");
            System.out.println("Enter 7 to remove any song from the playlist");
            System.out.println("Enter 8 to add song in queue:");
            System.out.println("Enter 8 to exit:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Entered Playlist!!!");
                    if (temp != 0) {
                        System.out.println("Already in playlist");
                    }
                    temp = 1;
                    break;
                case 2:
                    System.out.println("Enter the Song to be added:");
                    String value2 = sc.next();
                    list.insertAtLast(value2);
                    break;
                case 3:
                    System.out.println("Enter a song to listen:");
                    String value3 = sc.next();
                    list.displaySong(value3);
                    break;
                case 4:
                    list.displaySongPrev();
                    break;
                case 5:
                    list.displaySongNext();
                    break;
                case 6:
                    list.display();
                    break;

                case 7:
                    System.out.println("Enter a sing you want to delete");
                    String value4 = sc.next();
                    list.deleteSpecificNode(value4);
                    break;
                case 8:
                    isbreak = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        sc.close();
    }
}
