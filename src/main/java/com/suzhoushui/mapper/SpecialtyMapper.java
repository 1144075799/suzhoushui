package com.suzhoushui.mapper;

import com.suzhoushui.domain.Specialty;
import com.suzhoushui.domain.SpeciatyImage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpecialtyMapper {

    @Select("SELECT * FROM specialty")
    List<Specialty> getAllSpecialty();


    @Select("SELECT * FROM specialty where id=#{id}")
    Specialty getById(int id);

    @Select("Select image from specialty_image where specialty_id=#{id}")
    List<String> getImageById(int id);

}
