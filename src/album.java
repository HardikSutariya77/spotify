import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    
    public album(String name,String artist){
        this.name=name;
        this.artist=artist;
        this.songs=new ArrayList<>();
    }

    public boolean findSong(String title){
        for(Song checksong:this.songs)
        {
            if(checksong.getTitle().equals(title))
            {
                System.out.print("SongSong found!!!");
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title,double duration)
    {
        if(findSong(title)==true)
        {
            System.out.println("Song is already present");
            return false;
        }
        Song newsong=new Song(title,duration);
        this.songs.add(newsong);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
        for(Song chekedSong:this.songs)
        {
            if(chekedSong.getTitle().equals(title)) {
                playList.add(chekedSong);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber,LinkedList<Song> playList){
        int index=trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1){
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }
}
