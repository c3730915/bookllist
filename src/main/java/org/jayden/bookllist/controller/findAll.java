package org.jayden.bookllist.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jayden.bookllist.entity.BookChinaMechinePress;
import org.jayden.bookllist.mapper.BookChinaMechinePressMapper;
import org.jayden.bookllist.service.IBookChinaMechinePressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/book/find")
@SpringBootTest
@RunWith(SpringRunner.class)
public class findAll {
    @Autowired
    IBookChinaMechinePressService bookService;
    @Autowired
    BookChinaMechinePressMapper mapper;
    @RequestMapping("/all")
    public ModelAndView findall(){
        ModelAndView modelAndView =new ModelAndView();
        QueryWrapper<BookChinaMechinePress> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("date");
        Page<BookChinaMechinePress> page = new Page<>(1, 5);
        IPage<BookChinaMechinePress> userIPage = mapper.selectPage(page, queryWrapper);
        List<BookChinaMechinePress> list = bookService.list(queryWrapper);
//        E page = bookService.page(1);

        modelAndView.addObject("books",list);
//        bookService.pa
        modelAndView.setViewName("result");
        return modelAndView;

//        return bookService.list().toString();


    }
    @Test
    @RequestMapping("/all/page")
    public ModelAndView page(@RequestParam int pageId){
        QueryWrapper<BookChinaMechinePress> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("date");
        Page<BookChinaMechinePress> page = new Page<>(pageId, 10);
        IPage<BookChinaMechinePress> userIPage = mapper.selectPage(page, queryWrapper);
        List<BookChinaMechinePress> list = userIPage.getRecords();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books",list);
        modelAndView.addObject("totalPages",userIPage.getPages());
        modelAndView.addObject("currentPages",userIPage.getCurrent());

        System.out.println(userIPage.getPages());
//        bookService.pa
        modelAndView.setViewName("result");
        return modelAndView;

    }


}
