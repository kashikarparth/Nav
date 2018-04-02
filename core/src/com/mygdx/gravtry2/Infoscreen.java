package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by akhauri on 3/28/2017.
 */

public class Infoscreen implements Screen {

    gravtry2 game;
    public Viewport port;
    public OrthographicCamera cam;
    private Texture infopage;
    private Sprite infopages;
    public Infoscreen(gravtry2 game){
        this.game = game;
        infopage = new Texture("infopage.png");
        infopages = new Sprite(infopage, infopage.getWidth(), infopage.getHeight());
        infopages.setSize(infopage.getWidth()*(Gdx.graphics.getWidth()/1920f), infopage.getHeight()*(Gdx.graphics.getHeight()/1080f));
        infopages.setPosition(0,0);

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        infopages.draw(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }
    public void update(float dt){
        handleinput();
    }
    public void handleinput(){
        if(Gdx.input.justTouched()){
            game.setScreen(new MenuScreen(game));
        }
    }
    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
