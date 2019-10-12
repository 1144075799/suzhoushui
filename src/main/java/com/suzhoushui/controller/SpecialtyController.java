package com.suzhoushui.controller;

import com.suzhoushui.mapper.SpecialtyMapper;
import com.suzhoushui.service.impl.SpecialtyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "特色模板")
@RestController
@RequestMapping("/api")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/getAllSpecialty")
    @ApiOperation(value = "返回所有特色的接口",notes = "Get请求")
    public Object getAll(){
        return specialtyService.getAll();
    }

}
