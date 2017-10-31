import java.util.*;

public class sComp implements Comparator<sAttributes>
{
    @Override
    public int compare(sAttributes s1, sAttributes s2)
    {
        int s1id = Integer.parseInt(s1.getproductID().split("X")[0]);
        int s2id = Integer.parseInt(s2.getproductID().split("X")[0]);
        if (s1id == s2id)
            return 0;
        else if (s1id > s2id)
            return 1;
        else
            return -1;
    } 
}