package com.ambow.springboot.controller;

import com.ambow.springboot.mapper.OrdersMapper;
import com.ambow.springboot.service.OrdersService;
import com.ambow.springboot.vo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RespectBinding;
import java.util.List;

@RequestMapping("/report")
@Controller
public class ReportController {

    @Autowired
    private OrdersService ordersService;

    private List<Report> reportList;
    /*
    *区间内的日销量
    * */
    @RequestMapping("/ordersDay")
    @ResponseBody
    public List<Report> ordersDay(String time1,String time2){
        //System.out.println(time1);
        reportList=ordersService.ordersDay(time1,time2);
        return reportList;
    }

    /*
    * 某个年的月销量
    * */
    @RequestMapping("/ordersMonth")
    @ResponseBody
    public List<Report> ordersMonth(String year){
       // System.out.println(year);
        reportList=ordersService.ordersMonth(year);
        return reportList;
    }

    /*
    *  商品销售数量
    * */
    @RequestMapping(value = "/goodsSale",method = RequestMethod.POST)
    @ResponseBody
    public  List<Report> goodsSale(){
        reportList=ordersService.goodsSale();
        return reportList;
    }
    /*
    * 某一天时段客流量
    * */
    @RequestMapping(value = "/hoursCustmer",method = RequestMethod.POST)
    @ResponseBody
    public List<Report> hoursCustmer(String time1){
        reportList=ordersService.hoursCustmer(time1);
        return reportList;
    }
    /*
    * 时间段的日成本利润
    * */
    @RequestMapping("costGain")
    @ResponseBody
    public List<Report> costGain(String time1,String time2){
        reportList=ordersService.costGain(time1,time2);
        return reportList;
    }

    /*
     * 时间段的月成本利润
     * */
    @RequestMapping("costGainMonth")
    @ResponseBody
    public List<Report> costGainMonth(String time1,String time2){
        reportList=ordersService.costGainMonth(time1,time2);
        return reportList;
    }

}
