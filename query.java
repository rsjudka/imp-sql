import java.util.*;
import java.io.*;

public class query
{
    static Map<String, pAttributes> pTable = new TreeMap<String, pAttributes>(new pComp());
    static List<sAttributes> sTable = new ArrayList<sAttributes>();  

    public static void main(String[] args) throws IOException
    {
        //calls methods for reading data and for commands
        readProduct();
        readSoldvia();

        System.out.println("Running Query1:");
        System.out.println("SELECT\tproductid, productname, productprice\n" +
                            "FROM\tproduct\n" +
                            "WHERE\tproductid IN\n" +
                            "\t(SELECT productid\n" +
                            "\tFROM soldvia\n" +
                            "\tGROUP BY productid\n" +
                            "\tHAVING COUNT(*) > 1);"); 
        System.out.println("\nQuery1 result:");
        query1();

        System.out.println("\n----------------------------------------------------------------------\n");

        System.out.println("Running Query2:");
        System.out.println("SELECT\tproduct.productid, productname, productprice, tid\n" +
                            "FROM\tproduct, soldvia\n" +
                            "WHERE\tproduct.productid = soldvia.productid;"); 
        System.out.println("\nQuery2 result:");
        query2();
    }

    public static void readProduct() throws IOException
    {
        pAttributes attributes;

        File oFile = new File("product.txt");
        Scanner rFile = new Scanner(oFile);

        String header = rFile.nextLine();

        String readLine;
        String[] saveData = null;
        while (rFile.hasNextLine())
        {
            readLine = rFile.nextLine();
            saveData = readLine.split(",");
            attributes = new pAttributes(saveData[1], Integer.parseInt(saveData[2]), saveData[3], saveData[4]);
            pTable.put(saveData[0], attributes);
        }
    }

    public static void readSoldvia() throws IOException
    {
        sAttributes attributes;

        File oFile = new File("soldvia.txt");
        Scanner rFile = new Scanner(oFile);

        String header = rFile.nextLine();

        String readLine;
        String[] saveData = null;
        while (rFile.hasNextLine())
        {
            readLine = rFile.nextLine();
            saveData = readLine.split(",");
            attributes = new sAttributes(saveData[0], saveData[1], Integer.parseInt(saveData[2]));
            sTable.add(attributes);
        }

        //sorts list
        Collections.sort(sTable, new sComp());
    }

    public static void query1()
    {
        System.out.printf("%s    %s    %s\n", "productid", "productname", "productprice");
        String key = null;
        sAttributes curr = null;
        sAttributes next = null;
        //iterate through soldvia table
        ListIterator<sAttributes> it = sTable.listIterator();
        while (it.hasNext())
        {
            curr = it.next();
            if (it.hasNext())
            {
                next = it.next();
                if (pTable.containsKey(curr.getproductID()) && curr.getproductID().equals(next.getproductID()))
                {
                    key = curr.getproductID();
                    System.out.printf("%-6s       %-10s     %s\n",key, pTable.get(key).getname(), pTable.get(key).getprice());
                    while (curr.getproductID().equals(next.getproductID()) && it.hasNext())
                    {
                        next = it.next();
                    }
                }
                it.previous();
            }
        }
    }

    public static void query2()
    {
        System.out.printf("%s    %s    %s    %s\n", "productid", "productname", "productprice", "tid");
        for (sAttributes s : sTable)
        {
            if (pTable.containsKey(s.getproductID()))
            {
                String key = s.getproductID();
                System.out.printf("%-6s       %-10s     %-4s            %s\n", key, pTable.get(key).getname(), pTable.get(key).getprice(), s.gettid());
            }
        }
    }
}