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

public class Hud implements Disposable {
    @Override
    public void dispose() {
        stage.dispose();
    }
    public static Stage stage;
    public BitmapFont font24;
    private Viewport viewport;
    public Integer worldTimer;
    public Integer score;
    public Integer coins;
    public Integer life;

    private BitmapFont font25;
    Label scorelabel;
    Label lifelabel;
    public Hud(SpriteBatch sb){
        life = 7;
        coins = 0;
        score = 0;
        worldTimer = 0;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("geniso.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator.FreeTypeFontParameter params2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params2.size = (int) (100*(Gdx.graphics.getWidth()/1920f));
        params.size = (int) (250*(Gdx.graphics.getWidth()/1920f));
        font24 = generator.generateFont(params);
        font25 = generator.generateFont(params2);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);
        lifelabel = new Label(String.format("%02d", life), new Label.LabelStyle(font24, Color.WHITE.set(1,1,1,0.9f)));
        table.add(lifelabel).padLeft(1550*Gdx.graphics.getWidth()/1920f).padTop(350*Gdx.graphics.getHeight()/1080f);
        table.row();
        scorelabel = new Label(String.format("%06d", worldTimer), new Label.LabelStyle(font25, Color.WHITE));
        table.add(scorelabel). padLeft(1550*Gdx.graphics.getWidth()/1920f).padTop(20*Gdx.graphics.getHeight()/1080f);
        stage.addActor(table);
    }
    public void update(float dt){ }

}
