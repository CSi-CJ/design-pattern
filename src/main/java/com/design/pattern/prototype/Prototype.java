package com.design.pattern.prototype;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 10:14
 * **************************************************
 */
public class Prototype implements Cloneable{
  Prototype(){
    System.out.println("具体原型创建成功！");
  }
  public Object clone() throws CloneNotSupportedException {
    System.out.println("具体原型创建成功！");
    return (Prototype)super.clone();
  }

}

//原型模式测试
class PrototypeTest{
  public static void main(String[] args) throws CloneNotSupportedException {
    Prototype prototype = new Prototype();
    Prototype cloneObj = (Prototype)prototype.clone();
    System.out.println("prototype == cloneObj  ?   " + (prototype == cloneObj));
  }
}
