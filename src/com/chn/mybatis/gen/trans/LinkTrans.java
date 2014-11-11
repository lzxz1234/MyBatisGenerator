/**
 * MyBatisGenerator
 * @title LinkTrans.java
 * @package com.chn.mybatis.gen.trans
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月10日-下午2:24:31
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.trans;

import com.chn.mybatis.gen.def.LinkMetadata;

/**
 * @class LinkTrans
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class LinkTrans extends Trans {
    
    private ColumnTrans from;
    private ColumnTrans to;
    
    public LinkTrans(ColumnTrans from, ColumnTrans to) {
        
        this.from = from;
        this.to = to;
        //自己对自己的连接，需要更新别名
        if(this.from.getTableTrans() == this.to.getTableTrans()) {
            this.from.setTableTrans(TableTrans.forceNew(from.getTableName()));
            this.to.setTableTrans(TableTrans.forceNew(to.getTableName()));
        }
    }
    
    public LinkTrans(LinkMetadata link) {
        
        this(new ColumnTrans(link.getFrom()), new ColumnTrans(link.getTo()));
    }
    
    public TableTrans getTargetTableTrans() {
        
        return to.getTableTrans();
    }
    
    public TableTrans getFromTableTrans() {
        
        return from.getTableTrans();
    }
    
    public String getFromColumnName() {
        
        return from.getName();
    }
    
    public String getToColumnName() {
        
        return to.getName();
    }
}
