/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class VentanaLicenciasExpiradas extends javax.swing.JDialog {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) this.getParent();
    
    private final MyTableModel modeloTabla;
    private List<Carnet> listaExpirados;
    
    public VentanaLicenciasExpiradas(java.awt.Frame parent, boolean modal)  {
        super(parent, modal);
        initComponents();
        
//        JTExpirados.setDefaultRenderer(Object.class, new MyTableCellRenderer());
        modeloTabla = new MyTableModel(
            new Object [][] {},
            new String [] {
                "Nro de Licencia", "Fecha de Expiración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        JTExpirados.setModel(modeloTabla);
        JTExpirados.setDefaultRenderer(Object.class, new MyTableCellRenderer());
        
        listaExpirados = new ArrayList<>();
        
        jTHasta.setText(formatter.format(LocalDate.now()));
        
        try {
            completarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaLicenciasExpiradas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTDesde = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTHasta = new javax.swing.JTextField();
        jBtBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTExpirados = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jBImprimir = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Licencias Expiradas");

        jLabel1.setText("Desde");

        jTDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDesdeActionPerformed(evt);
            }
        });

        jLabel2.setText("Hasta");
        jLabel2.setToolTipText("");

        jTHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTHastaActionPerformed(evt);
            }
        });

        jBtBuscar.setText("Buscar");
        jBtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        JTExpirados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nro de Licencia", "Fecha de Expiración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTExpirados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTExpirados.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        JTExpirados.setPreferredSize(new java.awt.Dimension(354, 1000));
        JTExpirados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTExpiradosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTExpirados);
        if (JTExpirados.getColumnModel().getColumnCount() > 0) {
            JTExpirados.getColumnModel().getColumn(0).setResizable(false);
            JTExpirados.getColumnModel().getColumn(1).setResizable(false);
        }

        jBImprimir.setText("Imprimir...");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel17.setText("Ingrese un rango de fechas. El campo desde es opcional");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Buscar licencias expiradas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBImprimir))
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtBuscar))
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jBImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTDesde.getAccessibleContext().setAccessibleName("");
        jTDesde.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarActionPerformed
        try {
            if (jTHasta.getText().equals("")) {
                throw new CampoVacioException("HASTA");
            }
            
            completarTabla();
            
        } catch (CampoVacioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " no puede estar vacío.");
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Una o ambas fechas no son válidas. Deben estar en formato dd/mm/yyyy.");
        } catch (SQLException ex) {
            Logger.getLogger(VentanaLicenciasExpiradas.class.getName()).log(Level.SEVERE, null, ex);
        }                        
    }//GEN-LAST:event_jBtBuscarActionPerformed
        
    private void JTExpiradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTExpiradosMouseClicked
        
        if (evt.getClickCount() == 2){
            int fila = JTExpirados.getSelectedRow();
            Carnet c = listaExpirados.get(fila);
            
            VentanaDetallesCarnet ventanaDetallesCarnet = new VentanaDetallesCarnet(null, true, c, 0);
            ventanaDetallesCarnet.setVisible(true);
        }
    }//GEN-LAST:event_JTExpiradosMouseClicked

    private void jTDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDesdeActionPerformed

    private void jTHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTHastaActionPerformed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        if(listaExpirados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay elementos en la lista para imprimir.");
            return;
        }
        
        try {
            pdf unPdf = new pdf();
            unPdf.imprimirListaCarnets(listaExpirados, "Listado de Licencias Expiradas", true);
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de escritura al generar el PDF.");
        } 
    }//GEN-LAST:event_jBImprimirActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaLicenciasExpiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLicenciasExpiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLicenciasExpiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLicenciasExpiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaLicenciasExpiradas dialog = new VentanaLicenciasExpiradas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTExpirados;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBtBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTDesde;
    private javax.swing.JTextField jTHasta;
    // End of variables declaration//GEN-END:variables
    
    private void completarTabla() throws SQLException {
        LocalDate desde = jTDesde.getText().isEmpty() ? null : LocalDate.parse(jTDesde.getText(), formatter);
        LocalDate hasta = LocalDate.parse(jTHasta.getText(), formatter);

        Optional<LocalDate> expiracionDesde = Optional.ofNullable(desde);

        listaExpirados = DAOCarnet.expirados(expiracionDesde, hasta);

        //Borramos todas las filas
        int rowCount = modeloTabla.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }

        //llenamos el modelo con la lista
        listaExpirados.forEach((c) -> {
            modeloTabla.addRow(c);
        });
    }
    
    private static class CampoVacioException extends Exception {
        public CampoVacioException(String campo) {
            super(campo);
        }
    }
    
    private class MyTableModel extends DefaultTableModel {
        
        public MyTableModel(Object[][] data, Object[] columnNames) {
            super.setDataVector(data, columnNames);
        }

        List<Color> rowColours = new ArrayList<>();
        
        public void addRow(Carnet c) {
            addRow(new Object[]{c.getNumero().get(), c.getExpiracion().format(formatter)});
            Color color = (c.isExpirado()) ? Color.RED : Color.GREEN;
            
            int row = getRowCount();
            rowColours.add(color);
            fireTableRowsUpdated(row, row);
        }
        
        @Override
        public void removeRow(int row) {
            rowColours.remove(row);
            super.removeRow(row);
        }

        public Color getRowColour(int row) {
            return rowColours.get(row);
        }
    }
    
    public class MyTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            MyTableModel model = (MyTableModel) table.getModel();
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(model.getRowColour(row));
            return c;
        }
    }
}
