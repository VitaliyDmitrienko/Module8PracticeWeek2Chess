// Module 8. Practice week #2. Chess. ChessPiece "Horse".
public class Horse extends ChessPiece {

    public Horse(String color) {
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
                if ((((Math.abs ( toLine - line ) == 2) && (Math.abs ( toColumn - column ) == 1)) ||
                        ((Math.abs ( toLine - line ) == 1) && (Math.abs ( toColumn - column ) == 2))) && (chessBoard.board[toLine][toColumn] == null
                        || !chessBoard.board[toLine][toColumn].getColor ().equals ( chessBoard.nowPlayerColor () )))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
