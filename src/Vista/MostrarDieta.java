/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Dieta;
import Persistencia.DietaData;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class MostrarDieta extends javax.swing.JInternalFrame {
 private DefaultTableModel TbDieta;
 private Persistencia.DietaData dietaData;
 
    public MostrarDieta() {
        initComponents();
         //this.setImagen("/imagen/FondoAzulRombo.png");//Buscar una imagen y ponerla
        this.TbDieta = new DefaultTableModel();
        TbDieta.addColumn("Id Dieta");
        TbDieta.addColumn("Nombre");
        TbDieta.addColumn("IDPaciente");
        TbDieta.addColumn("Fecha inicio");
        TbDieta.addColumn("Fecha final");
        TbDieta.addColumn("Total calorias");
        TbDieta.addColumn("Estado");
        jTablaDietaLista.setModel(TbDieta);
        jTablaDietaLista.setDefaultEditor(Object.class, null);
        cargarDietasEnTabla();
    }
public void cargarDietasEnTabla() {
    
    List<Dieta> listaDietas = dietaData.obtenerTodasLasDietas();

    TbDieta.setRowCount(0); // Limpiar 

    for (Dieta dieta : listaDietas) {
        TbDieta.addRow(new Object[] {
            dieta.getIdDieta(),
            dieta.getNombreD(),
            dieta.getFechaIni(),
            dieta.getFechaFin(),
            dieta.getTotalCalorias(),
            dieta.isEstado() 
        });
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDietaLista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTablaDietaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablaDietaLista);

        jLabel1.setText("Lista De Dietas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDietaLista;
    // End of variables declaration//GEN-END:variables
}
