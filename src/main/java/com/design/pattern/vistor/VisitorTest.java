package com.design.pattern.vistor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/23 11:33
 * **************************************************
 */
public class VisitorTest {
  public static void main(String[] args) {
    ObjectStructure objectStructure = new ObjectStructure();
    objectStructure.add(new ConcreteElementA());
    objectStructure.add(new ConcreteElementB());
    objectStructure.accept(new ConcreteVisitor());
  }

}

class ObjectStructure {
  private ArrayList<Element> list = new ArrayList<Element>();

  public void accept(Visitor visitor) {
    Iterator<Element> iterator = list.iterator();
    while (iterator.hasNext()) {
      iterator.next().accept(visitor);
    }

  }

  public void add(Element element) {
    if (!list.contains(element)) {
      list.add(element);
    }
  }

  public void remove(Element element) {
    list.remove(element);
  }
}

interface Visitor {
  public void visit(ConcreteElementA element);

  public void visit(ConcreteElementB element);
}

class ConcreteVisitorA implements Visitor {

  public void visit(ConcreteElementA element) {
    System.out.println("访问者A对元素A做出相应");
  }

  public void visit(ConcreteElementB element) {
    System.out.println("访问者A对元素B做出相应");
  }
}

class ConcreteVisitor implements Visitor {

  public void visit(ConcreteElementA element) {
    System.out.println("访问者B对元素A做出相应");
  }

  public void visit(ConcreteElementB element) {
    System.out.println("访问者B对元素B做出相应");
  }
}

interface Element {
  public void accept(Visitor visitor);
}

class ConcreteElementA implements Element {

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String operation() {
    return "concreteElementA";
  }
}

class ConcreteElementB implements Element {

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String operation() {
    return "concreteElementB";
  }
}


