package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


/**
 * Created by akhauri on 3/21/2017.
 */

public class Replayhud implements Disposable {
    @Override
    public void dispose() {
        stage.dispose();
    }
    public static Stage stage;
    private gravtry2 game;
    public BitmapFont font24;
    private Playscreen screen;
    private Viewport viewport;
    private BitmapFont font25;
    Label highlabel;
    Label coinlabel;
    Label scorelabel;
    Label namehighLabel;
    Label namecoinLabel;
    Label namescoreLabel;
    public Replayhud(SpriteBatch sb){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("geniso.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator.FreeTypeFontParameter params2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params2.size = (int) (100* Gdx.graphics.getHeight()/1080f);
        params.size = (int) (280*(Gdx.graphics.getHeight()/1080f));
        font24 = generator.generateFont(params);
        font25 = generator.generateFont(params2);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        scorelabel = new Label("LOL", new Label.LabelStyle(font25, Color.WHITE));
        namescoreLabel = new Label("SCORE: ", new Label.LabelStyle(font25, Color.WHITE));
        highlabel = new Label("LOL", new Label.LabelStyle(font25, Color.WHITE));
        namehighLabel = new Label("HIGHSCORE: ", new Label.LabelStyle(font25, Color.WHITE));
        coinlabel = new Label("LOL", new Label.LabelStyle(font25, Color.WHITE));
        namecoinLabel = new Label("COINS: ", new Label.LabelStyle(font25, Color.WHITE));

        table.add(namescoreLabel).padLeft(1*Gdx.graphics.getWidth()/1920f).padTop(400*Gdx.graphics.getHeight()/1080f);
        table.add(scorelabel).padLeft(1*Gdx.graphics.getWidth()/1920f).padTop(400*Gdx.graphics.getHeight()/1080f);
        table.row();
        table.add(namehighLabel).padLeft(1*Gdx.graphics.getWidth()/1920f).padTop(10*Gdx.graphics.getHeight()/1080f);
        table.add(highlabel).padLeft(1*Gdx.graphics.getWidth()/1920f).padTop(10*Gdx.graphics.getHeight()/1080f);
        table.row();
        table.add(namecoinLabel).padLeft(1*Gdx.graphics.getWidth()/1920f).padTop(10*Gdx.graphics.getHeight()/1080f);
        table.add(coinlabel).padLeft(1*Gdx.graphics.getWidth()/1920f).padTop(10*Gdx.graphics.getHeight()/1080f);
        table.row();
        stage.addActor(table);
    }
    public void update(float dt){ }

}
