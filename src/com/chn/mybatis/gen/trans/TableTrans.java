/**
 * MyBatisGenerator
 * @title TableTrans.java
 * @package com.chn.mybatis.gen.trans
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月7日-上午9:00:03
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.trans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.chn.mybatis.gen.def.ColumnMetadata;
import com.chn.mybatis.gen.def.TableMetadata;
import com.chn.mybatis.gen.utils.IteratorableHashMap;

/**
 * @class TableTrans
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class TableTrans extends Trans {

    private String alias;
    private TableMetadata meta;
    
    private List<ColumnTrans> linkList;
    private List<ColumnTrans> keyList;
    private List<ColumnTrans> columnList;
    
    public TableTrans(TableMetadata meta) {
        
        this.meta = meta;
        this.alias = this.createTableAlias();
    }
    
    public String getUpperStartClassName() {
        
        return underscoreToCamelCase(meta.getTableName());
    }
    
    public String getLowerStartClassName() {
        
        String camelCase = underscoreToCamelCase(meta.getTableName());
        return camelCase.substring(0,1).toLowerCase() + camelCase.substring(1);
    }
    
    public String getName() {
        
        return meta.getTableName();
    }
    
    public List<ColumnTrans> getKeys() {
        
        return keyList == null ? keyList = buildTrans(meta.getKeys()) : keyList;
    }
    
    public List<ColumnTrans> getColumns() {
        
        return columnList == null ? columnList = buildTrans(meta.getColumns()) : columnList;
    }
    
    public List<ColumnTrans> getLinks() {
        
        return linkList == null ? linkList = buildTrans(meta.getLinks()) : linkList;
    }
    
    public String getAlias() {
        
        return this.alias;
    }
    
    private List<ColumnTrans> buildTrans(IteratorableHashMap<String, ColumnMetadata> cols) {
        
        List<ColumnTrans> result = new ArrayList<ColumnTrans>();
        Map.Entry<String, ColumnMetadata> entry = null;
        Iterator<Map.Entry<String, ColumnMetadata>> it = cols.entrySet().iterator();
        while(it.hasNext()) {
            entry = it.next();
            result.add(new ColumnTrans(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}
