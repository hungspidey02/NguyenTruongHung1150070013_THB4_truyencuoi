package com.example.nguyentruonghung1150070013_thb4_truyencuoi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFrg(new M000SplashFrg());
    }

    private void showFrg(Fragment frg) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, frg, null)
                .commit();
    }

    public void gotoM001Screen() {
        showFrg(new M001TopicFrg());
    }

    public void gotoM002Screen(String topicName) {
        this.topicName = topicName;
        M002StoryFrg frg = new M002StoryFrg();
        frg.setTopicName(topicName);
        showFrg(frg);
    }

    public void backToM001Screen() {
        gotoM001Screen();
    }

    public void gotoM003Screen(ArrayList<StoryEntity> listStory, StoryEntity story) {
        M003DetailStoryFrg frg = new M003DetailStoryFrg();
        frg.setData(topicName, listStory, story);
        showFrg(frg);
    }

    public void gotoZodiacMenu() {
        showFrg(new Z001MenuFrg());
    }

    public void gotoZodiacDetail(Zodiac zodiac) {
        Z002DetailFrg frg = new Z002DetailFrg();
        frg.setZodiac(zodiac);
        showFrg(frg);
    }

    public void backToZodiacMenu() {
        gotoZodiacMenu();
    }
}
