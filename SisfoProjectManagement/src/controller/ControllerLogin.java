/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.Serialization;
import sisfoprojectmanagement.view.Login;

/**
 *
 * @author skday
 */
public class ControllerLogin implements ActionListener{
    Login view;
    Aplikasi model;
    
    public ControllerLogin(Aplikasi model){
        this.model = model;
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogin())) {
            String nama = view.getTUsername().getText();
            if (model.getManajerProyek(nama)!=null) {
                new ControllerHalamanAwalPM(model, model.getManajerProyek(nama));
                view.dispose();
            }else if (model.getProgrammer(nama)!=null){
                new ControllerHalamanAwalPr(model, model.getProgrammer(nama));
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(view, "Anda Tidak Terdaftar!");
            }
        }else if(source.equals(view.getBtnTambahOrang())){
            new ControllerTambahOrang(model);
            view.dispose();
        }else if(source.equals(view.getBtnKeluar())){
            view.dispose();
            Serialization sr = new Serialization();
            sr.serializeList(model.getListOrang());
        }
    }
}
