package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/15 13:07.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getCategoryList(long parentId) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        ArrayList<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            //创建一个节点
            EasyUITreeNode treeNode = new EasyUITreeNode();
            treeNode.setId(tbContentCategory.getId());
            treeNode.setText(tbContentCategory.getName());
            treeNode.setState(tbContentCategory.getIsParent()?"closed":"open");

            resultList.add(treeNode);
        }
        return resultList;
    }

    @Override
    public TaotaoResult insertContentCategory(long parentId, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setParentId(parentId);
        contentCategory.setIsParent(false);
        contentCategory.setName(name);
        contentCategory.setStatus(1);
        contentCategory.setUpdated(new Date());
        contentCategory.setCreated(new Date());
        contentCategory.setSortOrder(1);
        contentCategoryMapper.insert(contentCategory);
        //查看父节点的isParent列是否为true，如果不是true改成true
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        //判断是否为true
        if(!parentCat.getIsParent()) {
            parentCat.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        //返回结果
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult deleteContentCategory(long parentId, long id) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        contentCategoryMapper.deleteByExample(example);
//        contentCategoryMapper.deleteByPrimaryKey(id);
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        TbContentCategoryExample example2 = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example2);
        if (list == null) {
            parentCat.setIsParent(false);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateContentCategory(long id, String name) {
        /*TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        contentCategoryMapper.updateByExample(example);*/
        TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
        category.setName(name);
        contentCategoryMapper.updateByPrimaryKey(category);
        return TaotaoResult.ok();
    }
}
