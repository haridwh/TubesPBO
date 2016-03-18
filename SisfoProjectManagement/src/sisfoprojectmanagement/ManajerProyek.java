/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement;

/**
 *
 * @author skday
 */

import java.util.Date;

public class ManajerProyek extends Orang {
    private Proyek[] proyek = new Proyek[3];
    private int nProyek;
    
    public void createProyek( Date deadline){
        if (nProyek<3){
            setProyek(deadline);
        }else{
            System.out.println("Tidak Dapat Menambah Proyek Lagi");
        }
        nProyek++;
    }
    
    public void setProyek(Date deadline){
        proyek[nProyek] = new Proyek(deadline);
    }
    
    public Proyek getProyek(int index){
        return proyek[index];
    }
    
    public void deleteProyek(int index){
        if (index == 0){
            if (3 == 1){
                proyek[index] = null;
            }else{
                for (int i = index; i < 3; i++){
                    if(i == (3-1)){
                        proyek[i]=null;
                    }else{
                        proyek[i]=proyek[i+1];
                    }
                }
            }
        }else if (index == (3-1)){
            proyek[index] = null;
        }else{
            for (int i = index; i < 3; i++){
                if(i == (3-1)){
                    proyek[i]=null;
                }else{
                    proyek[i]=proyek[i+1];
		}
            }
        }
        nProyek--;
    }
    
    public int getNProyek(){
        return this.nProyek;
    }
}
