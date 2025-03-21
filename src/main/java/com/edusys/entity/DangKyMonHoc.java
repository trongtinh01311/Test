/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author tinhn
 */
public class DangKyMonHoc {
    private String MaSV ;
    private String MaMonHoc;
    private String KyHoc;
    private String Block;

    public DangKyMonHoc() {
    }

    public DangKyMonHoc(String MaSV, String MaMonHoc, String KyHoc, String Block) {
        this.MaSV = MaSV;
        this.MaMonHoc = MaMonHoc;
        this.KyHoc = KyHoc;
        this.Block = Block;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getMaMonHoc() {
        return MaMonHoc;
    }

    public void setMaMonHoc(String MaMonHoc) {
        this.MaMonHoc = MaMonHoc;
    }

    public String getKyHoc() {
        return KyHoc;
    }

    public void setKyHoc(String KyHoc) {
        this.KyHoc = KyHoc;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String Block) {
        this.Block = Block;
    }

    @Override
    public String toString() {
        return "DangKyMonHoc{" + "MaSV=" + MaSV + ", MaMonHoc=" + MaMonHoc + ", KyHoc=" + KyHoc + ", Block=" + Block + '}';
    }
    
    
}
