package com.design.pattern.flyweight;

import javax.security.auth.login.FailedLoginException;
import java.util.HashMap;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/20 15:20
 * **************************************************
 */
public interface Flyweight {
  public void operation(UnsharedConcreteFlyweight state);
}

// 非享元角色
class UnsharedConcreteFlyweight {
  private String info;

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}

// 享元工厂： 负责创建一些共享的角色和管理享元角色
class FlyweightFactory {
  private HashMap<String,Flyweight> flyweights = new HashMap<String,Flyweight>();

  public Flyweight getFlyweight(String key) {
    Flyweight flyweight = flyweights.get(key);
    if (flyweight==null){
      ConcreteFlyweight1 concreteFlyweight1 = new ConcreteFlyweight1(key);
      flyweights.put(key,concreteFlyweight1);
      return concreteFlyweight1;
    }else {
      return flyweight;
    }
  }
}

// 具体的享元角色
class ConcreteFlyweight1 implements Flyweight{
  private String key;

  public ConcreteFlyweight1(String key){
    this.key = key;
  }
  public void operation(UnsharedConcreteFlyweight state) {
    System.out.println("具体的享元key值： " + key);
    System.out.println("非具体的享元对象： " + state);
  }
}

class ConcreteFlyweight2 implements Flyweight{
  private String key;

  public ConcreteFlyweight2(String key){
    this.key = key;
  }
  public void operation(UnsharedConcreteFlyweight state) {
    System.out.println("具体的享元key值： " + key);
    System.out.println("非具体的享元对象： " + state);
  }
}


class FlyweightPattern{
  public static void main(String[] args) {
    FlyweightFactory flyweightFactory = new FlyweightFactory();
    Flyweight lisa = flyweightFactory.getFlyweight("lisa");
    UnsharedConcreteFlyweight unsharedConcreteFlyweight = new UnsharedConcreteFlyweight();
    unsharedConcreteFlyweight.setInfo("创建非共享对象");
    lisa.operation(unsharedConcreteFlyweight);
    System.out.println(lisa);
  }
}
