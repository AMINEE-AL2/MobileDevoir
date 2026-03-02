package com.example.media;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VilleAdapter extends RecyclerView.Adapter<VilleAdapter.VilleViewHolder> {

    private List<Ville> villeList;
    private Context context;

    public VilleAdapter(Context context, List<Ville> villeList) {
        this.context = context;
        this.villeList = villeList;
    }

    @NonNull
    @Override
    public VilleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ville, parent, false);
        return new VilleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VilleViewHolder holder, int position) {
        Ville ville = villeList.get(position);
        holder.txtNom.setText(ville.getNom());

        holder.btnSupprimer.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Suppression")
                    .setMessage("Voulez-vous supprimer cette ville ?")
                    .setPositiveButton("Oui", (dialog, which) -> {
                        villeList.remove(position);
                        notifyDataSetChanged();
                    })
                    .setNegativeButton("Non", null)
                    .show();
        });

        holder.btnModifier.setOnClickListener(v -> {
            EditText editText = new EditText(context);
            editText.setText(ville.getNom());

            new AlertDialog.Builder(context)
                    .setTitle("Modifier la ville")
                    .setView(editText)
                    .setPositiveButton("Modifier", (dialog, which) -> {
                        ville.setNom(editText.getText().toString());
                        notifyDataSetChanged();
                    })
                    .setNegativeButton("Annuler", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return villeList.size();
    }

    public static class VilleViewHolder extends RecyclerView.ViewHolder {
        TextView txtNom;
        Button btnModifier, btnSupprimer;

        public VilleViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNom = itemView.findViewById(R.id.txtNom);
            btnModifier = itemView.findViewById(R.id.btnModifier);
            btnSupprimer = itemView.findViewById(R.id.btnSupprimer);
        }
    }
}