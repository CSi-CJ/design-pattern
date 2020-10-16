package com.design.pattern.factory.abstractFactory;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 14:01
 * **************************************************
 */
public abstract class AbstractFactory {
  public abstract ProductCar carFactory();

  public abstract ProductPlane planeFactory();
}

class BenzFactory extends AbstractFactory {

  public ProductCar carFactory() {
    return new Benz();
  }

  public ProductPlane planeFactory() {
    return new BenzPlane();
  }
}

class AudiFactory extends AbstractFactory {

  public ProductCar carFactory() {
    return new Audi();
  }

  public ProductPlane planeFactory() {
    return new AudiPlane();
  }
}


interface ProductCar {
  public void show();
}

class Benz implements ProductCar {

  public void show() {
    System.out.println("生产奔驰e300l");
  }
}

class Audi implements ProductCar {

  public void show() {
    System.out.println("生产奥迪a8L");
  }
}

interface ProductPlane {
  public void show();
}

class BenzPlane implements ProductPlane {

  public void show() {
    System.out.println("生产奔驰飞机");
  }
}

class AudiPlane implements ProductPlane {

  public void show() {
    System.out.println("生产奥迪飞机");
  }
}


class Client {
  public static void main(String[] args) {
    BenzFactory benzFactory = new BenzFactory();
    ProductCar productCar = benzFactory.carFactory();
    productCar.show();
    ProductPlane productPlane = benzFactory.planeFactory();
    productPlane.show();
  }
}
