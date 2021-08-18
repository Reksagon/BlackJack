package com.blackjack;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity{

    CardDraw cardDraw;
    ArrayList<Card> current, player_card = new ArrayList<>(), dealer_card = new ArrayList<>();
    RecyclerView dealer, player;
    CardAdapter player_adapter, dealrer_adapter;
    Button hit, stand, plus, minus, deal, btn_back;
    TextView rate, player_score, dealer_score, money;
    ImageView player_image, dealer_image;
    int score_player = 0, score_dealer = 0;
    SoundPool sp;
    float curVolume,maxVolume,leftVolume, rightVolume;
    boolean game = false;
    int sound_start, sound_main, sound_lose, sound_win, sound_draw;
    MediaPlayer voice;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        cardDraw = new CardDraw(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        AudioAttributes audioAttrib = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        SoundPool.Builder builder= new SoundPool.Builder();
        builder.setAudioAttributes(audioAttrib).setMaxStreams(5);
        sp = builder.build();
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        leftVolume = curVolume / maxVolume;
        rightVolume = curVolume / maxVolume;

        sound_start = sp.load(this, R.raw.start, 1);
        sound_win = sp.load(this, R.raw.win, 1);
        sound_draw = sp.load(this, R.raw.draw, 1);
        sound_lose = sp.load(this, R.raw.lose, 1);
        sound_main = sp.load(this, R.raw.main, 1);

        player = findViewById(R.id.player);
        dealer = findViewById(R.id.dealer);
        hit = findViewById(R.id.hit);
        stand = findViewById(R.id.stand);
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

        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        back = Bitmap.createScaledBitmap(back, back.getWidth() / 4, back.getHeight() / 4, false);
        player_card.add(new Card("back", 0, back));
        player_card.add(new Card("back", 0, back));
        dealer_card.add(new Card("back", 0, back));
        dealer_card.add(new Card("back", 0, back));

        player_adapter = AddCard(player, player_card);
        dealrer_adapter = AddCard(dealer, dealer_card);

//        new Thread() {
//            public void run() {
//                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.main);
//                mp.start();
//                mp.setVolume(leftVolume/4, rightVolume/4);
//                mp.setLooping(true);
//            }
//        }.start();

        PlayVoice(this);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //back action
            }
        });
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (game) {
                    sp.play(sound_start, leftVolume, rightVolume, 1, 0, 1f);
                    player_card.add(current.get(0));
                    current.remove(0);
                    player_adapter.AddImage(player_card.get(player_card.size() - 1).image);

                    score_player = 0;
                    for (Card card : player_card) {
                        if (card.score == 1)
                            score_player += 11;
                        else
                            score_player += card.score;
                    }

                    if (score_player > 21) {
                        score_player = 0;
                        for (Card card : player_card)
                            score_player += card.score;

                    }
                    //score_player += player_card.get(player_card.size() - 1).score;
                    player_score.setText(String.valueOf(score_player));

                    if (score_player > 21)
                        LoseBust();
                    if (score_player == 21) {
                        if (score_dealer != 21)
                            Win();
                        else
                            Draw();
                    }

                }
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
                    game = true;
                    StartDeal();
                    sp.play(sound_start, leftVolume, rightVolume, 1, 0, 1f);
                }
            }
        });
        stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(score_dealer < score_player && game) {
                    dealrer_adapter.Clear();

                    for (Card card:dealer_card) {
                        dealrer_adapter.AddImage(card.image);
                    }

                    dealer_score.setVisibility(View.VISIBLE);
                    dealer_score.setText(String.valueOf(score_dealer));

                    while (score_dealer <= 17) {
                        dealer_card.add(current.get(0));
                        current.remove(0);
                        score_dealer = 0;
                        for (Card card :dealer_card) {
                            if (card.score == 1)
                                score_dealer += 11;
                            else
                                score_dealer += card.score;
                        }

                        if (score_dealer > 21) {
                            score_dealer = 0;
                            for (Card card : dealer_card)
                                score_dealer += card.score;
                        }
                        dealrer_adapter.AddImage(dealer_card.get(dealer_card.size() - 1).image);
                        dealer_score.setText(String.valueOf(score_dealer));
                    }
                    if(score_dealer > 21)
                        Win();
                    else if(score_dealer == score_player)
                        Draw();
                    else if(score_dealer > score_player)
                        LoseBust();
                    else Win();
                }
                else if(score_dealer == score_player)
                    Draw();
                else if(score_dealer > score_player)
                    LoseBust();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sp.play(sound_main, leftVolume/2, rightVolume/2, 1, 1, 1f);
    }

    public void PlayVoice(final Context context) {
        voice = MediaPlayer.create(context, R.raw.main);
        voice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (voice != null) {
                    voice.release();
                }
            }
        });
        voice.setVolume(leftVolume/4, rightVolume/4);
        voice.start();
    }
    void LoseBust()
    {
        Bitmap lose = BitmapFactory.decodeResource(getResources(), R.drawable.lose);
        lose = Bitmap.createScaledBitmap(lose, lose.getWidth() / 4, lose.getHeight() / 4, false);
        player_image.setImageBitmap(lose);
        player_image.setVisibility(View.VISIBLE);

        Bitmap win = BitmapFactory.decodeResource(getResources(), R.drawable.win);
        win = Bitmap.createScaledBitmap(win, win.getWidth() / 4, win.getHeight() / 4, false);
        dealer_image.setImageBitmap(win);
        dealer_image.setVisibility(View.VISIBLE);

        dealrer_adapter.Clear();

        for (Card card:dealer_card) {
            dealrer_adapter.AddImage(card.image);
            //score_dealer += card.score;
        }
        dealer_score.setVisibility(View.VISIBLE);
        dealer_score.setText(String.valueOf(score_dealer));
        game = false;
        sp.play(sound_lose, leftVolume, rightVolume, 1, 0, 1f);
    }

    void Win()
    {
        Bitmap lose = BitmapFactory.decodeResource(getResources(), R.drawable.lose);
        lose = Bitmap.createScaledBitmap(lose, lose.getWidth() / 4, lose.getHeight() / 4, false);
        dealer_image.setImageBitmap(lose);
        dealer_image.setVisibility(View.VISIBLE);

        Bitmap win = BitmapFactory.decodeResource(getResources(), R.drawable.win);
        win = Bitmap.createScaledBitmap(win, win.getWidth() / 4, win.getHeight() / 4, false);
        player_image.setImageBitmap(win);
        player_image.setVisibility(View.VISIBLE);

        dealrer_adapter.Clear();

        for (Card card:dealer_card) {
            dealrer_adapter.AddImage(card.image);
            //score_dealer += card.score;
        }
        dealer_score.setVisibility(View.VISIBLE);
        dealer_score.setText(String.valueOf(score_dealer));
        player_score.setVisibility(View.VISIBLE);
        player_score.setText(String.valueOf(score_player));
        GameConst.money += GameConst.rate * 2;
        money.setText(String.valueOf(GameConst.money));
        game = false;
        sp.play(sound_win, leftVolume, rightVolume, 1, 0, 1f);
    }

    void Draw()
    {
        dealrer_adapter.Clear();

        for (Card card:dealer_card) {
            dealrer_adapter.AddImage(card.image);
        }
        dealer_score.setVisibility(View.VISIBLE);
        dealer_score.setText(String.valueOf(score_dealer));
        player_score.setVisibility(View.VISIBLE);
        player_score.setText(String.valueOf(score_player));
        GameConst.money += GameConst.rate;
        money.setText(String.valueOf(GameConst.money));
        game = false;
        sp.play(sound_draw, leftVolume, rightVolume, 1, 0, 1f);
    }

    void StartDeal() {
        score_player = 0;
        score_dealer = 0;
        dealer_score.setVisibility(View.GONE);
        player_image.setVisibility(View.GONE);
        dealer_image.setVisibility(View.GONE);
        current = new ArrayList<Card>(cardDraw.getCards());
        for (int i = 0; i < 10; i++)
            Collections.shuffle(current);

        player_card.clear();
        dealer_card.clear();
        player_adapter.Clear();
        dealrer_adapter.Clear();

        player_card.add(current.get(0));
        current.remove(0);
        player_adapter.AddImage(player_card.get(player_card.size() - 1).image);

        dealer_card.add(current.get(0));
        current.remove(0);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        back = Bitmap.createScaledBitmap(back, back.getWidth() / 4, back.getHeight() / 4, false);
        dealrer_adapter.AddImage(back);

        player_card.add(current.get(0));
        current.remove(0);
        player_adapter.AddImage(player_card.get(player_card.size() - 1).image);

        dealer_card.add(current.get(0));
        current.remove(0);
        dealrer_adapter.AddImage(dealer_card.get(dealer_card.size() - 1).image);

        player_score.setVisibility(View.VISIBLE);

        for (Card card : player_card) {
            if (card.score == 1) {
                score_player += 11;
            } else
                score_player += card.score;
        }


        for (Card card : dealer_card) {
            if (card.score == 1) {
                score_dealer += 11;
            } else
                score_dealer += card.score;
        }

        player_score.setText(String.valueOf(score_player));

        if (score_dealer == 21)
            LoseBust();

        GameConst.current_rate = GameConst.rate;
        GameConst.money -= GameConst.current_rate;
        money.setText(String.valueOf(GameConst.money));

        if (score_player == 21) {
            if (score_dealer != 21) {
                Win();
                game = false;
            }
            else
                Draw();
        }
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
