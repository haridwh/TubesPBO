/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author skday
 */
public class Serialization {
    public void serializeList(List<Orang> list){
        try{
            FileOutputStream fOS = new FileOutputStream("listOrang.txt");
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(list);
            fOS.close();
            oOS.close();
        }catch(Exception e){            
            e.printStackTrace();
        }
    }
    
    public List deserializeList(){
        List<Orang> listDeserialized;
        try {
            FileInputStream fIN = new FileInputStream("listOrang.txt");
            ObjectInputStream oIS = new ObjectInputStream(fIN);
            listDeserialized = (List<Orang>) oIS.readObject();
            oIS.close();
            fIN.close();
        } catch (IOException io) {
            io.printStackTrace();
            return null;
        } catch (ClassNotFoundException c){
            c.printStackTrace();
            return null;
        }
        return listDeserialized;
    }
}
