package com.ambow.springboot.vo;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.entity.Type;

import java.util.Date;
import java.util.List;

public class GoodsTypeListVo {

    private Goods goods;
    /*private Integer goodsId; // 主键

    private String goodsTypeId; // 类型ID

    private String goodsName; // 商品名

    private Integer goodsPrice; // 单价

    private Integer goodsDiscount; // 折后价

    private Date goodsStartTime; // 打折开始

    private Date goodsEndTime; // 打折借书

    private Integer goodsNum; // 月销售量

    private String goodsInfo; // 详情*/

    private List<Type> typeList;

    public GoodsTypeListVo() {
    }

    @Override
    public String toString() {
        return "GoodsTypeListVo{" +
                "goods=" + goods +
                ", typeList=" + typeList +
                '}';
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }
}
