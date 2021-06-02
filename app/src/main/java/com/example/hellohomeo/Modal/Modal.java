package com.example.hellohomeo.Modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "crew")
public class Modal {

    @PrimaryKey(autoGenerate = true)
     private int crewid;
@ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "agency")
    String agency;
    @ColumnInfo(name = "image")
    String image;
    @ColumnInfo(name = "wikipedia")
    String wikipedia;
    @ColumnInfo(name = "status")
    String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getCrewid() {
        return crewid;
    }

    public void setCrewid(int crewid) {
        this.crewid = crewid;
    }

    public Modal(String name, String agency, String image, String wikipedia, String status) {
        this.name = name;
        this.agency = agency;
        this.image = image;
        this.wikipedia = wikipedia;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Modal{" +
                "crewid=" + crewid +
                ", name='" + name + '\'' +
                ", agency='" + agency + '\'' +
                ", image='" + image + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
