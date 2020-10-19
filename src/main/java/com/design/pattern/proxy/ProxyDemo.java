package com.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 13:45
 * **************************************************
 */
public class ProxyDemo {
  public static void main(String[] args) {
    Proxy proxy = new Proxy();
    proxy.request();
  }
}

// define abstract object
abstract class Subject{
  abstract void request();
}

// define conCreate real object
class RealSubject extends Subject{

  void request() {
    System.out.println("realSubject发出请求");
  }
}
// construct proxy object
class Proxy{
  private RealSubject realSubject = new RealSubject();

  // use Aop concept increase proxy method

  public void preRequest(){
    System.out.println("proxy send to preRequest");
  }

  public void request(){
    System.out.println("proxy instead of realSubject send to Request");
    realSubject.request();
  }

  public void postRequest(){
    System.out.println("proxy send to postRequest");
  }
}


class DyProxy implements InvocationHandler{
  private Object obj;

  public DyProxy(Object obj){
    this.obj = obj;
  }

  public RealSubject invoke(Object proxy, Method method, Object[] args) throws Throwable {
    RealSubject obj = (RealSubject)method.invoke(this.obj,args);
    return obj;
  }
}

class Test{
  public static void main(String[] args) {
    DyProxy dyProxy = new DyProxy(new RealSubject());
  }
}
