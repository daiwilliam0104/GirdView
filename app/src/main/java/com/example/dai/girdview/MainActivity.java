package com.example.dai.girdview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.dai.girdview.R;

public class MainActivity extends Activity {
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = { R.drawable.air, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.android,
            R.drawable.battery, R.drawable.behance, R.drawable.behance,
            R.drawable.bowlingball, R.drawable.busticketmachine, R.drawable.bus,
            R.drawable.cd };
    private String[] iconName = { "通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
            "设置", "语音", "天气", "浏览器", "视频" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gview = (GridView) findViewById(R.id.gview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.show, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
    }



    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }


}