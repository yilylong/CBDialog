# CBDialog
一个快速创建对话框的工具类库
============
集成了[sweet-alert-dialog](https://github.com/pedant/sweet-alert-dialog)<br/>
集成了[Titanic](https://github.com/RomainPiel/Titanic)的进度框动画样式<br/>
集成了[AVLoadingIndicatorView](https://github.com/81813780/AVLoadingIndicatorView)的动画样式<br/>
![](https://raw.githubusercontent.com/yilylong/ImageResource/master/cbdialog_1.png)  
![](https://raw.githubusercontent.com/yilylong/ImageResource/master/cbdialog_2.png)  
![](https://raw.githubusercontent.com/yilylong/ImageResource/master/cbdialog_3.png)  
![](https://raw.githubusercontent.com/yilylong/ImageResource/master/cbdialog_4.png)  

###How To Useage

    new CBDialogBuilder(this)
    .setTouchOutSideCancelable(true)
    .showCancelButton(true)
    .setTitle("这是一个普通样式的对话框")
    .setMessage("this is a normal CBDialog")
    .setConfirmButtonText("确定")
    .setCancelButtonText("取消")
    .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
    .create().show();  


######.create() 返回一个Dialog .show() 显示对话框  
可以传入不同样式。比如设置显示的是titanic风格的进度框
new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS_TITANIC).create();

    .setTouchOutSideCancelable(true) 设置是否点击对话框以外的区域dismiss对话框  
    .showCancelButton(true) 是否显示取消按钮
    .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM) 设置对话框的动画样式 
    .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)  设置对话框位于屏幕的位置
    .setButtonClickListener(true, new CBDialogBuilder.onDialogbtnClickListener() {
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
                        添加按钮回调监听

#####设置一个列表 和 列表项选中回调监听

    .setItems(new String[]{"较小", "中等", "较大", "巨无霸"}, new CBDialogBuilder.onDialogItemClickListener() {
       @Override
       public void onDialogItemClick(CBDialogBuilder.DialogItemAdapter ItemAdapter,Context context, CBDialogBuilder dialogbuilder,             Dialog dialog,int position) {
        //TODO 保存选中设置
        dialog.dismiss();
        }
     }, 2)

#####设置一个进度框的超时监听

     .setOnProgressOutTimeListener(5, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {
                            // do your work
                            }
      })
      
#####设置avloading进度框动画样式颜色

    .setProgressIndicatorColor(0xaa198675)
    .setProgressIndicator(CBDialogBuilder.INDICATOR_BallRotate)

详情参考DEMO
