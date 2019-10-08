package com.suzhoushui.mapper;

import com.suzhoushui.domain.Specialty;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpecialtyMapper {

    @Select("SELECT * FROM specialty")
    List<Specialty> getAllSpecialty();



}
