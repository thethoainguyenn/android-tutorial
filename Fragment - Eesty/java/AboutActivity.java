package com.example.thoailun.eesty;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    ImageView imgAccount;
    ImageView imgSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imgAccount = (ImageView) findViewById(R.id.imgAccount);
        imgSend = (ImageView) findViewById(R.id.imgSend);
    }
    // View để biết click View nào
    public void AddFragment(View view ) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.imgAccount:
                fragment = new FragmentAccount();
                break;
            case  R.id.imgSend:
                fragment = new FragmentSend();
                break;
            default:
                fragment = new FragmentAccount();
                break;
        }
        fragmentTransaction.replace(R.id.frameConatiner, fragment);
        // Comfirm
        fragmentTransaction.commit();
    }
}
