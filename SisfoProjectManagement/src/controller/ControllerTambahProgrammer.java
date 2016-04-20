/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sisfoprojectmanagement.Aplikasi;
import sisfoprojectmanagement.ManajerProyek;
import sisfoprojectmanagement.Programmer;
import sisfoprojectmanagement.Proyek;
import sisfoprojectmanagement.view.TambahProgrammer;

/**
 *
 * @author skday
 */
public class ControllerTambahProgrammer implements ActionListener{

    Aplikasi model;
    ManajerProyek mp;
    Proyek p;
    TambahProgrammer view;
    
    public ControllerTambahProgrammer(Aplikasi model, ManajerProyek mp, Proyek p){
       this.model = model;
       this.mp = mp;
       this.p = p;
       view = new TambahProgrammer();
       view.setVisible(true);
       view.addListener(this);
        int i = 0;
        boolean get = false;
        while (i < model.getListOrang().size()){
            if ((model.getListOrang().get(i) instanceof Programmer)){
                view.getProgrammer().addItem(((Programmer)model.getListOrang().get(i)).getnama());
            }
            i++;
        }       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnTambah())) {
            String nama = view.getProgrammer().getSelectedItem().toString();
            int i = 0;
            boolean get = false;
            while ((i < model.getListOrang().size()) && (!get)){
                if ((model.getListOrang().get(i) instanceof Programmer) 
                        && (((Programmer)model.getListOrang().get(i)).getnama())
                                .equalsIgnoreCase(nama)){
                    p.addPogrammer((Programmer)model.getListOrang().get(i));
                    get=true;
                }else{
                    i++;
                }
            }
            new ControllerDetailProyek(model, mp, p);
            view.dispose();
        }else if (source.equals(view.getBtnBatal())) {
            new ControllerDetailProyek(model, mp, p);
            view.dispose();
        }
        
    }
    
}
