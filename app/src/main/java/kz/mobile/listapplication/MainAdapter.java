package kz.mobile.listapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ArrayList<String> persons;

    private ItemClickListener itemClickListener;

    public MainAdapter(ArrayList<String> persons, ItemClickListener itemClickListener) {
        super();
        this.persons = persons;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_row_person, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        holder.textViewPersonName.setText(persons.get(position));
        holder.setItemClick(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewPersonName;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPersonName = itemView.findViewById(R.id.textViewPersonName);
        }

        public void setItemClick(final String item) {
            textViewPersonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(item, getAdapterPosition());
                    }
                }
            });
        }
    }

    interface ItemClickListener {

        void onItemClick(String item, int position);
    }
}
