package com.sbtl.smartweaver.web.application;


import com.sbtl.smartweaver.business.service.ClothTypeService;
import com.sbtl.smartweaver.data.entity.ClothType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;



@Controller

public class ClothTypeController {

	@Autowired
    private ClothTypeService clothService;
    
     
       
    @RequestMapping(value = "/clothtypes", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("clothtypeDet", clothService.listAllClothProdTypes());
        System.out.println("Returning clothtypes:");
        return "clothtypes";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("clothtype/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("clothtypeid", clothService.getClothTypeById(id));
        return "cloth";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("clothtype/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("clothtypeid", clothService.getClothTypeById(id));
        return "cloth";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("clothtype/new")
    public String newProduct(Model model) {
        model.addAttribute("clothtypeid", new ClothType());
        return "clothtypes";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "clothtype", method = RequestMethod.POST)
    public String saveProduct(ClothType cloth) {
    	clothService.saveClothType(cloth);
        return "redirect:/clothtype/" + cloth.getClothId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("clothtype/delete/{id}")
    public String delete(@PathVariable long id) {
    	clothService.deleteClothType(id);
        return "redirect:/clothtypes";
    }
}
