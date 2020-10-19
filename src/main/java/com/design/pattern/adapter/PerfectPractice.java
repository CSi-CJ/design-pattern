package com.design.pattern.adapter;

import com.sun.xml.internal.ws.util.xml.XMLStreamReaderToXMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/19 14:42
 * **************************************************
 */
public class PerfectPractice {
}

interface Motor {
  public void drive();
}

// 适配者1
class ElectricMotor {
  public void electricDrive() {
    System.out.println("电能驱动");
  }
}

// 适配者2
class OpticalMotor {
  public void opticalDrive() {
    System.out.println("光能驱动");
  }
}

// 适配器1
class ElectricAdapter implements Motor {
  private ElectricMotor electricMotor;

  public ElectricAdapter(ElectricMotor electricMotor){
    this.electricMotor = electricMotor;
  }
  public void drive() {
    this.electricMotor.electricDrive();
  }
}

// 适配器2
class OpticalAdapter implements Motor {
  private OpticalMotor opticalMotor;

  public OpticalAdapter(OpticalMotor opticalMotor){
    this.opticalMotor = opticalMotor;
  }
  public void drive() {
    this.opticalMotor.opticalDrive();
  }
}



class ReadXML{
  public static Object getObject(){
    try {
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = null;
      documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document doc = documentBuilder.parse(new File("D:/2020.11/java.design.pattern/src/main/resources/config.xml"));
      NodeList nl = doc.getElementsByTagName("className");
      Node classNode = nl.item(0).getFirstChild();
      System.out.println(classNode);
      String cName = classNode.getNodeValue();
      System.out.println(cName);
      Class<?> aClass = Class.forName(cName);
      return aClass.newInstance();
    } catch (Exception e) {
      return null;
    }
  }
}
class MotorAdapterTest{
  public static void main(String[] args) {
    Motor motor = (Motor)ReadXML.getObject();
    motor.drive();
  }
}

