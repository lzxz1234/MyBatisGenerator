/**
 * MyBatisGenerator
 * @title ColumnMetadata.java
 * @package com.chn.mybatis.gen.def
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月6日-下午11:02:26
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.def;

/**
 * @class ColumnMetadata
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class ColumnMetadata {

    private String  tableCat         ;//TABLE_CAT
    private String  tableSchema      ;//TABLE_SCHEM
    private String  tableName        ;//TABLE_NAME
    private String  columnName       ;//COLUMN_NAME
    private Integer dataType         ;//DATA_TYPE
    private String  typeName         ;//TYPE_NAME
    private Integer columnSize       ;//COLUMN_SIZE
    private Integer decimalDigits    ;//DECIMAL_DIGITS
    private Integer numPrecRadix     ;//NUM_PREC_RADIX
    private Integer nullable         ;//NULLABLE
    private String  remarks          ;//REMARKS
    private String  columnDef        ;//COLUMN_DEF
    private Integer charOctetLength  ;//CHAR_OCTET_LENGTH
    private Integer ordinalPosition  ;//ORDINAL_POSITION
    private String  isNullable       ;//IS_NULLABLE
    private String  scopeCatalog     ;//SCOPE_CATALOG
    private String  scopeSchema      ;//SCOPE_SCHEMA
    private String  scopeTable       ;//SCOPE_TABLE
    private Short   sourceDataType   ;//SOURCE_DATA_TYPE
    private String  isAutoincrement  ;//IS_AUTOINCREMENT
    
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
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public Integer getDataType() {
        return dataType;
    }
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Integer getColumnSize() {
        return columnSize;
    }
    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }
    public Integer getDecimalDigits() {
        return decimalDigits;
    }
    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }
    public Integer getNumPrecRadix() {
        return numPrecRadix;
    }
    public void setNumPrecRadix(Integer numPrecRadix) {
        this.numPrecRadix = numPrecRadix;
    }
    public Integer getNullable() {
        return nullable;
    }
    public void setNullable(Integer nullable) {
        this.nullable = nullable;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getColumnDef() {
        return columnDef;
    }
    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }
    public Integer getCharOctetLength() {
        return charOctetLength;
    }
    public void setCharOctetLength(Integer charOctetLength) {
        this.charOctetLength = charOctetLength;
    }
    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }
    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }
    public String getIsNullable() {
        return isNullable;
    }
    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }
    public String getScopeCatalog() {
        return scopeCatalog;
    }
    public void setScopeCatalog(String scopeCatalog) {
        this.scopeCatalog = scopeCatalog;
    }
    public String getScopeSchema() {
        return scopeSchema;
    }
    public void setScopeSchema(String scopeSchema) {
        this.scopeSchema = scopeSchema;
    }
    public String getScopeTable() {
        return scopeTable;
    }
    public void setScopeTable(String scopeTable) {
        this.scopeTable = scopeTable;
    }
    public Short getSourceDataType() {
        return sourceDataType;
    }
    public void setSourceDataType(Short sourceDataType) {
        this.sourceDataType = sourceDataType;
    }
    public String getIsAutoincrement() {
        return isAutoincrement;
    }
    public void setIsAutoincrement(String isAutoincrement) {
        this.isAutoincrement = isAutoincrement;
    }
    
}
