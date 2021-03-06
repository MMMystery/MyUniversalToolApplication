package com.example.administrator.myuniversaltoolapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myuniversaltoolapplication.R;
import com.example.administrator.myuniversaltoolapplication.ui.activity.ChatActivity;
import com.example.administrator.myuniversaltoolapplication.ui.activity.ContactsActivity;
import com.example.administrator.myuniversaltoolapplication.ui.adapter.ConversationAdapter;

import cn.bmob.newim.BmobIM;
import cn.bmob.newim.bean.BmobIMConversation;


public class OneFragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, ConversationAdapter.OnRecyclerViewListener {
    private Button topBar_btn_left, topBar_btn_right;
    private TextView topBar_tv_title;
    SwipeRefreshLayout sw_refresh;
    RecyclerView rc_view;
    ConversationAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        initView(view);

        return view;

    }


    private void initView(View view) {
        topBar_btn_left = (Button) view.findViewById(R.id.topbar_btn_left);
        topBar_btn_right = (Button) view.findViewById(R.id.topbar_btn_right);
        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        rc_view = (RecyclerView) view.findViewById(R.id.onefragment_rc_view);
        sw_refresh = (SwipeRefreshLayout) view.findViewById(R.id.onefragment_sw_refresh);
        topBar_btn_left.setOnClickListener(this);
        topBar_btn_right.setOnClickListener(this);
        topBar_btn_left.setVisibility(View.GONE);
        topBar_btn_right.setBackgroundResource(R.mipmap.bar_friends);
        topBar_tv_title.setText("聊天");

        adapter = new ConversationAdapter();
        rc_view.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getActivity());
        rc_view.setLayoutManager(layoutManager);
        sw_refresh.setEnabled(true);
        sw_refresh.setOnRefreshListener(this);
        adapter.setOnRecyclerViewListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.topbar_btn_left:
                Toast.makeText(getActivity(), "left", Toast.LENGTH_LONG).show();
                break;
            case R.id.topbar_btn_right:
                Intent intent = new Intent(getActivity(), ContactsActivity.class);
                startActivity(intent);
                break;
        }

    }

    /*
    sw_refresh的刷新方法
    * */
    @Override
    public void onRefresh() {
        query();
    }

    /*
       adapter的点击方法
       * */
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        BmobIMConversation c = adapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("c", c);
        intent.putExtra(getActivity().getPackageName(), bundle);
        getActivity().startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }


    @Override
    public void onResume() {
        super.onResume();
        sw_refresh.setRefreshing(true);
        query();
    }

    private void query() {
        adapter.bindDatas(getActivity(), BmobIM.getInstance().loadAllConversation());
        adapter.notifyDataSetChanged();
        sw_refresh.setRefreshing(false);
    }

}
