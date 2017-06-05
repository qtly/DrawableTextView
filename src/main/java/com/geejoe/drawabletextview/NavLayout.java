package com.geejoe.drawabletextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoeLee on 2017/6/5 0005 11:36.
 */

public class NavLayout extends LinearLayout {

    private List<DrawableTextView> nav_list = new ArrayList<>();
    private OnNavSelectedListener onNavSelectedListener;
    private boolean isSingleSelect = true;

    private boolean isAddChild = false;

    private int defaultSelected = -1;

    public NavLayout(Context context) {
        this(context, null);
    }

    public NavLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setGravity(Gravity.CENTER);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NavLayout);
        isSingleSelect = a.getBoolean(R.styleable.NavLayout_singleSelect, true);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initChild();
    }

    private void initChild() {
        if (!isAddChild) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child instanceof DrawableTextView) {
                    DrawableTextView nav = (DrawableTextView) child;
                    nav_list.add(nav);
                }
            }
            for (int j = 0; j < nav_list.size(); j++) {
                final int index = j;
                DrawableTextView dt = nav_list.get(index);
                dt.setOnDTClickListener(new DrawableTextView.OnDTClickListener() {
                    @Override
                    public void onDTClick(View v) {
                        selectNav(index);
                    }
                });
            }
            if (defaultSelected != -1) {
                nav_list.get(defaultSelected).setSelected(true);
            }
            isAddChild = true;
        }
    }

    public void setDefaultSelected(int index) {
        defaultSelected = index;
    }

    private void selectNav(int index) {
        if (isSingleSelect) {
            for (DrawableTextView dt : nav_list) {
                dt.setSelected(false);
            }
            nav_list.get(index).setSelected(true);
        }
        if (onNavSelectedListener != null) {
            onNavSelectedListener.onNavSelected(index);
        }
    }

    public void setOnNavSelectedListener(OnNavSelectedListener onNavSelectedListener) {
        this.onNavSelectedListener = onNavSelectedListener;
    }

    public interface OnNavSelectedListener {
        void onNavSelected(int index);
    }

}
