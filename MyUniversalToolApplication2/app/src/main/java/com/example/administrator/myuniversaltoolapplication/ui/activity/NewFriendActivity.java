package com.example.administrator.myuniversaltoolapplication.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myuniversaltoolapplication.R;
import com.example.administrator.myuniversaltoolapplication.entity.NewFriend;
import com.example.administrator.myuniversaltoolapplication.ui.adapter.NewFriendAdapter;

import java.util.List;

public class NewFriendActivity extends BaseActivity implements View.OnClickListener{
    private Button topBar_bt_left,topBar_bt_right;
    private TextView topBar_tv_title;
    private RecyclerView rv_searchfriend;
    private SwipeRefreshLayout sw_refresh;
    private NewFriendAdapter newFriendAdapter;
    private List<NewFriend> newFriendDatasList;
    private NewFriend newFriendDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_friend);
        initView();
    }

    private void initView() {
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_left.setBackgroundResource(R.mipmap.bar_back);
        topBar_bt_right.setVisibility(View.GONE);
        topBar_tv_title.setText("新添加");
        topBar_bt_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.topbar_btn_left:
                this.finish();
                break;
        }
    }
}
