package cn.jxufe.cn.myapplication4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.jxufe.cn.myapplication4.R;

public class UpdateActivity extends AppCompatActivity {

    TextView update_title, update_author;
    Button update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");

        update_title = findViewById(R.id.update_title);
        update_author = findViewById(R.id.update_autuor);
        update_btn = findViewById(R.id.update_Btn);

        update_author.setText(author);
        update_title.setText(title);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentModel commentModel = new CommentModel(id, update_title.getText().toString(), update_author.getText().toString());
                MyDataHelper myDataHelper = new MyDataHelper(UpdateActivity.this);
                myDataHelper.updateOne(commentModel);
                finish();
            }
        });
    }
};