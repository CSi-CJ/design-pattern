package com.design.pattern.facade;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/20 10:54
 * **************************************************
 */
public class WySpcialty implements TreeSelectionListener {
  private Specialty1 specialty1 = new Specialty1();
  private Specialty2 specialty2 = new Specialty2();
  private Specialty3 specialty3 = new Specialty3();
  private Specialty4 specialty4 = new Specialty4();
  private Specialty5 specialty5 = new Specialty5();
  private Specialty6 specialty6 = new Specialty6();
  private Specialty7 specialty7 = new Specialty7();
  private Specialty8 specialty8 = new Specialty8();
  public WySpcialty(){}

  public void valueChanged(TreeSelectionEvent e) {
    specialty1.producer();
    specialty2.producer();
    specialty3.producer();
    specialty4.producer();
    specialty5.producer();
    specialty6.producer();
    specialty7.producer();
    specialty8.producer();
  }
}

class Specialty1 extends ImageIcon {
  public void producer(){
    System.out.println("生产荷包红li鲤");
}
}
class Specialty2 extends ImageIcon {
  public void producer(){
    System.out.println("绥远绿茶");
  }
}
class Specialty3 extends ImageIcon {
  public void producer(){
    System.out.println("龙尾馆");
  }
}
class Specialty4 extends ImageIcon {
  public void producer(){
    System.out.println("随便什么");
  }
}class Specialty5 extends ImageIcon {
  public void producer(){
    System.out.println("紫霞仙子");
  }
}
class Specialty6 extends ImageIcon {
  public void producer(){
    System.out.println("青霞");
  }
}
class Specialty7 extends ImageIcon {
  public void producer(){
    System.out.println("至尊宝");
  }
}
class Specialty8 extends ImageIcon {
  public void producer(){
    System.out.println("青牙牙");
  }
}


