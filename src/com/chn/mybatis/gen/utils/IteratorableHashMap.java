/**
 * MyBatisGenerator
 * @title IteratorableHashMap.java
 * @package com.chn.mybatis.gen.utils
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月7日-上午9:21:39
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.utils;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @class IteratorableHashMap
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class IteratorableHashMap<P, K> extends HashMap<P, K> implements Iterable<K>{

    private static final long serialVersionUID = -6455828927352156885L;

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<K> iterator() {
        
        return this.values().iterator();
    }

}
