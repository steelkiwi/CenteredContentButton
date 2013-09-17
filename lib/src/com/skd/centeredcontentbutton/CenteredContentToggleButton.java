package com.skd.centeredcontentbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;

/**
 * Based on https://gist.github.com/christopherperry/3746480
 */

public class CenteredContentToggleButton extends CenteredContentButton implements Checkable {
	private static final int[] CHECKED_STATE_SET = {
        android.R.attr.state_checked
    };
	
	private boolean checked = false;
	
	public CenteredContentToggleButton(Context context) {
		super(context);
		init(context, null);
	}

	public CenteredContentToggleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public CenteredContentToggleButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
        if (attrs == null) { return; }
        
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BtnOptions);
        boolean btnChecked = a.getBoolean(R.styleable.BtnOptions_btnChecked, false);
        a.recycle();
        
        setChecked(btnChecked);
	}
	
	@Override
	public boolean isChecked() {
		return checked;
	}

	@Override
	public void setChecked(boolean checked) {
		if (this.checked == checked) { return; }
		this.checked = checked;
		refreshDrawableState();
	}

	@Override
	public void toggle() {
		setChecked(!this.checked);
	}
	
	@Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }
	
	@Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }
 
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
 
        Drawable drawable = getBackground();
        if (drawable != null) {
            int[] myDrawableState = getDrawableState();
            drawable.setState(myDrawableState);
            invalidate();
        }
    }
    
    //State persistency
    
    static class SavedState extends BaseSavedState {
        boolean checked;
 
        SavedState(Parcelable superState) {
            super(superState);
        }
 
        private SavedState(Parcel in) {
            super(in);
            checked = (Boolean)in.readValue(null);
        }
 
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(checked);
        }
 
        @Override
        public String toString() {
            return "CheckableLinearLayout.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " checked=" + checked + "}";
        }
 
        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
 
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
 
    @Override
    public Parcelable onSaveInstanceState() {
        // Force our ancestor class to save its state
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
 
        ss.checked = isChecked();
        return ss;
    }
 
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
 
        super.onRestoreInstanceState(ss.getSuperState());
        setChecked(ss.checked);
        requestLayout();
    }
}
