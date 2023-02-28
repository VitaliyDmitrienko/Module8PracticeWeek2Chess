// Module 8. Practice week #2. Chess. ChessPiece Parent Class.

public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    // check is move on chess board (inside boards) & start position no empty (!null)
    public boolean isOnChessBoard(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return (chessBoard.checkPos ( toLine ) && chessBoard.checkPos ( toColumn ) && chessBoard.checkPos ( line ) && chessBoard.checkPos ( toLine )
                && (chessBoard.board[line][column] != null));
    }

    // check is move line is free (no intermediate chess pieces between start & end positions)
    public boolean isFreeLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine == line) {
            int start = Math.min ( column, toColumn );
            int end = Math.max ( column, toColumn );
            int countFreeLine = 0;
            for (int i = start + 1; i < end; i++) {
                if (chessBoard.board[line][i] != null) countFreeLine++;
            }
            if (countFreeLine == 0) return true;
        }
        return false;
    }

    // check is move column is free (no intermediate chess pieces between start & end positions)
    public boolean isFreeColumn(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn == column) {
            int start = Math.min ( line, toLine );
            int end = Math.max ( line, toLine );
            int countFreeColumn = 0;
            for (int i = start + 1; i < end; i++) {
                if (chessBoard.board[i][column] != null) countFreeColumn++;
            }
            if (countFreeColumn == 0) return true;
        }
        return false;
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
