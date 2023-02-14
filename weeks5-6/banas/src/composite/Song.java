package composite;

public class Song extends SongComponent {

    private final String songName;
    private final String bandName;
    private final int releaseYear;

    public Song(String songName, String bandName, int releaseYear) {
        this.songName = songName;
        this.bandName = bandName;
        this.releaseYear = releaseYear;
    }

    public String getSongName() {
        return songName;
    }

    public String getBandName() {
        return bandName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void displaySongInfo() {
        System.out.println(getSongName() + " was recorded by " +
            getBandName() + " in " + getReleaseYear());
    }
}