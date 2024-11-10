/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Dieta;
import Modelo.MenuDiario;
import Persistencia.DietaData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MostrarDieta extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTabla;
    private DietaData dietaData;
    private Dieta dieta;
    private List<Dieta> listaDietas ;
    
    public MostrarDieta() {
        initComponents();
        this.dietaData = new DietaData();
        this.dieta = new Dieta();
        modeloTabla = new DefaultTableModel();
        this.listaDietas =  dietaData.obtenerTodasLasDietas();
        
        // Inicializar columnas de dieta
        String[] columnasDieta = {"ID Dieta", "Nombre", "ID Paciente", "Fecha Inicio", "Fecha Final", "Total Calorías", "Estado"};
        modeloTabla.setColumnIdentifiers(columnasDieta);
        
        // Asignar el modelo a la tabla y bloquear edición
        jTablaDietaLista.setModel(modeloTabla);
        jTablaDietaLista.setDefaultEditor(Object.class, null);

        // Cargar dietas al inicio
        cargarDietasEnTabla();
    }
    
    
    public void cargarDietasEnTabla() {
        modeloTabla.setRowCount(0);
      
        for (Dieta dieta : listaDietas) {
            modeloTabla.addRow(new Object[] {
                dieta.getIdDieta(),
                dieta.getNombreD(),
                dieta.getPaciente().getIdPaciente(),
                dieta.getFechaIni(),
                dieta.getFechaFin(),
                dieta.getTotalCalorias(),
                dieta.isEstado()
            });
        }
        
    }

//    public void cargarDietasComidasEnTabla() {
//        List<Dieta> listaDietas = dietaData.obtenerTodasLasDietas();
//        modeloTabla.setRowCount(0);  // Limpiar la tabla
//        for (Dieta dieta : listaDietas) {
//            modeloTabla.addRow(new Object[] {
//                dieta.getIdDieta(),
//                dieta.getNombreD(),
//                dieta.getPaciente().getIdPaciente(),
//                dieta.getFechaIni(),
//                dieta.getFechaFin(),
//                dieta.getTotalCalorias(),
//                dieta.isEstado()
//            });
//        }
//        
//        // Configurar el evento de selección para cargar las comidas
//        jTablaDietaLista.getSelectionModel().addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                int filaSeleccionada = jTablaDietaLista.getSelectedRow();
//                if (filaSeleccionada != -1) {
//                    int idDietaSeleccionada = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
//                    cargarMenuYComidasPorDieta(idDietaSeleccionada);
//                }
//            }
//        });
//    }
    
    public void cargarMenuYComidasPorDieta(int idDieta) {
        Dieta dietaSeleccionada = dietaData.buscarDietaSegunID(idDieta);

        // Cambiar las columnas para mostrar menús y comidas
        String[] columnasMenuComida = {"ID Menú", "ID Comida", "Nombre Comida", "Tipo Comida", "Calorías", "No Apto", "Estado Comida"};
        modeloTabla.setColumnIdentifiers(columnasMenuComida);
        modeloTabla.setRowCount(0);  // Limpiar la tabla

        // Cargar datos de menús y comidas
        for (MenuDiario menu : dietaSeleccionada.getMenus()) {
            for (Modelo.Comidas comida : menu.getComidas()) {
                modeloTabla.addRow(new Object[] {
                    menu.getIdMenu(),
                    comida.getIdComida(),
                    comida.getNombre(),
                    comida.getTipoDeComida(),
                    comida.getCaloriasComida(),
                    comida.getNoApto(),
                    comida.isEstado()
                });
            }
        }
    }
    public void recargarInternalFrame() {
    modeloTabla.setRowCount(0);
   

    // Redibujar y actualizar la vista del JInternalFrame
    MostrarDieta mostrar = new MostrarDieta();
    mostrar.revalidate();
    mostrar.repaint();
    cargarDietasEnTabla();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDietaLista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();

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
        jTablaDietaLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaDietaListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaDietaLista);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Lista De Dietas");

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVolver))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVolver)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaDietaListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaDietaListaMouseClicked
                                              
    int filaSeleccionada = jTablaDietaLista.getSelectedRow();
        if (filaSeleccionada != -1) {
        int idDietaSeleccionada = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        cargarMenuYComidasPorDieta(idDietaSeleccionada);
        }
    
    }//GEN-LAST:event_jTablaDietaListaMouseClicked

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
      cargarDietasEnTabla();
    }//GEN-LAST:event_jButtonVolverActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDietaLista;
    // End of variables declaration//GEN-END:variables
}
