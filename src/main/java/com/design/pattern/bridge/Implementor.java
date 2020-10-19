package com.design.pattern.bridge;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 18:23
 * **************************************************
 */
public interface Implementor {
  public void operationImpl();
}

class ConcreteImplementorA implements Implementor{

  public void operationImpl() {
    System.out.println("实现角色A");
  }
}
class ConcreteImplementorB implements Implementor{

  public void operationImpl() {
    System.out.println("实现角色B");
  }
}

abstract class Abstraction{
  private Implementor implementor;
  public Abstraction(Implementor implementor){
    this.implementor = implementor;
  }

  public abstract void operation();
}

class RefinedAbstraction extends Abstraction{

  public RefinedAbstraction(Implementor implementor) {
    super(implementor);
  }

  public void operation() {
    System.out.println("扩展抽象类角色");
  }
}

class BridgeTest{
  public static void main(String[] args) {
    Implementor concreteImplementorA = new ConcreteImplementorA();
    RefinedAbstraction refinedAbstraction = new RefinedAbstraction(concreteImplementorA);
    refinedAbstraction.operation();
  }
}
