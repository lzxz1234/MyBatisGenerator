/**
 * MyBatisGenerator
 * @title LinkMetadata.java
 * @package com.chn.mybatis.gen.def
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月10日-上午11:18:56
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.def;

/**
 * @class LinkMetadata
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class LinkMetadata {

    private ColumnMetadata from;
    private ColumnMetadata to;
    
    public LinkMetadata(ColumnMetadata from, ColumnMetadata to) {
        
        this.from = from;
        this.to = to;
    }

    public ColumnMetadata getFrom() {
        return from;
    }

    public ColumnMetadata getTo() {
        return to;
    }
    
}
