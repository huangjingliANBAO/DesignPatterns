package dailimoshi;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
//抽象接口
interface Subject{
    void request();
}
class RealSubject implements Subject{
    public void request(){
        System.out.println("访问抽象接口");
    }
}
class Proxy implements Subject{
    private RealSubject realSubject;
    public void request(){
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        nextRequest();

    }
    public void preRequest(){
        System.out.println("访问前");
    }
    public void nextRequest(){
        System.out.println("访问后");
    }
}