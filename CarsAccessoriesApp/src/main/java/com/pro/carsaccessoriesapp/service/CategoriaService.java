/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pro.carsaccessoriesapp.service;

import com.pro.carsaccessoriesapp.Repositorio.CategoriaDAO;
import com.pro.carsaccessoriesapp.model.Categoria;
import java.util.List;
/**
 *
 * @author snowden
 */
public class CategoriaService {
    private CategoriaDAO categoriaDAO;

    public CategoriaService(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public void registrarCategoria(Categoria cat) throws Exception {
        if (cat.getNombre().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío");
        }
        categoriaDAO.insertar(cat);
    }

    public List<Categoria> listarCategorias() {
        return categoriaDAO.listar();
    }
}
