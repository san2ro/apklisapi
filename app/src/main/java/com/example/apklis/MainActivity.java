package com.example.apklis;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.apklis.databinding.ActivityMainBinding;
import cu.arr.apklisapi.Apklis;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());

        Apklis.checkUpdate(
                this,
                (infoApp, url) -> {
                    Toast.makeText(
                                    this,
                                    "App Name: " + infoApp.getLastRelease().getAppName(),
                                    Toast.LENGTH_LONG)
                            .show();
                    binding.text.setText(url.getDownloadUrl());
                },
                (error, unused) -> {
                    Toast.makeText(this, "Error " + error.getMessage(), Toast.LENGTH_LONG).show();
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
        Apklis.stopCheckUpdate();
    }
}
