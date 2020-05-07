<p align="center">
  <img src="https://avatars3.githubusercontent.com/u/38806334?s=400&u=b20d7b719e126e45e3d45c0ff04d0597ae3ed703&v=4" width="220" height="220" alt="Banner" />
</p>

# TabPay框架集成文档

![Support](https://img.shields.io/badge/API-19+-4BC51D.svg)&#160;&#160;&#160;&#160;&#160;[![TAS Update](https://img.shields.io/badge/更新-记录-4BC51D.svg)](https://github.com/toocms-library/TooCMSAndroidPay/releases)&#160;&#160;&#160;&#160;&#160;![Author](https://img.shields.io/badge/Author-Zero-4BC51D.svg)

## 添加Gradle依赖
- 在模块目录下的build.gradle文件的dependencies添加
```
dependencies {
    implementation 'com.github.toocms-library:TabPay:3.0.0.200507-rc'
}
```
## 集成方法
- 请求获取支付宝或微信支付签名的接口（后台提供）
- 在onComplete中调用Pay.pay()方法
```
/**
 * 获取支付信息接口
 * <p>
 * 该方法为示例方法，主要看onComplete中实现的内容
 *
 * @param url     请求支付签名的url
 * @param payment 1-支付宝、2-微信
 */
private void cardPay(String url, int payment) {
    HttpParams params = new HttpParams();
    params.put("pmsid", "120100");
    params.put("userid", "13");
    params.put("tradeno", "1015103735507315301");
    params.put("paid_type", "aliapp");
    ApiTool apiTool = new ApiTool();
    apiTool.postApi(url, params, new ApiListener<TooCMSResponse<PayRequest>>() {
        @Override
        public void onComplete(TooCMSResponse<PayRequest> data, Call call, Response response) {
            // 根据返回签名调起支付
            Pay.pay(PayAty.this, data.getData());
        }
    });
}
```
- 在onResume中调用Pay.payStatusCallback()方法
```
 @Override
 protected void onResume() {
     super.onResume();
     Pay.payStatusCallback(new PayStatusCallback() {
         @Override
         public void callback() {
             // 调用检测支付状态接口

         }
     });
 }
```