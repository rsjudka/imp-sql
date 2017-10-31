import java.util.*;
import java.io.*;

public class query
{
    static Map<String, pAttributes> pTable = new TreeMap<String, pAttributes>(new pComp());

    public static void main(String[] args) throws IOException
    {
        //calls methods for reading data and for commands
        readProduct();
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
}