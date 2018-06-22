/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.Serializable;
/**
 *
 * @author 展贝
 */
public class ResponseWorker implements Serializable{
    private static final long serialVersionUID=1L;
    private String pass;
    private String id;
    private String status="check";
    private static final String check="check";
    //如果想要有不被序列化的属性的时候可以添加transient
    
    public ResponseWorker(String name, String id, String status) {
        this.pass = pass;
        this.id = id;
        this.status = status;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String name) {
        this.pass = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
