package com.suzhoushui.service.impl;

import com.suzhoushui.domain.Specialty;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.SpecialtyMapper;
import com.suzhoushui.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService implements com.suzhoushui.service.SpecialtyService {

    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Override
    public Object getAll() {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Specialty> foodList=specialtyMapper.getAllSpecialty();
        baseResponse.setData(foodList);
        return baseResponse;
    }
}
