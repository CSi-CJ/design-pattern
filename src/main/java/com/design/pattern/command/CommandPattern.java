package com.design.pattern.command;

import javax.crypto.spec.PSource;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 10:53
 * **************************************************
 */
public class CommandPattern {
  public static void main(String[] args) {
    Invoker invoker = new Invoker(new ConcreteCommandA());
    invoker.cell();
  }
}

interface Command{
  public void execute();
}

class ConcreteCommandA implements Command{
  public RecevierA receiver = new RecevierA();
  public void execute() {
    System.out.println("具体指令A被调用了");
    receiver.action();
  }
}
class ConcreteCommandB implements Command{
  public RecevierB recevier = new RecevierB();
  public void execute() {
    System.out.println("具体指令B被调用了");
    recevier.action();
  }
}


class RecevierA{
  public void action(){
    System.out.println("接收者A接受指令");
  }
}

class RecevierB{
  public void action(){
    System.out.println("接收者B接受指令");
  }
}

class Invoker{
  private Command command;

  public Invoker(Command command) {
    this.command = command;
  }

  public void setCommand(Command command) {
    this.command = command;
  }
  public void cell(){
    command.execute();
  }
}
