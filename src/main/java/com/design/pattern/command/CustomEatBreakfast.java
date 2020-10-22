package com.design.pattern.command;

import java.util.ArrayList;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 11:13
 * **************************************************
 */
public class CustomEatBreakfast {
  public static void main(String[] args) {
    Waiter waiter = new Waiter();
    waiter.setHuFen(new HeFen());
    waiter.chooseHuFen();

    // 调用扩展组合模式
    CompositeInvoker compositeInvoker = new CompositeInvoker();
    compositeInvoker.addBreakfast(new HunDun());
    compositeInvoker.cooking();
  }
}


interface Breakfast{
  public void cooking();
}

// 相当于具体命令
class ChangFen implements Breakfast{
  private ChangFenChef changFenChef = new ChangFenChef();
  public void cooking() {
    changFenChef.cooking();
  }
}

class HunDun implements Breakfast{
  private HunDunChef hunDunChef = new HunDunChef();
  public void cooking() {
    hunDunChef.cooking();
  }
}

class HeFen implements Breakfast{
  private HeFenChef heFenChef = new HeFenChef();
  public void cooking() {
    heFenChef.cooking();
  }
}

// 相当于命令接收者
class ChangFenChef{
  public void cooking(){
    System.out.println("肠粉厨师开始制作肠粉");
  }
}
class HunDunChef{
  public void cooking(){
    System.out.println("混沌厨师开始制作馄饨");
  }
}

class HeFenChef{
  public void cooking(){
    System.out.println("河粉厨师开始制作河粉");
  }
}

// 服务员相当于调用者
class Waiter{
  private Breakfast changFen,hunDun,huFen;

  public void setChangFen(Breakfast changFen) {
    this.changFen = changFen;
  }

  public void setHunDun(Breakfast hunDun) {
    this.hunDun = hunDun;
  }

  public void setHuFen(Breakfast huFen) {
    this.huFen = huFen;
  }

  public void chooseChangFen(){
    System.out.println("客人点了肠粉");
    changFen.cooking();
  }

  public void chooseHunDun(){
    System.out.println("客人点了混沌");
    hunDun.cooking();
  }
  public void chooseHuFen(){
    System.out.println("客人点了河粉");
    huFen.cooking();
  }
}

// 扩展，与组合模式一起使用
class CompositeInvoker implements Breakfast{
  private ArrayList<Breakfast> breakfasts = new ArrayList<Breakfast>();
  public void addBreakfast(Breakfast breakfast){
    System.out.println("客人组合点餐");
    breakfasts.add(breakfast);
  }
  public void removeBreak(Breakfast breakfast){
    breakfasts.remove(breakfast);
  }
  public void cooking() {
    for (Breakfast breakfast : breakfasts) {
      breakfast.cooking();
    }
  }
}
