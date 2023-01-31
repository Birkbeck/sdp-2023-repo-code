public class TextModeBoardPresenter implements BoardPresenter {
    @Override
    public void displayBoard(Board board) {
        String formattedBoard = "";
        for (int i = 0; i < board.size * board.size; i++) {
            String borderOrNewline = "";
            if ((i + 1) % board.size == 0) { // end of row
                if ((i + 1) % (board.size * board.size) != 0) // except last
                    borderOrNewline += "\n";
            } else {
                borderOrNewline += " | ";
            }
            formattedBoard += board.spots.get(i);
            formattedBoard += borderOrNewline;
        }
        System.out.print(formattedBoard);
    }

}
