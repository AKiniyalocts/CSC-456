package com.akiniyalocts.csc_456.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.Html;
import android.transition.Transition;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akiniyalocts.commons.activities.ButterKnifeActivity;
import com.akiniyalocts.commons.widgets.MaterialIconTextView;
import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.Utils;
import com.akiniyalocts.csc_456.data.RealmManager;
import com.akiniyalocts.csc_456.model.pojos.Badge;

import butterknife.Bind;

public class BadgeDetailActivity extends ButterKnifeActivity {

    public static final String BADGE_KEY = "key::badge";
    public static final String BADGE_GLYPH_VIEW_KEY = "key::badge::glyph";
    public static final String BADGE_TITLE_VIEW_KEY = "key::badge::title";

    @Bind(R.id.detail_badge_glyph)
    MaterialIconTextView mGlyph;

    @Bind(R.id.detail_badge_title)
    TextView mTitle;

    @Bind(R.id.detail_badge_desc)
    TextView mDesc;

    @Bind(R.id.detail_badge_bg)
    FrameLayout mFrame;

    @Override
    public int getContentView() {
        return R.layout.activity_badge_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewCompat.setTransitionName(mGlyph, BADGE_GLYPH_VIEW_KEY);
        ViewCompat.setTransitionName(mTitle, BADGE_TITLE_VIEW_KEY);

        loadBadge();
    }

    private void loadBadge(){
        if(getIntent() != null){


            Badge badge = new RealmManager<Badge>(this, Badge.class).queryByFieldname("id", getIntent().getIntExtra(BADGE_KEY, 0)).get(0);


            if(badge != null){

                mGlyph.setText(Utils.BadgeMapper.get(badge.getBadge()));
                mTitle.setText(badge.getTitle());
                mFrame.setBackgroundColor(Color.parseColor(Utils.getRandomMaterialColor()));
                mDesc.setText(Html.fromHtml(badge.getDescription()));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()) {
                    // If we're running on Lollipop and we have added a listener to the shared element
                    // transition, load the thumbnail. The listener will load the full-size image when
                    // the transition is complete.

                } else {
                    // If all other cases we should just load the full-size image now
                    animateGlyph();
                }

            }
        }
    }

    private void animateGlyph(){
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        mGlyph.startAnimation(shake);
        shake = null;
    }


    private boolean addTransitionListener() {
        final Transition transition = getWindow().getSharedElementEnterTransition();

        if (transition != null) {
            // There is an entering shared element transition so add a listener to it
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionEnd(Transition transition) {
                    // As the transition has ended, we can now load the full-size image
                    animateGlyph();
                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionStart(Transition transition) {
                    // No-op
                }

                @Override
                public void onTransitionCancel(Transition transition) {
                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionPause(Transition transition) {
                    // No-op
                }

                @Override
                public void onTransitionResume(Transition transition) {
                    // No-op
                }
            });
            return true;
        }

        // If we reach here then we have not added a listener
        return false;
    }


}
