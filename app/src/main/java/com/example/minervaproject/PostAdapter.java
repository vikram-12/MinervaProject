package com.example.minervaproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hendraanggrian.appcompat.widget.SocialTextView;

public class PostAdapter extends FirebaseRecyclerAdapter<PostModel, PostAdapter.PostViewHolder> {


    public PostAdapter(@NonNull FirebaseRecyclerOptions<PostModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull PostModel model) {
        holder.name.setText(model.getName());
        holder.PostView.setText(model.getPost());
        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        final String userid=firebaseUser.getUid();
        final String postkey=getRef(position).getKey();

        holder.getlikebuttonstatus(postkey,userid);
        holder.like_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.testclick=true;

                holder.likereference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(holder.testclick==true)
                        {
                            if(snapshot.child(postkey).hasChild(userid))
                            {
                                holder.likereference.child(postkey).child(userid).removeValue();
                               holder.testclick=false;
                            }
                            else
                            {
                                holder.likereference.child(postkey).child(userid).setValue(true);
                                holder.testclick=false;
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new PostViewHolder(view);
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        LinearLayout scrollLayout;
        SocialTextView PostView;
        ImageView like_btn;
        TextView like_text;

        Boolean testclick=false;
        DatabaseReference likereference;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            like_btn=(ImageView)itemView.findViewById(R.id.like);
            like_text=(TextView)itemView.findViewById(R.id.no_of_likes);
            name=itemView.findViewById(R.id.name);
            likereference=FirebaseDatabase.getInstance().getReference("likes");

            scrollLayout=itemView.findViewById(R.id.layout2);
            PostView=itemView.findViewById(R.id.description);
        }
        public void getlikebuttonstatus(final String postkey, final String userid)
        {
            likereference= FirebaseDatabase.getInstance().getReference("likes");
            likereference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.child(postkey).hasChild(userid))
                    {
                        int likecount=(int)snapshot.child(postkey).getChildrenCount();
                        like_text.setText(likecount+" likes");
                        like_btn.setImageResource(R.drawable.ic_heart);
                    }
                    else
                    {
                        int likecount=(int)snapshot.child(postkey).getChildrenCount();
                        like_text.setText(likecount+" likes");
                        like_btn.setImageResource(R.drawable.ic_like);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}
