package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * PageHelper测试
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/9 19:14.
 */
public class TestPageHelper {
    @Test
    public void testPageHelper() {

        //创建spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获得mapper代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        //执行查询并分页
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(3, 10);
        List<TbItem> tbItems = mapper.selectByExample(example);
        //取商品列表
        for (TbItem tbItem : tbItems) {
            System.out.println(tbItem.getTitle());
        }
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        long total = pageInfo.getTotal();
        System.out.println("共有商品数目："+total);
    }
}
