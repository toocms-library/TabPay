package com.toocms.pay;

import android.app.Activity;
import android.util.Log;

import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.toocms.pay.modle.PayRequest;

/**
 * 微信支付封装类 <br/>
 *
 * @author Zero    2015年4月27日
 */
class WxPay {

    private final String TAG = "WxPay";

    private Activity activity;

    private PayRequest payRequest;

    /**
     * @param activity
     * @param payRequest
     */
    public WxPay(Activity activity, PayRequest payRequest) {
        this.activity = activity;
        this.payRequest = payRequest;
    }

    /**
     * 调用微信支付页面
     */
    public void pay() {
        // 签名、调用微信支付页面
        Log.e(TAG, payRequest.toString());
        PayReq payReq = new PayReq();
        payReq.appId = payRequest.getAppid();
        payReq.partnerId = payRequest.getPartnerid();
        payReq.prepayId = payRequest.getPrepayid();
        payReq.packageValue = payRequest.getPackage();
        payReq.nonceStr = payRequest.getNoncestr();
        payReq.timeStamp = String.valueOf(payRequest.getTimestamp());
        payReq.sign = payRequest.getSign();
        IWXAPI api = WXAPIFactory.createWXAPI(activity, null);
        api.registerApp(payRequest.getAppid());
        api.sendReq(payReq);
    }
}
