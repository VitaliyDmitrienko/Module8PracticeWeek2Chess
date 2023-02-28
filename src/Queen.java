// Module 8. Practice week #2. Chess. ChessPiece "Queen".

public class Queen extends ChessPiece {

    public Queen(String color) {
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
                if (((Math.abs ( toLine - line ) == Math.abs ( toColumn - column )) && isFreeDiagonal ( chessBoard, line, column, toLine, toColumn )) && (chessBoard.board[toLine][toColumn] == null
                        || !chessBoard.board[toLine][toColumn].getColor ().equals ( chessBoard.nowPlayerColor () )))
                    return true;
                else if ((((line == toLine) && (Math.abs ( toColumn - column ) <= 7) && isFreeLine ( chessBoard, line, column, toLine, toColumn ))
                        || ((column == toColumn) && (Math.abs ( toLine - line ) <= 7) && isFreeColumn ( chessBoard, line, column, toLine, toColumn )))
                        && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor ().equals ( chessBoard.nowPlayerColor () )))
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