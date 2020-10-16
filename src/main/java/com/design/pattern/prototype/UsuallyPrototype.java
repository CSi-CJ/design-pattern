package com.design.pattern.prototype;

import java.util.HashMap;
import java.util.Scanner;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 11:24
 * **************************************************
 */
public class UsuallyPrototype {
  private HashMap hp = new HashMap<String, Shape>();

  UsuallyPrototype() {
    hp.put("Circle", new Circle());
    hp.put("Square", new Square());
  }

  public void addShape(String key, Shape shape) {
    hp.put(key, shape);
  }
  public Shape getShape(String key){
    return (Shape) hp.get(key);
  }
}

interface Shape extends Cloneable {
  public Object clone();

  public void countArea();
}

class Circle implements Shape {

  public Object clone() {
    Circle c = null;
    try {
      c = (Circle) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return c;
  }

  public void countArea() {
    int r = 0;
    Scanner sc = new Scanner(System.in);
    r = sc.nextInt();
    System.out.println("该圆的面积="+3.1415*r*r+"\n");
  }
}

class Square implements Shape{

  public Object clone() {
    Square s = null;
    try {
      s = (Square) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return s;
  }

  public void countArea() {
    int x = 0;
    Scanner sc = new Scanner(System.in);
    x = sc.nextInt();
    System.out.println("该矩形的面积="+x*x+"\n");
  }
}

class ProtoTest{
  public static void main(String[] args) {
    UsuallyPrototype manager = new UsuallyPrototype();
    Circle circle = (Circle)manager.getShape("Circle");
    Circle cloneCir = (Circle)circle.clone();
    circle.countArea();
    cloneCir.countArea();
  }
}
