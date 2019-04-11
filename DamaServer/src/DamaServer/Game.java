package DamaServer;

public class Game {                     //Oyunun arkaplanını tutacak matris ve kullanıcılar tanımlandı.
    private int[][] board = null;
    private String player1 = "";
    private String player2 = "";
    private String turn = "";
    
    public Game(String player1, String player2) {   //matrise ve oyunculara ilk değer atamaları yapıldı.
        int[][] b = {
            {3, 0, 3, 0, 3, 0, 3, 0},
            {0, 3, 0, 3, 0, 3, 0, 3},
            {3, 0, 3, 0, 3, 0, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1}
        };
        board = b;
        turn = player1;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public String getBoard() {              //Oyun tahtasına string olarak ulaşıp işlem yapabilmek için tanımlandı.
        return intBoardToString(board);
    }
    
    private String intBoardToString(int[][] b) { // matrisin her dizininde dönerek string değere dönüştürmek 
        String strBoard = "[";                       // için köşeli parantes ve matristeki değer alınarak string olarak döndürüldü.
        for (int[] y : b) {
            strBoard += "[";
            for (int x: y) {
                strBoard += x+",";
            }
            strBoard = strBoard.substring(0, strBoard.length()-1);
            strBoard += "],";
        }
        strBoard = strBoard.substring(0, strBoard.length()-1);
        strBoard += "]";
        return strBoard;
    }
    
    public String getRotatedBoard(String stringBoard) { //iki kullanıcı tahtayı zıt hallerde göreceğinden
        String strBoard = stringBoard;                      //diğer oyuncu için matrisin tersten hali string olarak 
        strBoard = strBoard.replace("1", "-1");                   //döndürüldü.
        strBoard = strBoard.replace("3", "1");                
        strBoard = strBoard.replace("-1", "3");
        strBoard = strBoard.replace("2", "-2");
        strBoard = strBoard.replace("4", "2");
        strBoard = strBoard.replace("-2", "4");
        strBoard = new StringBuffer(strBoard).reverse().toString();
        strBoard = strBoard.replace("[", "*");
        strBoard = strBoard.replace("]", "[");
        strBoard = strBoard.replace("*", "]");
        return strBoard;
    }
    
    public void setBoard(int[][] newBoard) {
        if (turn.equals(player1)) {                                        //ilk oyuncuysa board oluşturur
            board = newBoard;                                              //ikinci oyuncuysa boardun tersini alarak oluşturur.
        } else {
            String newBoardStr = intBoardToString(newBoard);                
            newBoardStr = getRotatedBoard(newBoardStr);
            
            int[][] realBoard = new int[8][8];
            String str = newBoardStr.substring(1, newBoardStr.length()-1);
            String[] rows = str.split("\\],\\[");
            rows[0] = rows[0].substring(1, rows[0].length());
            rows[7] = rows[7].substring(0, rows[7].length()-1);

            for (int y = 0; y < 8; y++) {                           
                String chars[] = rows[y].split(",");
                for (int x = 0; x < 8; x++) {
                    realBoard[y][x] = Integer.parseInt(chars[x]);
                }
            }
            board = realBoard;
        }
    }
    
    public String getTurn() {               //oyuncu sırasını döndürür.
        return turn;
    }
    
    public void changeTurns() {             //sıra değiştiğinden turn değerini update eder.
        if (turn.equals(player1)) {
            turn = player2;
        } else if (turn.equals(player2)) {
            turn = player1;
        } 
    }
}
