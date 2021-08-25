package android.com.jumpco.io.superheroapi.adapters;

import android.com.jumpco.io.superheroapi.R;
import android.com.jumpco.io.superheroapi.pojo.SuperheroPojo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperheroAdapter extends BaseAdapter {

    private ArrayList<SuperheroPojo> list;
    private Context context;
    private LayoutInflater inflater;
    public static ViewHolder holder = null;


    public SuperheroAdapter(Context context,ArrayList<SuperheroPojo>list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        final SuperheroPojo pojo = list.get(position);

        if(view == null){
            view = inflater.inflate(R.layout.item_hero,null);
            holder = new ViewHolder();
            holder.idTextView = (TextView)view.findViewById(R.id.id_row);
            holder.nameTextView = (TextView)view.findViewById(R.id.name_row);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        if(list!=null) {
            holder.idTextView.setText(pojo.superHeroID);
            holder.nameTextView.setText(pojo.superHeroName);

        }

        return view;
    }


    class ViewHolder {
        public TextView idTextView;
        public TextView nameTextView;
    }
}
