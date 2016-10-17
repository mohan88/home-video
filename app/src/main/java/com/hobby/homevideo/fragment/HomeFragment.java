package com.hobby.homevideo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hobby.homevideo.R;
import com.hobby.homevideo.data.DataService;
import com.hobby.homevideo.model.Collection;
import com.hobby.homevideo.model.CollectionList;
import com.hobby.homevideo.presenter.CollectionPresenter;
import com.hobby.homevideo.presenter.PresenterFactory;

/**
 * Displays home page.
 */
public class HomeFragment extends Fragment {

    private final DataService mDataService = new DataService();
    private final PresenterFactory mPresenterFactory = PresenterFactory.getInstance();
    private CollectionList mCollectionList;
    private LinearLayout mParent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_collection, container, false);
        mParent = (LinearLayout) view.findViewById(R.id.fragment_parent);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCollectionList = mDataService.getHomeData(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mCollectionList != null) {
            for (Collection collection : mCollectionList.getCollections()) {
                final CollectionPresenter presenter = mPresenterFactory.getCollectionPresenter(collection.getType());
                presenter.present(getActivity(), collection, mParent);
            }
        }
    }
}
