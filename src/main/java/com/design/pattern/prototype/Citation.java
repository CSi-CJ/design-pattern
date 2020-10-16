package com.design.pattern.prototype;

import lombok.Data;

/**
 * **************************************************
 *
 * @Description TODO
 * @Author CSi
 * @Date 2020/10/16 10:43
 * **************************************************
 */
@Data
public class Citation implements Cloneable{
  private String name;
  private String info;
  private String college;

  public Citation(String name, String info, String college) {
    this.name = name;
    this.info = info;
    this.college = college;
  }

  public Object clone() throws CloneNotSupportedException {
    Citation cloneObj = (Citation) super.clone();
    return cloneObj;
  }
  public void display(){
    System.out.println(name+info+college);
  }
}

class PrototypeCitation{
  public static void main(String[] args) throws CloneNotSupportedException {
    Citation citation = new Citation("徐雅", "特别好看", "呆在家");
    Citation cloneXY = (Citation)citation.clone();
    citation.display();
    cloneXY.setName("Winter");
    cloneXY.display();
  }
}
