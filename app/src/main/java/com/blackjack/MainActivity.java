package com.blackjack;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity{

    CardDraw cardDraw;
    ArrayList<Card> current, player_card = new ArrayList<>(), dealer_card = new ArrayList<>();
    RecyclerView dealer, player;
    CardAdapter player_adapter, dealrer_adapter;
    Button hit, stand, plus, minus, deal, btn_back;
    TextView rate, player_score, dealer_score, money;
    ImageView player_image, dealer_image;
    int score_player = 0, score_dealer = 0;


    boolean game = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        cardDraw = new CardDraw(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        player = findViewById(R.id.player);
        dealer = findViewById(R.id.dealer);
        hit = findViewById(R.id.hit);
        stand = findViewById(R.id.hit);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        rate = findViewById(R.id.rate);
        deal = findViewById(R.id.deal);
        player_image = findViewById(R.id.image_player);
        dealer_image = findViewById(R.id.image_dealer);
        player_score = findViewById(R.id.player_score);
        dealer_score = findViewById(R.id.dealer_score);
        money = findViewById(R.id.money);
        btn_back = findViewById(R.id.back);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        player.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dealer.setLayoutManager(layoutManager2);

        current = new ArrayList<Card>(cardDraw.getCards());
        for(int i = 0; i < 10; i++)
            Collections.shuffle(current);


        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        back = Bitmap.createScaledBitmap(back, back.getWidth() / 4, back.getHeight() / 4, false);
        player_card.add(new Card("back", 0, back));
        player_card.add(new Card("back", 0, back));
        dealer_card.add(new Card("back", 0, back));
        dealer_card.add(new Card("back", 0, back));

        player_adapter = AddCard(player, player_card);
        dealrer_adapter = AddCard(dealer, dealer_card);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndGame();
                StartDeal();
            }
        });
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player_card.add(current.get(0));
                current.remove(0);
                player_adapter.AddImage(player_card.get(player_card.size()-1).image);

                if(player_card.get(player_card.size()-1).score == 1)
                {
                    if(score_player + 11 <= 21)
                        score_player += 11;
                    else score_player += 1;
                }else
                    score_player += player_card.get(player_card.size()-1).score;
                player_score.setText(String.valueOf(score_player));

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GameConst.rate > 5)
                {
                    GameConst.rate -= 5;
                    rate.setText(String.valueOf(GameConst.rate));
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GameConst.money >= 5)
                {
                    GameConst.rate += 5;
                    rate.setText(String.valueOf(GameConst.rate));
                }
            }
        });
        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!game)
                {
                    StartDeal();
                    game = true;
                }
            }
        });
    }


    void StartDeal()
    {
        player_card.clear();
        dealer_card.clear();
        player_adapter.Clear();
        dealrer_adapter.Clear();


        player_card.add(current.get(0));
        current.remove(0);
        player_adapter.AddImage(player_card.get(player_card.size()-1).image);

        dealer_card.add(current.get(0));
        current.remove(0);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        back = Bitmap.createScaledBitmap(back, back.getWidth() / 4, back.getHeight() / 4, false);
        dealrer_adapter.AddImage(back);

        player_card.add(current.get(0));
        current.remove(0);
        player_adapter.AddImage(player_card.get(player_card.size()-1).image);

        dealer_card.add(current.get(0));
        current.remove(0);
        dealrer_adapter.AddImage(dealer_card.get(dealer_card.size()-1).image);

        player_score.setVisibility(View.VISIBLE);

        for (Card card:player_card)
        {
            if(card.score == 1)
            {
                score_player += 11;
            }
            else
                score_player += card.score;
        }


        for (Card card:dealer_card)
        {
            if(card.score == 1)
            {
                score_dealer += 11;
            }
            else
                score_dealer += card.score;
        }

        player_score.setText(String.valueOf(score_player));

        if(score_dealer == 21)
            EndGame();

        GameConst.current_rate = GameConst.rate;
        GameConst.money -= GameConst.current_rate;
        money.setText(String.valueOf(GameConst.money));

    }
    CardAdapter AddCard(RecyclerView recyclerView, ArrayList<Card> cards)
    {
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        for (Card card:cards)
            bitmaps.add(card.image);
        CardAdapter adapter = new CardAdapter(this,  bitmaps);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new EqualSpaceItemDecoration());
        return adapter;
    }

    public void EndGame()
    {
        score_dealer = 0;
        score_player = 0;
        player_score.setVisibility(View.GONE);
        dealer_score.setVisibility(View.GONE);
        player_card.clear();
        dealer_card.clear();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


}
