package composite;

import java.util.ArrayList;

public class SongGroup extends SongComponent {

    // Contains any Songs or SongGroups that are added
    // to this ArrayList
    ArrayList<SongComponent> songComponents = new ArrayList<>();

    private final String groupName;
    private final String groupDescription;

    public SongGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    @Override
    public void add(SongComponent newSongComponent) {
        songComponents.add(newSongComponent);
    }

    @Override
    public void remove(SongComponent newSongComponent) {
        songComponents.remove(newSongComponent);
    }

    @Override
    public SongComponent getComponent(int componentIndex) {
        return songComponents.get(componentIndex);
    }

    public void displaySongInfo() {
        System.out.println(getGroupName() + " " +
            getGroupDescription() + "\n");

        // Cycles through and prints any Songs or SongGroups added
        // to this SongGroups ArrayList songComponents
        for (SongComponent songInfo : songComponents)
            songInfo.displaySongInfo();
    }
}