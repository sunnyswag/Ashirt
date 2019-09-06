package org.csu.ashirt.control;

import org.csu.ashirt.domain.Category;
import org.csu.ashirt.domain.Item;
import org.csu.ashirt.domain.Style;
import org.csu.ashirt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@RestController
public class CategoryController {
    @Resource
    CategoryService categoryService;

    //获得所有列表
    @RequestMapping(value = "getAllCategory")
    public List<Category> getAllCategory(){
        return categoryService.getCategoryList();
    }

    //根据列表ID获得所有图案
    @RequestMapping(value = "getAllItemsByCategoryId", method= RequestMethod.POST)
    public List<Item> getAllItemsByCategoryId(@RequestParam(value = "categoryId") int categoryId){
        return categoryService.getItemByCategory(categoryId);
    }

    //根据关键字找到列表
    @RequestMapping(value = "getCategoriesByKeyword", method= RequestMethod.POST)
    public List<Category> getCategoriesByKeyword(@RequestParam(value = "categoryKeyword") String categoryKeyword){
        return categoryService.searchCategoryList(categoryKeyword);
    }

    //根据关键字找到款式
    @RequestMapping(value = "getStylesByKeyword", method= RequestMethod.POST)
    public List<Style> getStylesByKeyword(@RequestParam(value = "stylesKeyword") String stylesKeyword){
        return categoryService.searchStyleList(stylesKeyword);
    }

    //根据颜色和款式找到对应的衣服
    @RequestMapping(value = "getStyleByColorAndName", method= RequestMethod.POST)
    public Style getStyleByColorAndName(@RequestParam(value = "color") String color,@RequestParam(value = "name") String name){
        return categoryService.getStyleByColorAndName(color,name);
    }

    //根据款式ID找到对应颜色的衣服
    @RequestMapping(value = "getSameStylesByCategoryId", method= RequestMethod.POST)
    public List<Style> getSameStylesByCategoryId(@RequestParam(value = "categoryId") int categoryId){
        return categoryService.getStylesByName(categoryService.getCategory(categoryId).getName());
    }

    //根据图案ID找到图案
    @RequestMapping(value = "getItemByItemId", method= RequestMethod.POST)
    public Item getItemByItemId(@RequestParam(value = "itemId") int itemId){
        return categoryService.getItem(itemId);
    }

    //根据列表ID找到列表
    @RequestMapping(value = "getCategoryByCategoryId", method= RequestMethod.POST)
    public Category getCategoryByCategoryId(@RequestParam(value = "categoryId") int categoryId){
        return categoryService.getCategory(categoryId);
    }

    //根据款式ID找到款式
    @RequestMapping(value = "getStyleByStyleId", method= RequestMethod.POST)
    public Style getStyleByStyleId(@RequestParam(value = "styleId") int styleId){
        return categoryService.getStyle(styleId);
    }
}
