package com.design.pattern.decorator;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/20 10:28
 * **************************************************
 */
// 莫里卡角色
public interface Morrigan {
  public void display();
}
// 原生的莫妮卡角色
class OriginalMorrigan implements Morrigan{

  public void display() {
    System.out.println("初始化状态的莫妮卡");
  }
}
// 拥有变形功能，获取额为的装扮
abstract class Changer implements Morrigan{
  private Morrigan morrigan;

  public Changer(Morrigan morrigan) {
    this.morrigan = morrigan;
  }
  public void display(){
    morrigan.display();
  }
}

// 定义具体的角色套装
class Succubus extends Changer{

  public Succubus(Morrigan morrigan) {
    super(morrigan);
  }

  public void setChanger(){
    System.out.println("设置女妖装扮");
  }
  @Override
  public void display() {
    super.display();
    setChanger();
  }
}

// 定义具体的角色套装
class Grirl extends Changer{

  public Grirl(Morrigan morrigan) {
    super(morrigan);
  }

  public void setChanger(){
    System.out.println("设置少女装扮");
  }
  @Override
  public void display() {
    super.display();
    setChanger();
  }
}

class MorriganTest{
  public static void main(String[] args) {
    Morrigan morrigan = new OriginalMorrigan();
    Changer changer = new Grirl(morrigan);
    changer.display();
  }
}
