package com.example.johnproject.dao;

import com.example.johnproject.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate template;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public synchronized Emp addEmp(Emp emp) {
        template.update("insert emp (ename,job) values(?,?)",emp.getEname(),emp.getJob());
        //获得自动增长的id
        int id=template.queryForObject("select @@IDENTITY",Integer.class);
        emp.setId(id);
        return emp;
    }
    @Override
    public List<Emp> findAllEmp() {
       List<Emp> emps= template.query("select empno as id ,ename,job from emp", new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp emp=new Emp();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                return emp;
            }
        });
        return emps;
    }

    public Emp updateEmp(Emp emp, int id){
        String sql="update emp set ename=?,job=? where empno=?";
        template.update(sql,emp.getEname(),emp.getJob(),emp.getId());
        return emp;
    }

    public  Emp loadEmp(int id){
        String sql="select empno as id,ename,job from emp where empno=?";
        Emp emp=template.queryForObject(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp emp1=new Emp();
                emp1.setId(rs.getInt("id"));
                emp1.setEname(rs.getString("ename"));
                emp1.setJob(rs.getString("job"));
                return emp1;
            }
        },id);
        return  emp;
    }

    @Override
    public void deleteEmp(int id) {
        String sql="delete from emp where empno=?";
        template.update(sql,id);
    }
}
