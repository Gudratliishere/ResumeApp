/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.user.panel;

import com.company.resume.user.config.Config;
import com.company.resume.dao.inter.CountryDaoInter;
import com.company.resume.etinity.Country;
import com.company.resume.main.Context;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author x
 */
public class DetailsPanel extends javax.swing.JPanel
{

    CountryDaoInter cdi = Context.instanceOfCountryDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DetailsPanel()
    {
        initComponents();
    }

    public void fillComponents()
    {
        fillComponentInformation();
        fillUserInformation();
    }

    private void fillComponentInformation()
    {
        fillBirthPlace();
        fillNationality();
    }

    private void fillBirthPlace()
    {
        List<Country> list = cdi.getAll();

        for (Country country : list)
            cbBirthplace.addItem(country);
    }

    private void fillNationality()
    {
        List<Country> list = cdi.getAll();

        for (Country country : list)
            cbNationality.addItem(country);
    }

    private void fillUserInformation()
    {
        tfAdress.setText(Config.loggedInUser.getAdress());
        tfEmail.setText(Config.loggedInUser.getEmail());
        tfPhone.setText(Config.loggedInUser.getPhone());

        String birthdate = (Config.loggedInUser.getBirthdate() != null)
                ? sdf.format(Config.loggedInUser.getBirthdate()) : "";
        tfBirthdate.setText(birthdate);

        cbBirthplace.setSelectedItem(Config.loggedInUser.getBirthplace());
        cbNationality.setSelectedItem(Config.loggedInUser.getNationality());
    }

    public void saveUserInformation()
    {
        String adress = tfAdress.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String birthdate = tfBirthdate.getText();
        java.sql.Date date = null;
        if (!birthdate.trim().isEmpty())
            try
            {
                date = new java.sql.Date(sdf.parse(birthdate).getTime());
            } catch (ParseException e)
            {
                JOptionPane.showMessageDialog(null, "There is mistake in birthdate.\nCheck it!");
            }

        Country birthplace = (Country) cbBirthplace.getSelectedItem();
        Country nationalty = (Country) cbNationality.getSelectedItem();

        Config.loggedInUser.setAdress(adress);
        Config.loggedInUser.setEmail(email);
        Config.loggedInUser.setPhone(phone);
        Config.loggedInUser.setBirthdate(date);
        Config.loggedInUser.setBirthplace(birthplace);
        Config.loggedInUser.setNationality(nationalty);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlDetails = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        tfAdress = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        tfBirthdate = new javax.swing.JTextField();
        lblBirthdate = new javax.swing.JLabel();
        lblBirthplace = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        cbBirthplace = new javax.swing.JComboBox<>();
        cbNationality = new javax.swing.JComboBox<>();

        lblEmail.setText("Email");

        lblPhone.setText("Phone");

        lblAdress.setText("Adress");

        lblBirthdate.setText("Birthdate");

        lblBirthplace.setText("Birthplace");

        lblNationality.setText("Nationality");

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetailsLayout.createSequentialGroup()
                        .addComponent(lblPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetailsLayout.createSequentialGroup()
                        .addComponent(lblAdress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBirthdate)
                            .addComponent(lblBirthplace)
                            .addComponent(lblNationality))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbNationality, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                                .addComponent(cbBirthplace, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthdate)
                    .addComponent(tfBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthplace)
                    .addComponent(cbBirthplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNationality)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbBirthplace;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBirthplace;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfBirthdate;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfPhone;
    // End of variables declaration//GEN-END:variables
}
