package com.design.pattern.templateMethod;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 9:46
 * **************************************************
 */
public class TemplateMethod {
  public static AbstractClass tm;
  public static void main(String[] args) {
    tm = new ConcreteClass();
    tm.templateMethod();
  }
}


abstract class AbstractClass{
  public  void templateMethod(){
    specificMethod();
    abstractMethod1();
    abstractMethod2();
  };
  public  void specificMethod(){
    System.out.println("模板父类公共方法被调用");
  };
  public abstract void abstractMethod1();
  public abstract void abstractMethod2();

}

class ConcreteClass extends AbstractClass{

  public void abstractMethod1() {
    System.out.println("模板子类的具体方法1被调用");
  }

  public void abstractMethod2() {
    System.out.println("模板子类的具体方法2被调用");
  }
}
