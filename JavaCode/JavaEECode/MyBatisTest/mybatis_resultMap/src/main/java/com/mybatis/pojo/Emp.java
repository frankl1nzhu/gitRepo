package com.mybatis.pojo;

public class Emp {

    private Integer empId;
    private String empName;
    private String gender;
    private Integer age;
    private Dept dept;

    public Emp(Integer empId, String empName, String gender, Integer age, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.age = age;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp() {
    }


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
