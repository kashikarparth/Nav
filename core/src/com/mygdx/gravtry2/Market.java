
package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.lwjgl.Sys;

/**
 * Created by Parth on 3/17/2017.
 */

public class Market implements Screen {

    gravtry2 game;
    public Viewport port;
    private markethud markethud;
    public OrthographicCamera cam;
    public World world;
    public Playscreen screen;
    Texture spritesel, levelsel;
    Texture t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
    Texture u1, u2, u3, u4, u5, u6, u7, u8 ,u9, u10, u11, u12, u13, u14, u15;
    Rectangle r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;
    Texture cost;
    public Market(gravtry2 game){
        this.game = game;
        cam = new OrthographicCamera();
        markethud = new markethud(game.batch, game);
        port= new StretchViewport(Gdx.graphics.getWidth()/ gravtry2.PPM,Gdx.graphics.getHeight()/ gravtry2.PPM,cam);
        cam.position.set((port.getWorldWidth()/2), (port.getWorldHeight()/2), 0);
        world = new World(new Vector2(0,0),true);
        spritesel = new Texture("selector.PNG");
        levelsel = new Texture("selector.PNG");
        cost = new Texture("cost.PNG");
        t1 = new Texture("padlock.png");
        t2 = new Texture("padlock.png");
        t3 = new Texture("padlock.png");
        t4 = new Texture("padlock.png");
        t5= new Texture("padlock.png");
        t6 = new Texture("padlock.png");
        t7 = new Texture("padlock.png");
        t8 = new Texture("padlock.png");
        t9 = new Texture("padlock.png");
        t10 = new Texture("padlock.png");
        t11 = new Texture("padlock.png");
        t12 = new Texture("padlock.png");
        t13 = new Texture("padlock.png");
        t14 = new Texture("padlock.png");
        t15 = new Texture("padlock.png");
        t16 = new Texture("bluenavbar.png");
        t17 = new Texture("back.png");
        u1 = new Texture("r1b.PNG");
        u2 = new Texture("r2w.png");
        u3 = new Texture("r3b.PNG");
        u4 = new Texture("griffin.png");
        u5 = new Texture("r5w.PNG");
        u6 = new Texture("r6b.png");
        u7 = new Texture("r7b.png");
        u8 = new Texture("r8b.png");
        u9 = new Texture("r9b.png");
        u10 = new Texture("r10.PNG");
        u11 = new Texture("r11.PNG");
        u12 = new Texture("r12.PNG");
        u13 = new Texture("r13.PNG");
        u14 = new Texture("r14.PNG");
        u15 = new Texture("r15.PNG");
        r1 = new Rectangle((140f/1920f)*Gdx.graphics.getWidth(),((242f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r2 = new Rectangle((140f/1920f)*Gdx.graphics.getWidth(),((842f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r3 = new Rectangle((140f/1920f)*Gdx.graphics.getWidth(),((544f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r4 = new Rectangle((743f/1920f)*Gdx.graphics.getWidth(),((242f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r5 = new Rectangle((743f/1920f)*Gdx.graphics.getWidth(),((842f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r6 = new Rectangle((743f/1920f)*Gdx.graphics.getWidth(),((544f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r7 = new Rectangle((442f/1920f)*Gdx.graphics.getWidth(),((242f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r8 = new Rectangle((442f/1920f)*Gdx.graphics.getWidth(),((844f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r9 = new Rectangle((442f/1920f)*Gdx.graphics.getWidth(),((544f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        r10 = new Rectangle((1636f/1920f)*Gdx.graphics.getWidth(),((842f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        r11= new Rectangle((1636f/1920f)*Gdx.graphics.getWidth(),((243f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        r12= new Rectangle((1636f/1920f)*Gdx.graphics.getWidth(),((544f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        r13= new Rectangle((1334f/1920f)*Gdx.graphics.getWidth(),((842f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        r14= new Rectangle((1334f/1920f)*Gdx.graphics.getWidth(),((243f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        r15 = new Rectangle((1334f/1920f)*Gdx.graphics.getWidth(),((544f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        r16 = new Rectangle((1750f/1920f)*Gdx.graphics.getWidth(),((65f)/1080f)*Gdx.graphics.getHeight(),(t17.getWidth()/1920f)*Gdx.graphics.getWidth(),(t17.getHeight()/1080f)*Gdx.graphics.getHeight());
    }
    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(55f/255f, 55f/255f, 55f/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        if(game.prefs.getInteger("sprite1")==0)
            game.batch.draw(t1,(140f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite7")==0)
            game.batch.draw(t1,(140f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite4")==0)
            game.batch.draw(t1,(140f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite3")==0)
            game.batch.draw(t1,(743f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite9")==0)
            game.batch.draw(t1,(743f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite6")==0)
            game.batch.draw(t1,(743f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite2")==0)
            game.batch.draw(t1,(442f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite8")==0)
            game.batch.draw(t1,(442f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("sprite5")==0)
            game.batch.draw(t1,(442f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t15,(1636f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t15,(1334f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t15,(1636f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t15,(1334f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t15,(1636f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t15,(1334f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t16,(0f/1920f)*Gdx.graphics.getWidth(),((1080f-115f)/1080f)*Gdx.graphics.getHeight(),(t16.getWidth()/1920f)*Gdx.graphics.getWidth(),(t16.getHeight()/1080f)*Gdx.graphics.getHeight());
        game.batch.draw(t17,(1750f/1920f)*Gdx.graphics.getWidth(),((1080f-180f)/1080f)*Gdx.graphics.getHeight(),(t17.getWidth()/1920f)*Gdx.graphics.getWidth(),(t17.getHeight()/1080f)*Gdx.graphics.getHeight());
        if(game.prefs.getInteger("currsprite") == 9){
            game.batch.draw(spritesel,(723f/1920f)*Gdx.graphics.getWidth(),((1080f-981f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 8){
            game.batch.draw(spritesel,(422f/1920f)*Gdx.graphics.getWidth(),((1080f-981f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 7){
            game.batch.draw(spritesel,(120f/1920f)*Gdx.graphics.getWidth(),((1080f-981f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 6){
            game.batch.draw(spritesel,(723f/1920f)*Gdx.graphics.getWidth(),((1080f-680f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 5){
            game.batch.draw(spritesel,(422f/1920f)*Gdx.graphics.getWidth(),((1080f-680f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 4){
            game.batch.draw(spritesel,(120f/1920f)*Gdx.graphics.getWidth(),((1080f-680f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 3){
            game.batch.draw(spritesel,(723f/1920f)*Gdx.graphics.getWidth(),((1080f-378f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 2){
            game.batch.draw(spritesel,(422f/1920f)*Gdx.graphics.getWidth(),((1080f-378f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currsprite") == 1){
            game.batch.draw(spritesel,(120f/1920f)*Gdx.graphics.getWidth(),((1080f-378f)/1080f)*Gdx.graphics.getHeight(),(spritesel.getWidth()/1920f)*Gdx.graphics.getWidth(),(spritesel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }

        if(game.prefs.getInteger("level1")==1){
            game.batch.draw(u14,(1334f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("level2")==1){
            game.batch.draw(u11,(1636f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("level3")==1){
            game.batch.draw(u15,(1334f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("level4")==1){
            game.batch.draw(u12,(1636f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("level5")==1){
            game.batch.draw(u10,(1636f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("level6")==1){
            game.batch.draw(u13,(1334f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t15.getWidth()/1920f)*Gdx.graphics.getWidth(),(t15.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite1") == 1){
            game.batch.draw(u1,(140f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite2") == 1) {
            game.batch.draw(u2, (442f / 1920f) * Gdx.graphics.getWidth(), ((1080f - 358f) / 1080f) * Gdx.graphics.getHeight(), (t1.getWidth() / 1920f) * Gdx.graphics.getWidth(), (t1.getHeight() / 1080f) * Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite3") == 1){
            game.batch.draw(u3,(743f/1920f)*Gdx.graphics.getWidth(),((1080f-358f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite4") == 1){
            game.batch.draw(u4,(140f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite5") == 1){
            game.batch.draw(u5,(442f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite6") == 1){
            game.batch.draw(u6,(743f/1920f)*Gdx.graphics.getWidth(),((1080f-660f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite7") == 1){
            game.batch.draw(u7,(140f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite8") == 1){
            game.batch.draw(u8,(442f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("sprite9") == 1){
            game.batch.draw(u9,(743f/1920f)*Gdx.graphics.getWidth(),((1080f-961f)/1080f)*Gdx.graphics.getHeight(),(t1.getWidth()/1920f)*Gdx.graphics.getWidth(),(t1.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        if(game.prefs.getInteger("currlevel") == 1){
            game.batch.draw(levelsel,(1314f/1920f)*Gdx.graphics.getWidth(),((1080f-378f)/1080f)*Gdx.graphics.getHeight(),(levelsel.getWidth()/1920f)*Gdx.graphics.getWidth(),(levelsel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        else if(game.prefs.getInteger("currlevel") == 2){
            game.batch.draw(levelsel,(1616f/1920f)*Gdx.graphics.getWidth(),((1080f-378f)/1080f)*Gdx.graphics.getHeight(),(levelsel.getWidth()/1920f)*Gdx.graphics.getWidth(),(levelsel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        else  if(game.prefs.getInteger("currlevel") == 3){
            game.batch.draw(levelsel,(1314f/1920f)*Gdx.graphics.getWidth(),((1080f-680f)/1080f)*Gdx.graphics.getHeight(),(levelsel.getWidth()/1920f)*Gdx.graphics.getWidth(),(levelsel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        else  if(game.prefs.getInteger("currlevel") == 4){
            game.batch.draw(levelsel,(1616f/1920f)*Gdx.graphics.getWidth(),((1080f-680f)/1080f)*Gdx.graphics.getHeight(),(levelsel.getWidth()/1920f)*Gdx.graphics.getWidth(),(levelsel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        else  if(game.prefs.getInteger("currlevel") == 5){
            game.batch.draw(levelsel,(1616f/1920f)*Gdx.graphics.getWidth(),((1080f-981f)/1080f)*Gdx.graphics.getHeight(),(levelsel.getWidth()/1920f)*Gdx.graphics.getWidth(),(levelsel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }
        else if(game.prefs.getInteger("currlevel") == 6){
            game.batch.draw(levelsel,(1314f/1920f)*Gdx.graphics.getWidth(),((1080f-981f)/1080f)*Gdx.graphics.getHeight(),(levelsel.getWidth()/1920f)*Gdx.graphics.getWidth(),(levelsel.getHeight()/1080f)*Gdx.graphics.getHeight());
        }

        game.batch.draw(cost, 0, 0, cost.getWidth()/1920f, cost.getHeight()/1080f);
        game.batch.end();
        com.mygdx.gravtry2.markethud.stage.draw();
        markethud.coins.setText(String.format("%03d", game.prefs.getInteger("coins")));
        cam.update();
        update(delta);

    }
    public void update(float dt){
        handleinput();
    }
    public void handleinput() {
        if(Gdx.input.justTouched()){
            if(r16.contains(Gdx.input.getX(),Gdx.input.getY())){
                game.setScreen(new MenuScreen(game));
                this.dispose();
            }
            if(r1.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite1")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite1", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite1")==1){
                    game.prefs.putInteger("currsprite", 1);
                    game.prefs.flush();
                }
            }
            if(r2.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite7")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite7", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite7")==1){
                    game.prefs.putInteger("currsprite", 7);
                    game.prefs.flush();
                }
            }
            if(r3.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite4")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite4", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite4")==1){
                    game.prefs.putInteger("currsprite", 4);
                    game.prefs.flush();
                }
            }
            if(r4.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite3")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite3", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite3")==1){
                    game.prefs.putInteger("currsprite", 3);
                    game.prefs.flush();
                }
            }
            if(r5.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite9")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite9", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite9")==1){
                    game.prefs.putInteger("currsprite", 9);
                    game.prefs.flush();
                }
            }
            if(r6.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite6")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite6", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite6")==1){
                    game.prefs.putInteger("currsprite", 6);
                    game.prefs.flush();
                }
            }
            if(r7.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite2")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite2", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite2")==1){
                    game.prefs.putInteger("currsprite", 2);
                    game.prefs.flush();
                }
            }
            if(r8.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite8")==0)&&(game.prefs.getInteger("coins")>=2000)){
                    game.prefs.putInteger("sprite8", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite8")==1){
                    game.prefs.putInteger("currsprite", 8);
                    game.prefs.flush();
                }
            }
            if(r9.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("sprite5") == 0)&&(game.prefs.getInteger("coins") >= 2000)){
                    game.prefs.putInteger("sprite5", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("sprite5")==1){
                    game.prefs.putInteger("currsprite", 5);
                    game.prefs.flush();
                }
            }
            if(r13.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("level6") == 0)&&(game.prefs.getInteger("coins") >= 2000)){
                    game.prefs.putInteger("level6", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("level6") == 1){
                    game.prefs.putInteger("currlevel", 6);
                    game.prefs.flush();
                }
            }
            if(r11.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("level2") == 0)&&(game.prefs.getInteger("coins") >= 2000)){
                    game.prefs.putInteger("level2", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("level2") == 1){
                    game.prefs.putInteger("currlevel", 2);
                    game.prefs.flush();
                }
            }
            if(r12.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("level4") == 0)&&(game.prefs.getInteger("coins") >= 2000)) {
                    game.prefs.putInteger("level4", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins") - 2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("level4") == 1){
                    game.prefs.putInteger("currlevel", 4);
                    game.prefs.flush();
                }
            }
            if(r10.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("level5") == 0)&&(game.prefs.getInteger("coins") >= 2000)){
                    game.prefs.putInteger("level5", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("level5") == 1){
                    game.prefs.putInteger("currlevel", 5);
                    game.prefs.flush();
                }
            }
            if(r14.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("level1") == 0)&&(game.prefs.getInteger("coins") >= 2000)) {
                    game.prefs.putInteger("level1", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins") - 2000));
                    game.prefs.flush();
                }
                    if(game.prefs.getInteger("level1") == 1){
                        game.prefs.putInteger("currlevel", 1);
                        game.prefs.flush();
                    }
                }
            if(r15.contains(Gdx.input.getX(), Gdx.input.getY())){
                if((game.prefs.getInteger("level3") == 0)&&(game.prefs.getInteger("coins") >= 2000)){
                    game.prefs.putInteger("level3", 1);
                    game.prefs.putInteger("coins", (game.prefs.getInteger("coins")-2000));
                    game.prefs.flush();
                }
                if(game.prefs.getInteger("level3") == 1){
                    game.prefs.putInteger("currlevel", 3);
                    game.prefs.flush();
                }
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
        t1.dispose();t2.dispose();t3.dispose();t4.dispose();t5.dispose();t6.dispose();t7.dispose();t8.dispose();t9.dispose();t10.dispose();t11.dispose();
        t12.dispose();t13.dispose();t14.dispose();t15.dispose();t16.dispose();t17.dispose();spritesel.dispose();levelsel.dispose();
        u1.dispose();u2.dispose();u3.dispose();u4.dispose();u5.dispose();u6.dispose();u7.dispose();u8.dispose();u9.dispose();u10.dispose();u11.dispose();
        u12.dispose();u13.dispose();u14.dispose();u15.dispose();cost.dispose();
    }
}
