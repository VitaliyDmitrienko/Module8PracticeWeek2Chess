// Module 8. Practice week #2. Chess. ChessPiece "King".

public class King extends ChessPiece {

    public King(String color) {
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
                if (((Math.abs ( toLine - line ) <= 1) && (Math.abs ( toColumn - column ) <= 1)) &&
                        (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor ().equals ( chessBoard.nowPlayerColor () ))
                        && !isUnderAttack ( chessBoard, toLine, toColumn ))
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
        if (board.checkPos(line) && board.checkPos(column)) {
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (board.board[i][j] != null) {
                        if (!board.board[i][j].getColor ().equals ( board.nowPlayerColor () ) && board.board[i][j].canMoveToPosition ( board, i, j, line, column )) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

}