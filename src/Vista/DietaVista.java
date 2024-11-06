
package Vista;
import Modelo.Dieta;
import Modelo.Paciente;
import Persistencia.DietaData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DietaVista extends javax.swing.JInternalFrame {

    private DefaultTableModel TbDieta;
    private Persistencia.DietaData dietaData;
    public static List<Dieta> listaDieta = new ArrayList<>();
     
    public DietaVista() {
        initComponents();
        this.dietaData = new DietaData();
        //this.setImagen("/imagen/FondoAzulRombo.png");//Buscar una imagen y ponerla
        this.TbDieta = new DefaultTableModel();
        TbDieta.addColumn("Id Dieta");
        TbDieta.addColumn("Nombre");
        TbDieta.addColumn("IDPaciente");
        TbDieta.addColumn("Fecha inicio");
        TbDieta.addColumn("Fecha final");
        TbDieta.addColumn("Total calorias");
        TbDieta.addColumn("Estado");
        jTablaDietaVista.setModel(TbDieta);
        //llenarTabla(); Hacer el metodo para llenar la tabla
    }
    public void llenarTabla(List<Modelo.Dieta> listaDieta){
    TbDieta.setRowCount(0);
    if (listaDieta == null || listaDieta.isEmpty()) {
        return; 
    }
        for (Modelo.Dieta dieta : listaDieta) {
            if (dieta != null) {
                Object[] rowData = new Object[9];
                rowData[0] = dieta.getIdDieta();
                rowData[1] = dieta.getNombreD();
                rowData[2] = dieta.getPaciente().getNombre(); // Obtén el nombre del paciente
                rowData[3] = dieta.getFechaIni();
                rowData[4] = dieta.getFechaFin();
                rowData[7] = dieta.getTotalCalorias();
                rowData[8] = dieta.isEstado();

                TbDieta.addRow(rowData); // Agrega la fila a la tabla
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
        jButton6 = new javax.swing.JButton();

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
        jLabel1.setText("Dietas segun paciente");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
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

        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Baja");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setText("Alta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    String textID = jTextFieldIDpaciente.getText().trim();
    String textNombre = jTextFieldBuscarPorNombre.getText().trim();
    Dieta dieta = null;
    int filaSeleccionada = jTablaDietaVista.getSelectedRow();
    Dieta dietaSeleccionada = null;

     
        if (!textID.isEmpty()) {
            int idPaciente = Integer.parseInt(textID);  
            dieta = dietaData.obtenerDieta(idPaciente);
            dietaData.altaLogica(dieta.getIdDieta());
            
        }
        if (!textNombre.isEmpty()) {
           dieta = dietaData.buscarDietaSegunNombre(textNombre);
           dietaData.altaLogica(dieta.getIdDieta());
            
        }
        if (filaSeleccionada >= 0) {
            dietaSeleccionada = (Modelo.Dieta) jTablaDietaVista.getValueAt(filaSeleccionada, 0); 
            if (dietaSeleccionada != null) {
                 dietaData.altaLogica(dietaSeleccionada.getIdDieta()); // Guarda la dieta seleccionada 
            }
            
        }
    
    }//GEN-LAST:event_jButton6ActionPerformed

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
    
    Modelo.Dieta dieta = null;
    
    
     try { 
         if (!textID.isEmpty() && !textNombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese solo ID o solo Nombre, no ambos.");
            return;
        } else if (!textID.isEmpty() && (fechaInicial != null || fechaFinal != null)) {
            JOptionPane.showMessageDialog(this, "Ingrese solo el ID, sin fechas.");
            return;
        } else if (!textNombre.isEmpty() && (fechaInicial != null || fechaFinal != null)) {
            JOptionPane.showMessageDialog(this, "Ingrese solo el Nombre, sin fechas.");
            return;
        } else if (fechaInicial != null && fechaFinal == null || fechaInicial == null && fechaFinal != null) {
            JOptionPane.showMessageDialog(this, "Seleccione ambas fechas para buscar por rango.");
            return;
        }
         
        if (!textID.isEmpty()) {
            int idPaciente = Integer.parseInt(textID);  
            dieta = dietaData.obtenerDieta(idPaciente);
            if (dieta != null) { // Añadir sólo si dieta no es nulo evita el error
                listaDieta.add(dieta);
            } else if(textNombre.isEmpty() && (fechaInicial == null) && (fechaFinal == null)) {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna dieta para el paciente con ID: " + idPaciente);
            }
        }
        if (!textNombre.isEmpty()) {
           dieta = dietaData.buscarDietaSegunNombre(textNombre);
            if (dieta != null) {
                listaDieta.add(dieta);
            } else if(textID.isEmpty() && (fechaInicial == null) && (fechaFinal == null)){
                JOptionPane.showMessageDialog(this, "No se encontró ninguna dieta con el nombre: " + textNombre);
            }
        }
          if (fechaInicial != null && fechaFinal != null) {
            List<Dieta> dietasPorFecha = dietaData.buscarDietasEnRangoDeFechas(fechaInicial, fechaFinal);
            if (dietasPorFecha != null && !dietasPorFecha.isEmpty()) {
                listaDieta.addAll(dietasPorFecha);
            } else if(textID.isEmpty() && textNombre.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "No se encontraron dietas en el rango de fechas especificado.");
            }
        }

        llenarTabla(listaDieta);
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de paciente válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    public void actualizarTabla() {
        
    int filaSeleccionada = jTablaDietaVista.getSelectedRow();
    if (filaSeleccionada != -1) { // Verificar si se ha seleccionado una fila
        // Obtener el ID de la dieta directamente desde la tabla que se encuentra en la columna 0
        int idDietaSeleccionada = (int) jTablaDietaVista.getValueAt(filaSeleccionada, 0);

        // Buscar la dieta seleccionada en la base de datos
        Dieta dietaOriginal = dietaData.buscarDietaSegunID(idDietaSeleccionada);
        String nombreDieta = dietaOriginal.getNombreD();
        LocalDate fechaInicial = dietaOriginal.getFechaIni();
        LocalDate fechaFinal = dietaOriginal.getFechaFin();
        double totalCalorias = dietaOriginal.getTotalCalorias();
        boolean estado = dietaOriginal.isEstado();

        // Obtener y setear los valores actuales de la fila seleccionada en la tabla
        String nombreDietaTabla = (String) jTablaDietaVista.getValueAt(filaSeleccionada, 1);
        LocalDate fechaInicialTabla = (LocalDate) jTablaDietaVista.getValueAt(filaSeleccionada, 3);
        LocalDate fechaFinalTabla = (LocalDate) jTablaDietaVista.getValueAt(filaSeleccionada, 4);
        double totalCaloriasTabla = (double) jTablaDietaVista.getValueAt(filaSeleccionada, 5);
        boolean estadoTabla = (boolean) jTablaDietaVista.getValueAt(filaSeleccionada, 6);

        // Verificar si hay cambios, sin incluir idPaciente
        boolean hayCambios = !nombreDieta.equals(nombreDietaTabla)
                || !fechaInicial.equals(fechaInicialTabla)
                || !fechaFinal.equals(fechaFinalTabla)
                || totalCalorias != totalCaloriasTabla
                || estado != estadoTabla;

        if (hayCambios) {
            // Crear el objeto Dieta con los valores actualizados de la tabla, excluyendo idPaciente
            Dieta dietaActualizada = new Dieta();
            dietaActualizada.setIdDieta(idDietaSeleccionada);
            dietaActualizada.setNombreD(nombreDietaTabla);
            dietaActualizada.setFechaIni(fechaInicialTabla);
            dietaActualizada.setFechaFin(fechaFinalTabla);
            dietaActualizada.setTotalCalorias(totalCaloriasTabla);
            dietaActualizada.setEstado(estadoTabla);

            // Llamar al método para actualizar la dieta en la base de datos
            dietaData.actualizarDieta(dietaActualizada);
        } else {
            JOptionPane.showMessageDialog(this, "No se han detectado cambios en la fila seleccionada", "Sin cambios", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para actualizar", "Error", JOptionPane.WARNING_MESSAGE);
    }
}

    

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    
    String textID = jTextFieldIDpaciente.getText().trim();
    String textNombre = jTextFieldBuscarPorNombre.getText().trim();
    Dieta dieta = null;
    int filaSeleccionada = jTablaDietaVista.getSelectedRow();
    Dieta dietaSeleccionada = null;

     
        if (!textID.isEmpty()) {
            int idPaciente = Integer.parseInt(textID);  
            dieta = dietaData.obtenerDieta(idPaciente);
            dietaData.altaLogica(dieta.getIdDieta());
            
        }
        if (!textNombre.isEmpty()) {
           dieta = dietaData.buscarDietaSegunNombre(textNombre);
           dietaData.altaLogica(dieta.getIdDieta());
            
        }
        if (filaSeleccionada >= 0) {
            dietaSeleccionada = (Modelo.Dieta) jTablaDietaVista.getValueAt(filaSeleccionada, 0); 
            if (dietaSeleccionada != null) {
                 dietaData.altaLogica(dietaSeleccionada.getIdDieta()); // Guarda la dieta seleccionada 
            }
            
        }
        
    
                       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filaSeleccionada = jTablaDietaVista.getSelectedRow();
        int idDietaSeleccionada = (int) jTablaDietaVista.getValueAt(filaSeleccionada, 0);
        dietaData.borrarDieta(idDietaSeleccionada);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      actualizarTabla();  
    
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jCalendariFinal;
    private com.toedter.calendar.JDateChooser jCalendariInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDietaVista;
    private javax.swing.JTextField jTextFieldBuscarPorNombre;
    private javax.swing.JTextField jTextFieldIDpaciente;
    // End of variables declaration//GEN-END:variables
}
