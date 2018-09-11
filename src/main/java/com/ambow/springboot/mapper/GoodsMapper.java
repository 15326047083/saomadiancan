package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.vo.GoodsTypeListVo;
import com.ambow.springboot.vo.TypeGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer[] ids);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    Goods selectByName(String name);

    List<TypeGoodsVo> toList(Goods goods);

    Integer selectGoodsCount(Goods goods);

    List<Goods> queryAll();

    void updateTypeNum(@Param("typeId") String typeId);

    void updateTypeNumdown(int id);
    void updateTypeNumdown2(Integer[] ids);
}