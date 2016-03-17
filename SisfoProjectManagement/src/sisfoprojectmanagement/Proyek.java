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
    int nProgrammmer;
    int nTugas;
    
    public Proyek(Date deadline){
        this.deadline = deadline;
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
        
    }
    
    public void createTugas(String tugas){
        
    }
    
    public Tugas getTugas(int index){
        return tugas[index];
    }
    
    public void deleteTugas(int index){
    
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
}
