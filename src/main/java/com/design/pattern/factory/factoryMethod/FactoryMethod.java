package com.design.pattern.factory.factoryMethod;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 13:48
 * **************************************************
 */
public interface FactoryMethod {
    public Product newProduct();

}
class BenzConcreteFactory implements FactoryMethod {

  public Product newProduct() {
    return new ConcreteProduct();
  }
}
class AudiConcreteFactory implements FactoryMethod {

  public Product newProduct() {
    return new ConcreteProduct2();
  }
}


interface Product{
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


class Client{
  public static void main(String[] args) {
    Product Benz = new BenzConcreteFactory().newProduct();
    Benz.show();
  }
}

