package com.example.thoailun.eesty;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by THOAILUN on 03/22/18.
 */

public class FragmentAccount extends Fragment {
    @Nullable
    @Override
    // LayoutInflater : connect
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }
}
