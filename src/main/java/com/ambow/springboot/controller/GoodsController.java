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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    private List<Goods> goodsList=null;
    private Goods goods=null;
    private List<Type> typeList;

    /*
    * 点击添加按钮，先显示商品类型
    * */
    @RequestMapping("/toList")
    @ResponseBody
    public List<Type> toList(){
        typeList=typeService.toList();
        return typeList;
    }

    /*
    * 增加商品信息，判重 有问题
    * */
    @RequestMapping("/toSave")
    public String addGoods(Goods goods){
        String name=goods.getName();
        if (goodsService.selectByName(name) != null) {
            return "error";
        }
        goodsService.addGoods(goods);//添加类型
        return "success";
    }

    /*
    * 批量删除商品
    * */
    @RequestMapping("/todelete/{ids}")
    public String deleteGoods(@PathVariable("ids") Integer[] ids){
        if (ids != null && ids.length > 0) {
            goodsService.deleteType(ids);
            return "success";
        }else {
            return "error";
        }

    }
    /*
    * 修改商品，判重
    * */
    public String updateGoods(Goods goods){
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
    @ResponseBody
    public Page<TypeGoodsVo> tolist(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "9") Integer rows){
        Page<TypeGoodsVo> toList = goodsService.toList(page, rows);
        return toList;
    }
    /*
     * 根据id查询商品
     * */
    @RequestMapping("/toUpdate/{id}")
    @ResponseBody
    public Goods toUpdate(@PathVariable("id") Integer id){
        goods=goodsService.toUpdate(id);
        return goods;
    }
}
