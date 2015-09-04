package com.example.vidmantas.viewpagerintro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Vidmantas Kerbelis (vkerbelis@yahoo.com) on 2015-08-05.
 */
public class IntroFragment extends Fragment {

    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String PAGE = "page";

    private int mBackgroundColor, mPage;

    public static IntroFragment newInstance(int backgroundColor, int page) {
        IntroFragment frag = new IntroFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, backgroundColor);
        b.putInt(PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getArguments().containsKey(BACKGROUND_COLOR)) {
            throw new RuntimeException("Fragment must contain a \"" + BACKGROUND_COLOR + "\" argument!");
        }
        mBackgroundColor = getArguments().getInt(BACKGROUND_COLOR);

        if (!getArguments().containsKey(PAGE)) {
            throw new RuntimeException("Fragment must contain a \"" + PAGE + "\" argument!");
        }
        mPage = getArguments().getInt(PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutResId;
        switch (mPage) {
            case 0:
                layoutResId = R.layout.fragment_intro_1;
                break;
            case 1:
                layoutResId = R.layout.fragment_intro_3;
                break;
            default:
                layoutResId = R.layout.fragment_intro_2;
        }
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);
        view.setTag(mPage);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        view.setBackgroundColor(mBackgroundColor);
    }

}