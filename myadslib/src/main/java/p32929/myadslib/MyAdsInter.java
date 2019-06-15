package p32929.myadslib;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdsInter {
    private View interAdView;

    private ImageView imageViewAppIcon;
    private TextView textViewAppName;
    private String url;

    public MyAdsInter(final Context context, MyAd myAd) {
        if (interAdView == null)
            interAdView = LayoutInflater.from(context).inflate(R.layout.my_inter_ads, null);

        imageViewAppIcon = interAdView.findViewById(R.id.appIcon);
        textViewAppName = interAdView.findViewById(R.id.adText);

        imageViewAppIcon.setImageResource(myAd.getAppIcon());
        textViewAppName.setText(myAd.getAppDescription());
        this.url = myAd.getUrl();

        new AlertDialog.Builder(context)
                .setView(interAdView)
                .setPositiveButton("Download", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        context.startActivity(browse);
                    }
                })
                .setNegativeButton("Later", null)
                .show();
    }
}