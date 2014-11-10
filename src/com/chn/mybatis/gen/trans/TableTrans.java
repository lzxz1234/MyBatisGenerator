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
import java.util.concurrent.ConcurrentHashMap;

import com.chn.mybatis.gen.def.ColumnMetadata;
import com.chn.mybatis.gen.def.LinkMetadata;
import com.chn.mybatis.gen.def.TableMetadata;
import com.chn.mybatis.gen.utils.IteratorableHashMap;

/**
 * @class TableTrans
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class TableTrans extends Trans {

    private static Map<String, TableTrans> map = new ConcurrentHashMap<>();
    
    private String alias;
    private TableMetadata meta;
    
    private List<LinkTrans> linkList;//Fom 是自己
    private List<LinkTrans> linkByList;//To 是自己
    private List<ColumnTrans> keyList;
    private List<ColumnTrans> columnList;
    
    private TableTrans(TableMetadata meta) {
        
        this.meta = meta;
        this.alias = this.createTableAlias();
    }
    
    public static TableTrans find(String tableName) {
        
        TableTrans result = map.get(tableName);
        if(result == null) {
            TableMetadata meta = TableMetadata.find(tableName);
            result = new TableTrans(meta);
            map.put(meta.getTableName(), result);
        }
        return result;
    }
    
    public static TableTrans forceNew(String tableName) {
        
        TableMetadata meta = TableMetadata.find(tableName);
        return new TableTrans(meta);
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
    
    public List<LinkTrans> getLinks() {
        
        return linkList == null ? linkList = buildTrans(meta.getLinks()) : linkList;
    }
    
    public List<LinkTrans> getLinkBys() {
        
        return linkByList == null ? linkByList = buildTrans(meta.getLinkBys()) : linkByList;
    }
    

    public String getAlias() {
        
        return this.alias;
    }
    
    private List<LinkTrans> buildTrans(List<LinkMetadata> links) {
        
        List<LinkTrans> result = new ArrayList<>();
        for(LinkMetadata link : links) 
            result.add(new LinkTrans(link));
        return result;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private List<ColumnTrans> buildTrans(IteratorableHashMap cols) {
        
        List<ColumnTrans> result = new ArrayList<ColumnTrans>();
        Map.Entry<String, ColumnMetadata> entry = null;
        Iterator<Map.Entry<String, ColumnMetadata>> it = cols.entrySet().iterator();
        while(it.hasNext()) {
            entry = it.next();
            result.add(new ColumnTrans(entry.getValue()));
        }
        return result;
    }
}
