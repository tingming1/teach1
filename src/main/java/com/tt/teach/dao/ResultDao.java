package com.tt.teach.dao;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {

    @Select("SELECT result.*,student.studentName AS\n" +
            " studentName,subject.subjectName AS subjectName FROM result,\n" +
            " student,SUBJECT WHERE result.studentNo=student.studentNo AND\n" +
            "  result.subjectNo=SUBJECT.subjectNo ORDER BY result.examDate DESC\n")
    List<Result> getResultList();
    @Delete("delete from result where resultNo = #{resultNo}")
    int deleteResult(Integer resultNo);
     @Update("update result set studentResult=#{studentResult} where resultNo=#{resultNo}\n")
    int updateResult(Result result);
     @Insert("insert into result(studentNo,subjectNo,examDate,studentResult) values(#{studentNo},#{subjectNo},#{examDate},#{studentResult})")
    int addResult(Result result);
     @Select("select * from subject")
    List<Subject> getSubject();
}
