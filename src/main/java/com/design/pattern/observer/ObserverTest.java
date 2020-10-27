package com.design.pattern.observer;

import java.util.ArrayList;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/23 9:48
 * **************************************************
 */
public class ObserverTest {
  public static void main(String[] args) {
    Subject subject = new ConcreteSubject();
    subject.add(new ConcreteObserver1());
    subject.notifyObserver();

  }
}

interface Observer{
  public void response();
}

class ConcreteObserver1 implements Observer{

  public void response() {
    System.out.println("观察者1做出响应");
  }
}
class ConcreteObserver2 implements Observer{

    public void response() {
      System.out.println("观察者1做出响应");
    }
  }

abstract class Subject{
  protected ArrayList<Observer> observers = new ArrayList<Observer>();

  public void add(Observer observer){
    observers.add(observer);
  }
  public void remove(Observer observer){
    observers.remove(observer);
  }
  public abstract void notifyObserver();
}

class ConcreteSubject extends Subject{
  public void notifyObserver(){
    for (Observer observer : observers) {
      observer.response();
    }
  }
}
