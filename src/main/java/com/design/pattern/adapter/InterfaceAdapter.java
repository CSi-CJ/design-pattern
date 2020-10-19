package com.design.pattern.adapter;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 17:43
 * **************************************************
 */
public interface InterfaceAdapter {
  public void operation1();
  public void operation2();
  public void operation3();
  public void operation4();
}

// 定义一个抽象类作为适配器对接口进行空实现
class AbstructClassAdapter implements InterfaceAdapter{

  public void operation1() {

  }

  public void operation2() {

  }

  public void operation3() {

  }

  public void operation4() {

  }
}


// 定义具体要使用的类
class Client{

  public static void main(String[] args) {
    AbstructClassAdapter abstructClassAdapter = new AbstructClassAdapter(){
      @Override
      public void operation1() {
        System.out.println("实现方法一");
      }
    };

    abstructClassAdapter.operation1();
  }
}
