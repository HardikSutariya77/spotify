import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        album album1=new album("album1","AlanWalker");
        album1.addSong("Alone",5.2);
        album1.addSong("Faded",4.5);
        //album1.addSong("Dark side",3.5);
        LinkedList<Song> myPlayList=new LinkedList<>();

        album1.addToPlayList("Alone",myPlayList);
        myPlayList.get(0).setTitle("arijit");

        play(myPlayList);
    }

    public static void ShowMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show The List Of All Songs In The Playlist");
        System.out.println("3. Play Next Song");
        System.out.println("4. Play Previous Song");
        System.out.println("5. Repeat The Song");
        System.out.println("6. Delete The Song");

    }

    public static void printList(LinkedList<Song> playList)
    {
        ListIterator<Song> itr=playList.listIterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        return;
    }

    public static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playList.listIterator();
        if(!itr.hasNext())
        {
            System.out.println("play list is empty"); return;
        }
        System.out.println("you are now listening"+itr.next());

        ShowMenu();

        boolean forward=true;
        while(true)
        {
            int option=sc.nextInt();
            switch (option)
            {
                case 0:
                    System.out.println("Thank you for Listening"); return;
                case 1:
                    ShowMenu(); break;
                case 2:
                    printList(playList); break;
                case 3:
                    if(!forward)
                    {
                      if(itr.hasNext()) itr.next();
                    }
                    if(!itr.hasNext())
                    {
                        System.out.println("you have reached the end of playlist");
                    }
                    else
                    {
                        System.out.println("you are listening to:"+itr.next());
                    }
                    forward=true;
                    break;
                case 4:
                    if(forward)
                    {
                        if(itr.hasPrevious()) itr.hasPrevious();
                    }
                    if(!itr.hasPrevious())
                    {
                        System.out.println("you are reached to start of playlist");
                    }
                    else
                    {
                        System.out.println("you are listening to:"+itr.previous());
                    }
                    forward=false;
                    break;

            }
        }

    }
}
