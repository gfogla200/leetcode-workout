public class ValidTicTacToe {

    public static boolean validTicTacToe(String[] board) {

        int oCount = 0, xCount = 0;
        for(int i = 0;i<3;i++){
            char[] word = board[i].toCharArray();
            for(int j=0;j<3;j++){

                if(word[j] == 'X'){
                    xCount++;
                }
                if (word[j] == 'O'){
                    oCount++;
                }
            }
        }

        if (oCount != xCount && oCount != xCount - 1) return false;
        if (win(board, 'X') && oCount != xCount - 1) return false;
        if (win(board, 'O') && oCount != xCount) return false;

        return true;
    }

    public static boolean win(String[] B, char P) {
        // B: board, P: player
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }

    public static void main(String args[]){

        String[] board = new String[]{"XOO","OXO","XXX"};
        System.out.println(validTicTacToe(board));
    }
}
