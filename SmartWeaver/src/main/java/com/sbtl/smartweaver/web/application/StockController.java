package com.sbtl.smartweaver.web.application;



import com.sbtl.smartweaver.business.service.StockingService;
import com.sbtl.smartweaver.data.entity.Stocking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller

public class StockController {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private StockingService stockService;
    
 
    
    @RequestMapping(value = "/stockdetails", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("stockDetails", stockService.listAllStocks());
        System.out.println("Returning stockdetails:");
        return "stockdetails";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("stockdetail/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("stockDetail", stockService.getStockById(id));
        return "stockdetail";
    }


    @RequestMapping("stockdetail/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("stockDetail", stockService.getStockById(id));
        return "stockdetail";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("stockdetail/new")
    public String newProduct(Model model) {
    	Stocking newStock = new Stocking();
    	java.util.Date date=new java.util.Date();  
    		//newStock.setEntryDate(DATE_FORMAT.parse(date));
        model.addAttribute("stockDetail", newStock);
        return "stockdetail";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "stockdetail", method = RequestMethod.POST)
    public String saveProduct(Stocking stk) {
    	stockService.saveStock(stk);
        return "redirect:/stockdetail/" + stk.getPcId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("stockdetail/delete/{id}")
    public String delete(@PathVariable long id) {
    	stockService.deleteStock(id);
        return "redirect:/stockdetails";
    }

    /*@RequestMapping(value="/stock",method= RequestMethod.GET)
    public String StockList(@RequestParam(value="date", required=false)String dateString, Model model){
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
        List<StockProcessor> stockList = this.stockService.getStockByDate(date);
        model.addAttribute("stockDetails", stockList);
        return "stocks";
    }
    @RequestMapping(value="/savestock",method= RequestMethod.GET)
    public long saveStock(Stocking stock){
        if(null!=stock) {
            
               return stock.getPcId();
        }else{
            //date = new Date();
        }
        return -1;
    }
    @RequestMapping(value="/stock{id}",method= RequestMethod.GET)
    public String stock(@PathVariable long pcid, Model model){
        
    	model.addAttribute("stockDetails", stkRespository.findById(pcid));
        return "stocks";}*/
    
}
