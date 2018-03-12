package homework6;

public class PricingStrategyFactory
{
    private static PricingStrategyFactory instance;


    public static PricingStrategyFactory getlnstance()
    {
        if ( instance == null )
            instance = new PricingStrategyFactory();
        return instance;
    }

//    public IPricingStrategy getPricingStratey(int i)
//    {
//
//    }



}
