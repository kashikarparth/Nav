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

public class antigrav extends Sprite {
    public Sprite getantigravs() {
        return antigravs;
    }
    private int antigravtimer = 0;
    public Body body;
    private World world;
    private gravtry2 game;
    public Playscreen screen;
    public player player;
    private Sprite antigravs;
    private float posY;
    private int posX;
    Random rand = new Random();

    public Sprite getAntigravs() {
        return antigravs;
    }

    public antigrav(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world = world;
        this.screen = screen;
        this.player = player;
        if(game.prefs.getInteger("currlevel") == 0 || game.prefs.getInteger("currlevel") == 1 || game.prefs.getInteger("currlevel") == 2){
            antigravs = new Sprite(screen.getAtlas().findRegion("antigravL0").getTexture(), 210, 0, 60, 60);
            antigravs.setSize(60*((float) Gdx.graphics.getWidth()/1920f),60*((float) Gdx.graphics.getHeight()/1080f));}
        if(game.prefs.getInteger("currlevel") == 3 || game.prefs.getInteger("currlevel") == 4 || game.prefs.getInteger("currlevel") == 5){
            antigravs = new Sprite(screen.getAtlas().findRegion("antigravL1").getTexture(), 150, 0, 60, 60);
            antigravs.setSize(60*((float) Gdx.graphics.getWidth()/1920f),60*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 6){
            antigravs = new Sprite(screen.getAtlas().findRegion("antigravL6").getTexture(), 30, 0, 60, 60);
            antigravs.setSize(60*((float) Gdx.graphics.getWidth()/1920f),60*((float) Gdx.graphics.getHeight()/1080f));
        }
        makeObj();

        antigravs.setPosition(5000,5000);
    }
    public void makeObj(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0,9400);
        body = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(antigravs.getWidth()/200, antigravs.getHeight()/200);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;

        Fixture fixture = body.createFixture(fdef);
        fixture.setUserData("antigrav");
        shape.dispose();
    }
    public void update(float dt) {
        if (screen.hudtimer > antigravtimer) {
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (antigravs.getWidth() / 2) / gravtry2.PPM) || screen.antigravreposition) {
                    posX = (int) (screen.cam.position.x + screen.port.getWorldWidth() / 2 + rand.nextInt(400) + 60);
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.antigravreposition = false;
                }
                body.setLinearDamping(1);

            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (antigravs.getWidth() / 2) / gravtry2.PPM) || screen.antigravreposition) {
                    posX = (int) (screen.cam.position.x - screen.port.getWorldWidth() / 2 - rand.nextInt(400) - 40);
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.antigravreposition = false;
                }
            }
            antigravs.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - antigravs.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - antigravs.getHeight() / 2);

        }
    }
    public void draw(Batch batch){super.draw(batch);}


}
