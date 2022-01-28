package com.example.johnproject.dao;

import com.example.johnproject.pojo.Emp;

import java.util.List;

public interface EmpDao {
     Emp addEmp(Emp emp);
     List<Emp> findAllEmp();
     Emp updateEmp(Emp emp, int id);
     Emp loadEmp(int id);
     void deleteEmp(int id);
}
