package com.mapper;

import com.po.Items;

public interface ItemsMapper {

    public Items queryById(int id)throws Exception;
    public void AddItems(Items items)throws Exception;
}
