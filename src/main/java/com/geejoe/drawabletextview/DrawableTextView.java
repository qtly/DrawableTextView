package com.geejoe.drawabletextview;

/**
 * Created by JoeLee on 2017/6/1 0001 11:05.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by JoeLee on 2017/5/27 0027 12:03.
 */

public class DrawableTextView extends TextView implements View.OnTouchListener {

    private Drawable leftDrawable;
    private Drawable rightDrawable;
    private Drawable topDrawable;
    private Drawable bottomDrawable;

    private Drawable leftClickedDrawable;
    private Drawable leftSelectedDrawable;
    private Drawable rightClickedDrawable;
    private Drawable rightSelectedDrawable;
    private Drawable topClickedDrawable;
    private Drawable topSelectedDrawable;
    private Drawable bottomClickedDrawable;
    private Drawable bottomSelectedDrawable;

    private Drawable leftShowDrawable;
    private Drawable rightShowDrawable;
    private Drawable topShowDrawable;
    private Drawable bottomShowDrawable;

    private Boolean selectable = false;

    private int leftDrawableWidth;
    private int leftDrawableHeight;
    private int rightDrawableWidth;
    private int rightDrawableHeight;
    private int topDrawableWidth;
    private int topDrawableHeight;
    private int bottomDrawableWidth;
    private int bottomDrawableHeight;

    private int defaultTextColor;
    private int selectedTextColor;
    private int clickedTextColor;

