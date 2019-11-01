package com.suzhoushui.service.impl;

import com.suzhoushui.domain.Specialty;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.SpecialtyMapper;
import com.suzhoushui.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecialtyService implements com.suzhoushui.service.SpecialtyService {

    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Override
    public List<Specialty> getAll() {

        //首先获取所有的基本信息
        List<Specialty> specialtyList=specialtyMapper.getAllSpecialty();


        //创建一个新的对象集
        List<Specialty> specialtyAllList=new ArrayList<Specialty>();

        for (int i=0;i<specialtyList.size();i++){

            //获取每个对象的id
            int id=Integer.valueOf(specialtyList.get(i).getId());

            //获取每个对象的基本信息
            String name= String.valueOf(specialtyList.get(i).getName());
            String intro=String.valueOf(specialtyList.get(i).getIntro());

            //获取每个对象的图片集
            List<String> imageList=specialtyMapper.getImageById(id);

            //创建一个新的对象并且赋值
            Specialty specialtyAll=new Specialty();
            specialtyAll.setId(id);
            specialtyAll.setName(name);
            specialtyAll.setIntro(intro);
            specialtyAll.setImageList(imageList);

            //将对象插入到对象集中
            specialtyAllList.add(specialtyAll);
        }


        return specialtyAllList;
    }

    @Override
    public Specialty findById(int id) {

        Specialty specialty = specialtyMapper.getById(id);
        List<String> imageList=specialtyMapper.getImageById(id);

        specialty.setImageList(imageList);

        return specialty;
    }


}
