package danlimoshi;

import javax.swing.*;
import java.awt.*;

public class HungrySingletonTest {
    public static void main(String[] args) {
       JFrame jf = new JFrame("饿汉式单例模式测试");
       jf.setLayout(new GridLayout(1,2));
       Container container = jf.getContentPane();
       Bajie o1 = Bajie.getInstance();
       container.add(o1);
       Bajie o2 = Bajie.getInstance();
       container.add(o2);
       if (o1 == o2){
           System.out.println("他们是同一个人");
       }else {
           System.out.println("他们不是同一个人");
       }
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Bajie extends JPanel {
    private static final Bajie instance = new Bajie();
    private Bajie(){
      JLabel jLabel = new JLabel(new ImageIcon("src/img/Bajie.jpg"));
      this.add(jLabel);
    }
    public static Bajie getInstance(){
        return instance;
    }
}
