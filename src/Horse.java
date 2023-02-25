// Module 8. Practice week #2. Chess. ChessPiece.
public class Horse extends ChessPiece {
    boolean check;

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!((line == toLine) && (column == toColumn))) {
            if ((toLine >= 0 && toLine <= 7) && (toColumn >= 0 && toColumn <= 7)) {
                if (((Math.abs(toLine - line) == 2) && (Math.abs(toColumn - column) == 1)) ||
                        ((Math.abs(toLine - line) == 1) && (Math.abs(toColumn - column) == 2)))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
