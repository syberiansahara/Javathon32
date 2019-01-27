package ru.sbt.ds.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTheme;
    private String theme;
    public Theme(String theme) 
    {
    	this.theme = theme;
    }
    public long getIdTheme() {
        return idTheme;
    }
    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
}
