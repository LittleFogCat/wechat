package com.lfc.wechat.utils;

import android.app.Dialog;
import android.content.Context;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class DialogUtils {
    public static SweetAlertDialog showErrorDialog(Context context, String errorMsg) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        dialog.setTitleText(errorMsg).show();
        return dialog;
    }

    public static SweetAlertDialog showSuccessDialog(Context context, SweetAlertDialog.OnSweetClickListener listener) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        dialog.setConfirmClickListener(listener)
                .setTitleText("完成")
                .show();
        return dialog;
    }

    public static SweetAlertDialog showSuccessDialog(Context context, String msg, SweetAlertDialog.OnSweetClickListener listener) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        dialog.setConfirmClickListener(listener)
                .setTitleText(msg)
                .show();
        return dialog;
    }


    public static SweetAlertDialog showProgressDialog(Context context, String msg) {
        return new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(msg);
    }
}
