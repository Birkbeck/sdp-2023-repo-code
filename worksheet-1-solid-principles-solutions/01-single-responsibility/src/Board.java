import java.util.ArrayList;
import java.util.List;

public class Board {
    List<String> spots;
    int size;
    BoardPresenter presenter;

    @Deprecated
    public Board() {
        this(3, new TextModeBoardPresenter());
    }

    public Board(int size, BoardPresenter presenter) {
        this.presenter = presenter;
        this.spots = new ArrayList<>();
        this.size = size;
        for (int i = 0; i < this.size * this.size; i++) {
            this.spots.add(String.valueOf(i));
        }
    }

    @Deprecated
    public List<String> firstRow() {
        return row(0);
    }

    @Deprecated
    public List<String> secondRow() {
        return row(1);
    }

    @Deprecated
    public List<String> thirdRow() {
        return row(2);
    }

    public List<String> row(int r) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < size; i++)
            row.add(this.spots.get(r * size + i));
        return row;
    }

    public void display() {
        presenter.displayBoard(this);
    }
}
