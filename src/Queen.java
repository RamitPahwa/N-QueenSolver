/**
 * Created by ramit on 10/29/2016.
 */
public class Queen {

    public int rowLocation;

    public void setRowLocation(int colNumber)
    {
        rowLocation=colNumber;
    }
    public int getRowLocation()
    {
        return rowLocation;
    }
    public boolean isSafe(Queen[] q,int loc)
    {
        for(int j=0;j<loc;j++) {
            //Checking Row ,Left Upper Diagonal and Left Lower diagonal
            if (q[j].getRowLocation() == rowLocation) return false;
            else if ((q[j].getRowLocation() - rowLocation) == (j - loc)) return false;
            else if ((q[j].getRowLocation() - rowLocation) == (loc - j)) return false;
        }
        return true;
    }

}
