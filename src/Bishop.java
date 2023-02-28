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
//      from Central to Upper-Right
        if ((toColumn > column) && (toLine > line)) {
            int i = (line + 1);
            int j = (column + 1);
            int countFreeColumn = 0;
            for (; i < toLine; i++, j++) {
                if (chessBoard.board[i][j] != null) countFreeColumn++;
            }
            if (countFreeColumn == 0) return true;
        }

//      from Central to Right-Down
        else if ((toColumn > column) && (line > toLine)) {
            int i = (line - 1);
            int j = (column + 1);
            int countFreeColumn = 0;
            for (; i > toLine; i--, j++) {
                if (chessBoard.board[i][j] != null) countFreeColumn++;
            }
            if (countFreeColumn == 0) return true;
        }

//      from Central to Upper-Left
        else if ((column > toColumn) && (toLine > line)) {
            int i = (line + 1);
            int j = (column - 1);
            int countFreeColumn = 0;
            for (; i < toLine; i++, j--) {
                if (chessBoard.board[i][j] != null) countFreeColumn++;
            }
            if (countFreeColumn == 0) return true;
        }

//      from Central to Left-Down
        else if ((column > toColumn) && (line > toLine)) {
            int i = (line - 1);
            int j = (column - 1);
            int countFreeColumn = 0;
            for (; i > toLine; i--, j--) {
                if (chessBoard.board[i][j] != null) countFreeColumn++;
            }
            if (countFreeColumn == 0) return true;
        }
        return false;
    }

}