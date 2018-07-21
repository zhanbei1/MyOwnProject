/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobang;

/**
 *
 * @author 展贝
 */
import java.awt.Color;
import java.io.Serializable;
/**
 * 棋子类
 */
public class Point implements Serializable{
  private int x;//棋盘中的x索引
  private int y;//棋盘中的y索引
  private Color color;//颜色
  public static final int DIAMETER=30;//直径
  
  public Point(int x,int y,Color color){
	  this.x=x;
	  this.y=y;
	  this.color=color;
  } 
  
  public int getX(){//拿到棋盘中x的索引
	  return x;
  }
  public int getY(){
	  return y;
  }
  public Color getColor(){//获得棋子的颜色
	  return color;
  }
}
