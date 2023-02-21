// Module 8. Practice week #2. Chess. ChessPiece.
public class Pawn extends ChessPiece {
    String color;
    boolean check;

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

    }

    public String getSymbol() {
        return "P";
    }

}
