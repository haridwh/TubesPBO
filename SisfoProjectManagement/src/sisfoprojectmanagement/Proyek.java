/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement;

import java.util.Date;

/**
 *
 * @author skday
 */
public class Proyek {
    private Programmer[] programmer;
    private Tugas[] tugas;
    String nama;
    Date deadline;
    int nProgrammmer=0;
    int nTugas=0;
    
    public Proyek(Date deadline){
        this.deadline = deadline;
        programmer = new Programmer[10];
        tugas = new Tugas[10];
    }
    
    public void addPogrammer(Programmer p){
        if (programmer.length>nProgrammmer){
            programmer[nProgrammmer] = p;
        }else{
            System.out.println("Tidak Dapat Menambah Programmer Lagi!");
        }
        nProgrammmer++;
    }
    
    public Programmer getProgrammer(int index){
        return programmer[index];
    }
    
    public void removeProgrammer(int index){
        if (index == 0){
            if (nProgrammmer == 1){
                programmer[index] = null;
            }else{
                for (int i = index; i < nProgrammmer; i++){
                    if(i == (nProgrammmer-1)){
                        programmer[i]=null;
                    }else{
                        programmer[i]=programmer[i+1];
                    }
                }
            }
        }else if (index == (nProgrammmer-1)){
            programmer[index] = null;
        }else{
            for (int i = index; i < nProgrammmer; i++){
                if(i == (nProgrammmer-1)){
                    programmer[i]=null;
                }else{
                    programmer[i]=programmer[i+1];
		}
            }
        }
        nProgrammmer--;
    }
    
    public void createTugas(String tugas){
        if (this.tugas.length>nTugas){
            Tugas t = new Tugas(tugas);
            this.tugas[nTugas] = t;
        }else{
            System.out.println("Tidak Dapat Menambah Programmer Lagi!");
        }
        nTugas++;
    }
    
    public Tugas getTugas(int index){
        return tugas[index];
    }
    
    public void deleteTugas(int index){
        if (index == 0){
            if (nTugas == 1){
                tugas[index] = null;
            }else{
                for (int i = index; i < nTugas; i++){
                    if(i == (nTugas-1)){
                        tugas[i]=null;
                    }else{
                        tugas[i]=tugas[i+1];
                    }
                }
            }
        }else if (index == (nTugas-1)){
            tugas[index] = null;
        }else{
            for (int i = index; i < nTugas; i++){
                if(i == (nTugas-1)){
                    tugas[i]=null;
                }else{
                    tugas[i]=tugas[i+1];
		}
            }
        }
        nTugas--;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void setDeadLine(Date date){
        this.deadline = date;
    }
    
    public Date getDeadLine(){
        return this.deadline;
    }
    
    public int getNProgrammmer() {
        return nProgrammmer;
    }

    public int getNTugas() {
        return nTugas;
    }
}
