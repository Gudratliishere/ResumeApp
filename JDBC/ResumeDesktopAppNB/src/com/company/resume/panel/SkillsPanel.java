/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.panel;

import com.company.resume.config.Config;
import com.company.resume.dao.inter.SkillDaoInter;
import com.company.resume.dao.inter.UserSkillDaoInter;
import com.company.resume.etinity.Skill;
import com.company.resume.etinity.UserSkill;
import com.company.resume.main.Context;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author x
 */
public class SkillsPanel extends javax.swing.JPanel
{

    SkillDaoInter sdi = Context.instanceOfSkillDao();
    UserSkillDaoInter usdi = Context.instanceOfUserSkillDao();

    public SkillsPanel()
    {
        initComponents();
    }

    public void fillComponents()
    {
        fillComponentsInformation();
        fillUserInformation();
    }

    private void fillComponentsInformation()
    {
        fillSkills();
    }

    List<UserSkill> listUSkills = null;

    private void fillUserInformation()
    {
        listUSkills = usdi.getAllSkillByUserId(Config.loggedInUser.getId());

        Vector columnVector = new Vector();

        for (UserSkill us : listUSkills)
        {
            Vector row = new Vector();
            row.add(us.getSkill());
            row.add(us.getPower());
            columnVector.add(row);
        }

        Vector<String> columnName = new Vector<>();
        columnName.add("Name");
        columnName.add("Power");

        DefaultTableModel model = new DefaultTableModel(columnVector, columnName);
        tblSkills.setModel(model);
    }

    private void fillSkills()
    {
        cbSkills.removeAllItems();

        List<Skill> listSkills = sdi.getAll();

        for (Skill skill : listSkills)
            cbSkills.addItem(skill);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        spSkills = new javax.swing.JScrollPane();
        tblSkills = new javax.swing.JTable();
        lblSelectSkill = new javax.swing.JLabel();
        cbSkills = new javax.swing.JComboBox<>();
        tfSkill = new javax.swing.JTextField();
        btnAddSkill = new javax.swing.JButton();
        btnDeleteSkill = new javax.swing.JButton();
        sdrPower = new javax.swing.JSlider();
        btnAddNewSkill = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(649, 271));

        spSkills.setAutoscrolls(true);

        tblSkills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        tblSkills.setNextFocusableComponent(btnDeleteSkill);
        spSkills.setViewportView(tblSkills);

        lblSelectSkill.setText("Select your skill");

        tfSkill.setForeground(new java.awt.Color(102, 102, 102));
        tfSkill.setText("Can't you find your skill? Write here!");
        tfSkill.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                tfSkillFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                tfSkillFocusLost(evt);
            }
        });

        btnAddSkill.setText("Add");
        btnAddSkill.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddSkillActionPerformed(evt);
            }
        });

        btnDeleteSkill.setText("Delete");
        btnDeleteSkill.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteSkillActionPerformed(evt);
            }
        });

        sdrPower.setMaximum(10);
        sdrPower.setMinimum(1);

        btnAddNewSkill.setText("Add skill");
        btnAddNewSkill.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddNewSkillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfSkill)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSelectSkill)
                        .addGap(14, 14, 14)
                        .addComponent(cbSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddSkill)
                        .addGap(10, 10, 10)
                        .addComponent(btnAddNewSkill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSkill))
                    .addComponent(sdrPower, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(spSkills, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSelectSkill)
                        .addComponent(cbSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sdrPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSkill)
                    .addComponent(btnDeleteSkill)
                    .addComponent(btnAddNewSkill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spSkills, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSkillActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddSkillActionPerformed
    {//GEN-HEADEREND:event_btnAddSkillActionPerformed

        Skill skill = (Skill) cbSkills.getSelectedItem();

        UserSkill userSkill = new UserSkill(1, Config.loggedInUser, skill, sdrPower.getValue());
        boolean addUserSkill = usdi.addUserSkill(userSkill);
        if (addUserSkill)
            JOptionPane.showMessageDialog(null, "New skill (" + skill.getName() + ") was added!");
        else
            JOptionPane.showMessageDialog(null, "There is a problem. New skill (" + skill.getName() + ") was not added!");

        fillUserInformation();
    }//GEN-LAST:event_btnAddSkillActionPerformed

    private void tfSkillFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_tfSkillFocusGained
    {//GEN-HEADEREND:event_tfSkillFocusGained
        if (tfSkill.getText().equals("Can't you find your skill? Write here!"))
        {
            tfSkill.setText("");
            tfSkill.setForeground(Color.black);
        }
    }//GEN-LAST:event_tfSkillFocusGained

    private void tfSkillFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_tfSkillFocusLost
    {//GEN-HEADEREND:event_tfSkillFocusLost
        if (tfSkill.getText().isEmpty())
        {
            tfSkill.setText("Can't you find your skill? Write here!");
            tfSkill.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_tfSkillFocusLost

    private void btnAddNewSkillActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddNewSkillActionPerformed
    {//GEN-HEADEREND:event_btnAddNewSkillActionPerformed
        if (!tfSkill.getText().isEmpty() && !tfSkill.getText().equals("Can't you find your skill? Write here!"))
        {
            Skill skill = new Skill(1, tfSkill.getText());
            if (!sdi.existSkill(skill))
                sdi.addSkill(skill);
            JOptionPane.showMessageDialog(null, "New skill was added!\nPlease select from items!");
        } else
            JOptionPane.showMessageDialog(null, "Please write skill correctly!");

        fillComponentsInformation();
    }//GEN-LAST:event_btnAddNewSkillActionPerformed

    private void btnDeleteSkillActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteSkillActionPerformed
    {//GEN-HEADEREND:event_btnDeleteSkillActionPerformed
        int index = tblSkills.getSelectedRow();
        UserSkill userSkill = listUSkills.get(index);
        boolean removeUS = usdi.removeUserSkill(userSkill.getId());

        if (removeUS)
            JOptionPane.showMessageDialog(null, "Skill succesfully was deleted!");
        else
            JOptionPane.showMessageDialog(null, "Skill can not deleted!");

        fillUserInformation();
    }//GEN-LAST:event_btnDeleteSkillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewSkill;
    private javax.swing.JButton btnAddSkill;
    private javax.swing.JButton btnDeleteSkill;
    private javax.swing.JComboBox<Skill> cbSkills;
    private javax.swing.JLabel lblSelectSkill;
    private javax.swing.JSlider sdrPower;
    private javax.swing.JScrollPane spSkills;
    private javax.swing.JTable tblSkills;
    private javax.swing.JTextField tfSkill;
    // End of variables declaration//GEN-END:variables
}
