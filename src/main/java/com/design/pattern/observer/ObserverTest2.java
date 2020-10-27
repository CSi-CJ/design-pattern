package com.design.pattern.observer;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/23 10:00
 * **************************************************
 */
public class ObserverTest2 {
  public static void main(String[] args) {
    BellEventSource bellEventSource = new BellEventSource();
    TeacherEventListener teacherEventListener = new TeacherEventListener();
    StudentEventListener studentEventListener = new StudentEventListener();
    bellEventSource.addListener(teacherEventListener);
    bellEventSource.addListener(studentEventListener);
    bellEventSource.ring(true);
  }
}

class RingEvent extends EventObject{
  private static final long serialVersionUID=1L;
  private boolean sound;
  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public RingEvent(Object source, boolean sound) {
    super(source);
    this.sound = sound;
  }

  public boolean getSound() {
    return sound;
  }

  public void setSound(boolean sound) {
    this.sound = sound;
  }
}

interface BellEventListener extends EventListener {
  public void heardBell(RingEvent e);
}

class TeacherEventListener implements BellEventListener{

  public void heardBell(RingEvent e) {
    if (e.getSound()){
      System.out.println("老师听见铃声进入教室");
    }else{
      System.out.println("老师继续在办公室休息");
    }
  }
}

class StudentEventListener implements BellEventListener{

  public void heardBell(RingEvent e) {
    if (e.getSound()){
      System.out.println("学生听见铃声进入教室");
    }else {
      System.out.println("上课铃没响学生继续玩耍");
    }
  }
}
class BellEventSource{
  protected ArrayList<BellEventListener> listeners;
  public BellEventSource(){
    listeners = new ArrayList<BellEventListener>();
  }
  public void addListener(BellEventListener listener){
    listeners.add(listener);
  }
  public void removeListener(BellEventListener listener){
    listeners.remove(listener);
  }
  public void ring(boolean sound){
    String type = sound ? "上课铃" : "下课铃";
    System.out.println(type + "响了");
    RingEvent ringEvent = new RingEvent(this,sound);
    notifies(ringEvent);
  }

  public void notifies(RingEvent e){
    for (BellEventListener listener : listeners) {
      listener.heardBell(e);
    }
  }
}
