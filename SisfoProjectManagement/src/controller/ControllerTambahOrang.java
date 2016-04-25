/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.view.TambahOrang;

/**
 *
 * @author skday
 */
public class ControllerTambahOrang implements ActionListener{
    TambahOrang view;
    Aplikasi model;
    
    public ControllerTambahOrang(Aplikasi model){
        this.model = model;
        view = new TambahOrang();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnCreate())) {
            String nama = view.getNama();
            String jk = view.getJK().getSelectedItem().toString();
            char a=0;
            if (view.getStatus().getSelectedIndex()==0) {
                a = '1';
            }else if (view.getStatus().getSelectedIndex()==1){
                a = '2';
            }
            try {
                int usia = Integer.parseInt(view.getUsia());
                model.tambahOrang(a, nama, usia, jk);
                JOptionPane.showMessageDialog(view, "Berhasil");
                new ControllerLogin(model);
                view.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Input Salah");

            }
        }else if (source.equals(view.getBtnKembali())) {
            new ControllerLogin(model);
            view.dispose();
        }
    }
}
