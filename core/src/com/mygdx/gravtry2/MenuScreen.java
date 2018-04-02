package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



/**
 * Created by Parth on 3/17/2017.
 */

public class MenuScreen implements Screen {
    gravtry2 game;
    float j = 0;
    float i = 0;
    public Viewport port;
    public OrthographicCamera cam;

    private Sprite rotates;
    private Sprite tuts;
    private Texture tut;
    private Texture icon,tap,sound,market,info, shadowon, shadowoff, rotate;
    private Sprite taps, sounds, markets, infos, shadowoffs, shadowons;
    private Sprite icons;
    public World world;
    public MenuScreen(gravtry2 game){
        this.game = game;
        cam = new OrthographicCamera();
        port= new StretchViewport(Gdx.graphics.getWidth()/ gravtry2.PPM,Gdx.graphics.getHeight()/ gravtry2.PPM,cam);
        cam.position.set((port.getWorldWidth()/2), (port.getWorldHeight()/2), 0);
        world = new World(new Vector2(0,0),true);
        tap = new Texture("taptostart.PNG");
        rotate = new Texture("rotate.PNG");
        rotates = new Sprite(rotate, rotate.getWidth(), rotate.getHeight());
        rotates.setSize(rotate.getWidth()*Gdx.graphics.getWidth()/1920f, rotate.getHeight()*Gdx.graphics.getHeight()/1080f);
        sound = new Texture("sound.PNG");
        market = new Texture("market.PNG");
        info = new Texture("info.PNG");
        icon = new Texture("icon.png");
        shadowon = new Texture("shadowon.PNG");
        tut = new Texture("tutorialindicate.png");
        tuts = new Sprite(tut, tut.getWidth(), tut.getHeight());
        tuts.setSize(tut.getWidth()*Gdx.graphics.getWidth()/1920f, tut.getHeight()*Gdx.graphics.getHeight()/1080f);
        shadowoff = new Texture("shadowoff.PNG");
        shadowons = new Sprite(shadowon, shadowon.getWidth(), shadowoff.getHeight());
        shadowoffs = new Sprite(shadowoff, shadowoff.getWidth(), shadowoff.getHeight());
        icons = new Sprite(icon,icon.getWidth(),icon.getHeight());
        taps = new Sprite(tap, tap.getWidth(), tap.getHeight());
        sounds = new Sprite(sound, sound.getWidth(), sound.getHeight());
        markets = new Sprite(market, market.getWidth(), market.getHeight());
        infos = new Sprite(info, info.getWidth(), info.getHeight());
        shadowoffs.setSize(shadowoff.getWidth()*(Gdx.graphics.getWidth()/1920f), shadowoff.getHeight()*(Gdx.graphics.getHeight()/1080f));
        shadowons.setSize(shadowon.getWidth()*(Gdx.graphics.getWidth()/1920f), shadowon.getHeight()*(Gdx.graphics.getHeight()/1080f));
        icons.setSize(icon.getWidth()*Gdx.graphics.getWidth()/1920f, icon.getHeight()*Gdx.graphics.getHeight()/1080f);
        sounds.setSize(sound.getWidth()*Gdx.graphics.getWidth()/1920f, sound.getHeight()*Gdx.graphics.getHeight()/1080f);
        markets.setSize(market.getWidth()*Gdx.graphics.getWidth()/1920f, market.getHeight()*Gdx.graphics.getHeight()/1080f);
        infos.setSize(info.getWidth()*Gdx.graphics.getWidth()/1920f, info.getHeight()*Gdx.graphics.getHeight()/1080f);
        taps.setSize(tap.getWidth()*Gdx.graphics.getWidth()/1920f, tap.getHeight()*Gdx.graphics.getHeight()/1080f);
        taps.setPosition((149.7f/1920f)*Gdx.graphics.getWidth(),(-(251f)/1080f)*Gdx.graphics.getHeight());
        sounds.setPosition((1756f/1920f)*Gdx.graphics.getWidth(),((1080f-502f)/1080f)*Gdx.graphics.getHeight());
        markets.setPosition((1756f/1920f)*Gdx.graphics.getWidth(),((1080f-963f)/1080f)*Gdx.graphics.getHeight());
        infos.setPosition((1756f/1920f)*Gdx.graphics.getWidth(),((1080f-733f)/1080f)*Gdx.graphics.getHeight());
        icons.setPosition((773f/1920f)*Gdx.graphics.getWidth(),((1080f-612f)/1080f)*Gdx.graphics.getHeight());
        tuts.setPosition((1441f/1920f)*Gdx.graphics.getWidth(),((1080f-410f)/1080f)*Gdx.graphics.getHeight());
        rotates.setPosition((650f/1920f)*Gdx.graphics.getWidth(), ((1080f-409f-300f)/1080f)*Gdx.graphics.getHeight());
        icons.setOriginCenter();
        rotates.setOriginCenter();
        shadowoffs.setPosition(0,Gdx.graphics.getHeight() - shadowoff.getHeight()*Gdx.graphics.getHeight()/1080f);
        shadowons.setPosition(0,Gdx.graphics.getHeight() - shadowoff.getHeight()*Gdx.graphics.getHeight()/1080f);
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        if (game.prefs.getInteger("currlevel") == 0) {
            Gdx.gl.glClearColor(69f / 255f, 83f / 255f, 154f / 255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 1) {
            Gdx.gl.glClearColor(140f/255f, 213f/255f, 255f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 2) {
            Gdx.gl.glClearColor(151f/255f, 137f/255f, 204f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 3) {
            Gdx.gl.glClearColor(225f/255f, 178f/255f, 111f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 4) {
            Gdx.gl.glClearColor(112f/255f, 228f/255f, 204f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 5) {
            Gdx.gl.glClearColor(233f/255f, 233f/255f, 233f/255f, 1f);
        }
        if (game.prefs.getInteger("currlevel") == 6) {
            Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1f);
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        update(delta);
        if(game.prefs.getInteger("shadows") == 1){
            shadowons.draw(game.batch);
        }
        if(game.prefs.getInteger("shadows") == 0){
            shadowoffs.draw(game.batch);
        }
        icons.draw(game.batch);
        taps.draw(game.batch);
        rotates.draw(game.batch);
        sounds.draw(game.batch);
        tuts.draw(game.batch);
        markets.draw(game.batch);
        infos.draw(game.batch);
        game.batch.end();
        cam.update();
    }
    public void update(float dt){
        tuts.setAlpha(0.01f * j);
        j++;
        if(j%1000 == 0){
            tuts.setAlpha(0);
            j = 0;
        }
        if (game.prefs.getInteger("sound") == 0) {
            game.music.pause();
        }
        if (game.prefs.getInteger("sound") == 1){
            game.music.play();
        }
        rotates.setRotation(2*i);
        icons.setRotation(-i);
        i += 0.5f;
        handleinput();
    }
    public void handleinput() {
        Rectangle marketbound = new Rectangle(1758f*(Gdx.graphics.getWidth()/1920f),
                502f*(Gdx.graphics.getHeight()/1080f), 104f*(Gdx.graphics.getWidth()/1920f), 104f*(Gdx.graphics.getHeight()/1080f));
        Rectangle infobound = new Rectangle(1758f*(Gdx.graphics.getWidth()/1920f),
                271f*(Gdx.graphics.getHeight()/1080f), 104f*(Gdx.graphics.getWidth()/1920f), 104f*(Gdx.graphics.getHeight()/1080f));
        Rectangle soundbound = new Rectangle(1758f*(Gdx.graphics.getWidth()/1920f),
                41f*(Gdx.graphics.getHeight()/1080f), 104f*(Gdx.graphics.getWidth()/1920f), 104f*(Gdx.graphics.getHeight()/1080f));
        Rectangle shadowbound = new Rectangle(0, 0, 420f*Gdx.graphics.getWidth()/1920f, 111f*Gdx.graphics.getHeight()/1080f);
        if(Gdx.input.justTouched())
        {
            if(marketbound.contains(Gdx.input.getX(),Gdx.input.getY()))
            {
                 game.setScreen(new Market(game));
            }
            else if(infobound.contains(Gdx.input.getX(), Gdx.input.getY())){
                game.setScreen(new splash(game, 1));
            }
            else if(soundbound.contains(Gdx.input.getX(), Gdx.input.getY())){
                if(game.prefs.getInteger("sound") == 1){
                    game.prefs.putInteger("sound", 0);
                    game.prefs.flush();
                }
                else{game.prefs.putInteger("sound", 1);
                game.prefs.flush();}
            }
            else if(shadowbound.contains(Gdx.input.getX(), Gdx.input.getY())){
                if(game.prefs.getInteger("shadows") == 1){
                    game.prefs.putInteger("shadows", 0);
                    game.prefs.flush();
                }
                else{
                    game.prefs.putInteger("shadows", 1);
                    game.prefs.flush();
                }
            }
            else{
                game.setScreen(new splash(game, 2));
                this.dispose();
            }
        }
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        tut.dispose();
        icon.dispose();tap.dispose();sound.dispose();market.dispose();info.dispose();shadowon.dispose();shadowoff.dispose();rotate.dispose();
    }
}
