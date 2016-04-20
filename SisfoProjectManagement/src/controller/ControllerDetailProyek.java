/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.Proyek;
import sisfoprojectmanagement.view.DetailProyek;

/**
 *
 * @author skday
 */
public class ControllerDetailProyek extends MouseAdapter implements ActionListener{
    Aplikasi model;
    ManajerProyek mp;
    Proyek p;
    DetailProyek view;
    
    public ControllerDetailProyek(Aplikasi model, ManajerProyek mp, Proyek p){
        this.model = model;
        this.mp = mp;
        this.p= p;
        view = new DetailProyek();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);
        view.getNamaTugas().setEditable(false);
        view.getDeadline().setEditable(false);
        view.getPelaksana().setEditable(false);
        view.getDetail().setEditable(false);
        view.getStatus().setEditable(false);
        String[] s=new String[10];
        for (int i = 0; i < p.getNTugas(); i++) {
            s[i]=p.getTugas(i).getNama();
        }
        view.getListTugas().setListData(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnCreateTugas())) {
            new ControllerCreateTugas(model, mp, p);
            view.dispose();
        }else if (source.equals(view.getBtnHapusTugas())) {
            
        }else if (source.equals(view.getBtnTambahprogrammer())) {
            new ControllerTambahProgrammer(model, mp, p);
            view.dispose();
        }else if (source.equals(view.getBtnHapusProgrammer())) {
            
        }else if (source.equals(view.getBtnKembali())) {
            new ControllerHalamanAwalPM(model, mp);
            view.dispose();
        }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(view.getListTugas())) {
            String namaTugas=view.getSelectedTugas();
            int i=0;
            boolean get=false;
            while((i<p.getNTugas()) && (!get)){
                if (p.getTugas(i).getNama().equalsIgnoreCase(namaTugas)) {
                    view.getNamaTugas().setText(p.getTugas(i).getNama());
                    view.getPelaksana().setText(p.getTugas(i).getPelaksana().getnama());
                    view.getDetail().setText(p.getTugas(i).getDetail());
                    if (p.getTugas(i).getStatus()) {
                        view.getStatus().setText("Selesai");
                    }else{
                        view.getStatus().setText("Belum Selesai");
                    }
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = this.mp.getProyek(0).getDeadLine();
                    view.getDeadline().setText(df.format(date));
                    get=true;
                }else{
                    i++;
                } 
            }
        }
    }
}