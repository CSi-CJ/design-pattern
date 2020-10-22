package com.design.pattern.composite;

import java.util.ArrayList;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/21 16:58
 * **************************************************
 */
// 树枝构件
public class Composite implements Component {
  private ArrayList<Component> children = new ArrayList<Component>();

  public void add(Component c) {
    children.add(c);
  }

  public void remove(Component c) {
    children.remove(c);
  }

  public Component getChild(int t) {
    Component component = children.get(t);
    if (component == null) {
      return null;
    } else {
      return component;
    }
  }

    public void operation() {
      for (Component child : children) {
        child.operation();
      }
  }
}

// 抽象构件
interface Component {
  public void add(Component c);

  public void remove(Component c);

  public Component getChild(int t);

  public void operation();
}

// 树叶构件
class Leaf implements Component {
  private String name;

  public Leaf(String name) {
    this.name = name;
  }

  public void add(Component c) {

  }

  public void remove(Component c) {

  }

  public Component getChild(int t) {
    return null;
  }

  public void operation() {
    System.out.println(name);
  }
}
class CompositeTest{
  public static void main(String[] args) {
    Composite composite = new Composite();
    Leaf leaf = new Leaf("1");
    Leaf leaf2 = new Leaf("2");
    Leaf leaf3 = new Leaf("3");
    composite.add(leaf);
    composite.add(leaf2);
    composite.add(leaf3);
    composite.operation();
  }
}


