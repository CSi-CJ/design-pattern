package com.design.pattern.state;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 15:01
 * **************************************************
 */
public class StatePattern {
  public static void main(String[] args) {
    ConcreteStateA concreteStateA = new ConcreteStateA();
    // 设置初始化状态
    Context context = new Context(concreteStateA);
    context.handle();
    context.handle();

  }
}
// 环境类
class Context{
  private State state;

  public Context(State state) {
    System.out.println("设置初始话状态");
    this.state = state;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
  public void handle(){
    state.handle(this);
  }
}

abstract class State{
  public abstract void handle(Context context);
}

class ConcreteStateA extends State{

  public void handle(Context context) {
    System.out.println("当前状态是A");
    context.setState(new ConcreteStateB());
    System.out.println("切换状态");
  }
}


class ConcreteStateB extends State{

  public void handle(Context context) {
    System.out.println("当前状态是B");
    context.setState(new ConcreteStateA());
    System.out.println("切换状态");
  }
}
