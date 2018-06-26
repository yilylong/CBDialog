[![](https://jitpack.io/v/yilylong/CBDialog.svg)](https://jitpack.io/#yilylong/CBDialog)
# CBDialog
一个快速创建对话框的工具类库
============
支持各种样式的配置<br/>
集成了[sweet-alert-dialog](https://github.com/pedant/sweet-alert-dialog)<br/>
集成了[Titanic](https://github.com/RomainPiel/Titanic)的进度框动画样式<br/>
集成了[AVLoadingIndicatorView](https://github.com/81813780/AVLoadingIndicatorView)的动画样式<br/>
<img src='/show_1.png'/><br/>
<img src='/show_2.png'/><br/>
<img src='/show_3.png'/><br/>
<img src='/GIF.gif'/>

How To Useage
---

引入依赖

step1.Add it in your root build.gradle at the end of repositories:
-
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency
-
    dependencies {
	        compile 'com.github.yilylong:CBDialog:v1.0.6'
	}

    
code
--

    new CBDialogBuilder(this)
    .setTouchOutSideCancelable(true)
    .showCancelButton(true)
    .setTitle("这是一个普通样式的对话框")
    .setMessage("this is a normal CBDialog")
    .setConfirmButtonText("确定")
    .setCancelButtonText("取消")
    .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
    .create().show();  


可以传入不同的样式<br/>

    CBDialogBuilder.DIALOG_STYLE_NORMAL
    CBDialogBuilder.DIALOG_STYLE_PROGRESS
    CBDialogBuilder.DIALOG_STYLE_PROGRESS_TITANIC
    CBDialogBuilder.DIALOG_STYLE_PROGRESS_AVLOADING

    new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS_TITANIC).create();
    .setTouchOutSideCancelable(true) 设置是否点击对话框以外的区域dismiss对话框  
    .showCancelButton(true) 是否显示取消按钮
    .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM) 设置对话框的动画样式 
    .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)  设置对话框位于屏幕的位置
    .setButtonClickListener(true, new CBDialogBuilder.onDialogbtnClickListener() { 添加按钮回调监听
                            @Override
                            public void onDialogbtnClick(Context context, Dialog dialog, int whichBtn) {
                                switch (whichBtn) {
                                    case BUTTON_CONFIRM:
                                        Toast.makeText(context, "点击了确认按钮", Toast.LENGTH_SHORT).show();
                                        break;
                                    case BUTTON_CANCEL:
                                        Toast.makeText(context, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        })
                       
			
设置一个列表 和 列表项选中回调监听
--

    .setItems(new String[]{"较小", "中等", "较大", "巨无霸"}, new CBDialogBuilder.onDialogItemClickListener() {
       @Override
       public void onDialogItemClick(CBDialogBuilder.DialogItemAdapter ItemAdapter,Context context, CBDialogBuilder dialogbuilder,             Dialog dialog,int position) {
        //TODO 保存选中设置
        dialog.dismiss();
        }
     }, 2)

设置一个进度框的超时监听
--

     .setOnProgressOutTimeListener(5, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {
                            // do your work
                            }
      })
      
设置avloading进度框动画样式颜色
--

    .setProgressIndicatorColor(0xaa198675)
    .setProgressIndicator(CBDialogBuilder.INDICATOR_BallRotate)
 
 
设置自定义的dialog布局文件
-- 
在构建的时候传入R.layout.layout_custom_dialog_layout自定义布局文件即可，但是里面的个控件（标题，消息，按钮）的ID要跟cb_dialog.xml 里面一致<br/>

    new CBDialogBuilder(this, R.layout.layout_custom_dialog_layout, 1.0f)
                        ...
                        .create().show();   
 
 
设置自定义消息布局文件
--    
   
    .setView(R.layout.custom_msg_view)
 
自定义消息布局的运用示例
--
<img src='GIF2.gif'/>


更多配置方法参考DEMO

感谢
==
[sweet-alert-dialog](https://github.com/pedant/sweet-alert-dialog)<br/>
[Titanic](https://github.com/RomainPiel/Titanic)的进度框动画样式<br/>
[AVLoadingIndicatorView](https://github.com/81813780/AVLoadingIndicatorView)的动画样式<br/>

