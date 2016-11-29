/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import core.Brute;
import util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.Util.alfabeto;

/**
 *
 * @author Alexandre
 */
public class Principal extends javax.swing.JFrame {

    public JFileChooser file;
    public static List<String> listaDeHashs2 = new ArrayList<>();
    public static Set<String> listaDeHashs = new HashSet<>();
    private static int numProcessadores;
    private int contAlfabeto;
    Thread thread[];

    public static int getNumProcessadores() {
        return numProcessadores;
    }

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        Runtime runTime = Runtime.getRuntime();
        this.numProcessadores = runTime.availableProcessors();
        thread = new Thread[this.numProcessadores];

    }

    public static void setArea(String text) {
        Principal.Area1.append(text);
    }

    public static void setButton(int t, boolean active) {

        if (t == 1) {
            rodar.setEnabled(active);
        } else {
            parar.setEnabled(active);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rodar = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spInicio = new javax.swing.JSpinner();
        spPara = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area1 = new javax.swing.JTextArea();
        btIntervalo = new javax.swing.JButton();
        spMinCarcteres = new javax.swing.JSpinner();
        spMaxCaracteres = new javax.swing.JSpinner();
        btRange = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btView = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        rodar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rodar.setText("Quebrar Hashs");
        rodar.setEnabled(false);
        rodar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rodarActionPerformed(evt);
            }
        });

        parar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        parar.setText("Sair");
        parar.setEnabled(false);
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });

        jLabel1.setText("Começar em:");

        jLabel2.setText("Parar em:");

        spInicio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spInicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 0, 1));
        spInicio.setEnabled(false);
        spInicio.setMaximumSize(new java.awt.Dimension(43, 36));
        spInicio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spInicioStateChanged(evt);
            }
        });

        spPara.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spPara.setEnabled(false);
        spPara.setMaximumSize(new java.awt.Dimension(36, 36));

        Area1.setColumns(20);
        Area1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Area1.setRows(5);
        jScrollPane1.setViewportView(Area1);

        btIntervalo.setText("Aplicar");
        btIntervalo.setEnabled(false);
        btIntervalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIntervaloActionPerformed(evt);
            }
        });

        spMinCarcteres.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spMinCarcteres.setModel(new javax.swing.SpinnerNumberModel(0, 0, 0, 1));
        spMinCarcteres.setEnabled(false);
        spMinCarcteres.setMaximumSize(new java.awt.Dimension(43, 36));

        spMaxCaracteres.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spMaxCaracteres.setEnabled(false);
        spMaxCaracteres.setMaximumSize(new java.awt.Dimension(36, 36));

        btRange.setText("Aplicar");
        btRange.setEnabled(false);
        btRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRangeActionPerformed(evt);
            }
        });

        jLabel3.setText("Minimo carac.");

        jLabel4.setText("Max carac.");

        btView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btView.setText("Detalhes");
        btView.setEnabled(false);
        btView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Importar Hashs");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btIntervalo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(spPara, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spMinCarcteres, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(spMaxCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btRange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(parar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(rodar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btView)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spMaxCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spMinCarcteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRange, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rodar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(parar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.file = new JFileChooser();
        this.file.setDialogType(JFileChooser.OPEN_DIALOG);
        this.file.setDialogTitle("Abrir Arquivo de hashs");
        this.file.setFileFilter(new FileNameExtensionFilter("Arquivos hash", "csv", "txt"));

        int valor = this.file.showDialog(this, null);
        if (valor == JFileChooser.APPROVE_OPTION) {
            try {
                File hashs = this.file.getSelectedFile();
                String nomeArquivo = file.getSelectedFile().toString();
                listaDeHashs = Util.leitor(nomeArquivo);
                listaDeHashs2.addAll(listaDeHashs);
                Principal.Area1.append("Quantidade de Hashs: " + listaDeHashs.size() + "\n");

                rodar.setEnabled(true);
                this.spInicio.setEnabled(true);
                this.spPara.setEnabled(true);

                this.spMinCarcteres.setModel(new SpinnerNumberModel(4, 4, 8, 1));
                this.spMaxCaracteres.setModel(new SpinnerNumberModel(8, 4, 8, 1));

                this.spMinCarcteres.setEnabled(true);
                this.spMaxCaracteres.setEnabled(true);
                this.btRange.setEnabled(true);
                this.btIntervalo.setEnabled(true);
                

                this.spInicio.setModel(new SpinnerNumberModel(0, 0, listaDeHashs.size() - 1, 1));
                this.spPara.setModel(new SpinnerNumberModel(listaDeHashs.size() - 1, 0, listaDeHashs.size() - 1, 1));
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum arquivo selecionado.", "Atenção", 2);
        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void rodarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rodarActionPerformed
        Util.limpaLog();
        this.rodar.setEnabled(false);
        this.parar.setEnabled(true);
        this.btView.setEnabled(true);

        int rest = alfabeto.length % (this.numProcessadores);
        contAlfabeto = (alfabeto.length / (this.numProcessadores));

        int z = 0;
        int x = contAlfabeto - 1;
        Principal.setArea("Iniciou\n");

        for (int i = 0; i < (this.numProcessadores); i++) {
            if (i == ((this.numProcessadores) - 1)) {
                thread[i] = new Thread(new Brute(z, (x + rest)));
                thread[i].start();
            } else {
                thread[i] = new Thread(new Brute(z, x));
                thread[i].start();
            }
            z += contAlfabeto;
            x += contAlfabeto;
        }

    }//GEN-LAST:event_rodarActionPerformed

    private void btIntervaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIntervaloActionPerformed

        Set<String> l = new HashSet<>();
        for (int i = Integer.parseInt(spInicio.getValue().toString()); i < Integer.parseInt(spPara.getValue().toString()); i++) {
            l.add(listaDeHashs2.get(i));
        }
        listaDeHashs.clear();
        listaDeHashs = l;
        JOptionPane.showMessageDialog(this, "Lista recarregada", "Atenção", 2);
        Area1.append("Quantidade de Hashs: " + listaDeHashs.size() + "\n");
    }//GEN-LAST:event_btIntervaloActionPerformed

    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        System.exit(0);
    }//GEN-LAST:event_pararActionPerformed

    private void btRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRangeActionPerformed

        Util.MIN_WORDLENGTH = Integer.parseInt(spMinCarcteres.getValue().toString());
        Util.MAX_WORDLENGTH = Integer.parseInt(spMaxCaracteres.getValue().toString());

        JOptionPane.showMessageDialog(this, "Range de caracteres carregado", "Atenção", 2);
        Area1.append("RANGE: " + Util.MIN_WORDLENGTH + " a " + Util.MAX_WORDLENGTH + " Caracteres\n");

    }//GEN-LAST:event_btRangeActionPerformed

    private void spInicioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spInicioStateChanged
        this.spPara.setModel(new SpinnerNumberModel(listaDeHashs.size() - 1, Integer.parseInt(this.spInicio.getValue().toString()), listaDeHashs.size() - 1, 1));
    }//GEN-LAST:event_spInicioStateChanged

    private void btViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewActionPerformed
        try {
            Util.geraHtml();
            Util.exibeHtml();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea Area1;
    private javax.swing.JButton btIntervalo;
    private javax.swing.JButton btRange;
    private javax.swing.JButton btView;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JButton parar;
    private static javax.swing.JButton rodar;
    private javax.swing.JSpinner spInicio;
    private javax.swing.JSpinner spMaxCaracteres;
    private javax.swing.JSpinner spMinCarcteres;
    private javax.swing.JSpinner spPara;
    // End of variables declaration//GEN-END:variables
}
