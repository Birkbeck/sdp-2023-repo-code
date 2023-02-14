package composite;

public class DiscJockey {

    private final SongComponent songList;

    // newSongList contains every Song, SongGroup,
    // and any Songs saved in SongGroups
    public DiscJockey(SongComponent songList) {
        this.songList = songList;
    }

    // Calls the displaySongInfo() on every Song
    // or SongGroup stored in songList

    public void getSongList() {
        songList.displaySongInfo();
    }
}