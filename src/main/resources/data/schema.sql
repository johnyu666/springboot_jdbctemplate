drop table if exists  emp;
create table emp(
                    empno           int unsigned auto_increment primary key COMMENT '雇员编号',
                    ename           varchar(15) COMMENT '雇员姓名',
                    job             varchar(10) COMMENT '雇员职位',
                    mgr             int unsigned COMMENT '雇员对应的领导的编号',
                    hiredate        date COMMENT '雇员的雇佣日期',
                    sal             decimal(7,2) COMMENT '雇员的基本工资',
                    comm            decimal(7,2) COMMENT '奖金',
                    deptno          int unsigned COMMENT '所在部门'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='雇员表';
