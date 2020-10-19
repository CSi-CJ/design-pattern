package com.design.pattern.adapter;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 14:24
 * **************************************************
 */
public class ClassAdapter extends Adaptee implements Target {
  public void request() {
    super.specificRequest();
  }
}

// 目标接口
interface Target {
  public void request();
}

// 适配者
class Adaptee {
  public void specificRequest() {
    System.out.println("发出具体请求");
  }
}

class ClassAdapterTest {
  public static void main(String[] args) {
    ClassAdapter classAdapter = new ClassAdapter();
    classAdapter.request();
  }
}

