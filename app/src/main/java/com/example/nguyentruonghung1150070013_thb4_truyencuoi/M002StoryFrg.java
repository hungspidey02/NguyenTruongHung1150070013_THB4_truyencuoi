package com.example.nguyentruonghung1150070013_thb4_truyencuoi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M002StoryFrg extends Fragment {

    private Context mContext;
    private String topicName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m002_frg_story, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        View ivBack = v.findViewById(R.id.iv_back);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(view -> backToM001Screen());
        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);

        RecyclerView rv = v.findViewById(R.id.rv_story);
        ArrayList<StoryEntity> listStory = readStory();
        StoryAdapter adapter = new StoryAdapter(listStory, mContext);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(adapter);
    }

    private ArrayList<StoryEntity> readStory() {
        ArrayList<StoryEntity> listStory = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            mContext.getAssets().open("story/" + topicName + ".txt"),
                            "UTF-8"
                    )
            );
            while (true) {
                String title = reader.readLine();
                if (title == null) {
                    break;
                }
                if (title.trim().isEmpty()) {
                    continue;
                }
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                    content.append(line).append("\n");
                }
                StoryEntity story = new StoryEntity(topicName, title, content.toString().trim());
                listStory.add(story);
                if (line == null) {
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
        }
        return listStory;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    private void backToM001Screen() {
        ((MainActivity) getActivity()).backToM001Screen();
    }
}
