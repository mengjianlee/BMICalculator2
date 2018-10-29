package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_MESSAGE="my.edu.tarc.bmicalculator.RESULT";
    private EditText weight;
    private EditText height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.textView);
        height = findViewById(R.id.textView2);

    }

    public void calculate(View view){
        double weightValue;
        double heightValue;
        double result;
        if(TextUtils.isEmpty(weight.getText())){
            weight.setError("Please enter you weight");
            return;
        }
        if(TextUtils.isEmpty(height.getText())){
            height.setError("Please enter you height");
            return;
        }
        weightValue = Double.parseDouble(weight.getText().toString());
        heightValue = Double.parseDouble(height.getText().toString());
        result = weightValue/(heightValue/100*heightValue/100);

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(TAG_MESSAGE, result);
        startActivity(intent);
    }
}
