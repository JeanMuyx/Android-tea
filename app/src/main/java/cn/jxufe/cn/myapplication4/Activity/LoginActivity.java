package cn.jxufe.cn.myapplication4.Activity;

import static android.view.Gravity.CENTER;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import cn.jxufe.cn.myapplication4.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入的用户名和密码
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // 检查用户名和密码是否为空
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    // 如果用户名或密码为空，显示错误消息
                    // 加载自定义布局文件
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast_layout, null);


// 找到布局中的 TextView
                    TextView textView = (TextView) layout.findViewById(R.id.custom_toast_text);
                    textView.setText("请输入用户名和密码"); // 设置要显示的文本

// 创建 Toast 实例并设置位置
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 450); // 设置Toast消息在屏幕中间显示

// 将自定义布局设置为 Toast 的视图
                    toast.setView(layout);
                    toast.show();


                } else {
                    // 如果用户名和密码不为空，启动另一个活动
                    Intent intent = new Intent(LoginActivity.this, ChinaTeaActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}