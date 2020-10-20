package com.design.pattern.facade;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/20 10:49
 * **************************************************
 */
public class Facade {
  private SubSystem1 sub1 = new SubSystem1();
  private SubSystem2 sub2 = new SubSystem2();
  private SubSystem3 sub3 = new SubSystem3();

  public void method(){
    sub1.method();
    sub2.method();
    sub3.method();
  }
}
class SubSystem1{
  public void method(){
    System.out.println("子系统1的方法");
  }
}
class SubSystem2{
  public void method(){
    System.out.println("子系统2的方法");
  }
}
class SubSystem3{
  public void method(){
    System.out.println("子系统3的方法");
  }
}
class Client{
  public static void main(String[] args) {
    Facade facade = new Facade();
    facade.method();
  }
}
