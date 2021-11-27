/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.panel;

import com.company.resume.config.Config;
import com.company.resume.dao.inter.EmploymentHistoryDaoInter;
import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.main.Context;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author x
 */
public class EmploymentHistoryPanel extends javax.swing.JPanel
{

    EmploymentHistoryDaoInter ehdi = Context.instanceOfEmploymentHistoryDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    EmploymentHistory employmentHistory = null;

    List<EmploymentHistory> listEH = null;

    public EmploymentHistoryPanel()
    {
        initComponents();
    }

    public void fillComponents()
    {
        fillComponentsInformation();

        employmentHistory = (EmploymentHistory) cbEmploymentHistory.getSelectedItem();

        fillUserInformation();
    }

    private void fillComponentsInformation()
    {
        listEH = ehdi.getAllEmploymentHistoryByUserId(Config.loggedInUser.getId());

        cbEmploymentHistory.removeAllItems();

        for (EmploymentHistory eh : listEH)
            cbEmploymentHistory.addItem(eh);
    }

    private void fillUserInformation()
    {
        tfHeader.setText(employmentHistory.getHeader());
        taJobDescription.setText(employmentHistory.getJobDescription());

        Date beginDate = (Date) employmentHistory.getBeginDate();
        Date endDate = (Date) employmentHistory.getEndDate();

        String begindate, enddate;
        if (beginDate != null)
            begindate = sdf.format(beginDate);
        else
            begindate = "Present";

        if (endDate != null)
            enddate = sdf.format(endDate);
        else
            enddate = "Present";

        tfBegindate.setText(begindate);
        tfEnddate.setText(enddate);
    }

    public void saveUserInformation()
    {
        fillEmploymentHistory(employmentHistory);

        ehdi.updateEmploymentHistory(employmentHistory);
    }

    private void fillEmploymentHistory(EmploymentHistory employmentHistory)
    {
        employmentHistory.setHeader(tfHeader.getText());
        employmentHistory.setJobDescription(taJobDescription.getText());

        java.sql.Date beginDate = null, endDate = null;
        try
        {
            String begindate = tfBegindate.getText();
            String enddate = tfEnddate.getText();
            if (!begindate.isEmpty() && !begindate.equals("Present"))
                beginDate = new java.sql.Date(sdf.parse(begindate).getTime());
            else
                beginDate = null;

            if (!enddate.isEmpty() && !enddate.equals("Present"))
                endDate = new java.sql.Date(sdf.parse(enddate).getTime());
            else
                endDate = null;

        } catch (ParseException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        employmentHistory.setBeginDate(beginDate);
        employmentHistory.setEndDate(endDate);
        employmentHistory.setUser(Config.loggedInUser);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblHeader = new javax.swing.JLabel();
        tfHeader = new javax.swing.JTextField();
        tfBegindate = new javax.swing.JTextField();
        lblBegindate = new javax.swing.JLabel();
        tfEnddate = new javax.swing.JTextField();
        lblEnddate = new javax.swing.JLabel();
        lblJobDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taJobDescription = new javax.swing.JTextArea();
        cbEmploymentHistory = new javax.swing.JComboBox<>();
        btnShow = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        lblHeader.setText("Header");

        lblBegindate.setText("Begin date");

        lblEnddate.setText("Begin date");

        lblJobDescription.setText("Job description");

        taJobDescription.setColumns(20);
        taJobDescription.setRows(5);
        jScrollPane1.setViewportView(taJobDescription);

        btnShow.setText("Show");
        btnShow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnShowActionPerformed(evt);
            }
        });

        btnAdd.setText("Add new one");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJobDescription)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBegindate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEnddate, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEnddate, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(tfBegindate)
                            .addComponent(tfHeader))))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(cbEmploymentHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEmploymentHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShow)
                    .addComponent(btnAdd))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBegindate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfBegindate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnddate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEnddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblJobDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnShowActionPerformed
    {//GEN-HEADEREND:event_btnShowActionPerformed
        employmentHistory = (EmploymentHistory) cbEmploymentHistory.getSelectedItem();

        fillUserInformation();
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        EmploymentHistory employmentHistory = new EmploymentHistory();

        fillEmploymentHistory(employmentHistory);

        boolean result = ehdi.addEmploymentHistory(employmentHistory);

        if (result)
            JOptionPane.showMessageDialog(null, "New job was succesfully added!");
        else
            JOptionPane.showMessageDialog(null, "New job could not added!");

        fillComponentsInformation();
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox<EmploymentHistory> cbEmploymentHistory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBegindate;
    private javax.swing.JLabel lblEnddate;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblJobDescription;
    private javax.swing.JTextArea taJobDescription;
    private javax.swing.JTextField tfBegindate;
    private javax.swing.JTextField tfEnddate;
    private javax.swing.JTextField tfHeader;
    // End of variables declaration//GEN-END:variables
}
