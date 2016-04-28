/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.Proyek;
import sisfoprojectmanagement.view.CreateTugas;

/**
 *
 * @author skday
 */
public class ControllerCreateTugas implements ActionListener{

    Aplikasi model;
    ManajerProyek mp;
    Proyek p;
    CreateTugas view;
    
    public ControllerCreateTugas(Aplikasi model, ManajerProyek mp, Proyek p) {
       this.model = model;
       this.mp = mp;
       this.p = p;
       view = new CreateTugas();
       view.setVisible(true);
       view.addListener(this);
        for (int i = 0; i < p.getNProgrammmer(); i++) {
            view.getNamaProgrammer().addItem(p.getProgrammer(i).getnama());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnCreate())) {
            try {
                String namaTugas = view.getNamaTugas().getText();
                String deskripsi = view.getDeskripsiTugas().getText();
                String pelaksana = view.getNamaProgrammer().getSelectedItem().toString();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String date = view.getDeadlineTugas().getText();
                if ((!namaTugas.equals("")) && (!deskripsi.equals(""))
                        && (!pelaksana.equals("")) && (!date.equals(""))) {
                    Date d = format.parse(date);
                    int j=0;
                    boolean ada = false;
                    while(j<p.getNTugas() && (!ada)){
                        if (namaTugas.equalsIgnoreCase(p.getTugas(j).getNama())) {
                            ada = true;
                        }else{
                            j++;
                        }
                    }
                    if (!ada) {
                        p.createTugas(namaTugas);
                        p.getTugas((p.getNTugas()-1)).setDetail(deskripsi);
                        p.getTugas((p.getNTugas()-1)).setDeadline(d);
                        int i = 0;
                        boolean get=false;
                        while ((i < p.getNProgrammmer()) && (!get)){
                            if (p.getProgrammer(i).getnama()
                                .equalsIgnoreCase(pelaksana)){
                                p.getTugas((p.getNTugas()-1)).setPelaksana(p.getProgrammer(i));
                                get=true;
                                new ControllerDetailProyek(model, mp, p);
                                view.dispose();
                            }else{
                                i++;
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(view, "Tugas dengan nama "
                                + namaTugas+" sudah ada!");
                    }
                }else{
                    JOptionPane.showMessageDialog(view, "Form tidak boleh kosong");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Inputan Salah");
            }
        }else if (source.equals(view.getBtnBatal())) {
            new ControllerDetailProyek(model, mp, p);
            view.dispose();
        }
    }
    
}
