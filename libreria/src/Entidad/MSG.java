/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Mati Droid
 */
public class MSG {
    private int Id_MSG;
    private String MGS;

    public MSG(int Id_MSG, String MGS) {
        this.Id_MSG = Id_MSG;
        this.MGS = MGS;
    }

    public int getId_MSG() {
        return Id_MSG;
    }

    public String getMGS() {
        return MGS;
    }
}
