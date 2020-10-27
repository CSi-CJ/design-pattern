package com.design.pattern.mediator;

import java.util.ArrayList;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/23 10:41
 * **************************************************
 */
public class MediatorTest {
  public static void main(String[] args) {
    ConcreteMediator concreteMediator = new ConcreteMediator();
    concreteMediator.register(new ConcreteColleague1());
    concreteMediator.register(new ConcreteColleague2());
  }
}
abstract class Mediator{
  public abstract void register(Colleague colleague);
  public abstract void relay(Colleague colleague);
}
abstract class Colleague{
  protected Mediator mediator;

  public void setMedium(Mediator medium){
    this.mediator  = medium;
  }
  public abstract void receive();
  public abstract void send();
}

class ConcreteColleague1 extends Colleague{

  public void receive() {
    System.out.println("1");
  }

  public void send() {
    System.out.println("11");
  }
}

class ConcreteColleague2 extends Colleague{

  public void receive() {
    System.out.println("2");
  }

  public void send() {
    System.out.println("22");
  }
}
class ConcreteMediator extends Mediator{
  private ArrayList<Colleague> colleagues = new ArrayList<Colleague>();
  public void register(Colleague colleague) {
    colleagues.add(colleague);
    relay(colleague);
  }

  public void relay(Colleague colleague) {
    colleague.receive();
  }
}
