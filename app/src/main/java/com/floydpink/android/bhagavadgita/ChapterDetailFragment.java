package com.floydpink.android.bhagavadgita;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.floydpink.android.bhagavadgita.data.BookData;
import com.floydpink.android.bhagavadgita.models.Chapter;


/**
 * A fragment representing a single Chapter detail screen.
 * This fragment is either contained in a {@link ChapterListActivity}
 * in two-pane mode (on tablets) or a {@link ChapterDetailActivity}
 * on handsets.
 */
public class ChapterDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The chapter this fragment is presenting.
     */
    private Chapter mChapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChapterDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the chapter specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mChapter = BookData.Chapters.get(getArguments().getString(ARG_ITEM_ID));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chapter_detail, container, false);

        // Show the chapter as text in a TextView.
        if (mChapter != null) {
            TextView textView = (TextView) rootView.findViewById(R.id.chapter_detail);
            textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/AnjaliOldLipi.ttf"));
            textView.setText(mChapter.getTitle());
        }

        return rootView;
    }
}
