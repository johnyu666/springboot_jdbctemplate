package com.example.johnproject.dao;

import com.example.johnproject.DemoApplication;
import com.example.johnproject.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class EmpDaoTest {
    @Autowired
    private EmpDao dao;

    @Test
    public void testAddEmp(){
        Emp emp=new Emp();
        emp.setEname("tomli");
        emp.setJob("sale");
        dao.addEmp(emp);
        System.out.println(emp.getId());
    }
    @Test
    public void testFindAll(){
        List<Emp> emps=dao.findAllEmp();
        emps.forEach(emp-> System.out.println(emp.getId()));
    }

    @Test
    public void testUpdateEmp(){
        //测试更新第一条记录，可以查看数据库进行测试
        Emp emp=new Emp();
        emp.setId(7369);
        emp.setEname("SMI");
        emp.setJob("CODDING");
        dao.updateEmp(emp,7369);
    }

    @Test
    public void testLoadEmp(){
        //测试查询第一条记录，可以查看数据库进行测试
        Emp emp=dao.loadEmp(7369);
        System.out.println(emp.getEname());
    }

    @Test
    public void testDeleteEmp(){
        //测试删除第一条记录，可以查看数据库进行测试
        dao.deleteEmp(7369);
    }

}
