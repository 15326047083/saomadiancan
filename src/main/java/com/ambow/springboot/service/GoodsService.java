package com.ambow.springboot.service;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.entity.Type;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.GoodsTypeListVo;
import com.ambow.springboot.vo.TypeGoodsVo;

import java.util.List;

public interface GoodsService {
    /*
    * 根据商品名查询
    * */
    Goods selectByName(String name);
    /*
    * 添加商品
    * */
    void addGoods(Goods goods);

    /*
    * 批量删除商品
    * */
    void deleteType(Integer[] ids);
    /*
    *修改商品信息
    * */
    void updateByPrimaryKeySelective(Goods goods);

    Goods toUpdate(Integer id);

    Page<TypeGoodsVo> toList(Integer page, Integer rows);

    List<Goods> queryAll();

    Goods getById(Integer goodsId);
}
