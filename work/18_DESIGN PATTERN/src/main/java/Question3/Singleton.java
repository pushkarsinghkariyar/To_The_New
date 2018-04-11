package Question3;

public class Singleton {
    private static Singleton uniqueInstance;

    private void Singleton(){}

    public static synchronized Singleton getUniqueInstance(){
        if(uniqueInstance==null)
        {
            uniqueInstance=new Singleton();
        }
        return uniqueInstance;
    }
}
