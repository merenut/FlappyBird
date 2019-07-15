package Utilities;

public class ThreadUtils
{
    private ThreadUtils(){}

    public static void sleep(int milli)
    {
        try{
            Thread.sleep(milli);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
