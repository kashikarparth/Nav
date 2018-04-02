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

public class life extends Sprite {
    public Sprite getLifes() {
        return lifes;
    }
    private int lifetimer = 400;
    public Body body;
    private World world;
    public Playscreen screen;
    public player player;
    private Texture life;
    private gravtry2 game;
    private Rectangle rectangle;
    private Sprite lifes;
    private float posY;
    private int posX;
    Random rand = new Random();



    public life(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world = world;
        this.screen = screen;
        this.player = player;

        if(game.prefs.getInteger("currlevel") == 0 || game.prefs.getInteger("currlevel") == 1 || game.prefs.getInteger("currlevel") == 2){
        lifes = new Sprite(screen.getAtlas().findRegion("lifeL0").getTexture(), 390, 0, 60, 60);
        lifes.setSize(60*((float) Gdx.graphics.getWidth()/1920f),60*((float) Gdx.graphics.getHeight()/1080f));}
        if(game.prefs.getInteger("currlevel") == 3 || game.prefs.getInteger("currlevel") == 4 || game.prefs.getInteger("currlevel") == 5){
            lifes = new Sprite(screen.getAtlas().findRegion("lifeL1").getTexture(), 270, 0, 60, 60);
            lifes.setSize(60*((float) Gdx.graphics.getWidth()/1920f),60*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 6){
            lifes = new Sprite(screen.getAtlas().findRegion("lifeL6").getTexture(), 330, 0, 60, 60);
            lifes.setSize(60*((float) Gdx.graphics.getWidth()/1920f),60*((float) Gdx.graphics.getHeight()/1080f));
        }
        makeObj();
        lifes.setPosition(10000,10000);

    }
    public void makeObj(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0, 1200);
        body = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(lifes.getWidth()/200, lifes.getHeight()/200);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        Fixture fixture = body.createFixture(fdef);
        fixture.setUserData("life");
        shape.dispose();
    }
    public void update(float dt) {
        if (screen.hudtimer > lifetimer) {
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (lifes.getWidth() / 2) / gravtry2.PPM) || screen.lifereposition) {
                    posX = (int) (screen.cam.position.x + screen.port.getWorldWidth() / 2 + rand.nextInt(30));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.lifereposition = false;
                }
                body.setLinearDamping(1);
            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (lifes.getWidth() / 2) / gravtry2.PPM) || screen.lifereposition) {
                    posX = (int) (screen.cam.position.x - screen.port.getWorldWidth() / 2 - rand.nextInt(30));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.lifereposition = false;
                }
            }
            lifes.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - lifes.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - lifes.getHeight() / 2);
        }
    }


    public void draw(Batch batch){super.draw(batch);}


}
