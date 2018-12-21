package com.tt.teach.dao;

import com.tt.teach.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    @Select("select * from student where studentNo=#{studentNo} and loginPwd=#{loginPwd}")
    Student doLogin(Student student);

    @Select("select student.*,grade.gradeName AS gradeName from student,grade where student.gradeId = grade.gradeId")
    List<Student> getStudentList();

    @Delete("delete from student where studentNo=#{stuNo}")
    int deleteStudent(Integer stuNo);

    @Update("update student set loginPwd=#{loginPwd},studentName=#{studentName},phone=#{phone} where studentNo=#{studentNo}")
    int updateStudent(Student student);
     @Select("select * from student where studentNo = #{studentNo}")
    Student getStuByNo(Integer studentNo);
}
