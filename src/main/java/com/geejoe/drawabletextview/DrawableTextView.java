package com.geejoe.drawabletextview;

/**
 * Created by JoeLee on 2017/6/1 0001 11:05.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
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

    private int selectedColor;
    private int clickedColor;

    private boolean isEasySelectedColor = false;
    private boolean isEasyClickedColor = false;

    private OnDTClickListener onDTClickListener;

    public DrawableTextView(Context context) {
        this(context, null, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        initSize();
    }

    private void init(Context context, AttributeSet attrs) {
        setClickable(true);

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

        selectedColor = a.getColor(R.styleable.DrawableTextView_selectedColor, -1);
        clickedColor = a.getColor(R.styleable.DrawableTextView_clickedColor, -1);

        if (selectedColor != -1) {
            isEasySelectedColor = true;
        }
        if (clickedColor != -1) {
            isEasyClickedColor = true;
        }
        a.recycle();

        if (isEasySelectedColor || leftSelectedDrawable != null || rightSelectedDrawable != null ||
                topSelectedDrawable != null || bottomSelectedDrawable != null) {
            selectable = true;
        }

        setOnTouchListener(this);
    }

    private int dp2px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private void initSize() {
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
                if (isEasySelectedColor && leftDrawable != null) {
                    setLeftDrawable(changeColor(leftDrawable,selectedColor));
                    setTextColor(selectedColor);
                } else if (leftSelectedDrawable != null && leftDrawable != null) {
                    setLeftDrawable(leftSelectedDrawable);
                    setTextColor(selectedTextColor);
                }
                if (isEasySelectedColor && rightDrawable != null) {
                    setRightDrawable(changeColor(rightDrawable,selectedColor));
                    setTextColor(selectedColor);
                } else if (rightSelectedDrawable != null && rightDrawable != null) {
                    setRightDrawable(rightSelectedDrawable);
                    setTextColor(selectedTextColor);
                }
                if (isEasySelectedColor && bottomDrawable != null) {
                    setBottomDrawable(changeColor(bottomDrawable,selectedColor));
                    setTextColor(selectedColor);
                } else if (bottomSelectedDrawable != null && bottomDrawable != null) {
                    setBottomDrawable(bottomSelectedDrawable);
                    setTextColor(selectedTextColor);
                }
                if (isEasySelectedColor && topDrawable != null) {
                    setTopDrawable(changeColor(topDrawable,selectedColor));
                    setTextColor(selectedColor);
                } else if (topSelectedDrawable != null && topDrawable != null) {
                    setTopDrawable(topSelectedDrawable);
                    setTextColor(selectedTextColor);
                }
            } else {
                if ((leftSelectedDrawable != null || isEasySelectedColor) && leftDrawable != null) {
                    setLeftDrawable(resumeColor(leftDrawable));
                }
                if ((rightSelectedDrawable != null || isEasySelectedColor) && rightDrawable != null) {
                    setRightDrawable(resumeColor(rightDrawable));
                }
                if ((topSelectedDrawable != null || isEasySelectedColor) && topDrawable != null) {
                    setTopDrawable(resumeColor(topDrawable));
                }
                if ((bottomSelectedDrawable != null || isEasySelectedColor) && bottomDrawable != null) {
                    setBottomDrawable(resumeColor(bottomDrawable));
                }
                setTextColor(defaultTextColor);
            }
        }
    }

    private Drawable changeColor(Drawable drawable, int color) {
        Drawable dc = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintMode(dc, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(dc, color);
        return dc;
    }

    private Drawable resumeColor(Drawable drawable) {
        Drawable dc = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintMode(dc, PorterDuff.Mode.DST_IN);
        return dc;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!selectable) {
                    if (isEasyClickedColor && leftDrawable != null) {
                        setLeftDrawable(changeColor(leftDrawable,clickedColor));
                        setTextColor(clickedColor);
                    } else if (leftClickedDrawable != null && leftDrawable != null) {
                        setLeftDrawable(leftClickedDrawable);
                        setTextColor(clickedTextColor);
                    }
                    if (isEasyClickedColor && rightDrawable != null) {
                        setRightDrawable(changeColor(rightDrawable,clickedColor));
                        setTextColor(clickedColor);
                    } else if (rightClickedDrawable != null && rightDrawable != null) {
                        setRightDrawable(rightClickedDrawable);
                        setTextColor(clickedTextColor);
                    }
                    if (isEasyClickedColor && topDrawable != null) {
                        setTopDrawable(changeColor(topDrawable,clickedColor));
                        setTextColor(clickedColor);
                    } else if (topClickedDrawable != null && topDrawable != null) {
                        setTopDrawable(topClickedDrawable);
                        setTextColor(clickedTextColor);
                    }
                    if (isEasyClickedColor && bottomDrawable != null) {
                        setBottomDrawable(changeColor(bottomDrawable,clickedColor));
                        setTextColor(clickedColor);
                    } else if (bottomClickedDrawable != null && bottomDrawable != null) {
                        setBottomDrawable(bottomClickedDrawable);
                        setTextColor(clickedTextColor);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isTouchPointInView(this, (int) event.getRawX(), (int) event.getRawY())) {
                    if (onDTClickListener != null) {
                        onDTClickListener.onDTClick(this);
                    }
                }
                if (!selectable) {
                    if ((leftClickedDrawable != null || isEasyClickedColor) && leftDrawable != null) {
                        setLeftDrawable(resumeColor(leftDrawable));
                    }
                    if ((rightClickedDrawable != null || isEasyClickedColor) && rightDrawable != null) {
                        setRightDrawable(resumeColor(rightDrawable));
                    }
                    if ((topClickedDrawable != null || isEasyClickedColor) && topDrawable != null) {
                        setTopDrawable(resumeColor(topDrawable));
                    }
                    if ((bottomClickedDrawable != null || isEasyClickedColor) && bottomDrawable != null) {
                        setBottomDrawable(resumeColor(bottomDrawable));
                    }
                    setTextColor(defaultTextColor);
                }
                break;
        }
        return false;
    }

    private boolean isTouchPointInView(View view, int x, int y) {
        if (view == null) {
            return false;
        }
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        if (y >= top && y <= bottom && x >= left
                && x <= right) {
            return true;
        }
        return false;
    }

    public void setOnDTClickListener(OnDTClickListener onDTClickListener) {
        this.onDTClickListener = onDTClickListener;
    }

    public interface OnDTClickListener {
        void onDTClick(View v);
    }
}
