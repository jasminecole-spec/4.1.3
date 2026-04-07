/*
 * Activity 4.1.3
 *
 * Data attribute:
 * The World Bank:GDP (current US$): OECD National Accounts data files, CC BY 4.0
 */
import java.io.IOException;
import java.util.ArrayList;

public class GDP
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<GDPData> dataset = GDPData.createDataSet("gdp.csv");
        for (GDPData d : dataset)
        {
            System.out.println(d);
        }

        int aust = GDPSearch.find(dataset, 0, dataset.size(), "Australia");
        int brazil = GDPSearch.find(dataset, 0, dataset.size(), "Brazil");
        int china = GDPSearch.find(dataset, 0, dataset.size(), "China");
        int german = GDPSearch.find(dataset, 0, dataset.size(), "Germany");
        int southAfr = GDPSearch.find(dataset, 0, dataset.size(), "South Africa");
        int unitedSta = GDPSearch.find(dataset, 0, dataset.size(), "United States");
        
    }
}