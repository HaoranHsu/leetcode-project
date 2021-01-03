import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int numOfIslands = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for(int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++) {
                if(grid[r][c] == '1'){
                    numOfIslands++;
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    grid[r][c] = '2';
                    while(!neighbors.isEmpty()){
                        int position = neighbors.remove();
                        int currR = position / nc;
                        int currC = position % nc;
                        if(currR + 1 < nr && grid[currR + 1][currC] == '1'){
                            neighbors.add((currR + 1)* nc + currC);
                            grid[currR + 1][currC] = '2';
                        }
                        if(currR - 1 >= 0 && grid[currR - 1][currC] == '1'){
                            neighbors.add((currR - 1)* nc + currC);
                            grid[currR - 1][currC] = '2';
                        }
                        if(currC + 1 < nc && grid[currR][currC + 1] == '1'){
                            neighbors.add(currR* nc + currC + 1);
                            grid[currR][currC + 1] = '2';
                        }
                        if(currC - 1 >= 0 && grid[currR][currC - 1] == '1'){
                            neighbors.add(currR* nc + currC - 1);
                            grid[currR][currC - 1] = '2';
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
