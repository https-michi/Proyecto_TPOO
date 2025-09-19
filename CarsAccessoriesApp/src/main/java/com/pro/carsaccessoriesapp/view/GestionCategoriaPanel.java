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

        panelContenedor = panelContenedor = new  com.pro.carsaccessoriesapp.utils.styles.RoundedPanel(30); ;
        javax.swing.JPanel panelFormulario = panelFormulario = new  com.pro.carsaccessoriesapp.utils.styles.RoundedPanel(30); ;
        lblNombreCategoria = new javax.swing.JLabel();
        lblValidacionNombre = new javax.swing.JLabel();
        lblDescripcionCategoria = new javax.swing.JLabel();
        lblValidacionCategoria = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        txtDescripcionCategoria = new javax.swing.JTextField();
        btnRegistrarCategoria = new javax.swing.JButton();
        btnEditarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();
        panelTitulo = panelTitulo = new  com.pro.carsaccessoriesapp.utils.styles.RoundedPanel(30);
        jLabel5 = new javax.swing.JLabel();
        panelListaTabla = panelListaTabla = new  com.pro.carsaccessoriesapp.utils.styles.RoundedPanel(30);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelBusqueda = panelBusqueda = new  com.pro.carsaccessoriesapp.utils.styles.RoundedPanel(30);
        panelSalida = panelSalida = new  com.pro.carsaccessoriesapp.utils.styles.RoundedPanel(30);
        lblSalidaMensaje = new javax.swing.JLabel();

        panelContenedor.setBackground(new java.awt.Color(102, 204, 0));

        panelFormulario.setBackground(new java.awt.Color(0, 51, 102));

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

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel5)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreCategoria)
                            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout panelListaTablaLayout = new javax.swing.GroupLayout(panelListaTabla);
        panelListaTabla.setLayout(panelListaTablaLayout);
        panelListaTablaLayout.setHorizontalGroup(
            panelListaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
        panelListaTablaLayout.setVerticalGroup(
            panelListaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        lblSalidaMensaje.setText("jLabel1");

        javax.swing.GroupLayout panelSalidaLayout = new javax.swing.GroupLayout(panelSalida);
        panelSalida.setLayout(panelSalidaLayout);
        panelSalidaLayout.setHorizontalGroup(
            panelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalidaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblSalidaMensaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSalidaLayout.setVerticalGroup(
            panelSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalidaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblSalidaMensaje)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelListaTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelListaTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCategoria;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnRegistrarCategoria;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDescripcionCategoria;
    private javax.swing.JLabel lblNombreCategoria;
    private javax.swing.JLabel lblSalidaMensaje;
    private javax.swing.JLabel lblValidacionCategoria;
    private javax.swing.JLabel lblValidacionNombre;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelListaTabla;
    private javax.swing.JPanel panelSalida;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField txtDescripcionCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables

}
