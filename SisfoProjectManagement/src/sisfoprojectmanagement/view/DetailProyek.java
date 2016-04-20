/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoprojectmanagement.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author gridd
 */
public class DetailProyek extends javax.swing.JFrame {

    /**
     * Creates new form DetailProyek
     */
    public DetailProyek() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setTitle("Detail Proyek");
    }

    public JButton getBtnKembali() {
        return btnKembali;
    }

    public void setBtnKembali(JButton btnKembali) {
        this.btnKembali = btnKembali;
    }

    public JButton getBtnCreateTugas() {
        return BtnCreateTugas;
    }

    public void setBtnCreateTugas(JButton BtnCreateTugas) {
        this.BtnCreateTugas = BtnCreateTugas;
    }

    public JButton getBtnHapusProgrammer() {
        return btnHapusProgrammer;
    }

    public void setBtnHapusProgrammer(JButton btnHapusProgrammer) {
        this.btnHapusProgrammer = btnHapusProgrammer;
    }

    public JButton getBtnHapusTugas() {
        return btnHapusTugas;
    }

    public void setBtnHapusTugas(JButton btnHapusTugas) {
        this.btnHapusTugas = btnHapusTugas;
    }

    public JButton getBtnTambahprogrammer() {
        return btnTambahprogrammer;
    }

    public void setBtnTambahprogrammer(JButton btnTambahprogrammer) {
        this.btnTambahprogrammer = btnTambahprogrammer;
    }

    public JTextField getDeadline() {
        return deadline;
    }

    public void setDeadline(JTextField deadline) {
        this.deadline = deadline;
    }

    public JTextArea getDetail() {
        return detail;
    }

    public void setDetail(JTextArea detail) {
        this.detail = detail;
    }

    public JTextField getPelaksana() {
        return pelaksana;
    }

    public void setPelaksana(JTextField pelaksana) {
        this.pelaksana = pelaksana;
    }

    public JTextField getStatus() {
        return status;
    }

    public void setStatus(JTextField status) {
        this.status = status;
    }

    public JTextField getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(JTextField namaTugas) {
        this.namaTugas = namaTugas;
    }

    public JList getListTugas() {
        return listTugas;
    }

    public void setListTugas(JList<String> listTugas) {
        this.listTugas = listTugas;
    }
    
    public String getSelectedTugas(){
        return ((String)listTugas.getSelectedValue());
    }
    
    public void addAdapter(MouseAdapter e){
        listTugas.addMouseListener(e);
    }
    
    public void addListener(ActionListener e){
        BtnCreateTugas.addActionListener(e);
        btnTambahprogrammer.addActionListener(e);
        btnHapusProgrammer.addActionListener(e);
        btnHapusTugas.addActionListener(e);
        btnKembali.addActionListener(e);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        BtnCreateTugas = new javax.swing.JButton();
        btnHapusProgrammer = new javax.swing.JButton();
        btnTambahprogrammer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTugas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namaTugas = new javax.swing.JTextField();
        deadline = new javax.swing.JTextField();
        pelaksana = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        detail = new javax.swing.JTextArea();
        btnHapusTugas = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnCreateTugas.setText("Buat Tugas");

        btnHapusProgrammer.setText("Hapus Programmer");

        btnTambahprogrammer.setText("Tambah Programmer");

        listTugas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listTugas);

        jLabel1.setText("Nama Tugas");

        jLabel2.setText("Deadline");

        jLabel3.setText("Pelaksana");

        jLabel4.setText("Status");

        jLabel5.setText("Detail");

        detail.setColumns(20);
        detail.setRows(5);
        jScrollPane4.setViewportView(detail);

        btnHapusTugas.setText("Hapus Tugas");

        btnKembali.setText("Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addComponent(btnTambahprogrammer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHapusProgrammer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCreateTugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaTugas)
                            .addComponent(deadline)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(pelaksana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahprogrammer)
                    .addComponent(btnHapusProgrammer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(namaTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pelaksana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapusTugas)
                    .addComponent(btnKembali)
                    .addComponent(BtnCreateTugas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCreateTugas;
    private javax.swing.JButton btnHapusProgrammer;
    private javax.swing.JButton btnHapusTugas;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambahprogrammer;
    private javax.swing.JTextField deadline;
    private javax.swing.JTextArea detail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JList<String> listTugas;
    private javax.swing.JTextField namaTugas;
    private javax.swing.JTextField pelaksana;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
