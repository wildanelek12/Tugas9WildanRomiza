package com.codes.tugas9wildanromiza.ui.home;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codes.tugas9wildanromiza.Adapter.MakananAdapter;
import com.codes.tugas9wildanromiza.Model.Makanan;
import com.codes.tugas9wildanromiza.Model.MakananData;
import com.codes.tugas9wildanromiza.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView rv_makanan;
    private MakananAdapter makananAdapter;
    private List<Makanan> makananList;
    private TextView topBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        topBar =  root.findViewById(R.id.top_bar);
        topBar.setText("Home");

        rv_makanan = root.findViewById(R.id.rv_makanan);
        makananList = new ArrayList<>();
        makananList = MakananData.listMakanan();
        makananAdapter = new MakananAdapter(getContext(), makananList);
        rv_makanan.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rv_makanan.setAdapter(makananAdapter);

        rv_makanan.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view); // item position
                int spanCount = 2;
                int spacing = 10;//spacing between views in grid

                if (position >= 0) {
                    int column = position % spanCount; // item column

                    outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                    outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                    if (position < spanCount) { // top edge
                        outRect.top = spacing;
                    }
                    outRect.bottom = spacing; // item bottom
                } else {
                    outRect.left = 0;
                    outRect.right = 0;
                    outRect.top = 0;
                    outRect.bottom = 0;
                }
            }
        });

        return root;
    }

    private void initView() {

    }
}