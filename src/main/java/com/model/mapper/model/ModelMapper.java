package com.model.mapper.model;

import com.model.entity.model.Mail;
import com.model.entity.vo.CourseVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Morning JS
 * @date 2020/12/7 17:00
 * @desc mapper
 */
@Mapper
public interface ModelMapper {


    @Select("select c_name from `Course` where c_id = 1")
    String getTest();

    @Select("select * from `Course` where c_id = 1")
    CourseVO getOne();

    @Insert("INSERT INTO `Course`(`c_id`, `c_name`, `t_id`) VALUES (#{cId}, #{cName}, #{tId})")
    void postTest(CourseVO courseVO);

    @Select("select * from `Course`")
    List<CourseVO> getList();

    @Select("select * from mail")
    List<Mail> listMails();
}