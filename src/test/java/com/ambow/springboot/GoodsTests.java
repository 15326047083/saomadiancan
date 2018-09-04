package com.ambow.springboot;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTests {
        @Autowired
        private GoodsMapper goodsMapper;
    /*
    * 根据商品名查找
    * */
    @Test
    public void selectByName(){

        String name="1";
        System.out.println(goodsMapper.selectByName(name));
    }

    /*
     * 添加商品
     * */
    @Test
    public void addGoods(){
        Goods goods=new Goods();
        goods.setName("aa");
        goods.setTypeId("1");
        goods.setPrice(100);
        goods.setDiscount(50);
        goods.setInfo("aaaa");
        goods.setNum(11);
        goodsMapper.insert(goods);
    }

    /*
     * 批量删除商品
     * */
    @Test
    public void deleteGoods(){

        Integer[] ids={1,2};
        goodsMapper.deleteByPrimaryKey(ids);
    }

    /*
     * 修改商品信息
     * */
    @Test
    public void updateGoods(){
        Goods goods=new Goods();
        goods.setName("aaaa");
        goods.setTypeId("1");
        goods.setPrice(100);
        goods.setDiscount(50);
        goods.setInfo("aaaa");
        goods.setNum(11);
        goods.setId(3);
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /*
     * 修改商品信息
     * */
    @Test
    public void toupdateGoods(){
        Goods goods=new Goods();
     /*   goods.setName("aaaa");
        goods.setTypeId("1");
        goods.setPrice(100);
        goods.setDiscount(50);
        goods.setInfo("aaaa");
        goods.setNum(11);
        goods.setId(3);*/
     int id=3;
        System.out.println(goodsMapper.selectByPrimaryKey(id));
    }

}
