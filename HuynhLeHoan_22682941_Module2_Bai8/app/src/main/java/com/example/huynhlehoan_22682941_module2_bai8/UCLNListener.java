package com.example.huynhlehoan_22682941_module2_bai8;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UCLNListener implements View.OnClickListener {
    private EditText edita, editb;
    private TextView txtResult;

    public UCLNListener(EditText edita, EditText editb, TextView txtResult) {
        this.edita = edita;
        this.editb = editb;
        this.txtResult = txtResult;
    }

    @Override
    public void onClick(View v) {
        int a = Integer.parseInt(edita.getText().toString());
        int b = Integer.parseInt(editb.getText().toString());

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        txtResult.setText(String.valueOf(a));
    }
}
