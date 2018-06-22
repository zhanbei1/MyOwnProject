/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.ResponseWorker;
import beans.Worker;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 展贝
 */
public class OutStreamSocket {

    private Socket socket;
    private final String ip = "192.168.17.1";
    private final int port = 80;

    ObjectOutputStream objectOut = null;
    ObjectInputStream objectIn = null;

    static ResponseWorker res = null;
    static Map<String,String> m=new HashMap<String,String>();
    
    public OutStreamSocket() {
    }

    public ResponseWorker OutStream(Worker w) throws IOException {
        try {
            //建立连接
            socket = new Socket(ip, port);
            //序列化对象，并向服务器传输对象
            objectOut = new ObjectOutputStream(socket.getOutputStream());
            objectOut.writeObject(w);
            objectOut.flush();//刷新流。这将写入所有缓冲的输出字节，并刷新到基础流。
            //System.out.println(w.getPass());
            //接受服务器返回来的对象
            objectIn = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

            Object obj = objectIn.readObject();
            if (obj != null) {
                res = (ResponseWorker) obj;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OutStreamSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException e) {  //如果不添加catch捕获EOFException，将会以异常抛出，使程序暂停
            System.out.println("对象传送完毕");
            objectOut.close();
            objectIn.close();
            socket.close();
        }
        return res;
    }
    public static Map getMap(){
        m.put("id",res.getId());
        m.put("pass", res.getPass());
        m.put("status", res.getStatus());
        return m;
    }
}
