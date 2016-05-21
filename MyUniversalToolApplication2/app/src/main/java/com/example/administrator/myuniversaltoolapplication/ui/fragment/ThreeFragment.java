package com.example.administrator.myuniversaltoolapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.administrator.myuniversaltoolapplication.R;
import com.example.administrator.myuniversaltoolapplication.ui.activity.DiscoverActivity;


public class ThreeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_discover;
    private TextView topBar_tv_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        ll_discover = (LinearLayout) view.findViewById(R.id.fragment_three_ll_discover);
        ll_discover.setOnClickListener(this);
        topBar_tv_title.setText("分享");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_three_ll_discover:
                Intent intent = new Intent(getActivity(), DiscoverActivity.class);
                startActivity(intent);
                break;
        }
    }
}
