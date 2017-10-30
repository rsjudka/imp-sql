public class pAttributes
{
    private String name;
    private int price;
    private String vendorID;
    private String categoryID;

    public pAttributes()
    {
        this.name = null;
        this.price = 0;
        this.vendorID = null;
        this.categoryID = null;
    }

    public pAttributes(String sname, int sprice, String svendorID, String scategoryID)
    {
        this.name = sname;
        this.price = sprice;
        this.vendorID = svendorID;
        this.categoryID = scategoryID;
    }

    public String getname()
    {
        return this.name;
    }

    public int getprice()
    {
        return this.price;
    }

    public String getvendorID()
    {
        return this.vendorID;
    }

    public String getcategoryID()
    {
        return this.categoryID;
    }

    public void setname(String pname)
    {
        this.name = pname;
    } 

    public void setprice(int pprice)
    {
        this.price = pprice;
    }

    public void setvendorID(String pvendorID)
    {
        this.vendorID = pvendorID;
    }

    public void setcategoryID(String pcategoryID)
    {
        this.categoryID = pcategoryID;
    }
}