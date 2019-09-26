package com.example.ocrfirstactivity;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

class MyFakeNewsAdapter extends RecyclerView.Adapter<MyFakeNewsAdapter.MyViewHolder> {
    private final List<FakeNews> list = FakeNewsList.all;

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_article, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FakeNews pair = list.get(position);
        holder.display(pair);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private TextView htmlContent;
        private FakeNews current;

        public MyViewHolder(final View itemView) {
            super (itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), WebViewActivity.class);
                  //  intent.putExtra("htmlContent", htmlContent.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }

        public void display(FakeNews fakeNews) {
            current = fakeNews;
            title.setText(Html.fromHtml(fakeNews.title));
        }
    }
}
