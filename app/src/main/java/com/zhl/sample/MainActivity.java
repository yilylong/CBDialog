package com.zhl.sample;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.zhl.cbdialog.CBDialogBuilder;
import com.zhl.cbdialog.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends Activity implements OnClickListener {
    private int curSelectedItemPos = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_show_normal_dialog).setOnClickListener(this);
        findViewById(R.id.btn_set_btn_style).setOnClickListener(this);
        findViewById(R.id.btn_singlebtn).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_with_listener).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_with_items).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_progress).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_progress_titanic).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_progress_avloading).setOnClickListener(this);
        findViewById(R.id.custom_dialog_layout).setOnClickListener(this);
        findViewById(R.id.custom_dialog_view).setOnClickListener(this);
        findViewById(R.id.sweetAlert_dialog_success).setOnClickListener(this);
        findViewById(R.id.sweetAlert_dialog_error).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_normal_dialog:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(true)
                        .setTitle("这是一个普通样式的对话框")
                        .setMessage("this is a normal CBDialog")
                        .setConfirmButtonText("确定")
                        .setCancelButtonText("取消")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.btn_set_btn_style:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(true)
                        .setTitle("设置按钮和信息文字样式")
                        .setMessage("this is a normal CBDialog")
                        .setMessageTextSize(16)
                        .setMessageTextColor(Color.BLUE)
                        .setConfirmButtonText("确定")
                        .setConfirmBackgroundResouce(R.drawable.custom_button_background_right)
                        .setConfirmButtonTextColor(Color.WHITE)
                        .setCancelButtonText("Quit")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.btn_singlebtn:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(false)
                        .setTitle("单个按钮")
                        .setMessage("this is a normal CBDialog")
                        .setConfirmButtonText("确定")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.btn_show_normal_dialog_with_listener:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(true)
                        .setTitle("这是一个有按钮监听的对话框")
                        .setMessage("this is a normal CBDialog with listener")
                        .setConfirmButtonText("ok")
                        .setCancelButtonText("cancel")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)
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
                        .create().show();
                break;
            case R.id.btn_show_normal_dialog_with_items:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(false)
                        .showConfirmButton(false)
                        .setTitle("选择文字大小")
                        .setConfirmButtonText("ok")
                        .setCancelButtonText("cancel")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setItems(new String[]{"较小", "中等", "较大", "巨无霸"}, new CBDialogBuilder.onDialogItemClickListener() {

                            @Override
                            public void onDialogItemClick(CBDialogBuilder.DialogItemAdapter ItemAdapter,
                                                          Context context, CBDialogBuilder dialogbuilder, Dialog dialog,
                                                          int position) {
                                curSelectedItemPos = position;
                                //TODO 保存选中设置
                                dialog.dismiss();
                            }
                        }, curSelectedItemPos)
                        .create().show();
                break;
            case R.id.btn_show_normal_dialog_progress:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS, 0.5f)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(1, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {
                                dialogMsgTextView.setText("出错啦");
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_show_normal_dialog_progress_titanic:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS_TITANIC)
                        .setTouchOutSideCancelable(false)
                        .setDialogBackground(R.drawable.dialog_background_grey)
                        .setConfirmBackgroundResouce(R.drawable.gray_button_background)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setProgressTitanicText("拼命加载")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(2, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {

                            }
                        })
                        .create().show();
                break;
            case R.id.btn_show_normal_dialog_progress_avloading:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS_AVLOADING)
                        .setTouchOutSideCancelable(false)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(1, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {

                            }
                        })
//                        .setProgressIndicatorColor(0xaa198675)
//                        .setProgressIndicator(CBDialogBuilder.INDICATOR_BallGridPulse)
                        .create().show();
                break;
            case R.id.custom_dialog_layout:
                new CBDialogBuilder(this, R.layout.layout_custom_dialog_layout, 1.0f)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(false)
                        .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)
                        .setTitle("这是一个自定义dialog布局样式的对话框")
                        .setMessage("去除了dialog的圆角背景")
                        .setConfirmButtonText("确定")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();

                break;
            case R.id.custom_dialog_view:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_NORMAL, 1.0f)
                        .showIcon(false)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(false)
                        .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)
                        .setTitle("这是一个自定义消息布局view的对话框")
                        .setView(R.layout.custom_msg_view)
                        .setConfirmButtonText("确定")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.sweetAlert_dialog_success:
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE,0.5f).show();
                break;
            case R.id.sweetAlert_dialog_error:
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE,0.7F).setCancelText("Quit").show();
                break;
            default:
                break;
        }
    }
}
