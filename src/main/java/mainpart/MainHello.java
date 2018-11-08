package mainpart;

public class MainHello{
    private static MainHello mainhello=null;

    public MainHello() {
    }

    public static  MainHello getInstance(){
        if(mainhello==null)
            mainhello=new MainHello();
        return mainhello;
    }
}
