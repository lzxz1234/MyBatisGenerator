/**
 * MyBatisGenerator
 * @title TableMetadata.java
 * @package com.chn.mybatis.gen.def
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月6日-下午11:00:44
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chn.mybatis.gen.utils.IteratorableHashMap;

/**
 * @class TableMetadata
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class TableMetadata {

    private static Map<String, TableMetadata> map = new HashMap<>();
    
    public static TableMetadata find(String tableName) {
        
        TableMetadata result = map.get(tableName);
        if(result == null) {
            result = new TableMetadata();
            result.setTableName(tableName);
            map.put(tableName, result);
        }
        return result;
    }
    
    public static Map<String, TableMetadata> getAllTables() {
        
        return map;
    }
    
    private TableMetadata() {
        
    }
    
    private String tableCat    ;//TABLE_CAT 
    private String tableSchema ;//TABLE_SCHEM 
    private String tableName   ;//TABLE_NAME 
    private String tableType   ;//TABLE_TYPE 
    private String remarks     ;//REMARKS 
    
    private IteratorableHashMap<String, PKColumnMetadata> keys = new IteratorableHashMap<>();
    private IteratorableHashMap<String, ColumnMetadata> columns = new IteratorableHashMap<>();
    private List<LinkMetadata> links = new ArrayList<>();
    private List<LinkMetadata> linkBys = new ArrayList<>();
    
    public void addLink(LinkMetadata link) {
        this.links.add(link);
    }
    public List<LinkMetadata> getLinks() {
        return this.links;
    }
    public void addLinkBy(LinkMetadata linkBy) {
        this.linkBys.add(linkBy);
    }
    public List<LinkMetadata> getLinkBys() {
        return this.linkBys;
    }
    public void addKey(PKColumnMetadata key) {
        this.keys.put(key.getColumnName(), key);
    }
    public IteratorableHashMap<String, PKColumnMetadata> getKeys() {
        return this.keys;
    }
    public ColumnMetadata getKey(String name) {
        return this.keys.get(name);
    }
    public void addColumn(ColumnMetadata meta) {
        this.columns.put(meta.getColumnName(), meta);
    }
    public IteratorableHashMap<String, ColumnMetadata> getColumns() {
        return this.columns;
    }
    public ColumnMetadata getColumn(String name) {
        
        ColumnMetadata result = this.columns.get(name);
        if(result == null) 
            result = this.keys.get(name);
        if(result == null) 
            throw new RuntimeException(String.format("表【%s】不存在列【%s】", this.getTableName(), name));
        return result;
    }
    
    public String getTableCat() {
        return tableCat;
    }
    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }
    public String getTableSchema() {
        return tableSchema;
    }
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getTableType() {
        return tableType;
    }
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
}
