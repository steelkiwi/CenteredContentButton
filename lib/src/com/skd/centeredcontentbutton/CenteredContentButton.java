/*
 * Copyright (C) 2013 Steelkiwi Development, Julia Zudikova
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/*
 * Represents a button-like component with centered content - icon and/or text.
 * Background and icon resources, text value, text style and typeface can be defined in the XML layout file or with set() methods.
 */

public class CenteredContentButton extends RelativeLayout {
	private ImageView iconLeft;
	private ImageView iconRight;
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

		iconLeft = (ImageView) findViewById(R.id.btnIconLeft);
		iconRight = (ImageView) findViewById(R.id.btnIconRight);
		text = (TextView) findViewById(R.id.btnText);

		if (attrs == null) {
			return;
		}

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BtnOptions);
		int btnBg = a.getResourceId(R.styleable.BtnOptions_btnBg, 0);
		int btnIconLeft = a.getResourceId(R.styleable.BtnOptions_btnIconLeft, 0);
		int btnIconRight = a.getResourceId(R.styleable.BtnOptions_btnIconRight, 0);
		String btnText = a.getString(R.styleable.BtnOptions_btnText);
		int btnTextStyle = a.getResourceId(R.styleable.BtnOptions_btnTextStyle, 0);
		a.recycle();

		if (btnBg > 0) {
			this.setBackgroundResource(btnBg);
		}

		if (btnIconLeft > 0) {
			iconLeft.setImageResource(btnIconLeft);
			iconLeft.setVisibility(View.VISIBLE);
		}
		else {
			iconLeft.setVisibility(View.GONE);
		}
		
		if (btnIconRight > 0) {
			iconRight.setImageResource(btnIconRight);
			iconRight.setVisibility(View.VISIBLE);
		}
		else {
			iconRight.setVisibility(View.GONE);
		}

		text.setText(btnText);
		if (btnTextStyle > 0) {
			text.setTextAppearance(getContext(), btnTextStyle);
			text.setVisibility(View.VISIBLE);
		}
		else {
			text.setVisibility(View.GONE);
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

	public void setLeftIcon(int drawableId) {
		if (drawableId > 0) {
			iconLeft.setImageResource(drawableId);
			iconLeft.setVisibility(View.VISIBLE);
		}
		else {
			iconLeft.setVisibility(View.GONE);
		}
	}

	public void setRightIcon(int drawableId) {
		if (drawableId > 0) {
			iconRight.setImageResource(drawableId);
			iconRight.setVisibility(View.VISIBLE);
		}
		else {
			iconRight.setVisibility(View.GONE);
		}
	}

}
