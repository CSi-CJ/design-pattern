package com.design.pattern.stragey;

import java.util.HashMap;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/22 10:18
 * **************************************************
 */
public interface Strategy {
  public void strategyMethod();
}

class ConcreteStrategy1 implements Strategy{

  public void strategyMethod() {
    System.out.println("使用深度优先算法");
  }
}
class ConcreteStrategy implements Strategy{

  public void strategyMethod() {
    System.out.println("使用广度优先算法");
  }
}

class Context{
  private Strategy strategy;

  public Strategy getStrategy() {
    return strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void strategyMethod(){
    strategy.strategyMethod();
  }
}
class StrategyTest{
  public static void main(String[] args) {
    Context context = new Context();
    context.setStrategy(new ConcreteStrategy());
    context.strategyMethod();
  }
}



class StrategyFactory{
  private HashMap<String,Strategy> strategies = new HashMap<String, Strategy>();
  public void put(String key,Strategy strategy){
      strategies.put(key, strategy);
  }
  public Strategy get(String key){
    Strategy strategy = strategies.get(key);
    return strategy;
  }
  public void strategyMethod(String key){
    strategies.get(key).strategyMethod();
  }
}
