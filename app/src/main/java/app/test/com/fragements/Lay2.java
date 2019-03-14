package app.test.com.fragements;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Lay2 extends Fragment {


    private RecyclerView recyclerView;
    private List<Profiler> list;
    private DatabaseReference reference;
    private ProgressBar prbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.lay2_frag, container, false);
        recyclerView = v.findViewById(R.id.myrecyclerview);
        prbar = v.findViewById(R.id.myprbar);
        prbar.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<Profiler>();
        reference = FirebaseDatabase.getInstance().getReference().child("Links");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Profiler p = dataSnapshot1.getValue(Profiler.class);
                    prbar.setVisibility(View.INVISIBLE);
                    list.add(p);
                }
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext(), list);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "try again", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
