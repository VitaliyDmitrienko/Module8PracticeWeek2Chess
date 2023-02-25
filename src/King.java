// Module 8. Practice week #2. Chess. ChessPiece.
public class King extends ChessPiece {
    boolean check = true;

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
                        (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor()))
                        && !isUnderAttack(chessBoard, toLine, toColumn))
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
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (board.board[i][j] != null) {
                        if (!board.board[i][j].getColor().equals(board.nowPlayerColor()) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

}
