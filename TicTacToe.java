import java.util.*;

 public class TicTacToe{
    static ArrayList<Integer>playerPositions= new ArrayList<Integer>();
    static ArrayList<Integer>cpuPositions= new ArrayList<Integer>();
    public static void main(String[] args) {
        char[] [] gameBoard = {{' ', '|', ' ','|', ' '}, 
        {'-', '+', '-','+', '-'},
         {' ', '|', ' ','|', ' '},
         {'-', '+', '-','+', '-'},
          {' ', '|', ' ','|', ' '}};
         printGameBoard(gameBoard); 
         

         while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your placement 1 to 9:");
            int playerPos=sc.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)){
               System.out.println("position taken! Enter a correct position"); 
               playerPos=sc.nextInt();
            }
            
   
            placePiece(gameBoard, playerPos, "player");

            String result=checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                
            }
            Random rand= new Random();
            int cpuPos=rand.nextInt(9)+1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                
                cpuPos=rand.nextInt(9)+1;
            }
            placePiece(gameBoard, cpuPos, "cpu");
   
   
            printGameBoard(gameBoard);

             result=checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
         
         }
        
    }

          public static void printGameBoard(char [] [] gameBoard) {
          for (char[] row : gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();

          }
    }
    public static void placePiece(char[] [] gameBoard, int pos, String user){
        char symbol =' ';
        if(user.equals("player")){
            symbol='x';
            playerPositions.add(pos);

        }else if(user.equals("cpu")){
            symbol= 'o';
            cpuPositions.add(pos);
        }

      
        switch(pos){
            case 1:
            gameBoard [0] [0] = symbol;
            break;
            case 2:
            gameBoard[0] [2] = symbol;
            break;
            case 3:
            gameBoard [0] [4] = symbol;
            break;
            case 4:
            gameBoard [2] [0] = symbol;
            break;
            case 5:
            gameBoard [2] [2] = symbol;
            break;
            case 6:
            gameBoard [2] [4] = symbol;
            break;
            case 7:
            gameBoard [4] [0] = symbol;
            break;
            case 8:
            gameBoard [4] [2] = symbol;
            break;
            case 9:
            gameBoard [4] [4] = symbol;
            break;
            default:
            break;

    } 
        
    }
    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow= Arrays.asList(4, 5, 6);
        List botRow= Arrays.asList(7, 8, 9);
        List rightCol = Arrays.asList(1, 4, 7);
        List midCol= Arrays.asList(2, 5, 8);
        List leftCol= Arrays.asList(3, 6, 9);
        List cross1= Arrays.asList(1, 5, 9);
        List cross2= Arrays.asList(7, 5, 3);

        List<List>Winning=new ArrayList<List>();
        Winning.add(topRow);
        Winning.add(midRow);
        Winning.add(botRow);
        Winning.add(leftCol);
        Winning.add(midCol);
        Winning.add(rightCol);
        Winning.add(cross1);
        Winning.add(cross2);

        for(List l : Winning){
            if(playerPositions.containsAll(l)){
              return "~ Congratulations you won.!! ~"  ;
            }else if(cpuPositions.containsAll(l)){
                return "~ CPU wins.!! sorry :( ~";
            }
            }
        

      return "" ;
        
    }
 }
