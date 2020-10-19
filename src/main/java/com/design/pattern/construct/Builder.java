package com.design.pattern.construct;

import lombok.Data;

import javax.naming.directory.DirContext;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 14:37
 * **************************************************
 */
public abstract class Builder {
   Product product = new Product();

  public abstract void addA();
  public abstract void addB();
  public abstract void addC();
  public Product getResult(){
    return this.product;
  }
}

class ConcreteBuilder1 extends Builder{
  public void addA(){
    product.setA("a");
  }
  public void addB(){
    product.setB("b");
  }
  public void addC(){
    product.setC("c");
  }
}

class ConcreteBuilder2 extends Builder{
  public void addA(){
    product.setA("aa");
  }
  public void addB(){
    product.setB("bb");
  }
  public void addC(){
    product.setC("cc");
  }
}
@Data
class Product{
  private String A;
  private String B;
  private String C;
}

class Director{
  private Builder builder;
  public Director(Builder builder){
    this.builder = builder;
  }

  public void setBuilder(Builder builder) {
    this.builder = builder;
  }

  public Product construct(){
    builder.addA();
    builder.addB();
    builder.addC();
    return builder.getResult();
  }
}


class Client{
  public static void main(String[] args) {
    ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();

    // 最好可以将构建的先后顺序交给指挥者定义
//    concreteBuilder1.addA();
//    concreteBuilder1.addB();
//    concreteBuilder1.addC();
    Director director = new Director(concreteBuilder1);
    Product product = director.construct();
    System.out.println(product);
  }
}
