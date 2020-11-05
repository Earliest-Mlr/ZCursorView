package com.zhujianyu.cursorview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by ZhuJianYu on 2020/11/5
 * Note 光标指示器
 */
public class CursorView extends RelativeLayout {
    private float cursorWidth;
    private float cursorHeight;
    private int cursorColor;
    private int cursorNumber;
    private int layoutWidth;
    private int index;

    private RelativeLayout rlLayout;
    private View vLint;

    public CursorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CursorView, 0, 0);
        cursorWidth = typedArray.getDimension(R.styleable.CursorView_cursor_width, 0);
        cursorHeight = typedArray.getDimension(R.styleable.CursorView_cursor_height, 0);
        cursorColor = typedArray.getColor(R.styleable.CursorView_cursor_color, 0);
        cursorNumber = typedArray.getInteger(R.styleable.CursorView_cursor_number, 0);
        typedArray.recycle();

        LayoutInflater.from(context).inflate(R.layout.cursor_view, this);
        rlLayout = findViewById(R.id.rl_layout);
        vLint = findViewById(R.id.v_lint);

        initView(context);
    }

    private void initView(Context context){
        //设置光标宽高
        ViewGroup.LayoutParams cursorParams = vLint.getLayoutParams();
        cursorParams.width = (int) cursorWidth;
        cursorParams.height = (int) cursorHeight;
        vLint.setLayoutParams(cursorParams);

        //设置光标背景色
        vLint.setBackgroundColor(cursorColor);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        wm.getDefaultDisplay().getMetrics(dm);//当前屏幕宽
        layoutWidth = dm.widthPixels / cursorNumber;

        //设置Layout宽
        ViewGroup.LayoutParams layoutParams = rlLayout.getLayoutParams();
        layoutParams.width = layoutWidth;
        rlLayout.setLayoutParams(layoutParams);
    }

    public void mobileCursor(int i){
        Animation animation = new TranslateAnimation(
                layoutWidth * index,
                layoutWidth * i,
                0, 0);// 设置动画
        index = i;
        animation.setFillAfter(true);// True:图片停在动画结束位置
        animation.setDuration(300);
        startAnimation(animation);
    }
}
