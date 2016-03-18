/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement;
import java.util.Date;
/**
 *
 * @author Maidarman
 */
public class Tugas {
        private Programer pelaksana;
	private String nama;
	private String detail;
	private boolean status;
	private Date deadline;

	public void setPelaksana (Programer p){
		pelaksana = p;
	}

	public Programer getPelaksana (){
		return pelaksana;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setDetail (String detail){
		this.detail = detail;
	}

	public String getDetail (){
		return detail;
	}

	public void setStatus (boolean status){
		this.status = status;
	}

	public boolean getStatus (){
		return status;
	}

	public void setDeadline (Date date){
		deadline = date;
	}

	public Date getDeadline (){
		return deadline;
	}
}
