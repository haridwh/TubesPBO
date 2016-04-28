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
import javax.swing.JOptionPane;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.Programmer;
import sisfoprojectmanagement.view.HalamanAwalProgrammer;

/**
 *
 * @author skday
 */
public class ControllerHalamanAwalPr extends MouseAdapter implements ActionListener{
    Aplikasi model;
    Programmer p;
    HalamanAwalProgrammer view;
    
    public ControllerHalamanAwalPr(Aplikasi model, Programmer p) {
        this.p = p;
        this.model = model;
        view = new HalamanAwalProgrammer();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);
        view.getNamaTugas().setEditable(false);
        view.getDeadline().setEditable(false);
        view.getProjectManajer().setEditable(false);
        view.getDetail().setEditable(false);
        view.getStatus().setEditable(false);
        view.getNamaProyek().setEditable(false);
        String[] s=new String[10];
        boolean ada = false;
        int t = 0;
        for(int i = 0;i<model.getListOrang().size();i++){
            if(model.getListOrang().get(i) instanceof ManajerProyek){
                for(int j = 0; j<((ManajerProyek)model.getListOrang().get(i)).getNProyek();j++){
                    for(int k = 0;k<((ManajerProyek)model.getListOrang().get(i)).getProyek(j).getNTugas();k++){
                        if(((ManajerProyek)model.getListOrang().get(i))
                                .getProyek(j).getTugas(k)
                                .getPelaksana().getnama()
                                .equalsIgnoreCase(p.getnama())){
                            s[t]=((ManajerProyek)model.getListOrang().get(i))
                                    .getProyek(j).getTugas(k).getNama();
                            t++;
                        }
                    }
                }
            }
        }
        view.getListTugas().setListData(s);
        System.out.println(s[0]==null);
        if (s[0]==null) {
            view.getBtnSelesai().setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnSelesai())) {
            String namaTugas = view.getSelectedTugas();
            if (namaTugas != null) {
                if (model.tugasSelesai(namaTugas)) {
                    JOptionPane.showMessageDialog(view, "Status berhasil dirubah");
                    view.dispose();
                    new ControllerHalamanAwalPr(model, p);
                }else{
                    JOptionPane.showMessageDialog(view, "Status gagal dirubah");
                }
            }else{
                JOptionPane.showMessageDialog(view, "Pilih tugas terlebih dahulu!");
            }
        }else if (source.equals(view.getBtnLogout())) {
            new ControllerLogin(model);
            view.dispose();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(view.getListTugas())) {
            String namaTugas = view.getSelectedTugas();
            boolean ada = false;
            int i = 0;
            while((i<model.getListOrang().size()) && (!ada)){
                if(model.getListOrang().get(i) instanceof ManajerProyek){
                    int j=0;
                    while((j<((ManajerProyek)model.getListOrang().get(i)).getNProyek()) && (!ada)){
                        int k=0;
                        while((k<((ManajerProyek)model.getListOrang().get(i)).getProyek(j).getNTugas()) && (!ada)){
                            if(((ManajerProyek)model.getListOrang().get(i))
                                    .getProyek(j).getTugas(k).getNama()
                                    .equalsIgnoreCase(namaTugas)){
                                view.getNamaTugas().setText(namaTugas);
                                view.getProjectManajer().setText(((ManajerProyek)model.getListOrang().get(i))
                                    .getnama());
                                view.getNamaProyek().setText(((ManajerProyek)model.getListOrang().get(i))
                                    .getProyek(j).getNama());
                                view.getDetail().setText(((ManajerProyek)model.getListOrang().get(i))
                                    .getProyek(j).getTugas(k).getDetail());
                                if (((ManajerProyek)model.getListOrang().get(i))
                                        .getProyek(j).getTugas(k).getStatus()){
                                    view.getStatus().setText("Selesai");
                                }else{
                                    view.getStatus().setText("Belum Selesai");
                                }
                                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                Date date = ((ManajerProyek)model.getListOrang().get(i))
                                    .getProyek(j).getTugas(k).getDeadline();
                                view.getDeadline().setText(df.format(date));
                                ada=true;
                            }
                            k++;
                        }
                        j++;
                    }
                }
                i++;
            }
        }
    }
}
