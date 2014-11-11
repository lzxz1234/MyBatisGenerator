/**
 * MyBatisGenerator
 * @title PKColumnMetadata.java
 * @package com.chn.mybatis.gen.def
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月10日-上午10:55:01
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.def;

/**
 * @class PKColumnMetadata
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class PKColumnMetadata extends ColumnMetadata {

    public static PKColumnMetadata from(ColumnMetadata from) {
        
        PKColumnMetadata result = new PKColumnMetadata();
        result.setTableCat       (from.getTableCat       ());
        result.setTableSchema    (from.getTableSchema    ());
        result.setTableName      (from.getTableName      ());
        result.setColumnName     (from.getColumnName     ());
        result.setDataType       (from.getDataType       ());
        result.setTypeName       (from.getTypeName       ());
        result.setColumnSize     (from.getColumnSize     ());
        result.setDecimalDigits  (from.getDecimalDigits  ());
        result.setNumPrecRadix   (from.getNumPrecRadix   ());
        result.setNullable       (from.getNullable       ());
        result.setRemarks        (from.getRemarks        ());
        result.setColumnDef      (from.getColumnDef      ());
        result.setCharOctetLength(from.getCharOctetLength());
        result.setOrdinalPosition(from.getOrdinalPosition());
        result.setIsNullable     (from.getIsNullable     ());
        result.setScopeCatalog   (from.getScopeCatalog   ());
        result.setScopeSchema    (from.getScopeSchema    ());
        result.setScopeTable     (from.getScopeTable     ());
        result.setSourceDataType (from.getSourceDataType ());
        result.setIsAutoincrement(from.getIsAutoincrement());
        return result;
    }
    
}
