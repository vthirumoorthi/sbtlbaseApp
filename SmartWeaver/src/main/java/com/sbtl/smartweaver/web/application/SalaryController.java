package com.sbtl.smartweaver.web.application;

import com.sbtl.smartweaver.business.domain.SalaryProcessor;
import com.sbtl.smartweaver.business.service.SalProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/salarydetails")
public class SalaryController {
	//for formatting date
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private SalProcessService salprocessService;

    @RequestMapping(method= RequestMethod.GET)
    public String getSalary(@RequestParam(value="date", required=false)String dateString, Model model){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException pe) {
                date = new Date();
            }
        }else{
            date = new Date();
        }
        //salary processing invocation
        this.salprocessService.processSalaryForDate(date);
        
        //invoking the method to get salary list
        List<SalaryProcessor> salaryList = this.salprocessService.getSalaryForDate(date);
        /*List<SalaryProcessor> salaryList =*/
        model.addAttribute("salaryList", salaryList);
        return "salarydetails";
    }
}
