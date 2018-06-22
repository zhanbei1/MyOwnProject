
import action.OutStreamSocket;
import static action.OutStreamSocket.getMap;
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
public class WorkingPanel extends javax.swing.JPanel {

    public WorkingPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InWorking = new javax.swing.JButton();
        OutWorking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserInfo = new javax.swing.JTextArea();

        InWorking.setText("上班签到");
        InWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InWorkingMouseClicked(evt);
            }
        });

        OutWorking.setText("下班打卡");

        UserInfo.setColumns(20);
        UserInfo.setRows(5);
        jScrollPane1.setViewportView(UserInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(InWorking)
                        .addGap(40, 40, 40)
                        .addComponent(OutWorking))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InWorking)
                    .addComponent(OutWorking))
                .addGap(137, 137, 137))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InWorkingMouseClicked
        // TODO add your handling code here:
        Object source = evt.getSource();
        if (source == InWorking) {
            try {
                Worker w=new Worker();
                w.setId((String) getMap().get("id"));
                w.setPass((String) getMap().get("pass"));
                w.setStatus("InWorking");
                OutStreamSocket out = new OutStreamSocket();
                if ((out.OutStream(w).getStatus()).equals("InWorking")) {
                    UserInfo.setText("签到");
                }
                if ((out.OutStream(w).getStatus()).equals("outWorking")) {
                    UserInfo.setText("签到失败");
                }
                //System.out.println(out.OutStream(w).getStatus());
            } catch (IOException ex) {
                Logger.getLogger(WorkingPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_InWorkingMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InWorking;
    private javax.swing.JButton OutWorking;
    private javax.swing.JTextArea UserInfo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
