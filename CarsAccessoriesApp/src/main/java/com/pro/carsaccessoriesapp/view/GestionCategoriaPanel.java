/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pro.carsaccessoriesapp.view;

import com.pro.carsaccessoriesapp.model.Categoria;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snowden
 */
public class GestionCategoriaPanel extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private List<Categoria> listaCategorias; // Colección para manejar las categorías

    public GestionCategoriaPanel() {
        initComponents();
        listaCategorias = new ArrayList<>();
        configurarTabla();
        agregarEventos();
        txtNombreCategoria.setColumns(20);
        txtDescripcionCategoria.setColumns(20);
        lblValidacionNombre.setPreferredSize(new Dimension(250, 20));
        lblValidacionCategoria.setPreferredSize(new Dimension(250, 20));
        lblSalidaMensaje.setPreferredSize(new Dimension(250, 20));
    }

    private void configurarTabla() {
        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Descripción"}, 0);
        jTable1.setModel(modelo);
    }

    private void agregarEventos() {
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            int fila = jTable1.getSelectedRow();
            if (fila != -1) {
                Categoria cat = listaCategorias.get(fila);
                txtNombreCategoria.setText(cat.getNombre());
                txtDescripcionCategoria.setText(cat.getDescripcion());
            }
        });

        btnRegistrarCategoria.addActionListener(e -> {
            try {
                String nombre = txtNombreCategoria.getText().trim();
                String descripcion = txtDescripcionCategoria.getText().trim();

                if (nombre.isEmpty()) {
                    mostrarMensaje(lblValidacionNombre, "El nombre no puede estar vacío", Color.RED);
                    return;
                }
                if (descripcion.isEmpty()) {
                    mostrarMensaje(lblValidacionCategoria, "La descripción no puede estar vacía", Color.RED);
                    return;
                }

                int id = listaCategorias.size() + 1;
                Categoria categoria = new Categoria(id, nombre, descripcion);

                listaCategorias.add(categoria);
                modelo.addRow(new Object[]{id, nombre, descripcion});

                limpiarCampos();
                mostrarMensaje(lblSalidaMensaje, "Categoría registrada con éxito", new Color(0, 128, 0));

            } catch (Exception ex) {
                mostrarMensaje(lblSalidaMensaje, "Error al registrar: " + ex.getMessage(), Color.RED);
            }
        });

        btnEditarCategoria.addActionListener(e -> {
            try {
                int fila = jTable1.getSelectedRow();
                if (fila != -1) {
                    String nombre = txtNombreCategoria.getText().trim();
                    String descripcion = txtDescripcionCategoria.getText().trim();

                    if (nombre.isEmpty()) {
                        mostrarMensaje(lblValidacionNombre, "El nombre no puede estar vacío", Color.RED);
                        return;
                    }
                    if (descripcion.isEmpty()) {
                        mostrarMensaje(lblValidacionCategoria, "La descripción no puede estar vacía", Color.RED);
                        return;
                    }

                    Categoria cat = listaCategorias.get(fila);
                    cat.setNombre(nombre);
                    cat.setDescripcion(descripcion);

                    modelo.setValueAt(nombre, fila, 1);
                    modelo.setValueAt(descripcion, fila, 2);

                    limpiarCampos();
                    mostrarMensaje(lblSalidaMensaje, "Categoría editada con éxito", new Color(0, 128, 0));
                } else {
                    mostrarMensaje(lblSalidaMensaje, "Seleccione una fila para editar", Color.RED);
                }
            } catch (Exception ex) {
                mostrarMensaje(lblSalidaMensaje, "Error al editar: " + ex.getMessage(), Color.RED);
            }
        });

        btnEliminarCategoria.addActionListener(e -> {
            try {
                int fila = jTable1.getSelectedRow();
                if (fila != -1) {
                    listaCategorias.remove(fila);
                    modelo.removeRow(fila);
                    limpiarCampos();
                    mostrarMensaje(lblSalidaMensaje, "Categoría eliminada con éxito", new Color(0, 128, 0));
                } else {
                    mostrarMensaje(lblSalidaMensaje, "Seleccione una fila para eliminar", Color.RED);
                }
            } catch (Exception ex) {
                mostrarMensaje(lblSalidaMensaje, "Error al eliminar: " + ex.getMessage(), Color.RED);
            }
        });
    }

    private void limpiarCampos() {
        txtNombreCategoria.setText("");
        txtDescripcionCategoria.setText("");
        jTable1.clearSelection();
    }

    private void mostrarMensaje(JLabel label, String mensaje, Color color) {
        label.setText(mensaje);
        label.setForeground(color);

        Timer timer = new Timer(2000, e -> label.setText(""));
        timer.setRepeats(false);
        timer.start();
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
        jPanel2 = new javax.swing.JPanel();
        lblNombreCategoria = new javax.swing.JLabel();
        lblValidacionNombre = new javax.swing.JLabel();
        lblDescripcionCategoria = new javax.swing.JLabel();
        lblValidacionCategoria = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        txtDescripcionCategoria = new javax.swing.JTextField();
        btnRegistrarCategoria = new javax.swing.JButton();
        btnEditarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblSalidaMensaje = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        lblNombreCategoria.setText("NombreCategoria");

        lblValidacionNombre.setText("jLabel2");

        lblDescripcionCategoria.setText("DescripcionCategoria");

        lblValidacionCategoria.setText("jLabel4");

        txtNombreCategoria.setText("jTextField1");

        txtDescripcionCategoria.setText("jTextField2");

        btnRegistrarCategoria.setText("btnRegistrarCategoria");

        btnEditarCategoria.setText("btnEditarCategoria");

        btnEliminarCategoria.setText("btnEliminarCategoria");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel5)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreCategoria)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(lblValidacionCategoria)
                                .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDescripcionCategoria)
                                .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblValidacionNombre)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblNombreCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValidacionNombre)
                .addGap(60, 60, 60)
                .addComponent(lblDescripcionCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValidacionCategoria)
                .addGap(42, 42, 42)
                .addComponent(btnRegistrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        lblSalidaMensaje.setText("jLabel1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblSalidaMensaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblSalidaMensaje)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCategoria;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnRegistrarCategoria;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDescripcionCategoria;
    private javax.swing.JLabel lblNombreCategoria;
    private javax.swing.JLabel lblSalidaMensaje;
    private javax.swing.JLabel lblValidacionCategoria;
    private javax.swing.JLabel lblValidacionNombre;
    private javax.swing.JTextField txtDescripcionCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables

}
