/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author skday
 */
public class Aplikasi {
    List<Object> listOrang  = new ArrayList<Object>();
    Scanner scr = new Scanner(System.in);
    
    public void addManajerProyek(ManajerProyek mP){
        listOrang.add(mP);
    }
    
    public void addProgrammer(Programmer p){
        listOrang.add(p);
    }
    
    public List<Object> getListOrang(){
        return this.listOrang;
    }
    
    public ManajerProyek getManajerProyek(String nama){
        int i = 0;
        boolean get = false;
        while ((i < listOrang.size()) && (!get)){
            if ((listOrang.get(i) instanceof ManajerProyek) 
                    && (((ManajerProyek)listOrang.get(i)).getnama())
                            .equalsIgnoreCase(nama)){
                get=true;
            }else{
                i++;
            }
        }
        if (get){
            return ((ManajerProyek)listOrang.get(i));
        }else{
            return null;
        }
    }
    
    public Programmer getProgrammer(String nama){
        int i = 0;
        boolean get = false;
        while ((i < listOrang.size()) && (!get)){
            if ((listOrang.get(i) instanceof Programmer) 
                    && (((Programmer)listOrang.get(i)).getnama())
                            .equalsIgnoreCase(nama)){
                get=true;
            }else{
                i++;
            }
        }
        if (get){
            return (Programmer)listOrang.get(i);
        }else{
            return null;
        }
    }
    
    public void deleteManagerProyek(String nama){
        int i = 0;
        boolean get = false;
        while ((i < listOrang.size()) && (!get)){
            if ((listOrang.get(i) instanceof Programmer) 
                    && (((ManajerProyek)listOrang.get(i)).getnama())
                            .equalsIgnoreCase(nama)){
                get=true;
            }else{
                i++;
            }
        }
        if(get){
            listOrang.remove(i);
        }    
    }
    
    public void deleteProgrammer(String nama){
        int i = 0;
        boolean get = false;
        while ((i < listOrang.size()) && (!get)){
            if ((listOrang.get(i) instanceof Programmer) 
                    && (((Programmer)listOrang.get(i)).getnama())
                            .equalsIgnoreCase(nama)){
                get=true;
            }else{
                i++;
            }
        }
        if(get){
            listOrang.remove(i);
        }
    }
    
    public void mCreateProyek (ManajerProyek mp){
        try {
            System.out.println("PROYEK BARU");
            scr.nextLine();
            System.out.print("Masukkan Deadline Proyek(dd/MM/yyyy) : ");
            String date = scr.nextLine();
            mp.createProyek(new SimpleDateFormat("dd/MM/yyyy").parse(date));
            System.out.print("Masukkan Nama Proyke : ");
            mp.getProyek((mp.getNProyek()-1)).setNama(scr.nextLine());
        } catch (ParseException e) {
            System.out.println("Inputan Salah");
            scr.nextLine();
        }
    }
    
    public void lihatProyeks(ManajerProyek mp){
        char pil = 'z';
        while(pil!='0'){
            if(mp.getNProyek() != 0){
                for(int i=0;i<mp.getNProyek();i++){
                    System.out.println("Proyek ke-"+(i+1));
                    System.out.println("Nama : "+ mp.getProyek(i).getNama());
                    System.out.println("Deadline : " +mp.getProyek(i).getDeadLine());
                    System.out.println();
                }
                System.out.println("=============================================");
                System.out.println("1. Hapus Proyek");
                System.out.println("2. Detail Proyek");
                System.out.println("0. Kembali");
                System.out.print("Pilih : ");
                pil = scr.next().charAt(0);
                switch(pil){
                    case '1':
                        System.out.print("Nomor proyek yang akan dihapus : ");
                        mp.deleteProyek((scr.nextInt()-1));
                        break;
                    case '2':
                        System.out.print("Masukan Nomor proyek : ");
                        detailProyek(mp,(scr.nextInt()-1));
                        break;
                }
            }else{
                System.out.println("Belum Ada Proyek");
                scr.nextLine();
                scr.nextLine();
                pil = '0';
            }
        }
    }
    
