package yuanxingmoshi;

/**
 * Java 中的 Object 类提供了浅克隆的 clone() 方法，
 * 具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
 * 这里的 Cloneable 接口就是抽象原型类。
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }
}
class Realizetype implements Cloneable{
    public Realizetype(){
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return super.clone();
    }
}
