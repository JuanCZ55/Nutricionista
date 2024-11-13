/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Ingredientes;
import Persistencia.IngredientesData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanCZ
 */
public class GestionarIngredientes extends javax.swing.JInternalFrame {

    private IngredientesData id = new IngredientesData();
    DefaultTableModel modelo;

    public GestionarIngredientes() {
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
        jBActualizar.setEnabled(false);
        jBBuscar.setEnabled(false);
        jBAlta.setEnabled(false);
        jBbaja.setEnabled(false);
        enlistar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCBNoApto = new javax.swing.JComboBox<>();
        jTFcalorias = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFid = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jBNuevo = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBbaja = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gestion de Ingredientes");

        jLabel2.setText("ID");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Calorias x 100gramos");

        jLabel5.setText("No Apto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Calorias x 100gr", "No Apto", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jCBNoApto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Diabetes", "Hipertension", "Celiaca" }));

        jTFid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFidKeyReleased(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBbaja.setText("Baja");
        jBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbajaActionPerformed(evt);
            }
        });

        jBAlta.setText("Alta");
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBNoApto, 0, 121, Short.MAX_VALUE)
                            .addComponent(jTFcalorias)
                            .addComponent(jTFNombre)
                            .addComponent(jTFid))
                        .addGap(82, 82, 82)
                        .addComponent(jBBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBNuevo)
                        .addGap(46, 46, 46)
                        .addComponent(jBActualizar)
                        .addGap(53, 53, 53)
                        .addComponent(jBbaja)
                        .addGap(51, 51, 51)
                        .addComponent(jBAlta)
                        .addGap(141, 141, 141))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTFcalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCBNoApto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jBActualizar)
                    .addComponent(jBbaja)
                    .addComponent(jBAlta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        try {
            String nombre = "", noapto = "";
            double calorias = 0;
            if (!jTFNombre.getText().isEmpty()) {
                nombre = (String) jTFNombre.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un Nombre");
                return;
            }
            if (!jTFcalorias.getText().isEmpty()) {
                calorias = Double.parseDouble(jTFcalorias.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Calorias");
                return;
            }
            noapto = (String) jCBNoApto.getSelectedItem();
            Ingredientes in = new Ingredientes(nombre, calorias, noapto);
            id.insertarIngrediente(in);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente las calorias");
        }
        enlistar();

    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jTFidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFidKeyReleased
        if (jTFid.getText().isEmpty()) {
            jBActualizar.setEnabled(false);
            jBBuscar.setEnabled(false);
            jBAlta.setEnabled(false);
            jBbaja.setEnabled(false);
        } else {
            jBActualizar.setEnabled(true);
            jBBuscar.setEnabled(true);
            jBAlta.setEnabled(true);
            jBbaja.setEnabled(true);
        }
    }//GEN-LAST:event_jTFidKeyReleased

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        try {
            int ide = 0;
            String nombre = "", noapto = "";
            double calorias = 0;
            if (!jTFid.getText().isEmpty()) {
                ide = Integer.parseInt(jTFid.getText());
                if (ide <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a 0");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un ID Correcto");
                return;
            }
            if (!jTFNombre.getText().isEmpty()) {
                nombre = (String) jTFNombre.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un Nombre");
                return;
            }
            if (!jTFcalorias.getText().isEmpty()) {
                calorias = Double.parseDouble(jTFcalorias.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese las Calorias");
                return;
            }
            noapto = (String) jCBNoApto.getSelectedItem();
            Ingredientes in = new Ingredientes(ide, nombre, calorias, noapto);
            id.actualizarIngrediente(in);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente las calorias");
        }
        enlistar();

    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbajaActionPerformed
        try {
            int ide;
            if (!jTFid.getText().isEmpty()) {
                ide = Integer.parseInt(jTFid.getText());
                if (ide <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a 0");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un ID Correcto");
                return;
            }
            id.bajaLogica(ide);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamene el id");
        }
        enlistar();

    }//GEN-LAST:event_jBbajaActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        try {
            int ide;
            if (!jTFid.getText().isEmpty()) {
                ide = Integer.parseInt(jTFid.getText());
                if (ide <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a 0");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un ID Correcto");
                return;
            }
            id.altaLogica(ide);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamene el id");
        }
        enlistar();
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        try {
            int ide;
            if (!jTFid.getText().isEmpty()) {
                ide = Integer.parseInt(jTFid.getText());
                if (ide <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a 0");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un ID Correcto");
                return;
            }
            Ingredientes ingre = id.buscarIngredientes(ide);
            jTFNombre.setText(ingre.getNombre());
            jTFcalorias.setText(String.valueOf(ingre.getCaloriasPor100()));
            jCBNoApto.setSelectedItem(ingre.getNoApto());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamene el id");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    public void enlistar() {
        modelo.setRowCount(0);
        for (Ingredientes aux : id.listarIngredientes()) {
            modelo.addRow(new Object[]{
                aux.getIdIngredientes(),
                aux.getNombre(),
                aux.getCaloriasPor100(),
                aux.getNoApto(),
                aux.isEstado()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBbaja;
    private javax.swing.JComboBox<String> jCBNoApto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFcalorias;
    private javax.swing.JTextField jTFid;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
