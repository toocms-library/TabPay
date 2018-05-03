package com.toocms.pay;

import android.app.Activity;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.toocms.pay.modle.PayRequest;

/**
 * 支付宝接口封装类<br/>
 * 在Manifest文件中添加一个Activity：<br/>
 * &ltactivity <br/>
 * android:name="com.alipay.sdk.app.H5PayActivity"<br/>
 * android:configChanges="orientation|keyboardHidden|navigation"<br/>
 * android:exported="false"<br/>
 * android:screenOrientation="behind"<br/>
 * android:windowSoftInputMode="adjustResize|stateHidden"<br/>
 * /><br/>
 * 添加权限：<br/>
 * INTERNET<br/>
 * ACCESS_NETWORK_STATE<br/>
 * ACCESS_WIFI_STATE<br/>
 * READ_PHONE_STATE<br/>
 * WRITE_EXTERNAL_STORAGE<br/>
 *
 * @author Zero @date 2014年12月14日
 * @version 1.0
 */
class AliPay implements Runnable {

    private final String TAG = "Alipay";

    private Activity activity;
    private Thread thread;

    private PayRequest payRequest;

    /**
     * @param activity
     * @param payRequest
     */
    public AliPay(Activity activity, PayRequest payRequest) {
        thread = new Thread(this);
        this.activity = activity;
        this.payRequest = payRequest;
    }

    /**
     * 调用支付宝充值页面
     */
    public void pay() {
        thread.start();
    }

    @Override
    public void run() {
        // 构造PayTask 对象
        PayTask alipay = new PayTask(activity);
        // 调用支付接口，获取支付结果
        String result = alipay.pay(payRequest.getSign(), true);
        Log.i(TAG, "result = " + result);
    }
}
