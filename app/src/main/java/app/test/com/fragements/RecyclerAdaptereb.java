package app.test.com.fragements;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdaptereb extends RecyclerView.Adapter<RecyclerAdaptereb.viewholder1> {

    Context context1;
    List<Profiler> data1;
    public static final String TAG = "RecyclerAdaptereb";

    public RecyclerAdaptereb(Context context1, List<Profiler> data1) {
        this.context1 = context1;
        this.data1 = data1;
    }

    @NonNull
    @Override
    public viewholder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v=LayoutInflater.from(context1).inflate(R.layout.card1,viewGroup,false);
        viewholder1 viewholder1=new viewholder1(v);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder1 viewholder1, int i) {

        final int pos = i;
        viewholder1.txt1.setText(data1.get(i).getText());
        Picasso.with(context1).load(data1.get(i).getPhoto()).fit().centerCrop().into(viewholder1.img1);
        viewholder1.cvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1, "Loading", Toast.LENGTH_SHORT).show();
                String s = data1.get(pos).getLink();
                Uri u = Uri.parse(s);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(u);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context1.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

        return data1.size();
    }

    public static class viewholder1 extends RecyclerView.ViewHolder{

        private TextView txt1;
        private ImageView img1;
        private CardView cvv;

        public viewholder1(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.book_title_id);
            img1 = itemView.findViewById(R.id.book_img_id);
            cvv=itemView.findViewById(R.id.cardview_id);
        }
    }
}
