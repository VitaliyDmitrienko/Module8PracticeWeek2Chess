// Module 8. Practice week #2. Chess. ChessPiece "Pawn".
public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super ( color );
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // check is move not into himself
        if (!((line == toLine) && (column == toColumn))) {
            if (isOnChessBoard ( chessBoard, line, column, toLine, toColumn )) {
                if (this.color.equals ( "White" )) {
                    if ((line == 1) && ((toLine - line) <= 2) && (toColumn == column) && (chessBoard.board[line + 1][column] == null) && (chessBoard.board[toLine][toColumn] == null))
                        return true;
                    else if (((toLine - line) == 1) && (toColumn == column) && (chessBoard.board[toLine][toColumn] == null))
                        return true;
                    else if (((toLine - line) == 1) && (Math.abs ( toColumn - column ) == 1) && (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor ().equals ( "Black" )))
                        return true;
                    else return false;
                } else {
                    if (((line == 6) && ((line - toLine) <= 2) && (toColumn == column) && (chessBoard.board[line - 1][column] == null) && (chessBoard.board[toLine][toColumn] == null)) ||
                            (((line - toLine) == 1) && (toColumn == column) && (chessBoard.board[toLine][toColumn] == null)) ||
                            (((line - toLine) == 1) && (Math.abs ( toColumn - column ) == 1) && (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor ().equals ( "White" ))))
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
