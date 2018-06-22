/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.ResponseWorker;
import beans.Worker;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 展贝
 */
public class InStreamSocket {

    private static final Logger logger = Logger.getLogger(ServerSocket.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        while (true) {
            logger.info("server Socket start");
            Socket socket = server.accept();
            invoke(socket);
        }
    }

    public static void invoke(final Socket socket) {
        new Thread(
                new Runnable() {
            public void run() {
                ObjectInputStream objectIn = null;
                ObjectOutputStream objectOut = null;
                ResponseWorker res = new ResponseWorker();
                try {
                    objectIn = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                    objectOut = new ObjectOutputStream(socket.getOutputStream());
                    Object obj = objectIn.readObject();
                    Worker w = (Worker) obj;
                    //System.out.printf(w.getPass());
                    if (w.getStatus().equals("check")) {
                        DBAction db = new DBAction();
                        if (db.check(w)) {
                            res.setId(w.getId());
                            res.setPass(w.getPass());
                            res.setStatus("in");
                        } else {
                            res.setId(w.getId());
                            res.setPass(w.getPass());
                            res.setStatus(w.getStatus());
                            
                        }
                    }
                    if(w.getStatus().equals("InWorking")){
                        DBAction db=new DBAction();
                        if (db.InWorking(w)) {
                            res.setId(w.getId());
                            res.setPass(w.getPass());
                            res.setStatus("InWorking");
                        } else {
                            res.setId(w.getId());
                            res.setPass(w.getPass());
                            res.setStatus("InWorkingFalse");
                            
                        }
                    }
                    objectOut.writeObject(res);
                    objectOut.flush();//刷新输出流                          
                } catch (IOException ex) {
                    Logger.getLogger(InStreamSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InStreamSocket.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        objectIn.close();
                        objectOut.close();
                    } catch (IOException ex) {
                        Logger.getLogger(InStreamSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
        ).start();
    }
}
