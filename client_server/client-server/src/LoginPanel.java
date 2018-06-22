
import action.OutStreamSocket;
import beans.Worker;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 展贝
 */
public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginIDLabel = new javax.swing.JLabel();
        LoginPassLabel = new javax.swing.JLabel();
        LoginId = new javax.swing.JTextField();
        LoginPassWord = new javax.swing.JPasswordField();
        LoginSubmit = new javax.swing.JButton();
        LoginCancel = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        LoginIDLabel.setText("编号：");

        LoginPassLabel.setText("密码：");

        LoginSubmit.setText("登录");
        LoginSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginSubmitActionPerformed(evt);
            }
        });

        LoginCancel.setText("取消");
        LoginCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginCancelMouseClicked(evt);
            }
        });

        statusLabel.setText("未登录");
        statusLabel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LoginPassLabel)
                            .addComponent(LoginIDLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoginId, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(LoginPassWord)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LoginSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(LoginCancel)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginIDLabel)
                    .addComponent(LoginId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginPassLabel)
                    .addComponent(LoginPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginSubmit)
                    .addComponent(LoginCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LoginSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginSubmitActionPerformed
        // TODO add your handling code here:
        Object source = evt.getSource();
        if (source == LoginSubmit) {
            try {
                Worker w = new Worker();
                w.setId(LoginId.getText());
                w.setPass(String.valueOf(LoginPassWord.getPassword()));
                //JPassWord.getText获取的是一个char数组，不易传送，更改为String类型，符合beans中的String pass
                //应该调用String.valueOf()这个方法就爱那个数组类型转化为字符串 

                OutStreamSocket out = new OutStreamSocket();
                if ((out.OutStream(w).getStatus()).equals("in")) {
                    statusLabel.setText("你已登录");
                } 
                if((out.OutStream(w).getStatus()).equals("out")) {
                    statusLabel.setText("账号或密码错误，请核对信息");
                }
                //System.out.println(out.OutStream(w).getStatus());
            } catch (IOException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_LoginSubmitActionPerformed

    private void LoginCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginCancelMouseClicked
        // TODO add your handling code here:
        LoginId.setText(null);
        LoginPassWord.setText(null);
    }//GEN-LAST:event_LoginCancelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginCancel;
    private javax.swing.JLabel LoginIDLabel;
    private javax.swing.JTextField LoginId;
    private javax.swing.JLabel LoginPassLabel;
    private javax.swing.JPasswordField LoginPassWord;
    private javax.swing.JButton LoginSubmit;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
