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


public class MostrarDieta extends JInternalFrameImagen {
    private DefaultTableModel modeloTabla;
    private DietaData dietaData;
    private Dieta dieta;
    private List<Dieta> listaDietas ;
    
    public MostrarDieta() {
        initComponents();
        this.setImagen("/resouces/verduras.png");//Buscar una imagen y ponerla
        this.dietaData = new DietaData();
        this.dieta = new Dieta();
        modeloTabla = new DefaultTableModel();
        this.listaDietas =  dietaData.obtenerTodasLasDietas();
        this.setSize(885, 650);
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
         // Inicializar columnas de dieta
        String[] columnasDieta = {"ID Dieta", "Nombre", "ID Paciente", "Fecha Inicio", "Fecha Final", "Total Calorías", "Estado"};
        modeloTabla.setColumnIdentifiers(columnasDieta);
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
        jLabel2 = new javax.swing.JLabel();

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

        jLabel1.setBackground(new java.awt.Color(0, 102, 0));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Nutricionista\\src\\resouces\\Lista.png")); // NOI18N

        jButtonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/above_thearrow_1550.png"))); // NOI18N
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione una dieta para ver los menus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDietaLista;
    // End of variables declaration//GEN-END:variables
}
