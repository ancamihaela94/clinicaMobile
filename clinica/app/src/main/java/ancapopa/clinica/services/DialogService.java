package ancapopa.clinica.services;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import ancapopa.clinica.R;


/**
 * Created by vlad on 27/07/2017.
 */

public class DialogService {
    public static AlertDialog buildLogoutDialog(Context context, DialogInterface.OnClickListener onConfirm) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(R.string.dialog_logout_content)
                .setTitle(R.string.dialog_logout_title)
                .setCancelable(true)
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(R.string.yes,onConfirm);

        return builder.create();
    }
}
