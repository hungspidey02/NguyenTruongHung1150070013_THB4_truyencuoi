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

public class Z001MenuFrg extends Fragment implements View.OnClickListener {

    private Context mContext;
    private Zodiac[] zodiacs;
    private Zodiac currentZodiac;
    private ImageView ivCurrent;
    private TextView tvName;
    private TextView tvShort;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m001_frg_menu, container, false);
        initData();
        initViews(v);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initData() {
        zodiacs = new Zodiac[]{
                new Zodiac("Bạch Dương - Aries", "21/3 - 19/4", "Năng động, nhiệt huyết, thích dẫn đầu.", "Bạch Dương là cung hoàng đạo mang năng lượng của sự khởi đầu. Bạn luôn sẵn sàng xông pha trong mọi công việc, thích thử thách và không ngại đương đầu với khó khăn. Tuy đôi khi hơi nóng nảy và bốc đồng nhưng bạn lại rất chân thành và thẳng thắn.", R.drawable.ic_zd_aries),
                new Zodiac("Kim Ngưu - Taurus", "20/4 - 20/5", "Ổn định, thực tế, yêu thích sự an toàn.", "Kim Ngưu là người kiên nhẫn, chăm chỉ và có trách nhiệm. Bạn thích sự ổn định, yêu cái đẹp và có gu thưởng thức tinh tế. Đôi lúc bạn tỏ ra bướng bỉnh vì không muốn từ bỏ những điều mình cho là chắc chắn.", R.drawable.ic_zd_taurus),
                new Zodiac("Song Tử - Gemini", "21/5 - 20/6", "Hoạt bát, linh hoạt, giao tiếp tốt.", "Song Tử nhanh nhẹn, hài hước và rất giỏi nói chuyện. Bạn có thể thích ứng nhanh với môi trường mới, luôn tò mò muốn học hỏi điều mới. Hạn chế là dễ chán, hay thay đổi và đôi khi thiếu quyết đoán.", R.drawable.ic_zd_gemini),
                new Zodiac("Cự Giải - Cancer", "21/6 - 22/7", "Tình cảm, sâu sắc, yêu gia đình.", "Cự Giải sống nội tâm, giàu cảm xúc và luôn quan tâm chăm sóc những người mình yêu thương. Bạn đặt gia đình và các mối quan hệ lên hàng đầu. Tuy nhiên bạn cũng dễ bị tổn thương và có xu hướng giữ mọi chuyện trong lòng.", R.drawable.ic_zd_cancer),
                new Zodiac("Sư Tử - Leo", "23/7 - 22/8", "Tự tin, nổi bật, thích được chú ý.", "Sư Tử là người lãnh đạo đầy khí chất. Bạn thích thể hiện bản thân, hào phóng và rất trung thành với bạn bè. Đôi lúc cái tôi lớn khiến bạn trở nên cố chấp và thích được khen ngợi.", R.drawable.ic_zd_leo),
                new Zodiac("Xử Nữ - Virgo", "23/8 - 22/9", "Tỉ mỉ, cầu toàn, làm việc có kế hoạch.", "Xử Nữ có khả năng phân tích tốt, luôn muốn mọi thứ phải thật chỉn chu và hoàn hảo. Bạn làm việc có tổ chức, đáng tin cậy. Tuy nhiên bạn dễ lo lắng và hay tự tạo áp lực cho bản thân.", R.drawable.ic_zd_virgo),
                new Zodiac("Thiên Bình - Libra", "23/9 - 22/10", "Hòa nhã, công bằng, yêu cái đẹp.", "Thiên Bình rất khéo léo trong giao tiếp, luôn muốn giữ hòa khí và sự cân bằng. Bạn có gu thẩm mỹ tốt, thích cái đẹp và nghệ thuật. Hạn chế là bạn khá do dự khi phải đưa ra lựa chọn.", R.drawable.ic_zd_libra),
                new Zodiac("Bọ Cạp - Scorpio", "23/10 - 21/11", "Sâu sắc, bí ẩn, cảm xúc mạnh.", "Bọ Cạp là người giàu cảm xúc, có trực giác tốt và rất quyết liệt. Bạn yêu ghét rõ ràng, khi đã quyết tâm thì sẽ làm đến cùng. Nhưng bạn cũng dễ ghen tuông, khó tin tưởng người khác ngay từ đầu.", R.drawable.ic_zd_scorpio),
                new Zodiac("Nhân Mã - Sagittarius", "22/11 - 21/12", "Tự do, lạc quan, thích khám phá.", "Nhân Mã luôn mang đến nguồn năng lượng tích cực. Bạn yêu thích dịch chuyển, thích thử những điều mới lạ. Đôi khi bạn hơi thiếu kiên nhẫn với những công việc lặp lại và khuôn khổ.", R.drawable.ic_zd_sagittarius),
                new Zodiac("Ma Kết - Capricorn", "22/12 - 19/1", "Kỷ luật, tham vọng, nghiêm túc.", "Ma Kết tập trung vào mục tiêu dài hạn, chăm chỉ và có trách nhiệm. Bạn ít nói nhưng làm nhiều, không ngại khó khăn. Nhược điểm là đôi lúc quá nghiêm khắc với bản thân và người khác.", R.drawable.ic_zd_capricorn),
                new Zodiac("Bảo Bình - Aquarius", "20/1 - 18/2", "Độc đáo, sáng tạo, khác biệt.", "Bảo Bình có suy nghĩ rất riêng, yêu tự do và luôn muốn làm điều gì đó khác thường. Bạn quan tâm đến cộng đồng và các ý tưởng nhân văn. Tuy nhiên đôi khi bạn trở nên khó đoán và hơi xa cách.", R.drawable.ic_zd_aquarius),
                new Zodiac("Song Ngư - Pisces", "19/2 - 20/3", "Mơ mộng, nhạy cảm, giàu lòng trắc ẩn.", "Song Ngư là người lãng mạn, sống bằng cảm xúc và hay đồng cảm với người khác. Bạn có trí tưởng tượng phong phú, yêu nghệ thuật. Hạn chế là dễ bị cuốn vào cảm xúc, đôi khi thiếu thực tế.", R.drawable.ic_zd_pisces)
        };
        currentZodiac = zodiacs[0];
    }

    private void initViews(View v) {
        ivCurrent = v.findViewById(R.id.iv_current);
        tvName = v.findViewById(R.id.tv_name);
        tvShort = v.findViewById(R.id.tv_short);
        Button btnMore = v.findViewById(R.id.btn_more);

        v.findViewById(R.id.iv_aries).setOnClickListener(this);
        v.findViewById(R.id.iv_taurus).setOnClickListener(this);
        v.findViewById(R.id.iv_gemini).setOnClickListener(this);
        v.findViewById(R.id.iv_cancer).setOnClickListener(this);
        v.findViewById(R.id.iv_leo).setOnClickListener(this);
        v.findViewById(R.id.iv_virgo).setOnClickListener(this);
        v.findViewById(R.id.iv_libra).setOnClickListener(this);
        v.findViewById(R.id.iv_scorpio).setOnClickListener(this);
        v.findViewById(R.id.iv_sagittarius).setOnClickListener(this);
        v.findViewById(R.id.iv_capricorn).setOnClickListener(this);
        v.findViewById(R.id.iv_aquarius).setOnClickListener(this);
        v.findViewById(R.id.iv_pisces).setOnClickListener(this);

        btnMore.setOnClickListener(view -> gotoDetail());
        bindCurrent();
    }

    private void bindCurrent() {
        ivCurrent.setImageResource(currentZodiac.getIconRes());
        tvName.setText(currentZodiac.getDisplayName());
        tvShort.setText(currentZodiac.getShortDesc());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_aries) currentZodiac = zodiacs[0];
        else if (id == R.id.iv_taurus) currentZodiac = zodiacs[1];
        else if (id == R.id.iv_gemini) currentZodiac = zodiacs[2];
        else if (id == R.id.iv_cancer) currentZodiac = zodiacs[3];
        else if (id == R.id.iv_leo) currentZodiac = zodiacs[4];
        else if (id == R.id.iv_virgo) currentZodiac = zodiacs[5];
        else if (id == R.id.iv_libra) currentZodiac = zodiacs[6];
        else if (id == R.id.iv_scorpio) currentZodiac = zodiacs[7];
        else if (id == R.id.iv_sagittarius) currentZodiac = zodiacs[8];
        else if (id == R.id.iv_capricorn) currentZodiac = zodiacs[9];
        else if (id == R.id.iv_aquarius) currentZodiac = zodiacs[10];
        else if (id == R.id.iv_pisces) currentZodiac = zodiacs[11];
        bindCurrent();
    }

    private void gotoDetail() {
        ((MainActivity) mContext).gotoZodiacDetail(currentZodiac);
    }
}
