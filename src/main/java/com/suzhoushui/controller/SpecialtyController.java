package com.suzhoushui.controller;

import com.suzhoushui.domain.Specialty;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.SpecialtyMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.SpecialtyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "特色模板")
@RestController
@RequestMapping("/api")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/getAllSpecialty")
    @ApiOperation(value = "返回所有特色的接口",notes = "Get请求")
    public Object getAll(){

        //返回接口的状态设置
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);

        List<Specialty> specialty=specialtyService.getAll();

        //将返回结果添加到返回数据中
        baseResponse.setData(specialty);


        return baseResponse;
    }

}
