package android.com.jumpco.io.superheroapi.adapters;

import android.com.jumpco.io.superheroapi.R;
import android.com.jumpco.io.superheroapi.model.SuperheroPojo;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SuperheroListAdapter extends RecyclerView.Adapter<SuperheroListAdapter.ViewHolder>{

    private List<SuperheroPojo> superHeroList;

    public SuperheroListAdapter(List<SuperheroPojo> superHeroList){
        this.superHeroList = superHeroList;
    }



    @NonNull
    @Override
    public SuperheroListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate the custom layout
        View superHeroView = inflater.inflate(R.layout.item_hero,parent,false);

        //Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(superHeroView);
        return viewHolder;
    }

    @Override //populate data into the item through holder
    public void onBindViewHolder(@NonNull SuperheroListAdapter.ViewHolder holder, int position) {
    //get the data model based on position
        SuperheroPojo supeheroPojo = superHeroList.get(position);

        //set item views based on your views nd data model
        TextView idView = holder.idView;
        idView.setText(supeheroPojo.superHeroID);
        TextView nameView = holder.nameTextView;
        nameView.setText(supeheroPojo.superHeroName);
    }


    @Override // return the size of th list
    public int getItemCount() {
        return superHeroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView idView;
        public TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            idView = itemView.findViewById(R.id.id_row);
            nameTextView = itemView.findViewById(R.id.name_row);
        }

        @Override
        public void onClick(View view) {
            Log.i("DEBUG","Item RecyclerView Cliqué");
        }
    }
}
