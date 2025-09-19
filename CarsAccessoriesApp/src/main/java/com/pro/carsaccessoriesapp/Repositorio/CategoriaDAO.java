/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pro.carsaccessoriesapp.repositorio;

import com.pro.carsaccessoriesapp.model.Categoria;
import java.util.List;

/**
 *
 * @author snowden
 */

public interface CategoriaDAO {

    void insertar(Categoria categoria);

    void actualizar(Categoria categoria);

    void eliminar(int id);

    Categoria buscarPorId(int id);

    List<Categoria> listar();
}
