/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.user.main;

import com.company.resume.dao.inter.UserDaoInter;
import com.company.resume.dao.inter.UserLoginDaoInter;
import com.company.resume.main.Context;
import com.company.resume.user.config.Config;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Dunay Gudratli
 */
public class User extends javax.swing.JFrame
{

    UserDaoInter udi = Context.instanceOfUserDao();

    public User()
    {
        setLocationRelativeTo(null);

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

        initComponents();

        fillComponents();

        setTitle("User Information");

        pnlProfileDescription.fillComponents();
        pnlDetails.fillComponents();
        pnlSkills.fillComponents();
        pnlEmploymentHistory.fillComponents();
    }

    private void fillComponents()
    {
        tfName.setText(Config.loggedInUser.getName());
        tfSurname.setText(Config.loggedInUser.getSurname());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnl_top = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfSurname = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        spDivide = new javax.swing.JSeparator();
        tbpInformation = new javax.swing.JTabbedPane();
        pnlProfileDescription = new com.company.resume.user.panel.ProfileDescriptionPanel();
        pnlDetails = new com.company.resume.user.panel.DetailsPanel();
        pnlSkills = new com.company.resume.user.panel.SkillsPanel();
        pnlEmploymentHistory = new com.company.resume.user.panel.EmploymentHistoryPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setName("User Information"); // NOI18N
        setSize(new java.awt.Dimension(800, 600));

        pnl_top.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblName.setText("Name");

        lblSurname.setText("Surname");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblSurname))
                .addGap(35, 35, 35)
                .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(tfName))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname)
                    .addComponent(tfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tbpInformation.addTab("Profile description", pnlProfileDescription);
        tbpInformation.addTab("Details", pnlDetails);
        tbpInformation.addTab("Skillls", pnlSkills);
        tbpInformation.addTab("Employment History", pnlEmploymentHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDivide)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tbpInformation)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbpInformation))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = tfName.getText();
        String surname = tfSurname.getText();

        Config.loggedInUser.setName(name);
        Config.loggedInUser.setSurname(surname);
        pnlProfileDescription.saveUserInformation();
        pnlDetails.saveUserInformation();
        pnlEmploymentHistory.saveUserInformation();

        try
        {
            if (Config.loggedInUser.getId() == null) Config.loggedInUser.setId(0);
            if (udi.getUserById(Config.loggedInUser.getId()) == null)
            {
                udi.addUser(Config.loggedInUser);
                Config.login.setUser(Config.loggedInUser);
                
                UserLoginDaoInter loginDao = Context.instanceOfUserLoginDao();
                loginDao.updateLogin(Config.login);
            }
            
            udi.updateUser(Config.loggedInUser);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Name, surname, phone and email can not be empty!");
            return;
        }
    }//GEN-LAST:event_btnSaveActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainUser().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private com.company.resume.user.panel.DetailsPanel pnlDetails;
    private com.company.resume.user.panel.EmploymentHistoryPanel pnlEmploymentHistory;
    private com.company.resume.user.panel.ProfileDescriptionPanel pnlProfileDescription;
    private com.company.resume.user.panel.SkillsPanel pnlSkills;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JSeparator spDivide;
    private javax.swing.JTabbedPane tbpInformation;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSurname;
    // End of variables declaration//GEN-END:variables
}
