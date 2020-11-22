package com.buttomnavwithkotlinn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class Social_Media extends AppCompatActivity {

    private String Telegram = "";
    private String Instagram = "";
    private String blockCharacterSet = ",";
    private EditText insta_et;
    private EditText telegram_et;
    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null && blockCharacterSet.contains(("" + source))) {
                return "";
            }
            return null;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        telegram_et = (EditText)findViewById(R.id.Telegram_Link_EditText);
        insta_et = (EditText)findViewById(R.id.Instagram_Link_EditText);
        (telegram_et).setFilters(new InputFilter[] { filter });
        (insta_et).setFilters(new InputFilter[] { filter });


        ((Button)findViewById(R.id.Test_LinkTelegram)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Telegram = telegram_et.getText().toString();
                    if (Telegram.isEmpty() || Telegram.length() < 6) {
//                        showMsg("لینک تلگرام را بصورت صحیح وارد کنید");
                        Telegram = "";
                        telegram_et.setText("");
                    } else {
                        if (Telegram.substring(0, 4).equals("http")) {
                            if (Telegram.substring(7, 11).equals("t.me") || Telegram.substring(8, 12).equals("t.me")) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Telegram));
                                startActivity(browserIntent);
                            } else {
//                                showMsg("یا یوزر تلگرام را وارد کنید یا لینک را بصورت /https://t.me وارد کنید");
                                Telegram = "";
                            }
                        } else {
                            if (Telegram.substring(0, 4).equals("t.me")) {
                                Telegram = "https://" + Telegram;
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Telegram));
                                startActivity(browserIntent);
                            } else {
                                Telegram = "https://t.me/" + Telegram;
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Telegram));
                                startActivity(browserIntent);
                            }

                        }

                    }
                }catch (Exception e){
//                    showMsg("یا یوزر تلگرام را وارد کنید یا لینک را بصورت /https://t.me وارد کنید");
                    Telegram = "";
                }
            }
        });
        ((Button)findViewById(R.id.Test_LinkInsta)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Instagram = insta_et.getText().toString();
                    if (Instagram.isEmpty() || Instagram.length() < 6) {
//                        showMsg("لینک یا نام پیج اینستاگرام را بصورت صحیح وارد کنید");
                    } else {
                        if (Instagram.substring(0, 3).equals("www")){
                            Instagram = "https://"+Instagram;
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Instagram));
                            startActivity(browserIntent);
                        }else if (Instagram.substring(0, 3).equals("htt")){
//                            Instagram = "https://"+Instagram;
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Instagram));
                            startActivity(browserIntent);
                        }else {
                            Instagram = "https://www.instagram.com/"+Instagram;
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Instagram));
                            startActivity(browserIntent);
                        }
                    }
                }catch (Exception e){
                    Instagram = "";
//                    showMsg("لینک یا نام پیج اینستاگرام را بصورت صحیح وارد کنید");
                }

            }
        });
        ((Button)findViewById(R.id.Test_Website)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String WebsiteStore = ((EditText)findViewById(R.id.Website_Link_EditText)).getText().toString();
                    WebsiteStore = ((EditText) findViewById(R.id.Website_Link_EditText)).getText().toString();
                    if (WebsiteStore.isEmpty() || WebsiteStore.length() <5) {
//                        showMsg("لینک را بصورت صحیح وارد کنید");
                    } else {
                        if (WebsiteStore.substring(0, 3).equals("www")){
                            WebsiteStore = "http://"+WebsiteStore;
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(WebsiteStore));
                            startActivity(browserIntent);
                        }else if (!WebsiteStore.substring(0, 3).equals("htt")){
                            WebsiteStore = "http://"+WebsiteStore;
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(WebsiteStore));
                            startActivity(browserIntent);
                        }else {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(WebsiteStore));
                            startActivity(browserIntent);
                        }
                    }
                }catch (Exception e){
//                    WebsiteStore = "";
//                    showMsg("لینک را بصورت صحیح وارد کنید");
                }

            }
        });
    }
}
