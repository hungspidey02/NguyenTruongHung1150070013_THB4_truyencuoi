package com.example.nguyentruonghung1150070013_thb4_truyencuoi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class M001TopicFrg extends Fragment implements View.OnClickListener {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_topic, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        LinearLayout lnMain = v.findViewById(R.id.ln_topic);
        lnMain.removeAllViews();
        try {
            String[] listItem = mContext.getAssets().list("photo");
            if (listItem != null) {
                for (String fileName : listItem) {
                    String name = fileName.substring(0, fileName.indexOf("."));
                    View vTopic = LayoutInflater.from(mContext).inflate(R.layout.item_topic, null);
                    ImageView ivTopic = vTopic.findViewById(R.id.iv_topic);
                    TextView tvTopic = vTopic.findViewById(R.id.tv_topic);

                    ivTopic.setImageBitmap(BitmapFactory.decodeStream(
                            mContext.getAssets().open("photo/" + fileName)));

                    if (name.equals("nghenghiep")) {
                        tvTopic.setText("Nghề nghiệp");
                    } else {
                        tvTopic.setText(name);
                    }

                    lnMain.addView(vTopic);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vTopic.getLayoutParams();
                    params.bottomMargin = 40;
                    vTopic.setLayoutParams(params);
                    vTopic.setTag(name);
                    vTopic.setOnClickListener(this);
                }
            }
        } catch (Exception e) {
        }

        Button btnZodiac = v.findViewById(R.id.btn_zodiac);
        btnZodiac.setOnClickListener(view -> ((MainActivity) mContext).gotoZodiacMenu());
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).gotoM002Screen((String) v.getTag());
    }
}
