package cn.jxufe.cn.myapplication4.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import cn.jxufe.cn.myapplication4.R;

public class Part4Activity extends AppCompatActivity {

    TextView add_title,add_author;
    Button add_btn;
    ListView view_all;
    MyDataHelper myDataHelper;

    @Override
    protected void onRestart() {
        super.onRestart();
        viewAll();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4);

        add_author = findViewById(R.id.add_author);
        add_title = findViewById(R.id.add_title);
        add_btn = findViewById(R.id.add_btn);
        view_all = findViewById(R.id.view_all);

        myDataHelper = new MyDataHelper(Part4Activity.this);
        viewAll();

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentModel commentModel = new CommentModel(-1,add_title.getText().toString(),add_author.getText().toString());
                myDataHelper = new MyDataHelper(Part4Activity.this);
                String s = myDataHelper.addOne(commentModel);
                Toast.makeText(Part4Activity.this,"ADD:" + s,Toast.LENGTH_SHORT).show();
                viewAll();
            }
        });

        view_all.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CommentModel commentModel = (CommentModel) adapterView.getItemAtPosition(i);

                AlertDialog.Builder dialog = new AlertDialog.Builder(Part4Activity.this);
                dialog.setTitle("请选择操作");
                dialog.setNegativeButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String s = myDataHelper.deleteOne(commentModel);
                        Toast.makeText(Part4Activity.this,"DELETE:" + s,Toast.LENGTH_SHORT).show();
                        viewAll();
                    }
                });
                dialog.setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Part4Activity.this, UpdateActivity.class);
                        intent.putExtra("id",commentModel.getId());
                        intent.putExtra("title",commentModel.getTitle());
                        intent.putExtra("author",commentModel.getAuthor());
                        startActivity(intent);

                    }
                });

                dialog.create();
                dialog.show();
            }
        });

    }

    private void viewAll() {
        ArrayAdapter<CommentModel> adapter = new ArrayAdapter<>(Part4Activity.this, android.R.layout.simple_list_item_1, myDataHelper.getALL());
        view_all.setAdapter(adapter);
    }
}