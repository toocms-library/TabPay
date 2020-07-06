package com.toocms.tab.pay;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.toocms.tab.pay.listener.PayStatusCallback;
import com.toocms.tab.pay.modle.PayRequest;
import com.toocms.tab.ui.BaseActivity;

/**
 * 支付封装类
 *
 * @author Zero
 * @date 2016/5/21 10:41
 */
public class Pay {

    static final int ALIPAY = 0x123; // 支付宝支付标识
    static final int WXPAY = 0x456; // 微信支付标识

    static int payType; // 支付方式
    static boolean isPayState; // 是否为支付状态的标识
    static boolean isAlipaySec; // 当支付方式为支付宝时是否为第二次回调onResume

    /**
     * 支付
     *
     * @param activity
     * @param payRequest 接口返回的支付实体类
     */
    public static final void pay(Activity activity, PayRequest payRequest) {
        if (!TextUtils.isEmpty(payRequest.getAppid())) {  // 微信
            payType = WXPAY;
            isPayState = true;
            new WxPay(activity, payRequest).pay();
        } else if (!TextUtils.isEmpty(payRequest.getSign())) {  // 支付宝
            payType = ALIPAY;
            isPayState = true;
            new AliPay(activity, payRequest).pay();
        } else {
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).showToast("暂不支持的支付方式");
            } else {
                Toast.makeText(activity, "暂不支持的支付方式", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 支付状态回调
     *
     * @param callback
     */
    public static final void payStatusCallback(PayStatusCallback callback) {
        // 先判断是否为支付状态
        if (isPayState) {
            // 其次判断支付类型是否为支付宝
            if (payType == ALIPAY) {
                // 最后判断是否为第二次回调onResume
                // 如果不是则将第二次回调的变量改为true以至于下次判断是为第二次
                // 然后return掉onResume方法
                if (!isAlipaySec) {
                    isAlipaySec = true;
                    return;
                }
            }
            // 执行到这步判断支付方式
            // 如果为微信的话直接回调
            // 如果为支付宝的话判断是否为第二次
            // 最后将支付状态改为false，支付宝第二次回调同样改为false
            if (payType == WXPAY || (payType == ALIPAY && isAlipaySec)) {
                isPayState = false;
                isAlipaySec = false;
                callback.callback();
            }
        }
    }
}
