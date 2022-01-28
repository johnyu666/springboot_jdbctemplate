package com.example.johnproject.controller;

import com.example.johnproject.dao.EmpDao;
import com.example.johnproject.pojo.Emp;
import com.example.johnproject.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpDao empDao;
    @RequestMapping(value = "/emps",method = RequestMethod.POST)
    public CommonResult<Emp> addEmp(@RequestBody  Emp emp){
        Emp e=empDao.addEmp(emp);
        CommonResult<Emp> result=new CommonResult<>(201,"添加成功",e);
        return result;
    }

    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    public CommonResult<List> findAllEmp(){
        List<Emp> emps=empDao.findAllEmp();
        CommonResult<List> result=new CommonResult<>(200,"查询成功",emps);
        return result;
    }
    @RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
    public CommonResult<Emp> loadEmp(@PathVariable int id){
        Emp emp=empDao.loadEmp(id);
        CommonResult<Emp> result=new CommonResult<>(200,"查询成功",emp);
        return result;
    }

    @RequestMapping(value = "/emps/{id}",method = RequestMethod.DELETE)
    public CommonResult<Emp> deleteEmp(@PathVariable int id){
        empDao.deleteEmp(id);
        CommonResult<Emp> result=new CommonResult<>(204,"删除成功",null);
        return result;
    }

}
