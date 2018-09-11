package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Type;
import com.ambow.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired  private TypeService typeService;

    List<Type> typeList=null;
    private Type type=null;
    /*
    显示所有类型信息
    */
    @RequestMapping(value = "/toList",method = RequestMethod.POST)
    @ResponseBody
    public List<Type> toList(){
        typeList=typeService.toList();
        return typeList;
    }
    /*
    * 根据id查找要修改的信息
    * */
    //<a href="/type/toUpdate/123">
    @RequestMapping(value = "/toUpdate/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Type toUpdate(@PathVariable("id") Integer id){
        System.out.println("进入toUpdate");
        type=typeService.toUpdate(id);
        System.out.println(type);
        return type;
    }

    /*
    * 修改信息,判重
    * */

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(Type type){
        String typeName = type.getName();
        System.out.println(typeName+"接收到的值");
        Type type1 = typeService.selectByName(typeName);
        System.out.println(type1+"type1");
        if (type1 != null) {
            if (type1.getId() != type.getId()) {
                System.out.println("判重成功");
                return "error";
            } else {
                typeService.updateByPrimaryKeySelective(type);
                return "success";
            }
        } else {
            typeService.updateByPrimaryKeySelective(type);
            return "success";
        }
    }

    /*
    * 添加类型信息
    * */
    @RequestMapping(value = "/toSave",method = RequestMethod.POST)
    @ResponseBody
    public String addType(Type type) {
        System.out.println("添加操作"+type);
        String name=type.getName();
        if (typeService.selectByName(name) != null) {
            System.out.println("判重成功");
            return "error";
        }
        typeService.addType(type);//添加类型
        return "success";
    }

    /*
    * 删除数据类型
    * */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String deleteType(@PathVariable("id") int id){
        System.out.println("进入删除");
        typeService.deleteType(id);
            return "success";

    }
}
