/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Comidas;

import Persistencia.ComidaData;
import Persistencia.IngredientesData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JuanCZ
 */
public class ListarComidas extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = null;
    ComidaData cd = new ComidaData();
    IngredientesData id = new IngredientesData();

    public ListarComidas() {
        initComponents();
        modelo = (DefaultTableModel) jTListaComidas.getModel();
        setfal();
        setResizable(true);
        jCBlistar.setSelectedIndex(-1);
        JCBTipo.setSelectedIndex(-1);
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
        jCBlistar = new javax.swing.JComboBox<>();
        JCBTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLTipo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaComidas = new javax.swing.JTable();
        jLMin = new javax.swing.JLabel();
        jTFMin = new javax.swing.JTextField();
        jTFMax = new javax.swing.JTextField();
        jLMax = new javax.swing.JLabel();
        jBbuscar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jCBlistar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Listar Todos", "Listar Activos", "Listar No Activos", "Listar Por Tipo", "Calorias" }));
        jCBlistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBlistarActionPerformed(evt);
            }
        });

        JCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Colacion", "Almuerzo", "Merienda", "Cena" }));
        JCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTipoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listar por:");

        jLTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLTipo.setForeground(new java.awt.Color(255, 255, 255));
        jLTipo.setText("Tipo de Comida:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Listar Comidas");

        jTListaComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Calorias", "No Apto", "Ingredientes", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTListaComidas);
        if (jTListaComidas.getColumnModel().getColumnCount() > 0) {
            jTListaComidas.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTListaComidas.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        jLMin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLMin.setForeground(new java.awt.Color(255, 255, 255));
        jLMin.setText("Minimo");

        jLMax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLMax.setForeground(new java.awt.Color(255, 255, 255));
        jLMax.setText("Maximo");

        jBbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jBbuscar.setText("Buscar");
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jBsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/puerta-abierta.png"))); // NOI18N
        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBlistar, 0, 149, Short.MAX_VALUE)
                            .addComponent(JCBTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBsalir)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addComponent(jBbuscar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLMax)
                                                .addGap(76, 76, 76)
                                                .addComponent(jLMin))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(jTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBlistar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLTipo))
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBsalir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jBbuscar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLMin)
                            .addComponent(jLMax))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBTipoActionPerformed
        if (JCBTipo.getSelectedItem() != null) {
            ArrayList<Comidas> listacompleta = cd.listarComidasAll();
            String tipoSeleccionado = (String) JCBTipo.getSelectedItem();
            ArrayList<Comidas> lista = new ArrayList<>();
            ArrayList<String> ingredientes = new ArrayList<>();

            for (Comidas comidas : listacompleta) {
                if (tipoSeleccionado.equals(comidas.getTipoDeComida())) {
                    String ingred = "";
                    lista.add(comidas);
                    HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(comidas.getIdComida());
                    for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                        ingred += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                    }
                    ingredientes.add(ingred.trim());
                }
            }
            enlistarComidas(lista, ingredientes);
        }
    }//GEN-LAST:event_JCBTipoActionPerformed

    private void jCBlistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBlistarActionPerformed
        if (jCBlistar.getSelectedItem() != null) {

            String seleccion = (String) jCBlistar.getSelectedItem();
            ArrayList<Comidas> list = cd.listarComidasAll();
            ArrayList<String> ingredientes = new ArrayList<>();
            switch (seleccion) {
                case "Listar Todos" -> {
                    for (Comidas com : list) {
                        String ingreds0 = "";
                        HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(com.getIdComida());
                        for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                            ingreds0 += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                        }
                        ingredientes.add(ingreds0);
                    }
                    setfal();

                    enlistarComidas(list, ingredientes);
                }
                case "Listar Activos" -> {
                    ArrayList<Comidas> act = new ArrayList<>();
                    for (Comidas com : list) {
                        String ingreds1 = "";
                        if (com.isEstado() == true) {
                            act.add(com);
                            HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(com.getIdComida());
                            for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                                ingreds1 += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                            }
                            ingredientes.add(ingreds1);
                        }
                    }
                    setfal();
                    enlistarComidas(act, ingredientes);
                }
                case "Listar No Activos" -> {
                    ArrayList<Comidas> noact = new ArrayList<>();
                    for (Comidas com : list) {
                        String ingreds = "";
                        if (com.isEstado() == false) {
                            noact.add(com);
                            HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(com.getIdComida());
                            for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                                ingreds += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                            }
                            ingredientes.add(ingreds);
                        }
                    }
                    setfal();
                    enlistarComidas(noact, ingredientes);
                }
                case "Listar Por Tipo" -> {
                    jLTipo.setEnabled(true);
                    JCBTipo.setEnabled(true);
                }
                case "Calorias" -> {
                    jLMax.setEnabled(true);
                    jLMin.setEnabled(true);
                    jTFMax.setEnabled(true);
                    jTFMin.setEnabled(true);
                    jBbuscar.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_jCBlistarActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        ArrayList<String> ingredientes = new ArrayList<>();
        try {
            if (jTFMin.getText().isEmpty() && jTFMax.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar al menos un valor para las calorías.");
                return;
            }

            ArrayList<Comidas> lista = new ArrayList<>();

            if (!jTFMin.getText().isEmpty() && jTFMax.getText().isEmpty()) {
                double min = Double.parseDouble(jTFMin.getText());
                for (Comidas com : cd.listaMinCalorias(min)) {
                    String ingreds = "";
                    lista.add(com);
                    HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(com.getIdComida());
                    for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                        ingreds += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                    }
                    ingredientes.add(ingreds);
                }
            } else if (jTFMin.getText().isEmpty() && !jTFMax.getText().isEmpty()) {
                double max = Double.parseDouble(jTFMax.getText());
                for (Comidas com : cd.listaMaxCalorias(max)) {
                    String ingreds = "";
                    lista.add(com);
                    HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(com.getIdComida());
                    for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                        ingreds += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                    }
                    ingredientes.add(ingreds);
                }
            } else if (!jTFMin.getText().isEmpty() && !jTFMax.getText().isEmpty()) {
                double min = Double.parseDouble(jTFMin.getText());
                double max = Double.parseDouble(jTFMax.getText());
                for (Comidas com : cd.listaMinMaxCalorias(min, max)) {
                    String ingreds = "";
                    lista.add(com);
                    HashMap<Integer, Double> ingredientesPesos = cd.buscarIngredientesComidas(com.getIdComida());
                    for (Map.Entry<Integer, Double> entry : ingredientesPesos.entrySet()) {
                        ingreds += id.buscarIngredientes(entry.getKey()).getNombre() + " ";
                    }
                    ingredientes.add(ingreds);
                }
            }

            enlistarComidas(lista, ingredientes);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese unicamente numeros");
        }
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed
    private void enlistarComidas(ArrayList<Comidas> lista, ArrayList<String> ingredientes) {
        int i = 0;
        modelo.setRowCount(0);
        String estado = "";
        if (!lista.isEmpty()) {
            for (Comidas aux : lista) {
                if (aux.isEstado()) {
                    estado = "Activo";
                } else {
                    estado = "Inactivo";

                }
                modelo.addRow(new Object[]{
                    aux.getIdComida(),
                    aux.getNombre(),
                    aux.getTipoDeComida(),
                    aux.getCaloriasComida(),
                    aux.getNoApto(),
                    ingredientes.get(i),
                    estado
                });
                i++;
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay comidas para esa restriccion, ingrese nuevamente los valores");
        }
    }

    public void setfal() {
        jLTipo.setEnabled(false);
        JCBTipo.setEnabled(false);
        jTFMin.setEnabled(false);
        jTFMax.setEnabled(false);
        jLMin.setEnabled(false);
        jLMax.setEnabled(false);
        jTFMin.setText("");
        jTFMax.setText("");
        jBbuscar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBTipo;
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<String> jCBlistar;
    private javax.swing.JLabel jLMax;
    private javax.swing.JLabel jLMin;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFMax;
    private javax.swing.JTextField jTFMin;
    private javax.swing.JTable jTListaComidas;
    // End of variables declaration//GEN-END:variables
}
