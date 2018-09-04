package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.entity.Type;
import com.ambow.springboot.mapper.GoodsMapper;
import com.ambow.springboot.service.GoodsService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.GoodsTypeListVo;
import com.ambow.springboot.vo.TypeGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    /*
    * 根据名字查找
    * */
    @Override
    public Goods selectByName(String name) {
        return goodsMapper.selectByName(name);
    }
    /*
    * 添加商品
    * */
    @Override
    public void addGoods(Goods goods) {
        goodsMapper.insert(goods);
    }
    /*
    * 批量删除商品
    * */
    @Override
    public void deleteType(Integer[] ids) {
        goodsMapper.deleteByPrimaryKey(ids);
    }
    /*
    * 修改商品信息
    * */
    @Override
    public void updateByPrimaryKeySelective(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /*
    * 根据id查询商品信息
    * */
    @Override
    public Goods toUpdate(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<TypeGoodsVo> toList(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "4")Integer rows) {

        Goods goods = new Goods();

        goods.setStart((page - 1) * rows);
        goods.setRows(rows);
        List<TypeGoodsVo> books = goodsMapper.toList(goods);
        Integer count = goodsMapper.selectGoodsCount(goods);
        Page<TypeGoodsVo> pages = new Page<TypeGoodsVo>();
        pages.setPage(page);
        pages.setRows(books);
        pages.setSize(rows);
        pages.setTotal(count);
        return pages;
    }
}
