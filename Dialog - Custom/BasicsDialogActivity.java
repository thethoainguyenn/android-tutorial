package com.example.thoailun.androidtutorial;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BasicsDialogActivity extends AppCompatActivity {
    Button btnBasicsDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics_dialog);
        btnBasicsDialog = (Button) findViewById(R.id.btnBasicsDialog);
        btnBasicsDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // BasicsDialog();
                CustomDialog();
            }
        });
    }

    public void BasicsDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BasicsDialogActivity.this);
        alertDialog.setTitle("Notification");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Are you sure");

        // Yes , no
        // No
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(BasicsDialogActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        // No
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(BasicsDialogActivity.this, "NO", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }
    public void CustomDialog() {
        final Dialog dialog = new Dialog(BasicsDialogActivity.this);
        dialog.setContentView(R.layout.dialog_custom_login);
        // Ánh xạ
        EditText edtPassword = (EditText) dialog.findViewById(R.id.txtPassword);
        Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BasicsDialogActivity.this, "OK đã tương tác được", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
