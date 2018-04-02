package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by akhauri on 3/18/2017.
 */

public class speedup extends Sprite {
    public Sprite getSpeedups() {
        return speedups;
    }

    private int speeduptimer = 1300;

    public Body body;
    private World world;
    public Playscreen screen;
    public player player;
    private Texture speedup;
    private Rectangle rectangle;
    private gravtry2 game;
    private Sprite speedups;
    private float posY;
    private int posX;
    Random rand = new Random();




    public speedup(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world = world;
        this.screen = screen;
        this.player = player;
        /*
        if(game.prefs.getInteger("currlevel") == 0 == true){
            speedup = new Texture("speedupL0.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 1 == true){
            speedup = new Texture("speedupL0.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 2 == true){
            speedup = new Texture("speedupL0.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 3 == true){
            speedup = new Texture("speedupL1.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 4 == true){
            speedup = new Texture("speedupL1.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 5 == true){
            speedup = new Texture("speedupL1.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 6 == true){
            speedup = new Texture("speedupL0.PNG");
        }
        */
        if(game.prefs.getInteger("currlevel") == 0 || game.prefs.getInteger("currlevel") == 1 || game.prefs.getInteger("currlevel") == 2){
            speedups = new Sprite(screen.getAtlas().findRegion("speedupL0").getTexture(), 1642, 0, 80, 80);
            speedups.setSize(80*((float) Gdx.graphics.getWidth()/1920f),80*((float) Gdx.graphics.getHeight()/1080f));}
        if(game.prefs.getInteger("currlevel") == 3 || game.prefs.getInteger("currlevel") == 4 || game.prefs.getInteger("currlevel") == 5){
            speedups = new Sprite(screen.getAtlas().findRegion("speedupL1").getTexture(), 1802, 0, 80, 80);
            speedups.setSize(80*((float) Gdx.graphics.getWidth()/1920f),80*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 6){
            speedups = new Sprite(screen.getAtlas().findRegion("speedupL6").getTexture(), 1722, 0, 80, 80);
            speedups.setSize(80*((float) Gdx.graphics.getWidth()/1920f),80*((float) Gdx.graphics.getHeight()/1080f));
        }
        makeObj();
        body.setLinearDamping(1);
        speedups.setPosition(5000,4000);

    }
    public void makeObj(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set(0, 10000);
        body = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(speedups.getWidth()/200, speedups.getHeight()/200);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        Fixture fixture = body.createFixture(fdef);
        fixture.setSensor(true);
        fixture.setUserData("speedup");
        shape.dispose();
    }
    public void update(float dt) {
        if (screen.hudtimer > speeduptimer) {
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (speedups.getWidth() / 2) / gravtry2.PPM) || screen.speedupreposition) {
                    posX = (int) (screen.cam.position.x + screen.port.getWorldWidth() / 2 + rand.nextInt(100));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.speedupreposition = false;
                }
                body.setLinearDamping(1);
            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (speedups.getWidth() / 2) / gravtry2.PPM) || screen.speedupreposition) {
                    posX = (int) (screen.cam.position.x - screen.port.getWorldWidth() / 2 - rand.nextInt(100));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.speedupreposition = false;
                }
            }
            speedups.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - speedups.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - speedups.getHeight() / 2);
        }
    }

    public void draw(Batch batch){super.draw(batch);}


}
