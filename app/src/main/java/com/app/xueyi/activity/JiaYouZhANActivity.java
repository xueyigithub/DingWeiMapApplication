package com.app.xueyi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.xueyi.dingweimapapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class JiaYouZhANActivity extends AppCompatActivity {

    @OnClick(R.id.jiayouzhan)
    void button(View v) {
        //Intent intent = new Intent(this, LocationActivity.class);
       // Intent intent=new Intent(this,DiTuDingWeiActivity.class);
        //Intent intent=new Intent(this,PoiAroundSearchActivity.class);
        // Intent intent=new Intent(this,MapLocationTestActivity.class);
    //Intent intent=new Intent(this,MultipleRoutePlanningActivity.class);
       Intent intent=new Intent(this,LocationTestActivity.class);



        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jia_you_zh_an);
        ButterKnife.bind(this);


    }

}
