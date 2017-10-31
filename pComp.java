import java.util.*;

public class pComp implements Comparator<String>
{
    @Override
    public int compare(String s1, String s2)
    {
        int s1id = Integer.parseInt(s1.split("X")[0]);
        int s2id = Integer.parseInt(s2.split("X")[0]);
        if (s1id == s2id)
            return 0;
        else if (s1id > s2id)
            return 1;
        else
            return -1;
    } 
}