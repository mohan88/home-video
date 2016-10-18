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
import com.hobby.homevideo.presenter.CollectionPresenter;
import com.hobby.homevideo.presenter.PresenterFactory;

/**
 * Displays the categories page.
 */
public class CategoryFragment extends Fragment {

    private final DataService mDataService = new DataService();
    private final PresenterFactory mPresenterFactory = PresenterFactory.getInstance();
    private Collection mCollection;
    private LinearLayout mParent;

    public static CategoryFragment newInstance(final String categoryName) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString("categoryName", categoryName);
        fragment.setArguments(args);
        return fragment;
    }

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
        final String categoryName = getArguments().getString("categoryName");
        mCollection = mDataService.getCategoryData(getActivity(), categoryName);
        if (mCollection != null) {
            final CollectionPresenter presenter = mPresenterFactory.getCollectionPresenter(mCollection.getType());
            presenter.present(getActivity(), mCollection, mParent);
        }
    }
}