    public void detailProyek(ManajerProyek mp, int n){
        if (mp.getNProyek() > n) {
            char pil = 'z';
            while(pil != '0'){
                if(mp.getProyek(n).getNProgrammmer() !=0){
                    for(int i = 0; i<mp.getProyek(n).getNProgrammmer();i++){
                        System.out.println();
                        System.out.println("Programmer "+(i+1));
                        System.out.println("Nama : "+mp.getProyek(n).getProgrammer(i).getnama());
                        System.out.println("Umur : "+mp.getProyek(n).getProgrammer(i).getusia());
                        System.out.println("Gender : "+mp.getProyek(n).getProgrammer(i).getkelamin());
                    }
                    System.out.println("=============================================");
                }else{
                    System.out.println("Belum ada programmer");
                    System.out.println("=============================================");
                }

                if(mp.getProyek(n).getNTugas() != 0){
                    for(int i = 0; i<mp.getProyek(n).getNTugas() ;i++){
                        System.out.println("Tugas "+(i+1));
                        System.out.println("Nama Tugas : "+mp.getProyek(n).getTugas(i).getNama());
                        System.out.println("Detail : "+mp.getProyek(n).getTugas(i).getDetail());
                        System.out.println("Pelaksana : "+mp.getProyek(n).getTugas(i).getPelaksana().getnama());
                        System.out.println("Deadline : "+mp.getProyek(n).getTugas(i).getDeadline());
                        if (mp.getProyek(n).getTugas(i).getStatus()){
                            System.out.println("Status : Selesai");
                        }else{
                            System.out.println("Status : Belum Selesai");
                        }
                        System.out.println();
                    }
                    System.out.println("=============================================");
                }else{
                    System.out.println("Belum ada tugas");
                    System.out.println("=============================================");
                }
                System.out.println("1. Tambah Programmer");
                System.out.println("2. Hapus Programmer");
                System.out.println("3. Buat Tugas");
                System.out.println("4. Hapus Tugas");
                System.out.println("0. Kembali");
                System.out.print("Pilih : ");
                pil = scr.next().charAt(0);
                switch (pil){
                    case '1':
                        tambahProgrammer(mp, n);
                        break;
                    case '2':
                        hapusProgrammer(mp, n);
                        break;
                    case '3':
                        buatTugas(mp,n);
                        break;
                    case '4':
                        hapusTugas(mp, n);
                        break;
                }
            }
        }else{
            System.out.println("Proyek dengan nomor "+(n+1)+" tidak ada");
            scr.nextLine();
            scr.nextLine();
        }
    }
    
    public void tambahProgrammer(ManajerProyek mp, int n){
        scr.nextLine();
        System.out.print("Nama Programmer : ");
        String nama = scr.nextLine();
        int i = 0;
        boolean get = false;
        while ((i < listOrang.size()) && (!get)){
            if ((listOrang.get(i) instanceof Programmer) 
                    && (((Programmer)listOrang.get(i)).getnama())
                            .equalsIgnoreCase(nama)){
                get=true;
            }else{
                i++;
            }
        }
        if(get){
            mp.getProyek(n).addPogrammer((Programmer)listOrang.get(i));
        }else{
            System.out.println("Programmer tidak ada.");
            scr.nextLine();
        }
    }
    
    public void hapusProgrammer(ManajerProyek mp, int n){
        if (mp.getProyek(n).getNProgrammmer()!=0) {
            System.out.println("Nomor programmer yang akan dihapus : ");
            int i = scr.nextInt();
            mp.getProyek(n).removeProgrammer(i);
        }else{
            System.out.println("Tidak Ada Programmer");
            scr.nextLine();
            scr.nextLine();
        }
    }
    
