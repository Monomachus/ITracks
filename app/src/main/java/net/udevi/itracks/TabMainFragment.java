package net.udevi.itracks;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabMainFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TabMainFragment newInstance(int sectionNumber) {
        TabMainFragment fragment = new TabMainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TabMainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_main, container, false);

        // firstTimer
        if (savedInstanceState == null) {

            FrameLayout detailsLayout = (FrameLayout) rootView.findViewById(R.id.details_fragment);

            // portret mode
            if (detailsLayout == null) {
                
            }

        }

        return rootView;
    }

}
