package com.design.pattern.bridge;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 18:33
 * **************************************************
 */
public class BagManage {
  public static void main(String[] args) {
    Color color  = new Red();
    Bag bag = new Wallet();
    bag.setColor(color);
    System.out.println(bag.getName());
  }
}

/***
 * 桥接模式
 * 客户端依赖于接口和抽象类，接口和抽象类直接处于聚合关系
 * 抽象与实现分离，降低了耦合度
 */
interface Color{
  public String getColor();
}

class Red implements Color{

  public String getColor() {
    return "show red-color";
  }
}
class Yellow implements Color{

  public String getColor() {
    return "show yellow-color";
  }
}

abstract class Bag{
  protected Color color;

  public void setColor(Color color) {
    this.color = color;
  }

  public abstract String getName();
}

class HandBag extends Bag{

  public String getName() {
    return super.color.getColor() + " HandBag";
  }
}
class Wallet extends Bag{

  public String getName() {
    return super.color.getColor() + " Wallet";
  }
}
