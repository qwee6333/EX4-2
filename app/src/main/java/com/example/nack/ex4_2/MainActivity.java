package com.example.nack.ex4_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private final int LOGIN_REQUEST = 0;
    private Button btnBMI;
    private Button btnback;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }
    protected void findViews(){
        btnBMI=(Button)findViewById(R.id.btnBMI);
        btnback=(Button)findViewById(R.id.btnback );
        textView2=(TextView)findViewById(R.id.textView2);
        textView2.setText("面對BMI現實：\n結果為：");
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(MainActivity.this,Ca_BMI.class);
                startActivityForResult(intent,LOGIN_REQUEST);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode !=LOGIN_REQUEST ){
            return;
        }
        switch (requestCode){
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                int resoult= bundle.getInt("BMI");
                textView2.setText(resoult);
                break;
            case  RESULT_CANCELED:
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
