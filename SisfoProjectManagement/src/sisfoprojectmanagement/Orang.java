/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement;

/**
 *
 * @author gridd
 */
public class Orang {
    private String nama;
private String kelamin;
private int usia;

public Orang(String nama,String kelamin,int usia){
}
        
public void setnama(String nama)
{
	this.nama=nama;
}

public String getnama()
{
	return nama;
}

public void setkelamin(String kelamin)
{
	this.kelamin=kelamin;
}

public String getkelamin()
{
	return kelamin;
}

public void setusia(int usia)
{
	this.usia=usia;
}
public int getusia()
{
	return usia;
}
}
