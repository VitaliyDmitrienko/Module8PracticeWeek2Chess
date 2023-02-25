// Module 8. Practice week #2. Chess. ChessPiece.
public class Pawn extends ChessPiece {
    boolean check;

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!((line == toLine) && (column == toColumn))) {
            if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && chessBoard.checkPos(line) && chessBoard.checkPos(toLine)
                    && (chessBoard.board[line][column] != null)) {
                if (this.color.equals("White")) {
                    if (((line == 1) && ((toLine - line) <= 2) && (toColumn == column) && (chessBoard.board[line + 1][column] == null) && (chessBoard.board[toLine][column] == null)) ||
                            (((toLine - line) == 1) && (toColumn == column)) ||
                            (((toLine - line) == 1) && (Math.abs(toColumn - column) == 1) && (chessBoard.board[toLine][toColumn].getColor().equals("Black"))))
                        return true;
                } else {
                    if (((line == 6) && ((line - toLine) <= 2) && (toColumn == column) && (chessBoard.board[line - 1][column] == null) && (chessBoard.board[toLine][column] == null)) ||
                            (((line - toLine) == 1) && (toColumn == column)) ||
                            (((line - toLine) == 1) && (Math.abs(toColumn - column) == 1) && (chessBoard.board[toLine][toColumn].getColor().equals("White"))))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}
