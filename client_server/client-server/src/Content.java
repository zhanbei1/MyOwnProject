
import java.awt.BorderLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 展贝
 */
public class Content extends javax.swing.JFrame {
    public Content() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonPanel = new javax.swing.JPanel();
        LoginButton = new javax.swing.JButton();
        Working = new javax.swing.JButton();
        Salary = new javax.swing.JButton();
        Apply = new javax.swing.JButton();
        ShowPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setBounds(new java.awt.Rectangle(2, 2, 2, 2));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setName("ClientJFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 300));
        setSize(new java.awt.Dimension(500, 300));

        ButtonPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonPanel.setName(""); // NOI18N

        LoginButton.setText("登录");
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
        });

        Working.setText("打卡");
        Working.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WorkingMouseClicked(evt);
            }
        });

        Salary.setText("工资");
        Salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalaryMouseClicked(evt);
            }
        });

        Apply.setText("申请");

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoginButton))
                    .addGroup(ButtonPanelLayout.createSequentialGroup()
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Apply)
                            .addComponent(Working)
                            .addComponent(Salary))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ButtonPanelLayout.setVerticalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LoginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Working)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apply)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        getContentPane().add(ButtonPanel, java.awt.BorderLayout.WEST);

        ShowPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ShowPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(ShowPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        LoginPanel login=new LoginPanel();
        addShowPanel(login);
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void WorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WorkingMouseClicked
        WorkingPanel workingPanel=new WorkingPanel();
       addShowPanel(workingPanel);
    }//GEN-LAST:event_WorkingMouseClicked

    private void SalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalaryMouseClicked
        SalaryPanel salary=new SalaryPanel();
        addShowPanel(salary);
    }//GEN-LAST:event_SalaryMouseClicked
    private void addShowPanel(javax.swing.JPanel  PanelName){
        ShowPanel.removeAll();
        ShowPanel.add(PanelName,BorderLayout.CENTER);
        ShowPanel.revalidate();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Content().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apply;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton Salary;
    private javax.swing.JPanel ShowPanel;
    private javax.swing.JButton Working;
    // End of variables declaration//GEN-END:variables
}
