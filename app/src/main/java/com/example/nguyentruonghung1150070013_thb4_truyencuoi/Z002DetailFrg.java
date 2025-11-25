package com.example.nguyentruonghung1150070013_thb4_truyencuoi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Z002DetailFrg extends Fragment {

    private Context mContext;
    private Zodiac zodiac;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m002_frg_detail, container, false);
        initViews(v);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        ImageView ivIcon = v.findViewById(R.id.iv_icon);
        TextView tvTitle = v.findViewById(R.id.tv_title);
        TextView tvContent = v.findViewById(R.id.tv_content);
        Button btnBack = v.findViewById(R.id.btn_back);

        if (zodiac != null) {
            ivIcon.setImageResource(zodiac.getIconRes());
            tvTitle.setText(zodiac.getDisplayName());
            tvContent.setText(zodiac.getLongDesc());
        }

        btnBack.setOnClickListener(view -> ((MainActivity) mContext).backToZodiacMenu());
    }

    public void setZodiac(Zodiac zodiac) {
        this.zodiac = zodiac;
    }
}
