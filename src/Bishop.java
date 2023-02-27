// Module 8. Practice week #2. Chess. ChessPiece "Bishop".
public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super ( color );
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // check is move not into himself
        if (!((line == toLine) && (column == toColumn))) {
            if (isOnChessBoard ( chessBoard, line, column, toLine, toColumn )) {
                if (((Math.abs ( toLine - line ) == Math.abs ( toColumn - column )) && isFreeDiagonal ( chessBoard, line, column, toLine, toColumn ))
                        && (chessBoard.board[toLine][toColumn] == null
                        || !chessBoard.board[toLine][toColumn].getColor ().equals ( chessBoard.nowPlayerColor () )))
                    return true;

            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    public boolean isFreeDiagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toColumn > column) && (toLine > line)) {
            int i;
            int j = (toLine - 1);
            int countFreeColumn = 0;
            for (i = (toColumn - 1), j; i > line,j > column;
            i++, j++){
                if (chessBoard.board[i][j] != null) countFreeColumn++;
            }
            if (countFreeColumn == 0) return true;
        } else if ((toColumn > column) && (line > toLine)) {
        } else if ((column > toColumn) && (toLine > line)) {
        } else if ((column > toColumn) && (line > toLine)) {
        } else return false;
    }

}