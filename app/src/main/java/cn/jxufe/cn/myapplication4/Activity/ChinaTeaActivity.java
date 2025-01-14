package cn.jxufe.cn.myapplication4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import cn.jxufe.cn.myapplication4.R;

public class ChinaTeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_china_tea);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void part1Activity(View view) {
        Intent intent = new Intent(this, Part1Activity.class);
        startActivity(intent);
    }
    public void part2Activity(View view) {
        Intent intent = new Intent(this, Part2Activity.class);
        startActivity(intent);
    }
    public void part3Activity(View view) {
        Intent intent = new Intent(this, Part3Activity.class);
        startActivity(intent);
    }
    public void part4Activity(View view) {
        Intent intent = new Intent(this, Part4Activity.class);
        startActivity(intent);
    }

    public void EndActivity(View view) {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
    }

    public void LoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}