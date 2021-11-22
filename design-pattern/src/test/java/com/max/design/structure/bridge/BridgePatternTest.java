package com.max.design.structure.bridge;

import static org.junit.jupiter.api.Assertions.*;

import com.max.design.structure.bridge.channel.AliPay;
import com.max.design.structure.bridge.channel.Pay;
import com.max.design.structure.bridge.channel.WxPay;
import com.max.design.structure.bridge.mode.PayFaceMode;
import com.max.design.structure.bridge.mode.PayFingerprintMode;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BridgePatternTest {

    @Test
    public void test_pay() {

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new AliPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));

    }

}