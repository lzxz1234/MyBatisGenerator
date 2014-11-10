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

import com.chn.mybatis.gen.utils.IteratorableHashMap;

/**
 * @class TableMetadata
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class TableMetadata {

    private String tableCat    ;//TABLE_CAT 
    private String tableSchema ;//TABLE_SCHEM 
    private String tableName   ;//TABLE_NAME 
    private String tableType   ;//TABLE_TYPE 
    private String remarks     ;//REMARKS 
    
    private IteratorableHashMap<String, ColumnMetadata> links = new IteratorableHashMap<>();
    private IteratorableHashMap<String, ColumnMetadata> keys = new IteratorableHashMap<>();
    private IteratorableHashMap<String, ColumnMetadata> columns = new IteratorableHashMap<>();
    
    public void addLink(String columName, ColumnMetadata foreign) {
        this.links.put(columName, foreign);
    }
    public IteratorableHashMap<String, ColumnMetadata> getLinks() {
        return this.links;
    }
    public void addKey(ColumnMetadata key) {
        this.keys.put(key.getColumnName(), key);
    }
    public IteratorableHashMap<String, ColumnMetadata> getKeys() {
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
        return this.columns.get(name);
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
