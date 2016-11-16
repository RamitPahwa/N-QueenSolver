import java.util.ArrayList;

/**
 * Created by dellpc on 10/29/2016.
 */
public class ChessBoard {
    private int n;
    public int count;
    public ArrayList<int[]> solutions;
    public Queen[] q;

    ChessBoard(int size) {
        n = size;
        count = 0;
        solutions = new ArrayList<>();
        q = new Queen[n];
        for (int i = 0; i < n; i++) {
            q[i] = new Queen();

        }
    }
    public void placeQueen(int loc)
    {
        if (loc==n)
            addSolution();

        else
        {   for (int i=0;i<n;i++)
        {
            q[loc].setRowLocation(i);
            //System.out.println(q[i].getRowLocation());
            if (q[loc].isSafe(q, loc))
                placeQueen(loc+1);
        }
        }
    }

    public void addSolution()
    {
        int solution[] = new int [n];
        count++;
        for (int i=0;i<n;i++)
        {
                    solution[i] = q[i].getRowLocation();
                    //System.out.print(solution[i]);
        }

        solutions.add(solution);
        //System.out.print(solutions.get(0));

    }



}
