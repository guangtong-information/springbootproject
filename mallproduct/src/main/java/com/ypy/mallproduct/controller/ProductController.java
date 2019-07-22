package com.ypy.mallproduct.controller;

import com.ypy.mallproduct.bean.Product;
import com.ypy.mallproduct.bean.base.Response;
import com.ypy.mallproduct.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    /**
     * http://127.0.0.1:8080/add?pname=笔记本电脑2&type=笔记本2&price=5602
     */
    @PostMapping("/add")
    public Object add(Product product) {
        Integer res = productMapper.add(product);
        return res == 1 ? new Response("200", "ok") : new Response("500", "fail");
    }

    /**
     * http://127.0.0.1:8080/update?pname=笔记本电脑&type=笔记本&price=6600&pid=1
     */
    @PostMapping("/update")
    public Object update(Product product) {
        Integer res = productMapper.update(product);
        return res == 1 ? new Response("200", "ok") : new Response("500", "fail");
    }

    /**
     * 请求地址：http://127.0.0.1:8080/del/2
     */
    @DeleteMapping("/del/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        Integer res = productMapper.deleteById(id);
        return res == 1 ? new Response("200", "ok") : new Response("500", "fail");
    }

    /**
     * 请求地址：http://127.0.0.1:8080/get/2
     */
    @DeleteMapping("/del/{id}")
    public Object get(@PathVariable("id") Integer id) {
        Product product = productMapper.getById(id);
        return new Response("200", "ok", product);
    }

    @GetMapping("/list")
    public Object list(){
        return new Response("200","ok",productMapper.queryByLists());
    }
}

