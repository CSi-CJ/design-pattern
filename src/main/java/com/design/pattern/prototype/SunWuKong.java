package com.design.pattern.prototype;

import sun.security.provider.Sun;

import javax.swing.*;
import java.awt.*;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 10:26
 * **************************************************
 */
public class SunWuKong extends JPanel implements Cloneable {
  private static final long serialVersionUID = 5543049531872119328L;

  public SunWuKong() {
    JLabel jLabel = new JLabel(new ImageIcon("Wukong.jpg"));
    this.add(jLabel);
  }

  public Object clone() throws CloneNotSupportedException {
    SunWuKong swk = null;
    swk = (SunWuKong) super.clone();
    return swk;
  }
}

class PrototypeSWK {
  public static void main(String[] args) throws CloneNotSupportedException {
    JFrame jf = new JFrame("原型模式测试");
    jf.setLayout(new GridLayout(1, 2));
    Container contentPane = jf.getContentPane();
    SunWuKong obj1 = new SunWuKong();
    contentPane.add(obj1);
    SunWuKong obj2 = (SunWuKong) obj1.clone();
    contentPane.add(obj2);
    jf.pack();
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
