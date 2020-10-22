package com.design.pattern.chainOfResponsibility;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 13:54
 * **************************************************
 */
public class ChainOfResponsibility {
  public static void main(String[] args) {
    ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
    ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();
    concreteHandler1.setNext(concreteHandler2);
    concreteHandler1.handlerRequest("shuqi");
  }
}

// 定义一个接受处理请求的接口
abstract class Handler{
  private Handler next;

  public Handler getNext() {
    return next;
  }

  public void setNext(Handler next) {
    this.next = next;
  }

  // 接受请求
  public abstract void handlerRequest(String request);
}



// 定义所有能处理请求的对象，每个对象能够处理请求的级别不同、
class ConcreteHandler1 extends Handler{

  public void handlerRequest(String request) {
    if (request.equals("guanzhilin")){
      System.out.println("具体处理器1可以处理"+ request);
    }else {
      if (getNext()!=null){
        getNext().handlerRequest(request);
      }else {
        System.out.println("没人处理该请求");
      }
    }
  }
}

class ConcreteHandler2 extends Handler{
  public void handlerRequest(String request) {
    if (request.equals("shuqi")){
      System.out.println("具体处理器2可以处理"+request);
    }else {
      if (getNext()!=null){
        getNext().handlerRequest(request);
      }else {
        System.out.println("没人处理该请求");
      }
    }
  }
}


