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
        
        System.out.println("\nCountries with largest GDPs in their continents:");
        System.out.println("Australia: " + aust);
        System.out.println("Brazil: " + brazil);
        System.out.println("China: " + china);
        System.out.println("Germany: " + german);
        System.out.println("South Africa: " + southAfr);
        System.out.println("United States: " + unitedSta);

        double maxVal = Integer.MIN_VALUE;
        String country = null;
        for (int i = 0; i < dataset.size(); i++)
        {
             GDPData temp = dataset.get(i);
            if (temp.getGdpLast() > maxVal)
            {
                maxVal = temp.getGdpLast();
                country = temp.getCountry();
            }
        }
        System.out.println(country + " : " + maxVal);
    }
}