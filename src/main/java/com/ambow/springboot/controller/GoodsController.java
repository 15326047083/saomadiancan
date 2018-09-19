package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.entity.Type;
import com.ambow.springboot.service.GoodsService;
import com.ambow.springboot.service.TypeService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.GoodsTypeListVo;
import com.ambow.springboot.vo.TypeGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    private List<Goods> goodsList = null;
    private Goods goods = null;
    private List<Type> typeList;

    /**
     * 随机获取两个推荐菜品
     *
     * @return
     */
    @RequestMapping("/getLimit")
    public List<Goods> getLimit() {
        return goodsService.getLimit();
    }

    /*
     * 点击添加按钮，先显示商品类型
     * */
   /* @RequestMapping("/toList")
    @ResponseBody
    public List<Type> toList(){
        typeList=typeService.toList();
        return typeList;
    }*/

    /*
     * 增加商品信息，判重
     * */
    @RequestMapping(value = "/toSave")
    public String addGoods(Goods goods) {
        String name = goods.getName();
        String typeId = goods.getTypeId();

        if (goodsService.selectByName(name) != null) {
            return "error";
        }
        goodsService.addGoods(goods);//添加类型
        goodsService.updateTypeNum(typeId);//根据类型id
        return "success";
    }

    /*
     * 批量删除商品
     * */
    @RequestMapping(value = "/todelete", method = RequestMethod.POST)
    public String deleteGoods(@RequestParam(name = "ids") Integer[] ids) {
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {

                goodsService.deleteType(ids[i]);

            }
            return "success";
        } else {
            return "error";
        }

    }

    /*
     * 修改商品，判重
     * */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGoods(Goods goods) {
        String typeName = goods.getName();
        Goods goods1 = goodsService.selectByName(typeName);
        if (goods1 != null) {
            if (goods1.getId() != goods.getId()) {
                return "error";
            } else {
                goodsService.updateByPrimaryKeySelective(goods);
                return "success";
            }
        } else {
            goodsService.updateByPrimaryKeySelective(goods);
            return "success";
        }
    }

    /*
     * 查询所有商品，分页
     * */
    @RequestMapping("/toList")
    public Page<TypeGoodsVo> tolist(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "4") Integer rows) {
        Page<TypeGoodsVo> toList = goodsService.toList(page, rows);
        return toList;
    }

    /*
     * 根据id查询商品
     * */
    @RequestMapping("/toUpdate/{id}")
    public Goods toUpdate(@PathVariable("id") Integer id) {
        goods = goodsService.toUpdate(id);
        return goods;
    }

    /*
     * 查看
     * */
    @RequestMapping("/getGoodsById/{id}")
    public GoodsTypeListVo getGoodsById(@PathVariable("id") Integer id) {
        goods = goodsService.toUpdate(id);
        typeList = typeService.toList();
        GoodsTypeListVo goodsTypeListVo = new GoodsTypeListVo();
        goodsTypeListVo.setGoods(goods);
        goodsTypeListVo.setTypeList(typeList);
        return goodsTypeListVo;
    }

    @RequestMapping("/queryAll")
    public List<Goods> queryAll() {
        return goodsService.queryAll();
    }
}