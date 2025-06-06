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
                "com.arr.simple",
                response -> {
                    Toast.makeText(
                                    this,
                                    "App Name: " + response.getLastRelease().getAppName(),
                                    Toast.LENGTH_LONG)
                            .show();
                },
                error -> {
                    Toast.makeText(this, "Error " + error.getMessage(), Toast.LENGTH_LONG).show();
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
