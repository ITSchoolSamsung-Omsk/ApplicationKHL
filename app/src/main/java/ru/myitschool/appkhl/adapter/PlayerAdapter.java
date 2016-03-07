package ru.myitschool.appkhl.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import ru.myitschool.appkhl.R;
import ru.myitschool.appkhl.model.Player;

public class PlayerAdapter extends ArrayAdapter<Player> {

    public PlayerAdapter(Context context, ArrayList<Player> list) {
        super(context, R.layout.player_item, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Player player = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_item,null);
        }

        ((TextView)convertView.findViewById(R.id.full_name)).setText(player.getFullName());
        ((TextView)convertView.findViewById(R.id.club_name)).setText(player.getNameClub());
        ((TextView)convertView.findViewById(R.id.score)).setText(String.valueOf(player.getScore()));

        switch (player.getFullName()){
            case "Фурх Доминик":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.furhat);
                break;
            case "Казаков Максим":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.kazakov);
                break;
            case "Куляш Денис":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.kulash);
                break;
            case "Лаута Артур":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.lauta);
                break;
            case "Пережогин Александр":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.peregjogin);
                break;
            case "Первышин Андрей":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.pervishin);
                break;
            case "Попов Александр":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.popov);
                break;
            case "Соботка Владимир":
                ((ImageView)convertView.findViewById(R.id.image_player)).setImageResource(R.drawable.sobotka);
                break;
        }

        CheckBox ch = (CheckBox)convertView.findViewById(R.id.like);
        ch.setChecked(player.isLike());
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setLike(((CheckBox) v).isChecked());
            }
        });
        return convertView;
    }
}
