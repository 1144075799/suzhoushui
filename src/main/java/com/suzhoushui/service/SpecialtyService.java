package com.suzhoushui.service;

import com.suzhoushui.domain.Specialty;

import java.util.List;

public interface SpecialtyService {

    /**
     * 返回所有的特色接口
     * @return
     */
    public List<Specialty> getAll();

    /**
     * 根据id查找相关信息
     * @return
     */
    public Specialty findById(int id);

}
