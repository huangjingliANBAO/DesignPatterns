package yuanxingmoshi;

import javax.swing.*;
import java.awt.*;

/**
 * 分析：孙悟空拔下猴毛轻轻一吹就变出很多孙悟空，这实际上是用到了原型模式。
 * 这里的孙悟空类 SunWukong 是具体原型类，而 Java 中的 Cloneable 接口是抽象原型类
 * 另外，重写了 Cloneable 接口的 clone() 方法，用于复制新的孙悟空。
 * 访问类可以通过调用孙悟空的 clone() 方法复制多个孙悟空，并在框架窗体 JFrame 中显示。
 */
public class ProtoTypeWukong {
    public static void main(String[] args) {
        JFrame jf = new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        SunWukong obj1 = new SunWukong();
        contentPane.add(obj1);
        SunWukong obj2 = (SunWukong) obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
    }
}
class SunWukong extends JPanel implements Cloneable{
    public SunWukong(){
        JLabel jb = new JLabel(new ImageIcon("src/img/WuKong.jpg"));
        this.add(jb);
    }
    public Object clone()  {
        SunWukong swk = null;
        try {
           swk = (SunWukong) super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("拷贝悟空失败!");
        }
        return swk;
    }
}
