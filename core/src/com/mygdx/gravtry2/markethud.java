package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by akhauri on 4/4/2017.
 */

public class markethud implements Disposable {
    @Override
    public void dispose() {
        stage.dispose();
    }
    public static Stage stage;
    public BitmapFont font24;
    private Viewport viewport;
    Label coins;
    Label price;
    private gravtry2 game;
    public markethud(SpriteBatch sb, gravtry2 game){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("geniso.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params2.size = (int) (80*(Gdx.graphics.getWidth()/1920f));
        font24 = generator.generateFont(params2);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table table = new Table();
        //table.setFillParent(true);
        coins = new Label(String.format("%03d", game.prefs.getInteger("coins")), new Label.LabelStyle(font24, Color.WHITE.set(1,1,1,0.9f)));
        price = new Label("2000 EACH", new Label.LabelStyle(font24, Color.WHITE.set(1,1,1,0.9f)));
        table.add(coins).padLeft(260*Gdx.graphics.getWidth()/1920f).padTop(-2050f*Gdx.graphics.getHeight()/1080f);
        table.row();
        table.add(price).padLeft(3040*Gdx.graphics.getWidth()/1920f).padTop(-2050f*Gdx.graphics.getHeight()/1080f);
        stage.addActor(table);
    }
    public void update(float dt){}
}
