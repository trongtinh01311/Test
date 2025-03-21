/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.DangKyMonHoc;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tinhn
 */
public class DangKyMonHocDAO2 extends EduSysDAO<DangKyMonHoc, String>{
    /*public void insert(DangKyMonHoc model){
        String sql="INSERT INTO DangKyMonHoc (MaSV, MaMonHoc, KyHoc, Block) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaSV(),
                model.getMaMonHoc(),
                model.getKyHoc(),
                model.getBlock());
    }*/
    
    public void insert(DangKyMonHoc model) {
        // Kiểm tra sinh viên đã đăng ký môn học chưa
        String checkSql = "SELECT COUNT(*) FROM DangKyMonHoc WHERE MaSV = ? AND MaMonHoc = ?";
        try {
            ResultSet rs = XJdbc.query(checkSql, model.getMaSV(), model.getMaMonHoc());
            if (rs.next() && rs.getInt(1) > 0) {
                throw new RuntimeException("Sinh viên này đã đăng ký môn học này rồi!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Chèn dữ liệu nếu chưa tồn tại
        String sql = "INSERT INTO DangKyMonHoc (MaSV, MaMonHoc, KyHoc, Block) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaSV(),
                model.getMaMonHoc(),
                model.getKyHoc(),
                model.getBlock());
    }
    
    public void update(DangKyMonHoc model) {
        String sql = "UPDATE DangKyMonHoc SET KyHoc = ?, Block = ? WHERE MaSV = ? AND MaMonHoc = ?";
        XJdbc.update(sql, 
                model.getKyHoc(),
                model.getBlock(),
                model.getMaSV(),
                model.getMaMonHoc());
    }

    
    /*
    public void update(DangKyMonHoc model){
        String sql="UPDATE DangKyMonHoc SET MaMonHoc = ?, KyHoc = ?, Block = ? WHERE MaSV=?";
        XJdbc.update(sql, 
                model.getMaMonHoc(),
                model.getKyHoc(),
                model.getBlock(),
                model.getMaSV());
    }*/
    
    public void delete(String Masv){
        String sql="DELETE FROM DangKyMonHoc WHERE MaSV=?";
        XJdbc.update(sql, Masv);
    }
    /*
    public void delete(String maSV, String maMonHoc) {
        String sql = "DELETE FROM DangKyMonHoc WHERE MaSV = ? AND MaMonHoc = ?";
        XJdbc.update(sql, maSV, maMonHoc);
    }*/

    
    public List<DangKyMonHoc> selectAll(){
        String sql="SELECT * FROM DangKyMonHoc";
        return this.selectBySql(sql);
    }
    
    public DangKyMonHoc selectById(String MaSV){
        String sql="SELECT * FROM DangKyMonHoc WHERE MaSV=?";
        List<DangKyMonHoc> list = this.selectBySql(sql, MaSV);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<DangKyMonHoc> selectBySql(String sql, Object...args){
        List<DangKyMonHoc> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    DangKyMonHoc entity=new DangKyMonHoc();
                    entity.setMaSV(rs.getString("MaSV"));
                    entity.setMaMonHoc(rs.getString("MaMonHoc"));
                    entity.setKyHoc(rs.getString("KyHoc"));
                    entity.setBlock(rs.getString("Block"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    /*
    public List<DangKyMonHoc> selectByKeyword(String keyword){
        String sql="SELECT * FROM DangKyMonHoc WHERE MaSV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }*/
    
    
    public List<DangKyMonHoc> selectByStudent(String maSV) {
        String sql = "SELECT * FROM DangKyMonHoc WHERE MaSV = ?";
        return this.selectBySql(sql, maSV);
    }

}
