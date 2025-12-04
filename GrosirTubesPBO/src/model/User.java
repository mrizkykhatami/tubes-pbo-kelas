/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */
public class User {
    private int idUser;
    private String namaUser;
    private String username;
    private String pass;
    private String role;

    public User() {
    }

    // Konstruktor untuk login/mengambil data
    public User(int idUser, String namaUser, String username, String pass, String role) {
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.username = username;
        this.pass = pass;
        this.role = role;
    }

    // Konstruktor untuk registrasi
    public User(String namaUser, String username, String pass, String role) {
        this.namaUser = namaUser;
        this.username = username;
        this.pass = pass;
        this.role = role;
    }

    // Setters
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    // Getters
    public int getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }
}
