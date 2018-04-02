package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Replayscreen implements Screen, Disposable {

    gravtry2 game;
    public Viewport port;
    private Texture replaybtn;
    private BitmapFont font25;
    private Stage stage;
    private Replayhud hud;
    private Sprite replaybtns;
    private Playscreen screen;
    public OrthographicCamera cam;
    private Texture replaybg;
    public Replayscreen(gravtry2 game){
        this.game = game;
        cam = new OrthographicCamera();
        port= new StretchViewport(Gdx.graphics.getWidth()/ gravtry2.PPM,Gdx.graphics.getHeight()/ gravtry2.PPM,cam);
        cam.position.set((port.getWorldWidth()/2), (port.getWorldHeight()/2), 0);
        replaybg = new Texture("replaybg.PNG");
        replaybtn = new Texture("replaybtn.PNG");
        replaybtns = new Sprite(replaybtn, replaybtn.getWidth(), replaybtn.getHeight());
        replaybtns.setSize(replaybtn.getWidth()*(Gdx.graphics.getWidth()/1920f), replaybtn.getHeight()*(Gdx.graphics.getWidth()/1920f));
        replaybtns.setPosition((1453f/1920f)*Gdx.graphics.getWidth(), ((1080f-769f)/1080f)*Gdx.graphics.getHeight());
        hud = new Replayhud(game.batch);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        handleinput();
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(Replayhud.stage.getCamera().combined);
        game.batch.begin();
        game.batch.draw(replaybg,0, 0, replaybg.getWidth()*(Gdx.graphics.getWidth()/1920f), replaybg.getHeight()*(Gdx.graphics.getHeight()/1080f));
        replaybtns.draw(game.batch);
        game.batch.end();
        Replayhud.stage.draw();
        hud.scorelabel.setText(String.format("%06d", game.prefs.getInteger("currscore")));
        hud.highlabel.setText(String.format("%06d", game.prefs.getInteger("score")));
        hud.coinlabel.setText(String.format("%06d", game.prefs.getInteger("coins")));
        cam.update();


    }
    public void update(float dt){
        hud.update(dt);
    }

    public void handleinput() {
        Rectangle replaybound = new Rectangle(1453f * (Gdx.graphics.getWidth() / 1920f),
                (1080f-769f)*(Gdx.graphics.getHeight() / 1080f), 409f * (Gdx.graphics.getWidth() / 1920f), 409f* (Gdx.graphics.getHeight() / 1080f));
        if(Gdx.input.justTouched()){
            if(replaybound.contains(Gdx.input.getX(), Gdx.input.getY())){
                game.setScreen(new MenuScreen(game));
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
    }
}
