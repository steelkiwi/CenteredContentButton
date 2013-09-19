Centered Content Button Library
=======================================

Centered Content Button is Android library which contains following classes:
<dl>
<dt>CenteredContentButton</dt>
<dd>Represents a button-like component with centered content - icon and/or text.
Background and icon resources, text value, text style and typeface can be set in the XML layout file or with set() methods.

See /demo folder for example how to use.</dd>


<dt>CenteredContentToggleButton</dt>
<dd>Represents a toggle button-like component with centered content - icon and/or text.
Background selector is used to represent selected and not selected states of a button.

See /toggle-demo folder for example how to use.</dd>


<dt>CenteredContentToggleGroup</dt>
<dd>Represents a group for toggle button-like components (like RadioGroup for RadioButtons).
Can be used to simulate tabs behavior.

See /tabs-demo folder for example how to use.</dd>
<dl>

How to use
----------

A button component is defined in the XML layout file as followed:

```xml
<com.skd.centeredcontentbutton.CenteredContentButton
    android:id="@+id/btn"
    android:layout_width="fill_parent"     <!-- you can also set size in dp -->
    android:layout_height="wrap_content"   <!-- you can also set size in dp -->
    ccb:btnBg="@drawable/..."              <!-- background drawable (or selector) -->
    ccb:btnIcon="@drawable/..."	           <!-- button icon -->
    ccb:btnText="@string/..."              <!-- button text -->
    ccb:btnTextStyle="@style/..."          <!-- button text style -->
/>
```

A group of toggle buttons is defined in the XML layout file as followed:

```xml
<com.skd.centeredcontentbutton.CenteredContentToggleGroup
    android:id="@+id/tabs"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal" >

    <com.skd.centeredcontentbutton.CenteredContentToggleButton
    	android:id="@+id/tab1"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.5"
        ccb:btnBg="@drawable/..."          <!-- background selector -->
        ccb:btnChecked="true"              <!-- set button to "checked" state -->
        ccb:btnIcon="@drawable/..."
        ccb:btnText="@string/..."
        ccb:btnTextStyle="@style/..." />

    <com.skd.centeredcontentbutton.CenteredContentToggleButton
        android:id="@+id/tab2"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.5"
        ccb:btnBg="@drawable/..."
        ccb:btnIcon="@drawable/..."
        ccb:btnText="@string/..."
        ccb:btnTextStyle="@style/..." />
</com.skd.centeredcontentbutton.CenteredContentToggleGroup>
```

In order to use components attributes add a namespace definition to the root layout in your XML layout file:

```xml
xmlns:ccb="http://schemas.android.com/apk/res-auto"
```

Button background and icon resources, text value, text style and typeface can also be defined with set() methods.


