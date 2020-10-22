package com.design.pattern.state;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 15:13
 * **************************************************
 */
public class EvaluateSystem {
}

// 指定环境类
class ScoreContext{
  private AbstractState state;

  public ScoreContext(AbstractState state) {
    this.state = state;
  }

  public AbstractState getState() {
    return state;
  }

  public void setState(AbstractState state) {
    this.state = state;
  }
  public void add(int score){
    state.add(score);
  }
}

abstract class AbstractState{
  protected ScoreContext hj;
  protected String stateName;
  protected int score;
  public abstract void checkState();
  public void add(int score){
    this.score+=score;
    System.out.print("加上："+score +"分，\t当前分数："+this.score );
    checkState();
    System.out.println("分，\t当前状态："+hj.getState().stateName);
  }
}


class HighState extends AbstractState{
  public HighState(AbstractState state) {

  }

  public void checkState() {
    System.out.println("当前状态为优秀");

  }
}
class LowState extends AbstractState{
  public LowState(AbstractState state) {

  }

  public LowState(ScoreContext h) {
    hj = h;

  }
  public void checkState() {
    System.out.println("当前状态为不及格");

  }
}

class MiddleState extends AbstractState{
  public MiddleState(AbstractState state) {

  }

  public void checkState() {
    System.out.println("当前状态为中等");

  }
}