    public void buatTugas(ManajerProyek mp, int n){
        if (mp.getProyek(n).getNProgrammmer()!=0) {
            try {
                scr.nextLine();
                System.out.print("Nama tugas : ");
                String namaT = scr.nextLine();
                System.out.print("Detail tugas : ");
                String detailT = scr.nextLine();
                System.out.print("Deadline : ");
                String date = scr.nextLine();
                mp.getProyek(n).createTugas(namaT);
                mp.getProyek(n).getTugas((mp.getProyek(n).getNTugas()-1)).setDetail(detailT);
                mp.getProyek(n).getTugas((mp.getProyek(n).getNTugas()-1))
                        .setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(date));
                boolean get = false;
                while (!get){
                    System.out.print("Pelaksana : ");
                    String pelaksana = scr.nextLine();
                    int i = 0;
                    while ((i < mp.getProyek(n).getNProgrammmer()) && (!get)){
                        if (mp.getProyek(n).getProgrammer(i).getnama()
                                .equalsIgnoreCase(pelaksana)){
                            get=true;
                        }else{
                            i++;
                        }
                    }
                    if (get){
                        mp.getProyek(n).getTugas((mp.getProyek(n).getNTugas()-1))
                                .setPelaksana(mp.getProyek(n).getProgrammer(i));
                    }else{
                        System.out.println("Programmer tidak terdaftar pada proyek ini.");
                    }
                }
            }catch(ParseException e){
                System.out.println("Inputan Salah");
                scr.nextLine();
            }
        }else{
            System.out.println("Belum ada pelaksana/programmer, silakan tambahkan terlebih dahulu");
            scr.nextLine();
        }
        
    }
    
    public void hapusTugas(ManajerProyek mp, int n){
        if (mp.getProyek(n).getNTugas()!=0) {
            System.out.println("Nomer tugas yang akan dihapus : ");
            int i = scr.nextInt();
            mp.getProyek(n).deleteTugas(i);
        }else{
            System.out.println("Tidak Ada Tugas");
            scr.nextLine();
        }
    }
    
    public boolean tugasSelesai(String nama){
        int i=0;
        int j=0;
        int k=0;
        boolean get = false;
        while((i<listOrang.size()) && (!get)){
            if(listOrang.get(i) instanceof ManajerProyek){
                while((j<((ManajerProyek)listOrang.get(i)).getNProyek()) && (!get)){
                    while((k<((ManajerProyek)listOrang.get(i)).getProyek(j).getNTugas()
                            && (!get))){
                        if(((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k)
                                .getNama().equalsIgnoreCase(nama)){
                            if(!((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k)
                                .getStatus()){
                                ((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k)
                                .setStatus(true);
                                get=true;
                            }
                        }
                        k++;
                    }
                    j++;
                }
            }
            i++;
        }
        return get;
    }
    
    public void login(String nm){
        if (getManajerProyek(nm) != null){
            menuManajerProyek(getManajerProyek(nm));
        }else if (getProgrammer(nm)!= null){
            menuProgrammer(getProgrammer(nm));
        }else{
            System.out.println("Anda Tidak Terdaftar");
            scr.nextLine();
        }
    }
    
    public void tambahOrang(char a, String nama, int usia, String gender){
        switch(a){
            case '1':
                addManajerProyek(new ManajerProyek(nama,gender,usia));
                break;
            case '2':
                addProgrammer(new Programmer(nama,gender,usia));
                break;
        }
    }
    
    public void menuManajerProyek(ManajerProyek mP){
        char pil='z';
        while (pil != '0'){
            System.out.println("MENU");
            System.out.println("1. Buat Proyek");
            System.out.println("2. Lihat Proyek");
            System.out.println("0. Logout");
            System.out.print("Pilih : ");
            pil = scr.next().charAt(0);
            switch(pil){
                case '1':
                    mCreateProyek(mP);
                    break;
                case '2' :
                    lihatProyeks(mP);
                    break;
            }
        }
    }
    
    public void menuProgrammer(Programmer p){
        boolean ada = false;
        for(int i = 0;i<listOrang.size();i++){
            if(listOrang.get(i) instanceof ManajerProyek){
                for(int j = 0; j<((ManajerProyek)listOrang.get(i)).getNProyek();j++){
                    for(int k = 0;k<((ManajerProyek)listOrang.get(i)).getProyek(j).getNTugas();k++){
                        if(((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k)
                                .getPelaksana().getnama()
                                .equalsIgnoreCase(p.getnama())){
                            System.out.println("Project Manager : "+((ManajerProyek)listOrang.get(i))
                                .getnama());
                            System.out.println("Nama Proyek : "+((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getNama());
                            System.out.println("Nama Tugas : "+((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k).getNama());
                            System.out.println("Detail : "+((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k).getDetail());
                            System.out.println("Deadline : "+((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k).getDeadline());
                            if (((ManajerProyek)listOrang.get(i))
                                .getProyek(j).getTugas(k).getStatus()){
                                System.out.println("Status : Selesai");
                            }else{
                                System.out.println("Status : Belum Selesai");
                            }
                            ada=true;
                        }
                    }
                }
            }
        }
        if(ada){
            char pil = 'z';
            while(pil!='0'){
                System.out.println("1. Tugas Selesai");
                System.out.println("0. Logout");
                System.out.print("Pilih : ");
                pil = scr.next().charAt(0);
                switch (pil){
                    case '1':
                        scr.nextLine();
                        System.out.println("Masukkan nama tugas : ");
                        String nama = scr.nextLine();
                        if(tugasSelesai(nama)){
                            System.out.println("Status berhasil dirubah");
                        }else{
                            System.out.println("Tidak ditemukan tugas "+nama);
                        }
                        break;
                }
            }            
        }else{
            System.out.println("Tidak ada tugas");
            System.out.println("Tekan Enter Untuk Logout!");
            scr.nextLine();
        }
    }
    
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public void mainMenu(){
        char pil='z';
        while(pil != '0'){
            System.out.println(listOrang.size());
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Tambah Orang");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pil= scr.next().charAt(0);
            switch(pil){
                case '1':
                    System.out.println("LOGIN");
                    System.out.print("Masukkan Nama Anda : ");
                    scr.nextLine();
                    String nm = scr.nextLine();
                    login(nm);
                    break;
                case '2':
                    System.out.println("TAMBAH ORANG");
                    scr.nextLine();
                    System.out.print("Nama : ");
                    String nama = scr.nextLine();
                    System.out.print("Usia : ");
                    int usia = scr.nextInt();
                    System.out.print("Jenis Kelamin : ");
                    scr.nextLine();
                    String kelamin = scr.nextLine();
                    char a='z';
                    while (a!='1' && a!='2'){
                        System.out.println("1. Project Manager");
                        System.out.println("2. Programmer");
                        System.out.print("Pilih : ");
                        a = scr.next().charAt(0);
                        tambahOrang(a,nama,usia,kelamin);
                    }
                    break;
            }
        }
    }
}
