// Module 8. Practice week #2. Chess. ChessPiece.
public class Queen extends ChessPiece {
    boolean check;

    public Queen(String color) {
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
                if (((Math.abs(toLine - line) == Math.abs(toColumn - column))) && (chessBoard.board[toLine][toColumn] == null
                        || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())))
                    return true;
                else if ((((line == toLine) && (Math.abs(toColumn - column) <= 7)) || ((column == toColumn) && (Math.abs(toLine - line) <= 7)))
                        && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

}