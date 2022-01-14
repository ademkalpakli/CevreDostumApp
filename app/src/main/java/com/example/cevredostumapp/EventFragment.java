package com.example.cevredostumapp;
//ademkalpakli
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cevredostumapp.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class EventFragment extends Fragment {

    OnEventSelected listener;
    List<Events> events= new ArrayList<>();


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EventFragment newInstance(int columnCount) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        events.add(new Events("Akyaka Çöp Temizleme","Türkiye Çevre Eğitim Vakfı (TÜRÇEV) Avrupa Çevre Ajansı'nın deniz çöpleri izleme komitesi programı kapsamında Akyaka Kermetur'da plaj temizliği yaptı.\n" +
                "Türkiye Çevre Eğitim Vakfı, Sıtkı Koçman Üniversitesi öğrencileri ve Ula Belediyesi işbirliğinde Akyaka'nın Kermetur plajında çöp temizlik etkinliği düzenlendi.\n" +
                "TÜRÇEV Avrupa Ajansının 'Deniz çöpleri izleme' programı kapsamında düzenlenen etkinlik Kermetur plajının 100 metrelik sahilinde gerçekleştirildi. Toplanan atıklar ayrı ayrı değerlendirilirken, plastik atık, cem-seramik, metal, kağıt-karton, kumaş, kauçuk gibi atık toplanıcak.",
                "2022/01/01",12.45,"Akyaka",48));
        events.add(new Events("Bodrum Sahil Temizleme"," Bugün Bodrum'da denizlerdeki kirlilik ve iklim değişikliğine dikkat çekip bu konulardaki farkındalığı arttırmak için bir araya geldik.Sahil temizleme etkinliğimiz Bodrum Kumbahçe Plajı’nda civar okullardan gelen öğrencilerin yardımıyla gerçekleşti.Bodrum Belediyesi bünyesindeki balık adamlar da bu etkinliğe deniz temizleme çalışmalarıyla katkı sağladılar." ,
                "2022/06/11",09.30,"Bodrum",60));
        events.add(new Events("Marmaris Deniz Çöp Temizleme","Deniz yüzeyi temizleme tekneleri, deniz yüzeyinde biriken çöpleri, teknenin ön kısmında bulunan bant sistemi yardımıyla teknenin atık toplama haznesine almaktadır. Toplanan bu atıklar karadan vinçli atık toplama kamyonu ile atık transfer istasyonlarına götürülmektedir.",
                "2022/12/01",15.00,"Marmaris",27));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyEventRecyclerViewAdapter(events,listener));
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnEventSelected){
            listener = (OnEventSelected) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;



    }

    public interface  OnEventSelected{
        void eventSelected(Events event);

    }
}