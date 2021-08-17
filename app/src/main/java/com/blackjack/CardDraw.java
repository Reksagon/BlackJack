package com.blackjack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class CardDraw {

    ArrayList<Card> cards = new ArrayList<>();

    Bitmap twoclubs;
    Bitmap threeclubs;
    Bitmap fourclubs;
    Bitmap fiveclubs;
    Bitmap sixclubs;
    Bitmap sevenclubs;
    Bitmap eightclubs;
    Bitmap nineclubs;
    Bitmap tenclubs;
    Bitmap jackclubs;
    Bitmap queenclubs;
    Bitmap kingclubs;
    Bitmap aceclubs;
    Bitmap twohearts;
    Bitmap threehearts;
    Bitmap fourhearts;
    Bitmap fivehearts;
    Bitmap sixhearts;
    Bitmap sevenhearts;
    Bitmap eighthearts;
    Bitmap ninehearts;
    Bitmap tenhearts;
    Bitmap jackhearts;
    Bitmap queenhearts;
    Bitmap kinghearts;
    Bitmap acehearts;
    Bitmap twospades;
    Bitmap threespades;
    Bitmap fourspades;
    Bitmap fivespades;
    Bitmap sixspades;
    Bitmap sevenspades;
    Bitmap eightspades;
    Bitmap ninespades;
    Bitmap tenspades;
    Bitmap jackspades;
    Bitmap queenspades;
    Bitmap kingspades;
    Bitmap acespades;
    Bitmap twodiamonds;
    Bitmap threediamonds;
    Bitmap fourdiamonds;
    Bitmap fivediamonds;
    Bitmap sixdiamonds;
    Bitmap sevendiamonds;
    Bitmap eightdiamonds;
    Bitmap ninediamonds;
    Bitmap tendiamonds;
    Bitmap jackdiamonds;
    Bitmap queendiamonds;
    Bitmap kingdiamonds;
    Bitmap acediamonds;

    public CardDraw(Context context) {
        twoclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.two_of_clubs);
        twoclubs = Bitmap.createScaledBitmap(twoclubs, twoclubs.getWidth() / 4, twoclubs.getHeight() / 4, false); // adjusting scale

        cards.add(new Card("twoclubs", 2, twoclubs));

        threeclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.three_of_clubs);
        threeclubs = Bitmap.createScaledBitmap(threeclubs, threeclubs.getWidth() / 4, threeclubs.getHeight() / 4, false);
        cards.add(new Card("threeclubs", 3, threeclubs));

        fourclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.four_of_clubs);
        fourclubs = Bitmap.createScaledBitmap(fourclubs, fourclubs.getWidth() / 4, fourclubs.getHeight() / 4, false);
        cards.add(new Card("fourclubs", 4, fourclubs));

        fiveclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.five_of_clubs);
        fiveclubs = Bitmap.createScaledBitmap(fiveclubs, fiveclubs.getWidth() / 4, fiveclubs.getHeight() / 4, false);
        cards.add(new Card("fiveclubs", 5, fiveclubs));

        sixclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.six_of_clubs);
        sixclubs = Bitmap.createScaledBitmap(sixclubs, sixclubs.getWidth() / 4, sixclubs.getHeight() / 4, false);
        cards.add(new Card("sixclubs", 6, sixclubs));

        sevenclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.seven_of_clubs);
        sevenclubs = Bitmap.createScaledBitmap(sevenclubs, sevenclubs.getWidth() / 4, sevenclubs.getHeight() / 4, false);
        cards.add(new Card("sevenclubs", 7, sevenclubs));

        eightclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.eight_of_clubs);
        eightclubs = Bitmap.createScaledBitmap(eightclubs, eightclubs.getWidth() / 4, eightclubs.getHeight() / 4, false);
        cards.add(new Card("eightclubs", 8, eightclubs));

        nineclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.nine_of_clubs);
        nineclubs = Bitmap.createScaledBitmap(nineclubs, nineclubs.getWidth() / 4, nineclubs.getHeight() / 4, false);
        cards.add(new Card("nineclubs", 9, nineclubs));

        tenclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.ten_of_clubs);
        tenclubs = Bitmap.createScaledBitmap(tenclubs, tenclubs.getWidth() / 4, tenclubs.getHeight() / 4, false);
        cards.add(new Card("tenclubs", 10, tenclubs));

        jackclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.jack_of_clubs);
        jackclubs = Bitmap.createScaledBitmap(jackclubs, jackclubs.getWidth() / 4, jackclubs.getHeight() / 4, false);
        cards.add(new Card("jackclubs", 10, jackclubs));

        queenclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.queen_of_clubs);
        queenclubs = Bitmap.createScaledBitmap(queenclubs, queenclubs.getWidth() / 4, queenclubs.getHeight() / 4, false);
        cards.add(new Card("queenclubs", 10, queenclubs));

        kingclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.king_of_clubs);
        kingclubs = Bitmap.createScaledBitmap(kingclubs, kingclubs.getWidth() / 4, kingclubs.getHeight() / 4, false);
        cards.add(new Card("kingclubs", 10, kingclubs));

        aceclubs = BitmapFactory.decodeResource(context.getResources(), R.drawable.ace_of_clubs);
        aceclubs = Bitmap.createScaledBitmap(aceclubs, aceclubs.getWidth() / 4, aceclubs.getHeight() / 4, false);
        cards.add(new Card("aceclubs", 1, aceclubs));


        twohearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.two_of_hearts);
        twohearts = Bitmap.createScaledBitmap(twohearts, twohearts.getWidth() / 4, twohearts.getHeight() / 4, false);
        cards.add(new Card("twohearts", 2, twohearts));

        threehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.three_of_hearts);
        threehearts = Bitmap.createScaledBitmap(threehearts, threehearts.getWidth() / 4, threehearts.getHeight() / 4, false);
        cards.add(new Card("threehearts", 3, threehearts));

        fourhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.four_of_hearts);
        fourhearts = Bitmap.createScaledBitmap(fourhearts, fourhearts.getWidth() / 4, fourhearts.getHeight() / 4, false);
        cards.add(new Card("fourhearts", 4, fourhearts));

        fivehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.five_of_hearts);
        fivehearts = Bitmap.createScaledBitmap(fivehearts, fivehearts.getWidth() / 4, fivehearts.getHeight() / 4, false);
        cards.add(new Card("fivehearts", 5, fivehearts));

        sixhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.six_of_hearts);
        sixhearts = Bitmap.createScaledBitmap(sixhearts, sixhearts.getWidth() / 4, sixhearts.getHeight() / 4, false);
        cards.add(new Card("sixhearts", 6, sixhearts));

        sevenhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.seven_of_hearts);
        sevenhearts = Bitmap.createScaledBitmap(sevenhearts, sevenhearts.getWidth() / 4, sevenhearts.getHeight() / 4, false);
        cards.add(new Card("sevenhearts", 7, sevenhearts));

        eighthearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.eight_of_hearts);
        eighthearts = Bitmap.createScaledBitmap(eighthearts, eighthearts.getWidth() / 4, eighthearts.getHeight() / 4, false);
        cards.add(new Card("eighthearts", 8, eighthearts));

        ninehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.nine_of_hearts);
        ninehearts = Bitmap.createScaledBitmap(ninehearts, ninehearts.getWidth() / 4, ninehearts.getHeight() / 4, false);
        cards.add(new Card("ninehearts", 9, ninehearts));

        tenhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.ten_of_hearts);
        tenhearts = Bitmap.createScaledBitmap(tenhearts, tenhearts.getWidth() / 4, tenhearts.getHeight() / 4, false);
        cards.add(new Card("tenhearts", 10, tenhearts));

        jackhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.jack_of_hearts);
        jackhearts = Bitmap.createScaledBitmap(jackhearts, jackhearts.getWidth() / 4, jackhearts.getHeight() / 4, false);
        cards.add(new Card("jackhearts", 10, jackhearts));

        queenhearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.queen_of_hearts);
        queenhearts = Bitmap.createScaledBitmap(queenhearts, queenhearts.getWidth() / 4, queenhearts.getHeight() / 4, false);
        cards.add(new Card("queenhearts", 10, queenhearts));

        kinghearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.king_of_hearts);
        kinghearts = Bitmap.createScaledBitmap(kinghearts, kinghearts.getWidth() / 4, kinghearts.getHeight() / 4, false);
        cards.add(new Card("kinghearts", 10, kinghearts));

        acehearts = BitmapFactory.decodeResource(context.getResources(), R.drawable.ace_of_hearts);
        acehearts = Bitmap.createScaledBitmap(acehearts, acehearts.getWidth() / 4, acehearts.getHeight() / 4, false);
        cards.add(new Card("acehearts", 1, acehearts));


        twospades = BitmapFactory.decodeResource(context.getResources(), R.drawable.two_of_spades);
        twospades = Bitmap.createScaledBitmap(twospades, twospades.getWidth() / 4, twospades.getHeight() / 4, false);
        cards.add(new Card("twospades", 2, twospades));

        threespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.three_of_spades);
        threespades = Bitmap.createScaledBitmap(threespades, threespades.getWidth() / 4, threespades.getHeight() / 4, false);
        cards.add(new Card("threespades", 3, threespades));

        fourspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.four_of_spades);
        fourspades = Bitmap.createScaledBitmap(fourspades, fourspades.getWidth() / 4, fourspades.getHeight() / 4, false);
        cards.add(new Card("fourspades", 4, fourspades));

        fivespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.five_of_spades);
        fivespades = Bitmap.createScaledBitmap(fivespades, fivespades.getWidth() / 4, fivespades.getHeight() / 4, false);
        cards.add(new Card("fivespades", 5, fivespades));

        sixspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.six_of_spades);
        sixspades = Bitmap.createScaledBitmap(sixspades, sixspades.getWidth() / 4, sixspades.getHeight() / 4, false);
        cards.add(new Card("sixspades", 6, sixspades));

        sevenspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.seven_of_spades);
        sevenspades = Bitmap.createScaledBitmap(sevenspades, sevenspades.getWidth() / 4, sevenspades.getHeight() / 4, false);
        cards.add(new Card("sevenspades", 7, sevenspades));

        eightspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.eight_of_spades);
        eightspades = Bitmap.createScaledBitmap(eightspades, eightspades.getWidth() / 4, eightspades.getHeight() / 4, false);
        cards.add(new Card("eightspades", 8, eightspades));

        ninespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.nine_of_spades);
        ninespades = Bitmap.createScaledBitmap(ninespades, ninespades.getWidth() / 4, ninespades.getHeight() / 4, false);
        cards.add(new Card("ninespades", 9, ninespades));

        tenspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.ten_of_spades);
        tenspades = Bitmap.createScaledBitmap(tenspades, tenspades.getWidth() / 4, tenspades.getHeight() / 4, false);
        cards.add(new Card("tenspades", 10, tenspades));

        jackspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.jack_of_spades);
        jackspades = Bitmap.createScaledBitmap(jackspades, jackspades.getWidth() / 4, jackspades.getHeight() / 4, false);
        cards.add(new Card("jackspades", 10, jackspades));

        queenspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.queen_of_spades);
        queenspades = Bitmap.createScaledBitmap(queenspades, queenspades.getWidth() / 4, queenspades.getHeight() / 4, false);
        cards.add(new Card("queenspades", 10, queenspades));

        kingspades = BitmapFactory.decodeResource(context.getResources(), R.drawable.king_of_spades);
        kingspades = Bitmap.createScaledBitmap(kingspades, kingspades.getWidth() / 4, kingspades.getHeight() / 4, false);
        cards.add(new Card("kingspades", 10, kingspades));

        acespades = BitmapFactory.decodeResource(context.getResources(), R.drawable.ace_of_spades);
        acespades = Bitmap.createScaledBitmap(acespades, acespades.getWidth() / 4, acespades.getHeight() / 4, false);
        cards.add(new Card("acespades", 1, acespades));


        twodiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.two_of_diamonds);
        twodiamonds = Bitmap.createScaledBitmap(twodiamonds, twodiamonds.getWidth() / 4, twodiamonds.getHeight() / 4, false);
        cards.add(new Card("twodiamonds", 2, twodiamonds));

        threediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.three_of_diamonds);
        threediamonds = Bitmap.createScaledBitmap(threediamonds, threediamonds.getWidth() / 4, threediamonds.getHeight() / 4, false);
        cards.add(new Card("threediamonds", 3, threediamonds));

        fourdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.four_of_diamonds);
        fourdiamonds = Bitmap.createScaledBitmap(fourdiamonds, fourdiamonds.getWidth() / 4, fourdiamonds.getHeight() / 4, false);
        cards.add(new Card("fourdiamonds", 4, fourdiamonds));

        fivediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.five_of_diamonds);
        fivediamonds = Bitmap.createScaledBitmap(fivediamonds, fivediamonds.getWidth() / 4, fivediamonds.getHeight() / 4, false);
        cards.add(new Card("fivediamonds", 5, fivediamonds));

        sixdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.six_of_diamonds);
        sixdiamonds = Bitmap.createScaledBitmap(sixdiamonds, sixdiamonds.getWidth() / 4, sixdiamonds.getHeight() / 4, false);
        cards.add(new Card("sixdiamonds", 6, sixdiamonds));

        sevendiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.seven_of_diamonds);
        sevendiamonds = Bitmap.createScaledBitmap(sevendiamonds, sevendiamonds.getWidth() / 4, sevendiamonds.getHeight() / 4, false);
        cards.add(new Card("sevendiamonds", 7, sevendiamonds));

        eightdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.eight_of_diamonds);
        eightdiamonds = Bitmap.createScaledBitmap(eightdiamonds, eightdiamonds.getWidth() / 4, eightdiamonds.getHeight() / 4, false);
        cards.add(new Card("eightdiamonds", 8, eightdiamonds));

        ninediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.nine_of_diamonds);
        ninediamonds = Bitmap.createScaledBitmap(ninediamonds, ninediamonds.getWidth() / 4, ninediamonds.getHeight() / 4, false);
        cards.add(new Card("ninediamonds", 9, ninediamonds));

        tendiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.ten_of_diamonds);
        tendiamonds = Bitmap.createScaledBitmap(tendiamonds, tendiamonds.getWidth() / 4, tendiamonds.getHeight() / 4, false);
        cards.add(new Card("tendiamonds", 10, tendiamonds));

        jackdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.jack_of_diamonds);
        jackdiamonds = Bitmap.createScaledBitmap(jackdiamonds, jackdiamonds.getWidth() / 4, jackdiamonds.getHeight() / 4, false);
        cards.add(new Card("jackdiamonds", 10, jackdiamonds));

        queendiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.queen_of_diamonds);
        queendiamonds = Bitmap.createScaledBitmap(queendiamonds, queendiamonds.getWidth() / 4, queendiamonds.getHeight() / 4, false);
        cards.add(new Card("queendiamonds", 10, queendiamonds));

        kingdiamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.king_of_diamonds);
        kingdiamonds = Bitmap.createScaledBitmap(kingdiamonds, kingdiamonds.getWidth() / 4, kingdiamonds.getHeight() / 4, false);
        cards.add(new Card("kingdiamonds", 10, kingdiamonds));

        acediamonds = BitmapFactory.decodeResource(context.getResources(), R.drawable.ace_of_diamonds);
        acediamonds = Bitmap.createScaledBitmap(acediamonds, acediamonds.getWidth() / 4, acediamonds.getHeight() / 4, false);
        cards.add(new Card("acediamonds", 1, acediamonds));

    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
