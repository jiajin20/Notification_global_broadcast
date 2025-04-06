package com.test.message.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT email FROM user")
    List<String> getAllEmails();
}
