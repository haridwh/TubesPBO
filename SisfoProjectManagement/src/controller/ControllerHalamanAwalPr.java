/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.Programmer;
import sisfoprojectmanagement.view.HalamanAwalProgrammer;

/**
 *
 * @author skday
 */
public class ControllerHalamanAwalPr implements ActionListener{
    Aplikasi model;
    Programmer p;
    HalamanAwalProgrammer view;
    
    public ControllerHalamanAwalPr(Aplikasi model, Programmer p) {
        this.p = p;
        this.model = model;
        view = new HalamanAwalProgrammer();
        view.setVisible(true);
        view.addListener(this);
        view.getNamaTugas().setEditable(false);
        view.getDeadline().setEditable(false);
        view.getProjectManajer().setEditable(false);
        view.getDetail().setEditable(false);
        view.getStatus().setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
