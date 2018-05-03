package com.toocms.pay.modle;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

/**
 * 支付返回签名结果基类
 * Author：Zero
 * Date：2017/3/29 14:37
 */
public class PayRequest {

    /**
     * link_string_encode : app_id=2088421265218041&biz_content={"body":"充值","out_trade_no":"14907685230638","product_code":"QUICK_MSECURITY_PAY","subject":"å¸å·åå¼","timeout_express":"10m","total_amount":"1"}&charset=utf-8&method=alipay.trade.app.pay¬ify_url=http://atg-api.jianyixian.com/index.php/Pay/asyncAliRenewal&sign_type=RSA×tamp=2017-03-29+14:22:03&version=1.0
     * link_string : app_id=2088421265218041&biz_content={"body":"用户充值","out_trade_no":"14907685230638","product_code":"QUICK_MSECURITY_PAY","subject":"帐号充值","timeout_express":"10m","total_amount":"1"}&charset=utf-8&method=alipay.trade.app.pay¬ify_url=http://atg-api.jianyixian.com/index.php/Pay/asyncAliRenewal&sign_type=RSA×tamp=2017-03-29 14:22:03&version=1.0
     * private : MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALMWzy0L+A5CCVj45TVL2jK1kM7O7E+4v8xf087/rv8eX0umUOhHMbWswMcN36GFFdn95WRE8WtLynuQmnq+aVvv5K+Q0vPfqAJplBIStu37ltHrdlvr2X7Qliv3bsyFcpnX0aFuFVE3yZ3svd4aj/wWJUqpc6Dix1Z/eVdQ7tUrAgMBAAECgYBns3SB9CVONETvZShsRSDzLhnM9xr1StidAnxGp91wUukBiCvfZKJPPdpfKRRulf7CPPfgqN9Wrwtvo5sgKjQdFVCSmqrdczciZpByuG3akXt/5B3LY/BHZ/VxfmceuM0gn/eKjK0RpSb61sD7lykn+6N3IHV+Rb+gEYvd4m88EQJBAN6/OX3UrlE+AWXN6oX9lbyRnGzmEff+jHuWED1zo7Rd5tHrl44UvxEC/b6rlFFBJBSdTub/Fyo0Mi+rsowu4fMCQQDN0xnj0OeegX7qWYsshg5BQnBeUEmCVmoXHw/qW8eyU8wrzXrjNYfgQASl/NjyYPLjx1zakU+fq2vrEvKzrNXpAkBNZ3odBelFhhyKOhJDWanNC3SmSxT3btd2ouEl2aeLqA3r6MiTsRXsXXO77Hfv/IkDON8QWpi8K8M82ZeEK06NAkB6oJk+OAqnTzPUYAEhR8VacEEOj/sb4mxW1jTfRktWHcL5HfVnRU9s9fdPBbQjxEsyFmdl+UldMf6cEa/0CLdxAkBzmaC6NOtouO0bHGe8smLuzpTsk27L3Hw/jGnGXj1UNVvx5GoZMkFKJzUIEiBrzP5XC4oknRrfw4s/jQLKFXP3
     * bill_sn : 14907683553327
     */

    // 支付宝
    private String link_string;
    @SerializedName("private")
    private String privateX;

    public String getLink_string() {
        return link_string;
    }

    public void setLink_string(String link_string) {
        this.link_string = link_string;
    }

    public String getPrivate() {
        return privateX;
    }

    public void setPrivate(String privateX) {
        this.privateX = privateX;
    }

    public String showAliRequest() {
        return "AliRequest{" +
                "link_string='" + link_string + '\'' +
                ", private='" + privateX +
                '}';
    }

    /**
     * appid : wx383f849a238548b5
     * partnerid : 1299440801
     * package : Sign=WXPay
     * noncestr : pqddcf5ovl2aznga56wkc2qmr52ak8f2
     * timestamp : 1490760688
     * prepayid : wx201703291211281d1044d99f0033272316
     * sign : 6d8114f981c680292e2d5603204c3919
     */

    // 微信
    private String appid;
    private String partnerid;
    @SerializedName("package")
    private String packageX;
    private String noncestr;
    private int timestamp;
    private String prepayid;
    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPackage() {
        return packageX;
    }

    public void setPackage(String packageX) {
        this.packageX = packageX;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String showWxRequest() {
        return "WxRequest{" +
                "appid='" + appid + '\'' +
                ", partnerid='" + partnerid + '\'' +
                ", package='" + packageX + '\'' +
                ", noncestr='" + noncestr + '\'' +
                ", timestamp=" + timestamp +
                ", prepayid='" + prepayid + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return TextUtils.isEmpty(getAppid()) ? showAliRequest() : showWxRequest();
    }
}
