package com.mapper;

import com.po.Student;

import java.util.List;

public interface StudentMapper {

    public Student queryById(int id);
    public List<Student> queryByName(String value);
    public List<Student> queryByName2(Student student);
    public void InsertStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);

    public Student queryByIdBieMing(int id);

    public List<Student> queryByMany(Student student);
    public List<Student> queryByMany2(Student student);

}
