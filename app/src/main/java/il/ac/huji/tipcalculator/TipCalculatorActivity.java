package il.ac.huji.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Button calc = (Button) findViewById(R.id.btnCalculate);
        calc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                TextView res = (TextView) findViewById(R.id.txtTipResult);
                EditText input = (EditText) findViewById(R.id.edtBillAmount);
                CheckBox round = (CheckBox) findViewById(R.id.chkRound);
                double tip = 0;
                try {
                    tip = Double.parseDouble(input.getText().toString()) * 0.12;
                    String sTip = "$" + String.valueOf(round.isChecked() ? Math.ceil(tip) : tip);
                    res.setText(sTip.endsWith(".0") ? sTip.substring(0, sTip.lastIndexOf(".0")) : sTip);
                } catch (NumberFormatException nfe) {
                    res.setText("invalid input");
                }

            }

        });
    }
}
