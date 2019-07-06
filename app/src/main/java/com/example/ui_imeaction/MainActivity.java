package com.example.ui_imeaction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        if(editText != null){
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND){
                            dialNumber();
                            handled = true;
                        }
                    return handled;
                }
            });
        }

    }

    private void dialNumber() {
        if (editText != null){
            String num = "tel:" + editText.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(num));
            startActivity(intent);
        }
    }
}
