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
}