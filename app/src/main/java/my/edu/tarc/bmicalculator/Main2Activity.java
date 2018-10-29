package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView resultText;
        resultText = findViewById(R.id.resultText);

        ImageView resultImage = findViewById(R.id.resultImage);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.TAG_MESSAGE)){
            double resultMsg = intent.getDoubleExtra(MainActivity.TAG_MESSAGE,0);
            resultMsg = Double.parseDouble(String.format("%.2f",resultMsg));
            String resultDesc;

            if(resultMsg <= 18.5){
                resultImage.setImageResource(R.drawable.under);
                resultDesc = " You are underweight";
            } else if(resultMsg > 18.5 && resultMsg <= 25){
                resultImage.setImageResource(R.drawable.normal);
                resultDesc = " You are normal weight";
            }else{
                resultImage.setImageResource(R.drawable.over);
                resultDesc = " You are overweight";
            }

            resultText.setText("BMI: " + resultMsg + resultDesc);
        }
    }
}
