package com.example.ocrfirstactivity;

import android.app.AlertDialog;
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
        final View view = inflater.inflate(R.layout.list_article, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), WebViewActivity.class);
            }
        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FakeNews pair = list.get(position);
        holder.display(pair);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private WebView htmlContent;
        private FakeNews current;

        public MyViewHolder(final View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            htmlContent = (WebView) itemView.findViewById(R.id.htmlContent);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(itemView.getContext(), WebViewActivity.class);
                    //view.getContext().startActivity(intent);
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            new AlertDialog.Builder(itemView.getContext())
                                    .setTitle(current.title)
                                    .setMessage(current.htmlContent)
                                    .show();
                        }
                    });
                }

                public void display(FakeNews fakeNews) {
                    current = fakeNews;
                    title.setText(Html.fromHtml(fakeNews.title));
                    // htmlContent.loadData(String.valueOf(htmlContent), "text/html; charset=UTF-8", null);
                }
            });
        }

        public void display(FakeNews pair) {
            current = pair;
            title.setText(Html.fromHtml(pair.title));
//            htmlContent.loadData(String.valueOf(htmlContent), "text/html; charset=UTF-8", null);
        }
    }
}
