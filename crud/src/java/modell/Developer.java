/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

/**
 *
 * @author hp
 */
public class Developer {

    private Integer Dev_ID;
    private String name;
    private String surname;
    private String email;
    private boolean editable;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Integer getDev_ID() {
        return Dev_ID;
    }

    public void setDev_ID(Integer Dev_ID) {
        this.Dev_ID = Dev_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Developer{" + "Dev_ID=" + Dev_ID + ", name=" + name + ", surname=" + surname + ", email=" + email + ", editable=" + editable + '}';
    }

    
}
