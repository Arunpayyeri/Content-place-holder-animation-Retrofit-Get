package com.example.signet.betaretetz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class GetOneActivity extends AppCompatActivity {
Button  btngetone;
    Button btn_get;
    TextView tv_get_response;
    String url = "https://api.myjson.com/bins/10t0ix";
    Stethotest app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_one);
        btn_get = (Button) findViewById(R.id.btn_get);
        tv_get_response = (TextView) findViewById(R.id.tv_get_response);


        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getJson();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void getJson() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        app.httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                final String responseData = response.body().string();

                GetOneActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GetOneActivity.this.tv_get_response.setText(responseData);
                    }
                });

            }
        });

    }
}
