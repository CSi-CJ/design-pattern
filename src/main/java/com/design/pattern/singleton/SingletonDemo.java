package com.design.pattern.singleton;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/15 16:42
 * **************************************************
 */
public class SingletonDemo {
  //饿汉式
  private final static SingletonDemo instance = new SingletonDemo();

  private SingletonDemo() {
  }

  ;

  public static SingletonDemo getInstance() {
    return instance;
  }

  public static void main(String[] args) {
    SingletonDemo instance = SingletonDemo.getInstance();
    SingletonDemo instance2 = SingletonDemo.getInstance();
    System.out.println(instance == instance2);
    System.out.println(instance.hashCode());
    System.out.println(instance2.hashCode());
  }

}

class SingletonDemo2 {
  //懒汉式（对于多线程情况下，是线程不安全的）
  private static SingletonDemo2 instance2;

  private SingletonDemo2() {
  }

  ;

  public SingletonDemo2 getInstance() {
    if (instance2 == null) {
      instance2 = new SingletonDemo2();
    }
    return instance2;
  }
}


class SingletonDemo3 {
  // 推荐使用双重检查(既满足了多线程安全的问题，又让性能效率的问题得以提高)
  private static volatile SingletonDemo3 instance;

  private SingletonDemo3() {
  }

  public SingletonDemo3 getInstance() {
    if (instance == null) {
      synchronized (SingletonDemo3.class) {
        if (instance == null) {
          instance = new SingletonDemo3();
        }
      }
    }
    return instance;
  }
}
