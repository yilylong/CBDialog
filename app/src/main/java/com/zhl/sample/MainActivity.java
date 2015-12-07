package com.zhl.sample;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.zhl.cbdialog.CBDialogBuilder;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_show_normal_dialog).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_with_listener).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_with_items).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_progress).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_progress_titanic).setOnClickListener(this);
        findViewById(R.id.btn_show_normal_dialog_progress_avloading).setOnClickListener(this);
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
                                //TODO 保存选中设置
                                dialog.dismiss();
                            }
                        }, 2)
                        .create().show();
                break;
            case R.id.btn_show_normal_dialog_progress:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS)
                        .setTouchOutSideCancelable(false)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(4, new CBDialogBuilder.onProgressOutTimeListener() {
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
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setProgressTitanicText("拼命加载")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(4, new CBDialogBuilder.onProgressOutTimeListener() {
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
                        .setOnProgressOutTimeListener(5, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {

                            }
                        })
                        .create().show();
                break;

            default:
                break;
        }
    }
}
