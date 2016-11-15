package jp.techacademy.yumie.minakami.calcapp;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText    et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)    findViewById(R.id.editText1);
        et1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        et2 = (EditText)    findViewById(R.id.editText2);
        et2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        Button button_add = (Button)   findViewById(R.id.Add);
        button_add.setOnClickListener(this);

        Button button_minus = (Button)  findViewById(R.id.Minus);
        button_minus.setOnClickListener(this);

        Button button_product = (Button)    findViewById(R.id.Product);
        button_product.setOnClickListener(this);

        Button button_division = (Button)   findViewById(R.id.Division);
        button_division.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        if(v.getId() == R.id.Add)   intent.putExtra("CALC", (double) (Double.valueOf(et1.getText().toString()) + Double.valueOf(et2.getText().toString())));
        else if(v.getId() == R.id.Minus)    intent.putExtra("CALC", (double) (Double.valueOf(et1.getText().toString()) - Double.valueOf(et2.getText().toString())));
        else if(v.getId() == R.id.Product)  intent.putExtra("CALC", (double) (Double.valueOf(et1.getText().toString()) * Double.valueOf(et2.getText().toString())));
        else if(v.getId() == R.id.Division) intent.putExtra("CALC", (double) (Double.valueOf(et1.getText().toString()) / Double.valueOf(et2.getText().toString())));
        else intent.putExtra("CALC", 0.0);
        startActivity(intent);
    }
}
