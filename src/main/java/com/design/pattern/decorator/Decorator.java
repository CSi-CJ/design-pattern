package com.design.pattern.decorator;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/20 10:03
 * **************************************************
 */
public abstract class Decorator implements Component{
  private Component component;
  public Decorator(Component component){
    this.component = component;
  }
  public void operation(){
    component.operation();
  };
}

// 定义接口
interface Component{
  public void operation();
}

class ConcreteComponent implements Component{

  public void operation() {
    System.out.println("运行具体组件");
  }
}

class ConcreteDecorator1 extends Decorator{

  public ConcreteDecorator1(Component component) {
    super(component);
  }
  public void operation(){
    super.operation();
    addedFunction();
  }
  public void addedFunction(){
    System.out.println("为具体装饰器1添加额外的功能");
  }
}
class ConcreteDecorator2 extends Decorator{

  public ConcreteDecorator2(Component component) {
    super(component);
  }
  public void operation(){
    super.operation();
    addedFunction();
  }
  public void addedFunction(){
    System.out.println("为具体装饰器2添加额外的功能");
  }
}


class DecorateTest{
  public static void main(String[] args) {
    Component component = new ConcreteComponent();
    Decorator decorator = new ConcreteDecorator1(component);
    decorator.operation();
  }
}

