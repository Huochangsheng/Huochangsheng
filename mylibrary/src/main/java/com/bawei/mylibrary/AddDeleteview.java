package com.bawei.mylibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created b 霍长生 on 2017/11/21 0021.
 */

public class AddDeleteview extends LinearLayout {
    private OnAddDelClickListener listener;
    private TextView et_number;

    interface OnAddDelClickListener {
        void onAddClick(View v);
        void onDelClick(View v);
    }
    //对外提供调用接口的方法
    public void setOnAddDelClickListener(OnAddDelClickListener listener) {
        if(listener != null){
            this.listener = listener;
        }
    }

    public AddDeleteview(Context context) {
        this(context,null);
    }

    public AddDeleteview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddDeleteview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        View.inflate(context,R.layout.layout_add_delete,this);
        ImageView iv_add = (ImageView) findViewById(R.id.iv_add);
        ImageView iv_del = (ImageView) findViewById(R.id.iv_del);
        et_number = (TextView) findViewById(R.id.et_number);
        iv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddClick(view);
            }
        });
        iv_del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelClick(view);
            }
        });
    }

}
