package com.design.pattern.factory.simpleFactory;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 13:31
 * **************************************************
 */
public interface Product {
  public void show();
}

class ConcreteProduct implements Product {

  public void show() {
    System.out.println("生产奔驰e300l");
  }
}

class ConcreteProduct2 implements Product {

  public void show() {
    System.out.println("生产奥迪a8L");
  }
}

class SimpleFactory {
  public static Product makeProduct(String kind) {
    if ("奔驰".equals(kind)) {
      return new ConcreteProduct();
    } else if ("奥迪".equals(kind)) {
      return new ConcreteProduct2();
    }
    return null;
  }
}

class Client {
  public static void main(String[] args) {
    Product Benz = SimpleFactory.makeProduct("奔驰");
    Benz.show();
  }
}
