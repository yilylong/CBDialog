# Android 开发者指南 #

----------
###[1.集成准备](#1)
###[2.基本功能集成](#2)
###[3.其它接口](#3)
----------

<span id="1"></span>
## 1 集成准备
### 1.1 注册应用,获得 Appkey
-----
集成 SDK 之前，您首先注册并且添加新应用与渠道，获得Appkey。一个应用的不同渠道应该对应不同的       Appkey ，不同平台的应用不能使用相同的 Appkey ，应用名称与实际应用包名无关，建议命名为“应用名名称”+“平台名称”。

### 1.2 下载 SDK
-----

下载 SDK 最新版 HMT-sdk.1.0.zip并将其解压

### 1.3 导入 SDK
-----

- android studio 将 plugin 拷贝到项目目录下
- 在项目 build.gradle 添加：<code>dependencies {classpath fileTree(dir: 'plugin', include: '*.jar')}</code>
- 在 app 目录的 build.gradle 添加：<code>apply plugin: 'HMTPlugin'</code>
- 将 libs 内 jar 包引入到项目中
- 重启 android studio


<span id="2"></span>
## 2 基本功能集成

### 2.1 配置 AndroidManifest.xml
-----

AndroidManifest.xml 的配置主要包括添加权限，填写 Appkey 两个部分，代码示例如下：

<pre><code>
&lt;manifest……>
&lt;application ……>
&lt;activity ……/>

&lt;meta-data android:name="HMT_APPKEY" android:value="YOUR_APP_KEY" />
&lt;meta-data android:name="HMT_CHANNEL" android:value="YOUR_CHANNEL" />
&lt;/application>

&lt;uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
&lt;uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
&lt;uses-permission android:name="android.permission.INTERNET"/>
&lt;uses-permission android:name="android.permission.READ_PHONE_STATE"/>
&lt;uses-permission android:name="android.permission.GET_TASKS"/>
&lt;uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
&lt;uses-permission android:name="android.permission.READ_LOGS"/>
&lt;uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

&lt;/manifest>
</code></pre>

### 2.2 权限说明
-----

<table>
<tr>
<td>权限</td>
<td>说明</ta>
<tr>
<td>ACCESS_FINE_LOCATION</td>
<td>获取当前用户的位置信息</td>
</tr>
<td>ACCESS_WIFI_STATE</td>
<td>访问 Wi-Fi 网络状态信息</td>
</tr>
<td>INTERNET</td>
<td>向服务器发送用户的统计分析数据</td>
</tr>
<td>READ_PHONE_STATE</td>
<td>获取手机的相关状态信息</td>
</tr>
<td>GET_TASKS</td>
<td>获取最近运行任务信息</td>
</tr>
<td>WRITE_EXTERNAL_STORAGE</td>
<td>向 sdcard 读写文件</td>
</tr>
<td>READ_LOGS</td>
<td>读取程序产生的错误日志</td>
</tr>
<td>ACCESS_NETWORK_STATE</td>
<td>访问 GSM 网络信息</td>
</tr>
</table>

### 2.3 添加代码
-----
### 2.3.1 SDK 初始化
在应用启动时，或者第一个 Activity 的 onCreate 中调用
<pre><code>HMTAgent.Initialize(Context context)
HMTAgent.Initialize(Context context, int reportPolicy)
HMTAgent.Initialize(Context context, int reportPolicy, String[] unTracked)
</code></pre>
其中 reportPolicy 为发送模式，0 表示启动时发送，1 表示实时发送。unTracked 为参数黑名单数组，将需要过滤的参数填入其中，SDK 将不会发送该参数到服务器。实例如下：
<pre><code>String [] strArr = new String[2];
strArr[0] = "androidid";
strArr[1] = "androidid1";
HMTAgent.Initialize(context,1,strArr);
//或
//HMTAgent.Initialize(context,0);
</code></pre>
### 2.3.2 URL 白名单配置
URL 白名单需要在AndroidManifest.xml中配置。实例如下：
<pre><code>
&lt;application ……>
&lt;meta-data android:name="HMT_APPKEY" android:value="YOUR_APP_KEY" />
&lt;meta-data android:name="HMT_CHANNEL" android:value="YOUR_CHANNEL" />
&lt;meta-data android:name="HMT_TRACKEDURL" android:value="*" />
&lt;/application>
</code></pre>
其中 HMT_TRACKEDURL 为 URL 白名单，app 的所有 HTTP 以及 HTTPS 请求只有设置白名单才会抓取

trackedurl 目前支持以下几种方式
<pre><code>&lt;meta-data android:name="HMT_TRACKEDURL" android:value="*" />//抓取所有 URL

&lt;meta-data android:name="HMT_TRACKEDURL" android:value="baidu.com" />//抓取所有 baidu.com 以及其子域名的 URL

&lt;meta-data android:name="HMT_TRACKEDURL" android:value="www.baidu.com" />//抓取所有 www.baidu.com 以及其子域名的 URL

// 设置多条规则时，HTTP 以及 HTTPS 请求只要满足一条规则就会被抓取，将其用逗号拼接起来设置
&lt;meta-data android:name="HMT_TRACKEDURL" android:value="www.baidu.com,m.baidu.com" />//抓取所有 www.baidu.com 和 m.baidu.com 以及其子域名的 URL
</code></pre>

<span id="3"></span>
## 3 其它接口
### 3.1 设置数据接收地址
-----
如果想要更改数据接收地址，请在 SDK 初始化之前调用此api，实例如下：

<pre><code>HMTAgent.setBaseURL("https://m.irs01.com");
HMTAgent.Initialize(context);
</code></pre>