    public DrawableTextView(Context context) {
        this(context, null, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setWillNotDraw(false);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DrawableTextView);

        leftDrawable = a.getDrawable(R.styleable.DrawableTextView_leftDrawable);
        rightDrawable = a.getDrawable(R.styleable.DrawableTextView_rightDrawable);
        topDrawable = a.getDrawable(R.styleable.DrawableTextView_topDrawable);
        bottomDrawable = a.getDrawable(R.styleable.DrawableTextView_bottomDrawable);

        leftShowDrawable = leftDrawable;
        rightShowDrawable = rightDrawable;
        topShowDrawable = topDrawable;
        bottomShowDrawable = bottomDrawable;

        leftClickedDrawable = a.getDrawable(R.styleable.DrawableTextView_leftClickedDrawable);
        leftSelectedDrawable = a.getDrawable(R.styleable.DrawableTextView_leftSelectedDrawable);
        rightClickedDrawable = a.getDrawable(R.styleable.DrawableTextView_rightClickedDrawable);
        rightSelectedDrawable = a.getDrawable(R.styleable.DrawableTextView_rightSelectedDrawable);
        bottomClickedDrawable = a.getDrawable(R.styleable.DrawableTextView_bottomClickedDrawable);
        bottomSelectedDrawable = a.getDrawable(R.styleable.DrawableTextView_bottomSelectedDrawable);
        topClickedDrawable = a.getDrawable(R.styleable.DrawableTextView_topClickedDrawable);
        topSelectedDrawable = a.getDrawable(R.styleable.DrawableTextView_topSelectedDrawable);

        leftDrawableWidth = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_leftDrawableWidth, 0));
        leftDrawableHeight = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_leftDrawableHeight, 0));
        rightDrawableWidth = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_rightDrawableWidth, 0));
        rightDrawableHeight = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_rightDrawableHeight, 0));
        topDrawableWidth = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_topDrawableWidth, 0));
        topDrawableHeight = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_topDrawableHeight, 0));
        bottomDrawableWidth = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_bottomDrawableWidth, 0));
        bottomDrawableHeight = dp2px(context, a.getDimensionPixelSize(R.styleable.DrawableTextView_bottomDrawableHeight, 0));

        defaultTextColor = a.getColor(R.styleable.DrawableTextView_defaultTextColor, Color.BLACK);
        selectedTextColor = a.getColor(R.styleable.DrawableTextView_selectedTextColor, Color.BLACK);
        clickedTextColor = a.getColor(R.styleable.DrawableTextView_clickedTextColor, Color.BLACK);
        a.recycle();

        if (leftSelectedDrawable != null || rightSelectedDrawable != null ||
                topSelectedDrawable != null || bottomSelectedDrawable != null) {
            selectable = true;
        }

        setOnTouchListener(this);
    }

    private int dp2px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (leftDrawable != null) {
            leftDrawable.setBounds(0, 0, leftDrawableWidth, leftDrawableHeight);
        }
        if (leftClickedDrawable != null) {
            leftClickedDrawable.setBounds(0, 0, leftDrawableWidth, leftDrawableHeight);
        }
        if (leftSelectedDrawable != null) {
            leftSelectedDrawable.setBounds(0, 0, leftDrawableWidth, leftDrawableHeight);
        }
        if (leftShowDrawable != null) {
            leftShowDrawable.setBounds(0, 0, leftDrawableWidth, leftDrawableHeight);
        }

        if (rightDrawable != null) {
            rightDrawable.setBounds(0, 0, rightDrawableWidth, rightDrawableHeight);
        }
        if (rightClickedDrawable != null) {
            rightClickedDrawable.setBounds(0, 0, rightDrawableWidth, rightDrawableHeight);
        }
        if (rightSelectedDrawable != null) {
            rightSelectedDrawable.setBounds(0, 0, rightDrawableWidth, rightDrawableHeight);
        }
        if (rightShowDrawable != null) {
            rightShowDrawable.setBounds(0, 0, rightDrawableWidth, rightDrawableHeight);
        }

        if (topDrawable != null) {
            topDrawable.setBounds(0, 0, topDrawableWidth, topDrawableHeight);
        }
        if (topClickedDrawable != null) {
            topClickedDrawable.setBounds(0, 0, topDrawableWidth, topDrawableHeight);
        }
        if (topSelectedDrawable != null) {
            topSelectedDrawable.setBounds(0, 0, topDrawableWidth, topDrawableHeight);
        }
        if (topShowDrawable != null) {
            topShowDrawable.setBounds(0, 0, topDrawableWidth, topDrawableHeight);
        }

        if (bottomDrawable != null) {
            bottomDrawable.setBounds(0, 0, bottomDrawableWidth, bottomDrawableHeight);
        }
        if (bottomClickedDrawable != null) {
            bottomClickedDrawable.setBounds(0, 0, bottomDrawableWidth, bottomDrawableHeight);
        }
        if (bottomSelectedDrawable != null) {
            bottomSelectedDrawable.setBounds(0, 0, bottomDrawableWidth, bottomDrawableHeight);
        }
        if (bottomShowDrawable != null) {
            bottomShowDrawable.setBounds(0, 0, bottomDrawableWidth, bottomDrawableHeight);
        }

        draw();
    }

    private void draw() {
        setCompoundDrawables(this.leftShowDrawable, this.topShowDrawable, this.rightShowDrawable, this.bottomShowDrawable);
    }

    public void setLeftDrawable(Drawable drawable) {
        this.leftShowDrawable = drawable;
        draw();
    }

    public void setRightDrawable(Drawable drawable) {
        this.rightShowDrawable = drawable;
        draw();
    }

    public void setTopDrawable(Drawable drawable) {
        this.topShowDrawable = drawable;
        draw();
    }

    public void setBottomDrawable(Drawable drawable) {
        this.bottomShowDrawable = drawable;
        draw();
    }

    public void setSelected(boolean selected) {
        if (selectable) {
            if (selected) {
                if (leftSelectedDrawable != null && leftDrawable != null) {
                    setLeftDrawable(leftSelectedDrawable);
                }
                if (rightSelectedDrawable != null && rightDrawable != null) {
                    setRightDrawable(rightSelectedDrawable);
                }
                if (bottomSelectedDrawable != null && bottomDrawable != null) {
                    setBottomDrawable(bottomSelectedDrawable);
                }
                if (topSelectedDrawable != null && topDrawable != null) {
                    setTopDrawable(topSelectedDrawable);
                }
                setTextColor(selectedTextColor);
            } else {
                if (leftSelectedDrawable != null && leftDrawable != null) {
                    setLeftDrawable(leftDrawable);
                }
                if (rightSelectedDrawable != null && rightDrawable != null) {
                    setRightDrawable(rightDrawable);
                }
                if (topSelectedDrawable != null && topDrawable != null) {
                    setTopDrawable(topDrawable);
                }
                if (bottomSelectedDrawable != null && bottomDrawable != null) {
                    setBottomDrawable(bottomDrawable);
                }
                setTextColor(defaultTextColor);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!selectable) {
                    if (leftClickedDrawable != null && leftDrawable != null) {
                        setLeftDrawable(leftClickedDrawable);
                    }
                    if (rightClickedDrawable != null && rightDrawable != null) {
                        setRightDrawable(rightClickedDrawable);
                    }
                    if (topClickedDrawable != null && topDrawable != null) {
                        setTopDrawable(topClickedDrawable);
                    }
                    if (bottomClickedDrawable != null && bottomDrawable != null) {
                        setBottomDrawable(bottomClickedDrawable);
                    }
                    setTextColor(clickedTextColor);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (!selectable) {
                    if (leftClickedDrawable != null && leftDrawable != null) {
                        setLeftDrawable(leftDrawable);
                    }
                    if (rightClickedDrawable != null && rightDrawable != null) {
                        setRightDrawable(rightDrawable);
                    }
                    if (topClickedDrawable != null && topDrawable != null) {
                        setTopDrawable(topDrawable);
                    }
                    if (bottomClickedDrawable != null && bottomDrawable != null) {
                        setBottomDrawable(bottomDrawable);
                    }
                    setTextColor(defaultTextColor);
                }
                break;
        }
        return false;
    }
}
