/**
 * MyBatisGenerator
 * @title Trans.java
 * @package com.chn.mybatis.gen.trans
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月7日-下午4:31:23
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.trans;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

/**
 * @class Trans
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class Trans {

    private static AtomicInteger atomic = new AtomicInteger();
    
    protected String createTableAlias() {
        
        return "T" + atomic.incrementAndGet();
    }
    
    protected String createColumnAlias() {
        
        return "C" + atomic.incrementAndGet();
    }
    
    protected String underscoreToCamelCase(String src) {
        
        if(StringUtils.isEmpty(src)) return StringUtils.EMPTY;
        src = src.toLowerCase();
        StringBuilder sb = new StringBuilder(src.length());
        boolean needUpper = true;
        for(char c : src.toCharArray()) {
            if(c == '_')
                needUpper = true;
            else {
                sb.append(needUpper ? Character.toUpperCase(c) : c);
                needUpper = false;
            }
        }
        return sb.toString();
    }
    
}
