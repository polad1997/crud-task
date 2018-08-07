/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polad;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import db.DeveloperManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modell.Developer;

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped

public class DeveloperController {

    private List<Developer> developers;
    private DeveloperManager developermanager = null;
    private Developer currentDeveloper;

    @PostConstruct
    public void init() {
        if (developers == null) {
            developers = new ArrayList<>();
        }
        if (developermanager == null) {
            developermanager = new DeveloperManager();
        }
        try {
            developers.clear();
            developers.addAll(developermanager.getAllDevelopers());
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    public List<Developer> getDevelopers() throws ClassNotFoundException, SQLException {

        return developers;

    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public void editRow(Developer developer) {
        try {
            System.out.println(developer);
            currentDeveloper = developer;
            developer.setEditable(true);
            developermanager.updateDeveloper(developer);
            System.out.println("edededededededede");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("bbbbbbbbbbbbbbbb");
        }

    }

    public void saveRow() {
        try {
            developermanager.updateDeveloper(currentDeveloper);
            developers.clear();
            developers.addAll(developermanager.getAllDevelopers());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Developer developer) {

        try {
            developermanager.deleteDeveloper(developer.getDev_ID());
            developers.clear();
            developers.addAll(developermanager.getAllDevelopers());
        } catch (Exception e) {

        }
        
    }
    

}
