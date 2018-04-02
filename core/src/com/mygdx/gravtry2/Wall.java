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
 * Created by Parth on 1/04/2017.
 */

public class Wall extends Sprite {
    public Sprite getwalls() {
        return walls;
    }

    public Body body;
    private World world;
    public Playscreen screen;
    private Texture wall;
    private int walltimer = 1200;
    private Sprite walls;
    private float posY;
    private player player;
    private int posX;
    private gravtry2 game;
    Random rand = new Random();

    public Wall(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world = world;
        this.screen = screen;
        this.player = player;
        if(game.prefs.getInteger("currlevel") != 6){
        walls = new Sprite(screen.getAtlas().findRegion("wall").getTexture(), 115, 195, 80, 200);
        walls.setSize(80*((float) Gdx.graphics.getWidth()/1920f), 400*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 6){
            walls = new Sprite(screen.getAtlas().findRegion("wallL6").getTexture(), 195, 195, 80, 200);
            walls.setSize(80*((float) Gdx.graphics.getWidth()/1920f), 400*((float) Gdx.graphics.getHeight()/1080f));
        }
        walls.setPosition(1000,4000);
        makeObj();

    }
    public void makeObj(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(10,4000);
        body = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(walls.getWidth()/200f, walls.getHeight()/200f);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        Fixture fixture = body.createFixture(fdef);
        fixture.setUserData("wall");
        shape.dispose();
    }
    public void update(float dt) {
        if (screen.hudtimer > walltimer) {
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (walls.getWidth() / 2) / gravtry2.PPM) || screen.lifereposition) {
                    posX = (int) (screen.cam.position.x + screen.port.getWorldWidth() / 2 + rand.nextInt(100));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.lifereposition = false;
                }
                body.setLinearDamping(1);
            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (walls.getWidth() / 2) / gravtry2.PPM) || screen.lifereposition) {
                    posX = (int) (screen.cam.position.x - screen.port.getWorldWidth() / 2 - rand.nextInt(10));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.lifereposition = false;
                }
            }
            walls.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - walls.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - walls.getHeight() / 2);
            body.setLinearDamping(10);
        }
    }

    public void draw(Batch batch){super.draw(batch);}


}