package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.view.HalamanAwalProyekManager;
import sisfoprojectmanagement.view.TambahOrang;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skday
 */

public class ControllerHalamanAwalPM implements ActionListener{
    Aplikasi model;
    HalamanAwalProyekManager view;
    ManajerProyek mp;

    public ControllerHalamanAwalPM(Aplikasi model, ManajerProyek mp) {
        this.model = model;
        this.mp = mp;
        view = new HalamanAwalProyekManager();
        view.setVisible(true);
        view.addListener(this);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (this.mp.getNProyek()==0) {
            view.getPProyek1().setVisible(false);
            view.getPProyek2().setVisible(false);
            view.getPProyek3().setVisible(false);
        }else if (this.mp.getNProyek()==1) {
            view.getPProyek2().setVisible(false);
            view.getPProyek3().setVisible(false);
            view.getNamaProyek1().setText(this.mp.getProyek(0).getNama());
            Date date = this.mp.getProyek(0).getDeadLine();
            view.getDL1().setText(df.format(date));
        }else if (this.mp.getNProyek()==2) {
            view.getPProyek2().setVisible(true);
            view.getPProyek3().setVisible(false);
            view.getNamaProyek1().setText(this.mp.getProyek(0).getNama());
            Date date = this.mp.getProyek(0).getDeadLine();
            view.getDL1().setText(df.format(date));
            view.getNamaProyek2().setText(this.mp.getProyek(1).getNama());
            date = this.mp.getProyek(1).getDeadLine();
            view.getDL2().setText(df.format(date));
        }else if (this.mp.getNProyek()==3) {
            view.getBtnCreateProyek().setEnabled(false);
            view.getNamaProyek1().setText(this.mp.getProyek(0).getNama());
            Date date = this.mp.getProyek(0).getDeadLine();
            view.getDL1().setText(df.format(date));
            view.getNamaProyek2().setText(this.mp.getProyek(1).getNama());
            date = this.mp.getProyek(1).getDeadLine();
            view.getDL2().setText(df.format(date));
            view.getNamaProyek3().setText(this.mp.getProyek(2).getNama());
            date = this.mp.getProyek(2).getDeadLine();
            view.getDL3().setText(df.format(date));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogout())) {
            new ControllerLogin(model);
            view.dispose();
        }else if(source.equals(view.getBtnCreateProyek())){
            new ControllerCreateProyek(model, this.mp);
            view.dispose();
        }else if (source.equals(view.getBtnHapusproyek1())) {
            mp.deleteProyek(0);
            new ControllerHalamanAwalPM(model, mp);
            view.dispose();
        }else if(source.equals(view.getBtnDetailProyek1())){
            new ControllerDetailProyek(model,mp, mp.getProyek(0));
            view.dispose();
        }else if (source.equals(view.getBtnHapusproyek2())) {
            mp.deleteProyek(1);
            new ControllerHalamanAwalPM(model, mp);
            view.dispose();
        }else if(source.equals(view.getBtnDetailProyek2())){
            new ControllerDetailProyek(model,mp,mp.getProyek(0));
            view.dispose();
        }else if (source.equals(view.getBtnHapusproyek3())) {
            mp.deleteProyek(2);
            new ControllerHalamanAwalPM(model, mp);
            view.dispose();
        }else if(source.equals(view.getBtnDetailProyek3())){
            new ControllerDetailProyek(model,mp,mp.getProyek(0));
            view.dispose();
        }
    }
    
}
