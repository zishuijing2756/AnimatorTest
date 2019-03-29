package com.nana.animator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageIv;
    private Button mStartAnimatorBtn;
    private Button mGoBackBtn;
    private Button mShowOrHideBtn;
    private static int sStartLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageIv=findViewById(R.id.m_img_iv);
        mImageIv.post(new Runnable() {
            @Override
            public void run() {
                int[] location=new int[2];
                mImageIv.getLocationOnScreen(location);
                sStartLocation=location[1];
            }
        });
        mStartAnimatorBtn=findViewById(R.id.m_start_animator_btn);
        mGoBackBtn=findViewById(R.id.m_go_back_btn);
        mShowOrHideBtn=findViewById(R.id.m_show_or_hide_btn);

        mStartAnimatorBtn.setOnClickListener(this);
        mGoBackBtn.setOnClickListener(this);
        mShowOrHideBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        int[] location=new int[2];
        mImageIv.getLocationOnScreen(location);
        switch (id) {
            case R.id.m_start_animator_btn:
                // AnimationUtil.translate(mImageIv,location[1],100-location[1]);
                int bottom= mImageIv.getBottom();
                AnimationUtil.objectTranslate(mImageIv,0,bottom-50);
                break;
            case R.id.m_go_back_btn:
                // AnimationUtil.translate(mImageIv,location[1],location[1]-sStartLocation);
                break;
            case R.id.m_show_or_hide_btn:
                if(mImageIv.getVisibility()==View.VISIBLE){
                    mImageIv.setVisibility(View.GONE);
                }else{
                    mImageIv.setVisibility(View.VISIBLE);

                }
                break;
            default:
                break;
        }
    }
}
