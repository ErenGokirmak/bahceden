package com.swifties.bahceden.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.databinding.LayoutCommentProducerViewBinding;
import com.swifties.bahceden.databinding.LayoutItemBinding;
import com.swifties.bahceden.models.Comment;

import java.util.List;

public class ProducerHomeNewReviewsAdapter extends RecyclerView.Adapter<ProducerHomeNewReviewsAdapter.ViewHolder>{

    List<Comment> newComments;
    Context context;
    LayoutInflater inflater;

    public ProducerHomeNewReviewsAdapter(List<Comment> newComments, Context context, LayoutInflater inflater) {
        this.newComments = newComments;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutCommentProducerViewBinding binding = LayoutCommentProducerViewBinding.inflate(inflater, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProducerHomeNewReviewsAdapter.ViewHolder holder, int position) {
        Comment comm = newComments.get(position);
        holder.binding.commentName.setText(comm.getAuthor().getName());
        holder.binding.commentMessage.setText(comm.getMessage());
        holder.binding.likeCount.setText(String.valueOf(comm.getCountOfLikes()));
        holder.binding.rating.setText(String.valueOf(comm.getRatingGiven()));
        holder.binding.whichProductId.setText(comm.getProduct().getName());
        Picasso.get().load(comm.getAuthor().getProfileImageURL().replace("localhost", "10.0.2.2"))
                .into(holder.binding.commentImage);

        holder.replyButton.setOnClickListener(v -> {
            holder.replyEdit.setVisibility(View.VISIBLE);
            holder.replyButton.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop);
            holder.replyEdit.startAnimation(animation);
            holder.likeCount.setVisibility(View.GONE);
        });

        holder.replyEdit.setOnEditorActionListener((v, actionId, event) -> {
            holder.replyEdit.setVisibility(View.GONE);
            holder.replyButton.setVisibility(View.VISIBLE);
            holder.likeCount.setVisibility(View.VISIBLE);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return newComments == null ? 0 : newComments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        LayoutCommentProducerViewBinding binding;

        EditText replyEdit;
        ImageView replyButton;
        TextView likeCount;
        public ViewHolder(@NonNull LayoutCommentProducerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            replyEdit = binding.commentReplyEditText;
            replyButton = binding.commentReplyButton;
            likeCount = binding.likeCount;

            binding.getRoot().setOnClickListener(v ->
                    Toast.makeText(binding.getRoot().getContext(), "BaS:" + getBindingAdapterPosition(), Toast.LENGTH_SHORT).show());
        }
    }
}
