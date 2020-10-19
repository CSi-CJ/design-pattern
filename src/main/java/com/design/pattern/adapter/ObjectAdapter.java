package com.design.pattern.adapter;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 14:29
 * **************************************************
 */
public class ObjectAdapter implements ObjectTarget{
  private ObjectAdaptee adaptee;
  public ObjectAdapter(ObjectAdaptee objectAdaptee){
    this.adaptee = objectAdaptee;
  }
  public void request() {
    adaptee.specificRequest();
  }
}


interface ObjectTarget{
  public void request();
}

// 创建适配者
class ObjectAdaptee{
  public void specificRequest(){
    System.out.println("对象适配者发出请求");
  }
}



class ObjectAdapterTest{
  public static void main(String[] args) {
    ObjectAdaptee adaptee = new ObjectAdaptee();
    ObjectAdapter objectAdapter = new ObjectAdapter(adaptee);
    objectAdapter.request();
  }
}
