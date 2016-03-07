package ru.myitschool.appkhl.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import ru.myitschool.appkhl.R;
import ru.myitschool.appkhl.adapter.PlayerAdapter;
import ru.myitschool.appkhl.model.Player;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Player> arrayList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initArrayList();
        initListView();
    }

    private void initListView() {
        listView = (ListView)findViewById(R.id.list_player);
        PlayerAdapter playerAdapter = new PlayerAdapter(MainActivity.this,arrayList);
        listView.setAdapter(playerAdapter);
    }

    private void initArrayList(){
        arrayList = new ArrayList<>();
        arrayList.add(new Player("Соботка Владимир","Авангард",
                      250,true));
        arrayList.add(new Player("Попов Александр","Авангард",
                300,true));
        arrayList.add(new Player("Пережогин Александр", "Авангард",
                300, false));
    }

    private void showPlayer(){
        HashMap<String, String> hashMap;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for(Player player : arrayList){
            hashMap = new HashMap<>();
            hashMap.put("name", player.getFullName());
            hashMap.put("club", player.getNameClub());
            hashMap.put("score", String.valueOf(player.getScore()));
            hashMap.put("like", Boolean.toString(player.isLike()));
            list.add(hashMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
                                            list, R.layout.player_item,
                                            new String[] {"name", "club", "score",
                                                            "like"},
                                            new int[] {R.id.full_name, R.id.club_name,
                                                        R.id.score, R.id.like});
        listView.setAdapter(simpleAdapter);
    }
}
