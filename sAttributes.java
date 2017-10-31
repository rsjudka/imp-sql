public class sAttributes
{
    private String productID;
    private String tid;
    private int noofitems;

    public sAttributes()
    {
        this.productID = null;
        this.tid = null;
        this.noofitems = 0;
    }

    public sAttributes(String sproductID, String stid, int snoofitems)
    {
        this.productID = sproductID;
        this.tid = stid;
        this.noofitems = snoofitems;
    }

    public String getproductID()
    {
        return this.productID;
    }

    public String gettid()
    {
        return this.tid;
    }

    public int getnoofitems()
    {
        return this.noofitems;
    }

    public void setproductID(String pproductID)
    {
        this.productID = pproductID;
    } 

    public void settid(String ptid)
    {
        this.tid = ptid;
    }

    public void setnoofitems(int pnoofitems)
    {
        this.noofitems = pnoofitems;
    }
}