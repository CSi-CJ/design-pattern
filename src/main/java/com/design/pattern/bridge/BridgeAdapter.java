package com.design.pattern.bridge;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 18:51
 * **************************************************
 */
public class BridgeAdapter {
  public static void main(String[] args) {
    PuzzleInter puzzleInter = new ObjectAdapter(new BridgeAdaptee());
    AbstractRole abstractRole = new RefinedAbstractionRole(puzzleInter);
    abstractRole.operation();
  }
}
// 抽象接口
interface PuzzleInter{
  public void operationImpl();
}

// 抽象话角色

abstract class AbstractRole{
  private PuzzleInter puzzleInter;

  public AbstractRole(PuzzleInter puzzleInter){
    this.puzzleInter = puzzleInter;
  }

  public abstract void operation();
}

// 抽象化扩展角色
class RefinedAbstractionRole extends AbstractRole{

  public RefinedAbstractionRole(PuzzleInter puzzleInter) {
    super(puzzleInter);
  }

  public void operation() {
    System.out.println("扩展的抽象化角色");
  }
}

// 具体实现角色
class ImplInter implements  PuzzleInter{

  public void operationImpl() {
    System.out.println("桥接模式的具体实现");
  }
}

// 适配者
class BridgeAdaptee{
  public void specificRequest(){
    System.out.println("适配者发出的请求");
  }
}

// 适配器
class ObjectAdapter extends ImplInter{
  private BridgeAdaptee bridgeAdaptee;
  public ObjectAdapter(BridgeAdaptee bridgeAdaptee){
    this.bridgeAdaptee = bridgeAdaptee;
  }
  public void operationImpl() {
    bridgeAdaptee.specificRequest();
  }
}
