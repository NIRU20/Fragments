package app.test.com.fragements;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Lay1 extends Fragment {

   // CardView cv1,cv2,cv3,cv4,cv5;
    //FirebaseDatabase ref= FirebaseDatabase.getInstance();

    private RecyclerView recyclerView1;
    private List<Profiler> list1;
    private DatabaseReference reference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       final View vw;
        vw=inflater.inflate(R.layout.lay1_frag,container,false);
        recyclerView1 = vw.findViewById(R.id.myrecycler1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        list1= new ArrayList<Profiler>();
        reference = FirebaseDatabase.getInstance().getReference().child("Links");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Profiler p = dataSnapshot1.getValue(Profiler.class);
                    list1.add(p);
                }
                RecyclerAdaptereb recyclerAdapter = new RecyclerAdaptereb(getContext(),list1);
                recyclerView1.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "try again", Toast.LENGTH_SHORT).show();
            }
        });
        return vw;
    }

}
