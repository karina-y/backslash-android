package layout;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.backslash.R;
import com.backslash.multispinner.KeyPairBoolData;
import com.backslash.multispinner.MultiSpinnerSearch;
import com.backslash.multispinner.SpinnerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileClosetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileClosetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileClosetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfileClosetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileClosetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileClosetFragment newInstance(String param1, String param2) {
        ProfileClosetFragment fragment = new ProfileClosetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_closet, container, false);

        //set custom font of button
        String fontPath = "fonts/badaboom.TTF";
        Button tv = (Button) v.findViewById(R.id.badaboom);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);

        if (tv != null && tf != null) {
            tv.setTypeface(tf);
        }

        populateSpinners(v);

        // Inflate the layout for this fragment
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void populateSpinners(View v) {
        populateColors(v);
        populateMaterials(v);
        populateTops(v);
        populateBottoms(v);
        populateOnePieces(v);
        populateOuterwear(v);
        populateOccasion(v);
        populateSeason(v);
        populateStyle(v);
        populateWeather(v);
    }

    public void populateColors(View v) {
        //populate colors
        final List<String> colorList = Arrays.asList(getResources().getStringArray(R.array.color));
        final List<KeyPairBoolData> colorListArray = new ArrayList<>();

        for (int i = 0; i < colorList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(colorList.get(i));
            h.setSelected(false);
            colorListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.colorListView);

        searchMultiSpinnerUnlimited.setItems(colorListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateMaterials(View v) {
        //populate materials
        final List<String> materialList = Arrays.asList(getResources().getStringArray(R.array.material));
        final List<KeyPairBoolData> materialListArray = new ArrayList<>();

        for (int i = 0; i < materialList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(materialList.get(i));
            h.setSelected(false);
            materialListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.materialListView);

        searchMultiSpinnerUnlimited.setItems(materialListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateTops(View v) {
        //populate tops
        final List<String> topsList = Arrays.asList(getResources().getStringArray(R.array.tops));
        final List<KeyPairBoolData> topsListArray = new ArrayList<>();

        for (int i = 0; i < topsList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(topsList.get(i));
            h.setSelected(false);
            topsListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.topsListView);

        searchMultiSpinnerUnlimited.setItems(topsListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateBottoms(View v) {
        //populate bottoms
        final List<String> bottomsList = Arrays.asList(getResources().getStringArray(R.array.bottoms));
        final List<KeyPairBoolData> bottomsListArray = new ArrayList<>();

        for (int i = 0; i < bottomsList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(bottomsList.get(i));
            h.setSelected(false);
            bottomsListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.bottomsListView);

        searchMultiSpinnerUnlimited.setItems(bottomsListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateOnePieces(View v) {
        //populate onePieces
        final List<String> onePiecesList = Arrays.asList(getResources().getStringArray(R.array.one_pieces));
        final List<KeyPairBoolData> onePiecesListArray = new ArrayList<>();

        for (int i = 0; i < onePiecesList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(onePiecesList.get(i));
            h.setSelected(false);
            onePiecesListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.onePiecesListView);

        searchMultiSpinnerUnlimited.setItems(onePiecesListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateOuterwear(View v) {
        //populate outerwear
        final List<String> outerwearList = Arrays.asList(getResources().getStringArray(R.array.outerwear));
        final List<KeyPairBoolData> outerwearListArray = new ArrayList<>();

        for (int i = 0; i < outerwearList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(outerwearList.get(i));
            h.setSelected(false);
            outerwearListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.outerwearListView);

        searchMultiSpinnerUnlimited.setItems(outerwearListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateOccasion(View v) {
        //populate occasion
        final List<String> occasionList = Arrays.asList(getResources().getStringArray(R.array.occasion));
        final List<KeyPairBoolData> occasionListArray = new ArrayList<>();

        for (int i = 0; i < occasionList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(occasionList.get(i));
            h.setSelected(false);
            occasionListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.occasionListView);

        searchMultiSpinnerUnlimited.setItems(occasionListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateSeason(View v) {
        //populate season
        final List<String> seasonList = Arrays.asList(getResources().getStringArray(R.array.season));
        final List<KeyPairBoolData> seasonListArray = new ArrayList<>();

        for (int i = 0; i < seasonList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(seasonList.get(i));
            h.setSelected(false);
            seasonListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.seasonListView);

        searchMultiSpinnerUnlimited.setItems(seasonListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateStyle(View v) {
        //populate style
        final List<String> styleList = Arrays.asList(getResources().getStringArray(R.array.style));
        final List<KeyPairBoolData> styleListArray = new ArrayList<>();

        for (int i = 0; i < styleList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(styleList.get(i));
            h.setSelected(false);
            styleListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.styleListView);

        searchMultiSpinnerUnlimited.setItems(styleListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

    public void populateWeather(View v) {
        //populate weather
        final List<String> weatherList = Arrays.asList(getResources().getStringArray(R.array.weather));
        final List<KeyPairBoolData> weatherListArray = new ArrayList<>();

        for (int i = 0; i < weatherList.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(weatherList.get(i));
            h.setSelected(false);
            weatherListArray.add(h);
        }

        MultiSpinnerSearch searchMultiSpinnerUnlimited = (MultiSpinnerSearch) v.findViewById(R.id.weatherListView);

        searchMultiSpinnerUnlimited.setItems(weatherListArray, -1, new SpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });
    }

}