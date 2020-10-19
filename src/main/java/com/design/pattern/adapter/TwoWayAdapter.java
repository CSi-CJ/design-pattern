package com.design.pattern.adapter;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 16:21
 * **************************************************
 */
public class TwoWayAdapter implements TwoWayAdaptee,TwoWayTarget{
  private TwoWayAdaptee twoWayAdaptee;
  private TwoWayTarget twoWayTarget;

  public TwoWayAdapter(TwoWayAdaptee twoWayAdaptee, TwoWayTarget twoWayTarget){
    this.twoWayAdaptee = twoWayAdaptee;
    this.twoWayTarget = twoWayTarget;
  }


  public void request(){
    this.twoWayAdaptee.specificRequest();
  }
  public void specificRequest(){
    this.twoWayTarget.request();
  }
}
// 是适配者
interface TwoWayAdaptee{
  public void specificRequest();
}
// 目标实现
interface TwoWayTarget{
  public void request();
}

// 适配者实现
class AdapterRealize implements TwoWayAdaptee{

  public void specificRequest() {
    System.out.println("适配者实现输出");
  }
}
// 目标实现
class TargetRealize implements TwoWayTarget{

  public void request() {
    System.out.println("目标实现输出");
  }
}


// 客户端
class TwoWayClient{
  public static void main(String[] args) {
    AdapterRealize adaptee = new AdapterRealize();
    TargetRealize targetRealize = new TargetRealize();
    TwoWayAdapter twoWayAdapter1 = new TwoWayAdapter(adaptee, targetRealize);
    twoWayAdapter1.request();
  }
}
