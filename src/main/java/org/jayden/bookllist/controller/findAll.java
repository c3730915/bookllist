package org.jayden.bookllist.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jayden.bookllist.entity.BookChinaMechinePress;
import org.jayden.bookllist.service.IBookChinaMechinePressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/book/find")
public class findAll {
    @Autowired
    IBookChinaMechinePressService bookService;

    @RequestMapping("/all")
    public ModelAndView findall(){
        ModelAndView modelAndView =new ModelAndView();
        QueryWrapper<BookChinaMechinePress> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("date");
        List<BookChinaMechinePress> list = bookService.list(queryWrapper);
        modelAndView.addObject("books",list);
        modelAndView.setViewName("result");
        return modelAndView;

//        return bookService.list().toString();


    }


}
