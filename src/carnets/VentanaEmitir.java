/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import carnets.Carnet.CarnetAnteriorInvalidoException;
import carnets.Carnet.CarnetAnteriorRequeridoException;
import carnets.Carnet.EsMayorParaPrimerProfesionalException;
import carnets.Carnet.EsMenorException;
import carnets.Carnet.EsMenorParaProfesionalException;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class VentanaEmitir extends javax.swing.JDialog {
    private final VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) this.getParent();
    private final ComboBoxModel<String> tipoDNIModel;
    private final ComboBoxModel<String> grupoSanguineoModel;
    private final ComboBoxModel<String> factorSanguineoModel;
    private final ComboBoxModel<String> claseModel;
    private Clase claseSeleccionada;
    private TipoDocumento tipoDocumentoSeleccionado;
    private Optional<Titular> titularEncontrado = Optional.empty();
    private Optional<Integer> costo;
    
    static private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /**
     * Creates new form VentanaEmitir
     */
    public VentanaEmitir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        // Init tipoDNICombo
        ArrayList<String> tipoDNIModelItems = new ArrayList<>();
        for (TipoDocumento tipoDocumento: ventanaPrincipal.tipoDocumentos) {
            tipoDNIModelItems.add(tipoDocumento.nombre);
        }
        tipoDNIModel = new DefaultComboBoxModel(tipoDNIModelItems.toArray());
        
        // Init grupoSanguineoCombo
        ArrayList<String> grupoSanguineoModelItems = new ArrayList<>();
        for (GrupoSanguineo grupoSanguineo: ventanaPrincipal.grupoSanguineos) {
            grupoSanguineoModelItems.add(grupoSanguineo.nombre);
        }
        grupoSanguineoModel = new DefaultComboBoxModel(grupoSanguineoModelItems.toArray());
        
        // Init factorSanguineoCombo
        ArrayList<Character> factorSanguineoModelItems = new ArrayList<>();
        for (FactorSanguineo factorSanguineo: ventanaPrincipal.factorSanguineos) {
            factorSanguineoModelItems.add(factorSanguineo.signo);
        }
        factorSanguineoModel = new DefaultComboBoxModel(factorSanguineoModelItems.toArray());
        
        // Init claseCombo
        ArrayList<Character> claseModelItems = new ArrayList<>();
        for (Clase clase : Clase.values()) {
            claseModelItems.add(clase.letra);
        }
        claseModel = new DefaultComboBoxModel(claseModelItems.toArray());
        
        initComponents();
        
        tipoDNICombo.setSelectedIndex(0);
        grupoSanguineoCombo.setSelectedIndex(0);
        factorSanguineoCombo.setSelectedIndex(0);
        claseCombo.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        tipoDNICombo = new javax.swing.JComboBox<>();
        nroDNITextField = new javax.swing.JTextField();
        apellidosTextField = new javax.swing.JTextField();
        nombresTextField = new javax.swing.JTextField();
        fechaNacimientoTextField = new javax.swing.JTextField();
        domicilioTextField = new javax.swing.JTextField();
        grupoSanguineoCombo = new javax.swing.JComboBox<>();
        factorSanguineoCombo = new javax.swing.JComboBox<>();
        claseCombo = new javax.swing.JComboBox<>();
        costoLabel = new javax.swing.JLabel();
        observacionesTextField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        emitirBtn = new javax.swing.JButton();
        esDonanteCheckbox = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        buscarBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        vigenciaLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emitir licencia");

        jLabel1.setText("Tipo de documento:");

        jLabel2.setText("Número de documento:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setText("Domicilio:");

        jLabel7.setText("Grupo sanguíneo:");

        jLabel8.setText("Factor sanguíneo:");

        jLabel9.setText("Donante:");

        jLabel10.setText("Clase:");

        jLabel13.setText("Costo:   $");

        jLabel14.setText("Observaciones:");

        tipoDNICombo.setModel(tipoDNIModel);
        tipoDNICombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDNIComboActionPerformed(evt);
            }
        });

        apellidosTextField.setEditable(false);

        nombresTextField.setEditable(false);

        fechaNacimientoTextField.setEditable(false);

        domicilioTextField.setEditable(false);

        grupoSanguineoCombo.setModel(grupoSanguineoModel);
        grupoSanguineoCombo.setEnabled(false);

        factorSanguineoCombo.setModel(factorSanguineoModel);
        factorSanguineoCombo.setEnabled(false);

        claseCombo.setModel(claseModel);
        claseCombo.setEnabled(false);
        claseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claseComboActionPerformed(evt);
            }
        });

        costoLabel.setText("-");

        observacionesTextField.setEnabled(false);

        emitirBtn.setText("Emitir...");
        emitirBtn.setEnabled(false);
        emitirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emitirBtnActionPerformed(evt);
            }
        });

        esDonanteCheckbox.setEnabled(false);

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        jLabel15.setText("Vigencia (años):");

        vigenciaLabel.setText("-");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Emitir licencia");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel16.setText("seleccione la clase de licencia a emitir.");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel17.setText("Busque un titular por su documento, verifique sus datos, y");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(claseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(costoLabel)
                            .addComponent(vigenciaLabel))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(emitirBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(70, 70, 70)
                                        .addComponent(tipoDNICombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nroDNITextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buscarBtn))
                                            .addComponent(apellidosTextField)
                                            .addComponent(nombresTextField)
                                            .addComponent(fechaNacimientoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(domicilioTextField)
                                            .addComponent(grupoSanguineoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(esDonanteCheckbox)
                                            .addComponent(factorSanguineoCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(observacionesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipoDNICombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nroDNITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fechaNacimientoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(domicilioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(grupoSanguineoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(factorSanguineoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(esDonanteCheckbox))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(claseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(costoLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vigenciaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(observacionesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emitirBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emitirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emitirBtnActionPerformed
        try {
            List<Carnet> carnetsTitular = DAOCarnet.buscar(titularEncontrado.get());
            
            Optional<Carnet> carnetMasUtil = Carnet.getCarnetAnteriorMasUtil(carnetsTitular);
            
            Carnet unCarnet = new Carnet(
                    carnetMasUtil,
                    claseSeleccionada,
                    observacionesTextField.getText(),
                    titularEncontrado.get()
            );
            
            VentanaEmitirConfirmar confirmar = new VentanaEmitirConfirmar(null, true, unCarnet, costo.get());
            confirmar.setVisible(true);
            
            if(confirmar.confirmado) {
                unCarnet = DAOCarnet.insertar(unCarnet);
                
                pdf unPdf = new pdf();
                unPdf.emitirLicencia(unCarnet, titularEncontrado.get());
                unPdf.imprimirComprobante(unCarnet, titularEncontrado.get(), costo.get());
                
                dispose();
            }
        }
        catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento debe ser válida y estar en formato dd/mm/yyyy.");
        } catch (EsMenorException ex) {
            JOptionPane.showMessageDialog(null, "No se puede emitir a un menor.");
        } catch (EsMenorParaProfesionalException ex) {
            JOptionPane.showMessageDialog(null, "No cumple con edad mínima para el tipo profesional.");
        } catch (EsMayorParaPrimerProfesionalException ex) {
            JOptionPane.showMessageDialog(null, "Supera la edad máxima para primer carnet profesional.");
        } catch (CarnetAnteriorRequeridoException | CarnetAnteriorInvalidoException ex) {
            JOptionPane.showMessageDialog(null, "No cumple los requisitos de carnet B para carnet profesional.");
        } catch (IOException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Error de escritura al generar el PDF.");
        } catch (Carnet.EmisionException ex) {
            JOptionPane.showMessageDialog(null, "Error general de emisión.");
        }
    }//GEN-LAST:event_emitirBtnActionPerformed

    private void claseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claseComboActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        claseSeleccionada = Clase.fromLetra((char) cb.getSelectedItem());
        
        if(titularEncontrado.isPresent()) actualizarVigenciaYCosto();
    }//GEN-LAST:event_claseComboActionPerformed

    private void actualizarVigenciaYCosto() {
        Optional<Vigencia> vigencia = Optional.empty();

        try {
            if(claseSeleccionada.isProfesional) {
                vigencia = Optional.of(Carnet.vigenciaMaximaProfesional(titularEncontrado.get().getEdad()));
            }
            else {
                boolean tuvoCarnet = DAOCarnet.buscar(titularEncontrado.get()).stream().anyMatch(c -> c.getClase() == claseSeleccionada);
                vigencia = Optional.of(Carnet.vigenciaMaximaNoProfesional(titularEncontrado.get().getEdad(), tuvoCarnet));
            }
        } catch (EsMenorException | EsMenorParaProfesionalException ignore) {

        }
        
        costo = vigencia.map(v -> Costo.calcularCosto(Costo.init(), claseSeleccionada, v));

        vigenciaLabel.setText(vigencia.map(v -> String.valueOf(v.anos)).orElse("–"));
        costoLabel.setText(costo.map(c -> String.valueOf(c)).orElse("–"));
    }
    
    
    private void tipoDNIComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDNIComboActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String nombreTipoDNI = (String)cb.getSelectedItem();
        
        for (TipoDocumento unTipoDocumento: ventanaPrincipal.tipoDocumentos) {
            if (unTipoDocumento.nombre.equals(nombreTipoDNI)) {
                tipoDocumentoSeleccionado = unTipoDocumento;
                break;
            }
        }
    }//GEN-LAST:event_tipoDNIComboActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        
        try {
            Titular titular = DAOTitular.obtener(tipoDocumentoSeleccionado, nroDNITextField.getText()).get();
            
            apellidosTextField.setText(titular.getApellidos());
            nombresTextField.setText(titular.getNombres());
            fechaNacimientoTextField.setText(titular.getFechaNacimiento().format(formatter));
            domicilioTextField.setText(titular.getDireccion());
            grupoSanguineoCombo.setSelectedItem(titular.getGrupoSanguineo());
            factorSanguineoCombo.setSelectedItem(titular.getFactorSanguineo());
            esDonanteCheckbox.setSelected(titular.isDonante());
            
            claseCombo.setEnabled(true);
            observacionesTextField.setEnabled(true);
            emitirBtn.setEnabled(true);
            
            titularEncontrado = Optional.of(titular);
            actualizarVigenciaYCosto();
            
        } catch (NoSuchElementException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el titular.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaEmitir.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de la base de datos.");
        }
    }//GEN-LAST:event_buscarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaEmitir dialog = new VentanaEmitir(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JComboBox<String> claseCombo;
    private javax.swing.JLabel costoLabel;
    private javax.swing.JTextField domicilioTextField;
    private javax.swing.JButton emitirBtn;
    private javax.swing.JCheckBox esDonanteCheckbox;
    private javax.swing.JComboBox<String> factorSanguineoCombo;
    private javax.swing.JTextField fechaNacimientoTextField;
    private javax.swing.JComboBox<String> grupoSanguineoCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField nombresTextField;
    private javax.swing.JTextField nroDNITextField;
    private javax.swing.JTextField observacionesTextField;
    private javax.swing.JComboBox<String> tipoDNICombo;
    private javax.swing.JLabel vigenciaLabel;
    // End of variables declaration//GEN-END:variables

    private static class CampoVacioException extends Exception {
        public CampoVacioException(String campo) {
            super(campo);
        }
    }
}
