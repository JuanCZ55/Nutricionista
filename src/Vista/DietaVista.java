
package Vista;
import Modelo.Dieta;
import Modelo.Paciente;
import Persistencia.DietaData;
import Persistencia.PacienteData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class DietaVista extends JInternalFrameImagen {

    private DefaultTableModel TbDieta;
    private Persistencia.DietaData dietaData;
    private List<Dieta> listaDieta ;
   
    public DietaVista() {
        initComponents();
        this.dietaData = new DietaData();
        this.listaDieta = new ArrayList<>();
        this.setImagen("/resouces/verduras.png");//Buscar una imagen y ponerla
        this.TbDieta = new DefaultTableModel();
        this.setSize(885, 650);
        jTablaDietaVista.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
        TbDieta.addColumn("Id Dieta");
        TbDieta.addColumn("Nombre");
        TbDieta.addColumn("IDPaciente");
        TbDieta.addColumn("Fecha inicio");
        TbDieta.addColumn("Fecha final");
        TbDieta.addColumn("Total calorias");
        TbDieta.addColumn("Estado");
        jTablaDietaVista.setModel(TbDieta);
       
    }
    public void llenarTabla(){
    TbDieta.setRowCount(0);
    if (listaDieta == null || listaDieta.isEmpty()) {
        return; 
    }
        for (Dieta dieta : listaDieta) {
            if (dieta != null) {
                Object[] rowData = new Object[7];
                rowData[0] = dieta.getIdDieta();
                rowData[1] = dieta.getNombreD();
                rowData[2] = dieta.getPaciente().getNombre(); 
                rowData[3] = dieta.getFechaIni();
                rowData[4] = dieta.getFechaFin();
                rowData[5] = dieta.getTotalCalorias();
                rowData[6] = dieta.isEstado();

                TbDieta.addRow(rowData);
            }
    
            }
                
        }
    
    public void actualizarDietaEnLista(int idDietaSeleccionada, String nombreDieta, LocalDate fechaInicial, LocalDate fechaFinal, double totalCalorias) {
    // Buscar la dieta en la lista y actualizar los valores
    for (Dieta dieta : listaDieta) {
       
            dieta.setNombreD(nombreDieta);
            dieta.setFechaIni(fechaInicial);
            dieta.setFechaFin(fechaFinal);
            dieta.setTotalCalorias(totalCalorias);
      
        
    }
} 

    public void actualizarDietaEstado(int idDietaSeleccionada, boolean estado) {
    // Buscar la dieta en la lista por el ID y actualizar solo esa dieta
    for (Dieta dieta : listaDieta) {
        if (dieta.getIdDieta() == idDietaSeleccionada) {
            dieta.setEstado(estado); 
            break;
        }
    }
}   public void actualizarFilaTabla(int idDietaSeleccionada, boolean nuevoEstado) {
    DefaultTableModel model = (DefaultTableModel) jTablaDietaVista.getModel();

    // Buscar la fila correspondiente al ID de dieta seleccionada
    for (int i = 0; i < model.getRowCount(); i++) {
        int idDieta = (int) model.getValueAt(i, 0);
        if (idDieta == idDietaSeleccionada) {
            model.setValueAt(nuevoEstado, i, 6); 
            break; 
        }
    }
}
        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDietaVista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCalendariFinal = new com.toedter.calendar.JDateChooser();
        jCalendariInicial = new com.toedter.calendar.JDateChooser();
        jTextFieldIDpaciente = new javax.swing.JTextField();
        jTextFieldBuscarPorNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/cycle_11044764.png"))); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTablaDietaVista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablaDietaVista);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/BuscarDietas.png"))); // NOI18N

        jLabel3.setText("Buscar por el Nombre de dieta");

        jLabel2.setText("Buscar por ID del paciente");

        jLabel4.setText("Ingrese Fecha Inicial y  final");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldIDpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCalendariInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCalendariFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jTextFieldBuscarPorNombre))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldIDpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCalendariFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jCalendariInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)))))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/delete_4980658.png"))); // NOI18N
        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/LUPA_CHICA.png"))); // NOI18N
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/refresh_11044876.png"))); // NOI18N
        jButton7.setText("Baja / Alta");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setText("Personalice la dieta combiando nombreDieta, fechas, calorias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(64, 64, 64)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    String textID = jTextFieldIDpaciente.getText().trim();
    String textNombre = jTextFieldBuscarPorNombre.getText().trim();
    LocalDate fechaInicial = null;
    LocalDate fechaFinal = null;

    // Verificamos si se seleccionó una fecha en jCalendariInicial para no tener error
    if (jCalendariInicial.getDate() != null) {
        fechaInicial = jCalendariInicial.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    if (jCalendariFinal.getDate() != null) {
        fechaFinal = jCalendariFinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    listaDieta.clear();  

    try {
        
        if (!textID.isEmpty() && !textNombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese solo ID o solo Nombre, no ambos.");
            jCalendariInicial.setDate(null);
            jCalendariFinal.setDate(null);
            jTextFieldIDpaciente.setText(""); 
            jTextFieldBuscarPorNombre.setText(""); 
            return;
        } else if (!textID.isEmpty() && (fechaInicial != null || fechaFinal != null)) {
            JOptionPane.showMessageDialog(this, "Ingrese solo el ID, sin fechas.");
            jCalendariInicial.setDate(null);
            jCalendariFinal.setDate(null);
            jTextFieldIDpaciente.setText(""); 
            jTextFieldBuscarPorNombre.setText(""); 
            return;
        } else if (!textNombre.isEmpty() && (fechaInicial != null || fechaFinal != null)) {
            JOptionPane.showMessageDialog(this, "Ingrese solo el Nombre, sin fechas.");
            jCalendariInicial.setDate(null);
            jCalendariFinal.setDate(null);
            jTextFieldIDpaciente.setText(""); 
            jTextFieldBuscarPorNombre.setText(""); 
            return;
        } else if ((fechaInicial != null && fechaFinal == null) || (fechaInicial == null && fechaFinal != null)) {
            JOptionPane.showMessageDialog(this, "Seleccione ambas fechas para buscar por rango.");
            return;
        }

       
        if (!textID.isEmpty()) {
            int idPaciente = Integer.parseInt(textID);
            Dieta dieta = dietaData.obtenerDieta(idPaciente);
            if (dieta != null) {
                listaDieta.add(dieta);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna dieta para el paciente con ID: " + idPaciente);
            }
        }

        // Búsqueda por Nombre
        if (!textNombre.isEmpty()) {
            Dieta dieta = dietaData.buscarDietaSegunNombre(textNombre);
            if (dieta != null) {
                listaDieta.add(dieta);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna dieta con el nombre: " + textNombre);
            }
        }

        // Búsqueda por Rango de Fechas
        if (fechaInicial != null && fechaFinal != null) {
            List<Dieta> dietasPorFecha = dietaData.buscarDietasEnRangoDeFechas(fechaInicial, fechaFinal);
            if (dietasPorFecha != null && !dietasPorFecha.isEmpty()) {
                listaDieta.addAll(dietasPorFecha);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron dietas en el rango de fechas especificado.");
            }
        }
            jCalendariInicial.setDate(null);
            jCalendariFinal.setDate(null);
            jTextFieldIDpaciente.setText(""); 
            jTextFieldBuscarPorNombre.setText(""); 
        llenarTabla();  

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de paciente válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        
    }

    }//GEN-LAST:event_jButton5ActionPerformed
    public void cambiarEstado(){
    int filaSeleccionada = jTablaDietaVista.getSelectedRow();
    if (filaSeleccionada != -1) { // Verificar si se ha seleccionado una fila
        // Obtener el ID de la dieta directamente desde la tabla que se encuentra en la columna 0
        int idDietaSeleccionada = (int) jTablaDietaVista.getValueAt(filaSeleccionada, 0);

        // Buscar la dieta original en la base de datos
        Dieta dietaOriginal = dietaData.buscarDietaSegunID(idDietaSeleccionada);

        // Verificar el estado actual de la dieta
        boolean nuevoEstado = !dietaOriginal.isEstado(); // Cambiar el estado (si es true pasa a false y viceversa)

        // Verifica si el estado ha cambiado
        if (dietaOriginal.isEstado() != nuevoEstado) {
            dietaOriginal.setEstado(nuevoEstado);  // Actualiza el estado de la dieta

            // Actualizar la dieta en la base de datos
            dietaData.actualizarDieta(dietaOriginal);
           
            // Actualizar solo el estado de la dieta seleccionada en la lista
            actualizarDietaEstado(idDietaSeleccionada, nuevoEstado);

            // Actualizar la fila de la tabla
            actualizarFilaTabla(idDietaSeleccionada, nuevoEstado);

            JOptionPane.showMessageDialog(null, "Estado de la dieta actualizado correctamente.");
        } else {
           
            JOptionPane.showMessageDialog(null, "No se detectaron cambios en el estado de la dieta.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.", "Sin cambios", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    public void actualizarTabla() {
    int filaSeleccionada = jTablaDietaVista.getSelectedRow();
    if (filaSeleccionada != -1) { // Verificar si se ha seleccionado una fila
        // Obtener el ID de la dieta directamente desde la tabla que se encuentra en la columna 0
        int idDietaSeleccionada = (int) jTablaDietaVista.getValueAt(filaSeleccionada, 0);
       
        // Buscar la dieta original en la base de datos con el ID buscado antes en la tabla
    Dieta dietaOriginal = dietaData.buscarDietaSegunID(idDietaSeleccionada);
    String nombreDieta = dietaOriginal.getNombreD();
    LocalDate fechaInicial = dietaOriginal.getFechaIni();
    LocalDate fechaFinal = dietaOriginal.getFechaFin();
    double totalCalorias = dietaOriginal.getTotalCalorias();
   

    // Obtener los valores actuales en la tabla y manejar valores null
    String nombreDietaTabla = (jTablaDietaVista.getValueAt(filaSeleccionada, 1) != null)
        ? jTablaDietaVista.getValueAt(filaSeleccionada, 1).toString(): nombreDieta;

    LocalDate fechaInicialTabla = (jTablaDietaVista.getValueAt(filaSeleccionada, 3) != null)
        ? LocalDate.parse(jTablaDietaVista.getValueAt(filaSeleccionada, 3).toString()): fechaInicial;

    LocalDate fechaFinalTabla = (jTablaDietaVista.getValueAt(filaSeleccionada, 4) != null)
        ? LocalDate.parse(jTablaDietaVista.getValueAt(filaSeleccionada, 4).toString()) : fechaFinal;

    double totalCaloriasTabla = (jTablaDietaVista.getValueAt(filaSeleccionada, 5) != null)
        ? Double.parseDouble(jTablaDietaVista.getValueAt(filaSeleccionada, 5).toString()): totalCalorias;
    
    // Verifica si hay cambios entre los valores originales y los de la tabla
    if (!nombreDieta.equals(nombreDietaTabla)|| 
    !fechaInicial.equals(fechaInicialTabla) || !fechaFinal.equals(fechaFinalTabla) ||
    totalCalorias != totalCaloriasTabla) {

    //reseteo los valores de busque luego de hacerla
    dietaOriginal.setNombreD(nombreDietaTabla);
    dietaOriginal.setFechaIni(fechaInicialTabla);
    dietaOriginal.setFechaFin(fechaFinalTabla);
    dietaOriginal.setTotalCalorias(totalCaloriasTabla);
    
    // Si hay cambios, actualiza la dieta en la base de datos
    dietaData.actualizarDieta(dietaOriginal);
    actualizarDietaEnLista(idDietaSeleccionada,nombreDieta,fechaInicial,fechaFinal,totalCalorias);
    JOptionPane.showMessageDialog(null, "Dieta actualizada correctamente.");
    
        } else {
            JOptionPane.showMessageDialog(null, "No se detectaron cambios en la dieta.");
        }
        } else {
            JOptionPane.showMessageDialog(this, "No se han detectado cambios en la fila seleccionada", "Sin cambios", JOptionPane.INFORMATION_MESSAGE);
        }
    }




 
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     cambiarEstado();
     
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      actualizarTabla();  
    
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jCalendariFinal;
    private com.toedter.calendar.JDateChooser jCalendariInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDietaVista;
    private javax.swing.JTextField jTextFieldBuscarPorNombre;
    private javax.swing.JTextField jTextFieldIDpaciente;
    // End of variables declaration//GEN-END:variables
}
