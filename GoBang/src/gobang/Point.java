/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobang;

/**
 *
 * @author չ��
 */
import java.awt.Color;
import java.io.Serializable;
/**
 * ������
 */
public class Point implements Serializable{
  private int x;//�����е�x����
  private int y;//�����е�y����
  private Color color;//��ɫ
  public static final int DIAMETER=30;//ֱ��
  
  public Point(int x,int y,Color color){
	  this.x=x;
	  this.y=y;
	  this.color=color;
  } 
  
  public int getX(){//�õ�������x������
	  return x;
  }
  public int getY(){
	  return y;
  }
  public Color getColor(){//������ӵ���ɫ
	  return color;
  }
}
