package com.skd.centeredcontentbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.skd.centeredcontentbutton.CenteredContentToggleButton.OnCheckedChangeListener;

/**
 * Based on RadioGroup source code
 */

public class CenteredContentToggleGroup extends LinearLayout implements OnCheckedChangeListener {
	private int checkedId = -1;
	private boolean protecting = false;
	private OnCheckedChangeListener onCheckedChangeListener;
	
	public CenteredContentToggleGroup(Context context) {
		super(context);
	}

	public CenteredContentToggleGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@SuppressLint("NewApi")
	public CenteredContentToggleGroup(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if (checkedId != -1) {
			protecting = true;
			setCheckedStateForView(checkedId, true);
			protecting = false;
			setCheckedId(checkedId);
		}
	}
	
	@Override
	public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
		if (child instanceof CenteredContentToggleButton) {
			final CenteredContentToggleButton button = (CenteredContentToggleButton) child;
			button.setClickable(true);
			button.setOnCheckedChangeListener(this);
			
			if (button.isChecked()) {
				protecting = true;
	            if (checkedId != -1) {
	            	setCheckedStateForView(checkedId, false);
	            }
	            protecting = false;
	            
	            int id = button.getId();
	            if (id == View.NO_ID) {
		            id = button.hashCode();
		            button.setId(id);
	            }
	            
	            setCheckedId(id);
			}
			
			super.addView(child, index, params);
		}	
	}

	public void check(int id) {
		if (id != -1 && (id == checkedId)) {
			return;
		}
		if (checkedId != -1) {
			setCheckedStateForView(checkedId, false);
		}
		if (id != -1) {
			setCheckedStateForView(id, true);
		}
		setCheckedId(id);
	}
	
	private void setCheckedId(int id) {
		checkedId = id;
		if (onCheckedChangeListener != null) {
			onCheckedChangeListener.onCheckedChanged(this, checkedId);
		}
	}
	
	private void setCheckedStateForView(int viewId, boolean checked) {
		View checkedView = findViewById(viewId);
		if (checkedView != null && checkedView instanceof CenteredContentToggleButton) {
			((CenteredContentToggleButton) checkedView).setChecked(checked);
		}
	}
	
	public int getCheckedRadioButtonId() {
		return checkedId;
	}
	
	public void clearCheck() {
		check(-1);
	}
	
	public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
		this.onCheckedChangeListener = onCheckedChangeListener;
	}

	@Override
	public void onCheckedChanged(CenteredContentToggleButton btn) {
		if (protecting) {
			return;
		}
		
		int id = btn.getId();
		
		protecting = true;
		if (checkedId == id && !btn.isChecked()) { //do not allow to uncheck selected button by clicking on it
			setCheckedStateForView(checkedId, true);
			protecting = false;
			return; 
		}
		
		if (checkedId != -1) {
			setCheckedStateForView(checkedId, false);
		}
		protecting = false;
		
		setCheckedId(id);
	}

	public interface OnCheckedChangeListener {
		public void onCheckedChanged(CenteredContentToggleGroup group, int checkedId);
	}
}
