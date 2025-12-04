/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTNightOwlIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import javax.swing.UIManager;
import view.component.LoginFrame;

/**
 *
 * @author M Rizky Khatami
 */
public class Main {
    public static void main(String[] args) {
        UIManager.put("Component.accentColor", new Color(0, 204, 204));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // 2. Buat dan tampilkan LandingFrame Anda
                new LoginFrame().setVisible(true);
            }
        });
    }
}

