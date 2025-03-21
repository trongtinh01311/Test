/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;
import com.edusys.entity.MonHoc;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tinhn
 */
public class MonHocDAO extends EduSysDAO<MonHoc, String>{
    public void insert(MonHoc model){
        String sql="INSERT INTO MonHoc (ID, TenMonHoc, KyHoc) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                model.getId(),
                model.getTenMonHoc(),
                model.getKyHoc());
    }
    
    public void update(MonHoc model){
        String sql="UPDATE MonHoc SET TenMonHoc = ?, KyHoc = ? WHERE ID=?";
        XJdbc.update(sql, 
                model.getTenMonHoc(),
                model.getKyHoc(),                
                model.getId());
    }
    
    public void delete(String ID){
        String sql="DELETE FROM MonHoc WHERE ID=?";
        XJdbc.update(sql, ID);
    }
    
    public List<MonHoc> selectAll(){
        String sql="SELECT * FROM MonHoc";
        return this.selectBySql(sql);
    }
    
    public MonHoc selectById(String ID){
        String sql="SELECT * FROM MonHoc WHERE ID=?";
        List<MonHoc> list = this.selectBySql(sql, ID);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<MonHoc> selectBySql(String sql, Object...args){
        List<MonHoc> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    MonHoc entity=new MonHoc();
                    entity.setId(rs.getString("Id"));
                    entity.setTenMonHoc(rs.getString("TenMonHoc"));
                    entity.setKyHoc(rs.getString("KyHoc"));
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
    
    public List<MonHoc> selectByKeyword(String keyword){
        String sql="SELECT * FROM MonHoc WHERE ID LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
