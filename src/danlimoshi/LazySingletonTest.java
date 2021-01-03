package danlimoshi;

public class LazySingletonTest {
    public static void main(String[] args) {
        President p1 = President.getInstance();
        p1.getName();
        President p2 = President.getInstance();
        p2.getName();
        if (p1 == p2){
            System.out.println("他们是同一个人");
        }else {
            System.out.println("他们不是一个人");
        }
    }

}
class President {
    private static volatile President instance = null;
    //避免在外部被实例化
    private President(){
        System.out.println("产生一个新总统");
    }
    public static synchronized President getInstance(){
        if (instance == null){
            instance = new President();
        }else {
            System.out.println("已经有一个总统了，不能产生新总统");
        }
        return instance;
    }
    public void getName(){
        System.out.println("我是总统，我叫特朗普");
    }
}
