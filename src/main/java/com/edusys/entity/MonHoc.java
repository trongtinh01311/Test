/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author tinhn
 */
public class MonHoc {
    private String id;
    private String TenMonHoc;
    private String KyHoc;

    public MonHoc() {
    }

    public MonHoc(String id, String TenMonHoc, String KyHoc) {
        this.id = id;
        this.TenMonHoc = TenMonHoc;
        this.KyHoc = KyHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return TenMonHoc;
    }

    public void setTenMonHoc(String TenMonHoc) {
        this.TenMonHoc = TenMonHoc;
    }

    public String getKyHoc() {
        return KyHoc;
    }

    public void setKyHoc(String KyHoc) {
        this.KyHoc = KyHoc;
    }   

    @Override
    public String toString() {
        return "MonHoc{" + "id=" + id + ", TenMonHoc=" + TenMonHoc + ", KyHoc=" + KyHoc + '}';
    }
    
    
}
