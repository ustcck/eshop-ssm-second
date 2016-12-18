package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbItem;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/15 16:20.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_CONTENT_SYNC_URL}")
    private String REST_CONTENT_SYNC_URL;

    @Override
    public EasyUIDateGridResult getContentList(int page, int rows, long categoryId) {

        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(page, rows);
        List<TbContent> tbContents = contentMapper.selectByExample(example);

        EasyUIDateGridResult result = new EasyUIDateGridResult();
        result.setRows(tbContents);
        //取记录总条数
        PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }

    @Override
    public TaotaoResult insertContent(TbContent content) {
        content.setUpdated(new Date());
        content.setCreated(new Date());
        contentMapper.insert(content);

        try {
            //添加缓存同步逻辑
            HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();

        }
        return TaotaoResult.ok();
    }
}
