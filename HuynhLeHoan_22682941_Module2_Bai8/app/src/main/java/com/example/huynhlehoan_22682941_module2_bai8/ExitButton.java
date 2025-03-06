package com.example.huynhlehoan_22682941_module2_bai8;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;

public class ExitButton extends AppCompatButton {
    public ExitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0); // Hoặc ((Activity) getContext()).finish();
            }
        });
    }
}

