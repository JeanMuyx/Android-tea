package cn.jxufe.cn.myapplication4.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.jxufe.cn.myapplication4.R;
import cn.jxufe.cn.myapplication4.recyclerView.RecyclerViewAdapter;
import cn.jxufe.cn.myapplication4.recyclerView.UserModel;

public class Part3Activity extends AppCompatActivity {

    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        recyclerView = findViewById(R.id.recycler);

        ArrayList<UserModel> usersList = new ArrayList<>();
        usersList.add(new UserModel("  茶道，就是品赏茶的美感之道。"));
        usersList.add(new UserModel("  茶道是“把茶视为珍贵、高尚的饮料，饮茶是一种精神上的享受，是一种艺术，或是一种修身养性的手段”。"));
        usersList.add(new UserModel("  茶道是一种通过饮茶的方式，对人民进行礼法教育、道德修养的一种仪式。"));
        usersList.add(new UserModel("  中国茶道的基本精神为“廉、美、和、敬”，即廉俭育德，美真康乐，和诚处世，敬爱为人。"));
        usersList.add(new UserModel("  中国茶道包含茶艺、茶德、茶礼、茶理、茶情、茶学说、茶道引导七种义理，中国茶道精神的核心是和。中国茶道就是通过喝茶的过程，引导个体在美的享受过程中走向完成品格修养以实现全人类和谐安乐之道。陈香白先生的茶道理论可简称为“七艺一心”。"));
        usersList.add(new UserModel("  说的比较随意，周作人先生对茶道的理解为：茶道的意思，用平凡的话来说，可以称作为忙里偷闲，苦中作乐，在不完全现实中享受一点美与和谐，在刹那间体会永久。"));
        usersList.add(new UserModel("  茶道是表现茶赋予人的一种生活方向或方法，也是指明人们在品茶过程中懂得的道理或理由。"));
        usersList.add(new UserModel("  所谓茶道是指品茗的方法与意境。"));
        usersList.add(new UserModel("  以身体动作作为媒介而演出的艺术。它包含了艺术的元素、社会因素、礼仪因素和修行因素等四个因素。"));
        usersList.add(new UserModel("  从历史学的角度提出：茶道是一种室内艺能。艺能是人本文化独有的一个艺术群，它通过人体的修炼达到陶冶情操完善人格的目的。"));
        usersList.add(new UserModel("  茶道是以深远的哲理为思想背景，综合生活文化，是东方文化之精华。"));
        usersList.add(new UserModel("  道是通向彻悟人生之路，茶道是茶至心之路，又是心至茶之路。"));



        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(Part3Activity.this,usersList);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Part3Activity.this));

    }
}