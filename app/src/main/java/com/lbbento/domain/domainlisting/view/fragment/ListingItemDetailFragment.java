package com.lbbento.domain.domainlisting.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lbbento.domain.domainlisting.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lbbento on 31/07/2016.
 */

public class ListingItemDetailFragment extends BaseFragment  {
    public static final String PARAM_TEXT = "text";

    @BindView(R.id.detail_text) TextView detailText;

    public ListingItemDetailFragment() { }

    public static ListingItemDetailFragment newInstance(String text) {
        ListingItemDetailFragment f = new ListingItemDetailFragment();
        if (text != null && !text.isEmpty()) {
            Bundle args = new Bundle();
            args.putSerializable(PARAM_TEXT, text);
            f.setArguments(args);
        }
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_listing_detail, container, false);

        //ButterKnife
        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Just show id on the screen. Usualy the presenter would get the details from the repo.
        Bundle args = getArguments();
        if (args != null) {
            detailText.setText(args.getString(PARAM_TEXT));
        }else {
            detailText.setText(getResources().getString(R.string.listing_item_default_text));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
