package app.test.com.fragements;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context mcontext;
    List<Profiler> mData;
    private static final String TAG ="RecyclerAdapter";
    public RecyclerAdapter(Context mcontext, List<Profiler> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v=LayoutInflater.from(mcontext).inflate(R.layout.cardview,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder,int i) {

         final int pos = i;
        Profiler profiler = mData.get(i);
        myViewHolder.tv.setText(mData.get(i).getText());
        Picasso.with(mcontext).load(profiler.getPhoto()).fit().centerCrop().into(myViewHolder.imgvw);

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Loading",Toast.LENGTH_SHORT).show();   //on click listner for everything in recycler view
                Log.i(TAG,"loading sucessfully");
                String str=mData.get(pos).getLink();
                Uri uri = Uri.parse(str);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(uri);
                mcontext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private ImageView imgvw;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.lnktextview);
            imgvw = itemView.findViewById(R.id.lnkimgview);
            cardView =itemView.findViewById(R.id.lnkscardview);
        }
    }
}
