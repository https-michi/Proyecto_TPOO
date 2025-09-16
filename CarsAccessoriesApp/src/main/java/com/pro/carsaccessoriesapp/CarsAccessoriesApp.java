/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pro.carsaccessoriesapp;

import com.pro.carsaccessoriesapp.ejem.LoginFrame;

/**
 *
 * @author snowden
 */
public class CarsAccessoriesApp {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
