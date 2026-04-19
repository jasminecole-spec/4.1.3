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
        ArrayList<GDPData> dataset = GDPData.createDataSet("gdp_per_capita.csv");
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

        double growth = Integer.MIN_VALUE;
        String countryGrow = null;
        for (int i = 0; i < dataset.size(); i++)
        {
             GDPData temp = dataset.get(i);
             double last = temp.getGdpLast();
             double first = temp.getGdpFirst();
             double difference = last - first;
             if(difference < 0)
             {
                difference = Math.abs(difference);
             }
                if (difference > growth)
                {
                    growth = difference;
                    countryGrow = temp.getCountry();
                }
        }
        System.out.println(countryGrow + " : " + growth);

        System.out.println();
        System.out.println("GDP PER CAPITA GROWTH >= US"); 
        double differenceUS = 0.0;
        for (GDPData temp : dataset) 
        {
            if (temp.getCountry().equals("United States")) 
            {
                differenceUS = Math.abs(temp.getGdpLast() - temp.getGdpFirst());
                break;
            }
        }

        for (GDPData temp : dataset) 
        {
            double difference = Math.abs(temp.getGdpLast() - temp.getGdpFirst());

            if (difference >= differenceUS) 
            {
                System.out.println(temp.getCountry() + ": " + difference);
            }
        }
    }
}
