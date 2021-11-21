package com.max.design.create.abstract_factory.bugstack;


import com.max.design.create.abstract_factory.bugstack.cuisine.impl.CacheServiceImpl;
import com.max.design.create.abstract_factory.bugstack.impl.EGMCacheAdapter;
import com.max.design.create.abstract_factory.bugstack.impl.IIRCacheAdapter;
import org.junit.jupiter.api.Test;

public class JDKProxyTest {

    @Test
    public void abstractFactoryTest() throws Exception {

        ICacheAdapter proxy_EGM = (ICacheAdapter) JDKProxy.getProxy(EGMCacheAdapter.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        ICacheAdapter proxy_IIR = (ICacheAdapter) JDKProxy.getProxy(IIRCacheAdapter.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);
    }
}