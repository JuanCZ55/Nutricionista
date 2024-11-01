
package Vista;
import Modelo.Dieta;
import Persistencia.DietaData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DietaVista extends javax.swing.JInternalFrame {

    private DefaultTableModel TbDieta;
    private Persistencia.DietaData dietaData;
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
        TbDieta.addColumn("Peso inicial");
        TbDieta.addColumn("Peso final");
        TbDieta.addColumn("Total calorias");
        TbDieta.addColumn("Estado");
        jTablDieta.setModel(TbDieta);
        jTablDieta.setDefaultEditor(Object.class, null);
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
                rowData[5] = dieta.getPesoInicial();
                rowData[6] = dieta.getPesoFinal();
                rowData[7] = dieta.getTotalCalorias();
                rowData[8] = dieta.isEstado();

                TbDieta.addRow(rowData); // Agrega la fila a la tabla
            }
    
            }
                
        }
        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGuardar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablDieta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCalendariFinal = new com.toedter.calendar.JDateChooser();
        jCalendariInicial = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextFieldIDpaciente = new javax.swing.JTextField();
        jTextFieldBuscarPorNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");

        jButton2.setText("Actualizar");

        jTablDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablDieta);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Dietas segun paciente");

        jLabel3.setText("Buscar por el Nombre de dieta");

        jLabel2.setText("Buscar por ID del paciente");

        jLabel4.setText("Ingrese Fecha Inicial y  final");

        jButton7.setText("Baja");

        jButton6.setText("Alta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

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
                        .addGap(78, 78, 78)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCalendariFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jTextFieldBuscarPorNombre))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton7)
                                .addComponent(jButton6))
                            .addComponent(jLabel5))
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

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButton5))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
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
    
    List<Modelo.Dieta> listaDieta = new ArrayList<>();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonGuardar;
    private com.toedter.calendar.JDateChooser jCalendariFinal;
    private com.toedter.calendar.JDateChooser jCalendariInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablDieta;
    private javax.swing.JTextField jTextFieldBuscarPorNombre;
    private javax.swing.JTextField jTextFieldIDpaciente;
    // End of variables declaration//GEN-END:variables
}
