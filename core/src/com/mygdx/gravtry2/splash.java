package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by akhauri on 3/28/2017.
 */

public class splash implements Screen {

    gravtry2 game;
    public Viewport port;
    public OrthographicCamera cam;
    private Texture infopage;
    private Texture infobg;
    private Sprite infobgs;
    private int z = 0;
    private int curr = 0;
    private int r = 0;
    private int level;
    private Sprite infopages;
    private Rectangle speedupr, slowdownr, antigravr, wallr, lifer, playerr, en1r, en2r, backr;
    private Texture speedupt, slowdownt, antigravt, wallt, lifet, playert, en1t, en2t;
    private Sprite speedups, slowdowns, antigravs, walls, lifes, players, en1s, en2s;
    public splash(gravtry2 game, int i){
        this.game = game;
        level = i;
        if(level == 1){
            infobg = new Texture("tutleftpart.png");
            infobgs = new Sprite(infobg, infobg.getWidth(), infobg.getHeight());
            infobgs.setSize(infobg.getWidth()*Gdx.graphics.getWidth()/1920f, infobg.getHeight()*Gdx.graphics.getHeight()/1080f);
            infobgs.setPosition(0,0);
            speedupt = new Texture("speeduptext.png");
            slowdownt = new Texture("slowdowntext.png");
            antigravt = new Texture("antigravtext.png");
            wallt = new Texture("walltext.png");
            lifet= new Texture("lifetext.png");
            playert = new Texture("playertext.png");
            en1t= new Texture("en1text.png");
            en2t = new Texture("en2text.png");

            speedups = new Sprite(speedupt);
            slowdowns = new Sprite(slowdownt);
            antigravs = new Sprite(antigravt);
            walls = new Sprite(wallt);
            lifes = new Sprite(lifet);
            players = new Sprite(playert);
            en1s = new Sprite(en1t);
            en2s = new Sprite(en2t);

            speedups.setSize(speedupt.getWidth()*Gdx.graphics.getWidth()/1920f, speedupt.getHeight()*Gdx.graphics.getHeight()/1080f);
            slowdowns.setSize(slowdownt.getWidth()*Gdx.graphics.getWidth()/1920f, slowdownt.getHeight()*Gdx.graphics.getHeight()/1080f);
            antigravs.setSize(antigravt.getWidth()*Gdx.graphics.getWidth()/1920f, antigravt.getHeight()*Gdx.graphics.getHeight()/1080f);
            walls.setSize(wallt.getWidth()*Gdx.graphics.getWidth()/1920f, wallt.getHeight()*Gdx.graphics.getHeight()/1080f);
            lifes.setSize(lifet.getWidth()*Gdx.graphics.getWidth()/1920f, lifet.getHeight()*Gdx.graphics.getHeight()/1080f);
            players.setSize(playert.getWidth()*Gdx.graphics.getWidth()/1920f, playert.getHeight()*Gdx.graphics.getHeight()/1080f);
            en1s.setSize(en1t.getWidth()*Gdx.graphics.getWidth()/1920f, en1t.getHeight()*Gdx.graphics.getHeight()/1080f);
            en2s.setSize(en2t.getWidth()*Gdx.graphics.getWidth()/1920f, en2t.getHeight()*Gdx.graphics.getHeight()/1080f);

            speedups.setPosition((1246f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            slowdowns.setPosition((1195f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            antigravs.setPosition((1090f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            walls.setPosition((1251f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            lifes.setPosition((1418f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            players.setPosition((1176f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            en1s.setPosition((1169f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());
            en2s.setPosition((1169f/1920f)*Gdx.graphics.getWidth(),((1080f-790f)/1080f)*Gdx.graphics.getHeight());

            speedups.setAlpha(0);
            slowdowns.setAlpha(0);
            antigravs.setAlpha(0);
            lifes.setAlpha(0);
            walls.setAlpha(0);
            players.setAlpha(0);
            en1s.setAlpha(0);
            en2s.setAlpha(0);

            speedupr =  new Rectangle((63f/1920f)*Gdx.graphics.getWidth(),((44f)/1080f)*Gdx.graphics.getHeight(),(172f/1920f)*Gdx.graphics.getWidth(),(172f/1080f)*Gdx.graphics.getHeight());
            slowdownr =  new Rectangle((316f/1920f)*Gdx.graphics.getWidth(),((44f)/1080f)*Gdx.graphics.getHeight(),(115f/1920f)*Gdx.graphics.getWidth(),(124f/1080f)*Gdx.graphics.getHeight());
            antigravr =  new Rectangle((568f/1920f)*Gdx.graphics.getWidth(),((44f)/1080f)*Gdx.graphics.getHeight(),(115f/1920f)*Gdx.graphics.getWidth(),(124f/1080f)*Gdx.graphics.getHeight());
            wallr =  new Rectangle((124f/1920f)*Gdx.graphics.getWidth(),((338f)/1080f)*Gdx.graphics.getHeight(),(120f/1920f)*Gdx.graphics.getWidth(),(314f/1080f)*Gdx.graphics.getHeight());
            lifer =  new Rectangle((494f/1920f)*Gdx.graphics.getWidth(),((416f)/1080f)*Gdx.graphics.getHeight(),(140f/1920f)*Gdx.graphics.getWidth(),(122f/1080f)*Gdx.graphics.getHeight());
            playerr =  new Rectangle((790f/1920f)*Gdx.graphics.getWidth(),((364f)/1080f)*Gdx.graphics.getHeight(),(184f/1920f)*Gdx.graphics.getWidth(),(220f/1080f)*Gdx.graphics.getHeight());
            en1r =  new Rectangle((114f/1920f)*Gdx.graphics.getWidth(),((802f)/1080f)*Gdx.graphics.getHeight(),(154f/1920f)*Gdx.graphics.getWidth(),(158f/1080f)*Gdx.graphics.getHeight());
            en2r =  new Rectangle((500f/1920f)*Gdx.graphics.getWidth(),((802f)/1080f)*Gdx.graphics.getHeight(),(140f/1920f)*Gdx.graphics.getWidth(),(142f/1080f)*Gdx.graphics.getHeight());
            backr =  new Rectangle((1770f/1920f)*Gdx.graphics.getWidth(),((930f)/1080f)*Gdx.graphics.getHeight(),(116f/1920f)*Gdx.graphics.getWidth(),(120f/1080f)*Gdx.graphics.getHeight());

        }
        if(level == 2){
            infopage = new Texture("loading.png");
            infopages = new Sprite(infopage, infopage.getWidth(), infopage.getHeight());
            infopages.setSize(infopage.getWidth()*(Gdx.graphics.getWidth()/1920f), infopage.getHeight()*(Gdx.graphics.getHeight()/1080f));
            infopages.setPosition(0,0);}
    }

    @Override
    public void dispose() {
        if(level == 2){
        infopage.dispose();}
        if(level == 1){
            speedupt.dispose();slowdownt.dispose();antigravt.dispose();wallt.dispose();lifet.dispose();playert.dispose();en1t.dispose();en2t.dispose();
            infobg.dispose();

        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(233f/255f,233f/255f,233f/255f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        if(level == 2){
        infopages.draw(game.batch);}
        if(level == 1){
        infobgs.draw(game.batch);
            if(curr == 1){
                speedups.draw(game.batch);}
            if(curr == 2){
                slowdowns.draw(game.batch);}
            if(curr == 3){
                walls.draw(game.batch);}
            if(curr == 4){
                antigravs.draw(game.batch);}
            if(curr == 5){
                lifes.draw(game.batch);}
            if(curr == 6){
                en2s.draw(game.batch);}
            if(curr == 7){
                en1s.draw(game.batch);}
            if(curr == 8){
                players.draw(game.batch);}
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }
    public void update(float dt){
        r++;
        if(r>5) {
            if(level == 2) {
                game.setScreen(new Playscreen(game));
                this.dispose();
            }
            if(level == 1){
                handleinput();
                z++;
            }
        }
    }
    public void handleinput(){
        if(0.01f*z < 1) {
            speedups.setAlpha(0.01f * z);
            slowdowns.setAlpha(0.01f * z);
            antigravs.setAlpha(0.01f * z);
            lifes.setAlpha(0.01f * z);
            walls.setAlpha(0.01f * z);
            players.setAlpha(0.01f * z);
            en1s.setAlpha(0.01f * z);
            en2s.setAlpha(0.01f * z);
        }
        if(Gdx.input.justTouched()){
            if(speedupr.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 1;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(slowdownr.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 2;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(wallr.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 3;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(antigravr.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 4;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(lifer.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 5;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(en2r.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 6;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(en1r.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 7;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
            if(backr.contains(Gdx.input.getX(),Gdx.input.getY())){
                game.setScreen(new Infoscreen(game));
                this.dispose();
            }
            if(playerr.contains(Gdx.input.getX(),Gdx.input.getY())){
                z = 0;
                curr = 8;        speedups.setAlpha(0);
                slowdowns.setAlpha(0);
                antigravs.setAlpha(0);
                lifes.setAlpha(0);
                walls.setAlpha(0);
                players.setAlpha(0);
                en1s.setAlpha(0);
                en2s.setAlpha(0);
            }
        }
    }
    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
