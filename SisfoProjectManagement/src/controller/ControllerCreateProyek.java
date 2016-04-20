/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.view.CreateProyek;
import sisfoprojectmanagement.view.HalamanAwalProyekManager;

/**
 *
 * @author skday
 */
public class ControllerCreateProyek implements ActionListener{

    Aplikasi model;
    ManajerProyek mp;
    CreateProyek view;
    
    public ControllerCreateProyek(Aplikasi model,ManajerProyek mp) {
        this.model = model;
        this.mp = mp;
        view = new CreateProyek();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnCreate())) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String date = view.getDeadline().getText();
                Date d = format.parse(date);
                mp.createProyek(d);
                mp.getProyek((mp.getNProyek()-1)).setNama(view.getNamaProyek().getText());
                new ControllerHalamanAwalPM(model, mp);
                JOptionPane.showMessageDialog(view, "Proyek Berhasil Dibuat");
                view.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Inputan Salah");
            }
        }else if (source.equals(view.getBtnBatal())) {
            new ControllerHalamanAwalPM(model, mp);
            view.dispose();
        }
    }
    
    
    
}
