// Module 8. Practice week #2. Chess. ChessPiece.
public class King extends ChessPiece {
    boolean check;

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!((line == toLine) && (column == toColumn))) {
            if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && chessBoard.checkPos(line) && chessBoard.checkPos(toLine)
                    && (chessBoard.board[line][column] != null)) {
                if (((Math.abs(toLine - line) <= 1) && (Math.abs(toColumn - column) <= 1)) &&
                        (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())))
                    return true;

            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        return true;
    }

}
