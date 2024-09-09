import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Benjamin Chock
 *
 */

public class MokshaPatam {
    private static int size;
    private static int[][] ladder;
    private static int[][] snake;
    private static int[] ladderBoard;
    private static int[] snakeBoard;
    private static int[] stepBoard;
    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int totalmoves = 0;
        int currentplace = 0;
        int tempincrease = 0;
        ladder = ladders;
        size = boardsize;
        snake = snakes;
        int orgcp = 0;
        makeLadderBoard();
        makeSnakeBoard();
        makeStepBoard();
        Queue<Integer> order = new LinkedList<Integer>();
        order.add(1);
//        System.out.println("start");
        //while queue isn't empty keep running
        while (!order.isEmpty()){
            //set current place to first place in queue
            currentplace = order.remove();
            orgcp = currentplace;
            totalmoves = stepBoard[currentplace];
            //add one move
            totalmoves++;
                //for dice rolls 1-6
                for (int r = 1; r < 7; r++) {
                    //System.out.println(currentplace);
                    //if current place plus roll is greater than board don't run
                    if (currentplace + r <= boardsize) {
                        //move place by diceroll
                        currentplace +=r;
                        //if spot is a snake move to end of snake
                        if (snakeBoard[currentplace] != 0) {
//                            System.out.println("Snake: " + currentplace);
                            currentplace = snakeBoard[currentplace];
                            //if spot is a ladder move to end of ladder
                        } else if (ladderBoard[currentplace] != 0) {
//                            System.out.println("Ladder: " + currentplace);
                            currentplace = ladderBoard[currentplace];
                        }
                        //if spot is out of the board return failure
                        if (currentplace > boardsize) {
                            System.out.println("failed");
                            return 0;
                        }
                        //if spot has never been visited: Save the # of rolls it took to get to place
                        //Add node to the back of the queue
                        if (stepBoard[currentplace] == 0) {
//                            System.out.println("place: "+currentplace);
                            order.add(currentplace);
//                            System.out.println("tt: " + totalmoves);
                            stepBoard[currentplace] = totalmoves;

                        }
//                        System.out.println("place: "+currentplace);
//                        System.out.println("tt: " + totalmoves);
                        currentplace = orgcp;
                    }
                }
            //if currentplace = the end return total moves
            if (currentplace == boardsize){
                for (int i = 0; i < stepBoard.length; i++){
                    System.out.print("#" + i + " ");
                    System.out.println(stepBoard[i] + " ");
                }
//                System.out.println("total: " + totalmoves);
                return stepBoard[boardsize];
            }
        }
        //return total moves
        System.out.println(stepBoard[boardsize]);
        return stepBoard[boardsize];
    }

    public static void makeLadderBoard(){
        ladderBoard = new int[size+1];
        for (int i = 0; i < ladder.length; i++){
             ladderBoard[ladder[i][0]] = ladder[i][1];
        }
//        for (int i = 0; i < ladderBoard.length; i++){
//            System.out.print(ladderBoard[i]);
//        }
    }

    public static void makeSnakeBoard(){
        snakeBoard = new int[size+1];
        for (int i = 0; i < snake.length; i++){
            snakeBoard[snake[i][0]] = snake[i][1];
        }
    }

    public static void makeStepBoard(){
        stepBoard= new int[size+1];
    }
}

