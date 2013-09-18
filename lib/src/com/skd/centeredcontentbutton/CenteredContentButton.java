package com.skd.centeredcontentbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CenteredContentButton extends RelativeLayout {
	private ImageView icon;
	private TextView text;
	
	public CenteredContentButton(Context context) {
		super(context);
		init(context, null);
	}

	public CenteredContentButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public CenteredContentButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.btn_layout, this);
        
        setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        
        icon = (ImageView) findViewById(R.id.btnIcon);
        text = (TextView)  findViewById(R.id.btnText);
        
        if (attrs == null) { return; }
        
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BtnOptions);
        int btnBg = a.getResourceId(R.styleable.BtnOptions_btnBg, 0);
        int btnIcon = a.getResourceId(R.styleable.BtnOptions_btnIcon, 0);
        String btnText = a.getString(R.styleable.BtnOptions_btnText);
        int btnTextStyle = a.getResourceId(R.styleable.BtnOptions_btnTextStyle, 0);
        a.recycle();
        
        if (btnBg > 0) {
        	this.setBackgroundResource(btnBg);
        }
        
        if (btnIcon > 0) {
        	icon.setImageResource(btnIcon);
        }
        else {
        	icon.setVisibility(View.GONE);
        }
        
        text.setText(btnText);
        if (btnTextStyle > 0) {
        	text.setTextAppearance(getContext(), btnTextStyle);
        }
	}
	
	public String getText() {
		return text.getText().toString();
	}
	
	public void setText(String txt) {
		text.setText(txt);
	}
	
	public void setTypeFace(Typeface font) {
		text.setTypeface(font);
	}
	
	public void setTextStyle(int styleID) {
		text.setTextAppearance(getContext(), styleID);
	}
	
	public void setIcon(int drawableID) {
		if (drawableID > 0) {
        	icon.setImageResource(drawableID);
        	icon.setVisibility(View.VISIBLE);
        }
        else {
        	icon.setVisibility(View.GONE);
        }
	}
}
