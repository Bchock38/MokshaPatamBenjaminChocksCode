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

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int totalmoves = 0;
        int distance = 0;
        int highestLadder = 0;
        int currentplace = 0;
        int nextGoal = highestLadder(ladders, currentplace);
        int goal = highestLadder(ladders, currentplace, nextGoal);


        while (currentplace != boardsize){
            totalmoves++;

        }
        return totalmoves;
    }
    //gives you location of the square where the highest later is located
    public int highestLadder(int[][] ladders, int limit){
        int num = limit;
        int goal = 0;
        for (int i = 0; i < ladders[0].length; i++){
            if (num < ladders[1][i]){
                num = ladders[1][i];
                goal = i;
            }
        }
        return goal;


    }
    //gives you location of ladder closet to location of highest ladder
    public int highestLadder(int[][] ladders, int limit, int nextGoal){
        int num = limit;
        int goal = 0;
        for (int i = 0; i < ladders[0].length; i++){
            if (num < ladders[1][i] && ladders[1][i] < nextGoal){
                num = ladders[1][i];
                goal = i;
            }
        }
        return goal;
}
