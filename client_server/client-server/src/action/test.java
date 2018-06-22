/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.ResponseWorker;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 展贝
 */
public class test {
    static Map<String,String> m=new HashMap<String,String>();
    public static void setMap(){
       m.put("1", "zhanbei");
       m.put("2", "zhang");
    }
    public static Map getMap(){
        setMap();
        return m;
    }
}
