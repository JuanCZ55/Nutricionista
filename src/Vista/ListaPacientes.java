/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Paciente;
import Persistencia.PacienteData;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author juanz
 */
public class ListaPacientes extends javax.swing.JInternalFrame {

    private final PacienteData pd = new PacienteData();
    private DefaultTableModel modelo;

    public ListaPacientes() {
        initComponents();
        modelo = (DefaultTableModel) jTtablaPacientes.getModel();
        jLNombre.setVisible(false);
        jTFNombre.setVisible(false);
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
        jCBSeleccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jBsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTtablaPacientes = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(74, 144, 205));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listar Pacientes por:");

        jCBSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Todos", "Los que llegaron al peso buscado", "Los que no llegaron al peso buscado", "Nombre" }));
        jCBSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSeleccionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de Pacientes");

        jLNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLNombre.setText("Ingrese el Nombre: ");

        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreKeyReleased(evt);
            }
        });

        jBsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/puerta-abierta.png"))); // NOI18N
        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jTtablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Edad", "Altura", "Condiciones", "Peso Actual", "Peso Buscado", "Peso Inicial", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTtablaPacientes);
        if (jTtablaPacientes.getColumnModel().getColumnCount() > 0) {
            jTtablaPacientes.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTtablaPacientes.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTtablaPacientes.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTtablaPacientes.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTtablaPacientes.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTtablaPacientes.getColumnModel().getColumn(6).setPreferredWidth(60);
            jTtablaPacientes.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBSeleccion, 0, 239, Short.MAX_VALUE)
                    .addComponent(jTFNombre))
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBsalir)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBsalir)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSeleccionActionPerformed
        ArrayList<Paciente> lp;
        if (jCBSeleccion.getSelectedItem().equals("Todos")) {
            jLNombre.setVisible(false);
            jTFNombre.setVisible(false);
            lp = pd.listarPacientes();
            enlistarPacientes(lp);
        } else if (jCBSeleccion.getSelectedItem().equals("Los que llegaron al peso buscado")) {
            jLNombre.setVisible(false);
            jTFNombre.setVisible(false);
            modelo.setRowCount(0);
            lp = pd.listarLosQueLLegaron();
            enlistarPacientes(lp);
        } else if (jCBSeleccion.getSelectedItem().equals("Los que no llegaron al peso buscado")) {
            jLNombre.setVisible(false);
            jTFNombre.setVisible(false);
            modelo.setRowCount(0);
            lp = pd.listarLosQueNoLLegaron();
            enlistarPacientes(lp);
        } else if (jCBSeleccion.getSelectedItem().equals("Nombre")) {
            modelo.setRowCount(0);
            jLNombre.setVisible(true);
            jTFNombre.setVisible(true);
        } else if (jCBSeleccion.getSelectedItem().equals("Elegir")) {
            modelo.setRowCount(0);
            jLNombre.setVisible(false);
            jTFNombre.setVisible(false);
        }
    }//GEN-LAST:event_jCBSeleccionActionPerformed

    private void jTFNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreKeyReleased
        String ingreso = jTFNombre.getText();
        ArrayList<Paciente> lp = pd.buscarPacientesPorNombre(ingreso);
        enlistarPacientes(lp);
    }//GEN-LAST:event_jTFNombreKeyReleased

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void enlistarPacientes(ArrayList<Paciente> lista) {
        modelo.setRowCount(0);
        String estado = "";
        if (!lista.isEmpty()) {
            for (Paciente aux : lista) {
                if (aux.isEstado()) {
                    estado = "Activo";
                } else {
                    estado = "Inactivo";
                }
                modelo.addRow(new Object[]{
                    aux.getIdPaciente(),
                    aux.getNombre(),
                    aux.getEdad(),
                    aux.getAltura(),
                    pd.convertirSetString(aux.getCondicionSalud()),
                    aux.getPesoActual(),
                    aux.getPesoBuscado(),
                    aux.getPesoInicial(),
                    estado
                });
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<String> jCBSeleccion;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTtablaPacientes;
    // End of variables declaration//GEN-END:variables
}
