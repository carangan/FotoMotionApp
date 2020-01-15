package com.example.fotomotionapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private List<AnimationProject> projectNames;
    private Context context;

    private RecyclerViewAdapter() {

        // initialize using ArrayList
        projectNames = new ArrayList<>();

        // do something with context?
    }

    public RecyclerViewAdapter(Context context, @NonNull List<AnimationProject> projectNames) {
        super();

        this.context = context;
        this.projectNames = projectNames;
    }

    @NonNull
    @Override
    // pre: none
    // post: adds all elements from within the
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // not sure what this does
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.project_item,
                parent,
                false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final AnimationProject currentProject = projectNames.get(position);
        holder.projectName.setText(currentProject.getProjectName());
        holder.authorName.setText(currentProject.getAuthorName());

        holder.viewLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d(TAG, "item clicked!");

                Intent switchScreenIntent = new Intent(context, PaintActivity.class);
                switchScreenIntent.putExtra("com.example.fotomotionapp.buttonText", "ur gay");
                context.startActivity(switchScreenIntent);

                Toast.makeText(context, currentProject.getProjectName() + " by " + currentProject.getAuthorName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.viewLayout.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Log.d(TAG,"Clicked remove option");

                remove(currentProject.getProjectName());
                projectNames.remove(position);
                // notifyItemRemoved(position);
                notifyDataSetChanged();
                return true;
            }
        });

        holder.projectPreview.setImageResource(Math.random() * 10 < 5? R.mipmap.spaghetti_round: R.mipmap.susan_round);

//        holder.menuOptions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                PopupMenu optionPane = new PopupMenu(context, holder.menuOptions);
//                optionPane.inflate(R.menu.project_option);
//                optionPane.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch(item.getItemId()) {
//                            case R.id.removeOption: {
//                                Log.d(TAG,"Clicked remove option");
//
//                                remove(currentProject.getProjectName());
//                                projectNames.remove(position);
//                                // notifyItemRemoved(position);
//                                notifyDataSetChanged();
//                                return true;
//                            }
//                            case R.id.renameOption: {
//                                Log.d(TAG,"Clicked rename option");
//
//                                currentProject.setProjectName("Bruh");
//                                // notifyItemChanged(position);
//                                notifyDataSetChanged();
//                                return true;
//                            }
//                            default: return false;
//                        }
//                    }
//                });
//                optionPane.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return projectNames.size();
    }

    // this ViewHolder contains the components within each list item
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView projectPreview;
        private TextView projectName;
        private TextView authorName;
        private TextView menuOptions;
        private RelativeLayout viewLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            projectPreview = itemView.findViewById(R.id.projectImage);
            projectName = itemView.findViewById(R.id.projectName);
            authorName = itemView.findViewById(R.id.authorName);
            // menuOptions = itemView.findViewById(R.id.txtOptionDigit);
            viewLayout = itemView.findViewById(R.id.previewItem);
        }
    }

    private void remove(String currentProjectName) {
        // removedFile.delete();
        File fileThatBoom = new File(MainActivity.directoryName.getPath() + "/" + currentProjectName + ".jag");
        fileThatBoom.delete();
    }
}
