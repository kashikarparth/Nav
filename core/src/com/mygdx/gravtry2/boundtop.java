package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by akhauri on 3/16/2017.
 */

public class boundtop extends Sprite {
    public Sprite getTopbgs() {
        return topbgs;
    }

    public Body body;
    private World world;
    private gravtry2 game;
    public Playscreen screen;
    public player player;

    private Texture topbg;
    private Sprite topbgs;
    public boundtop(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world=world;
        this.screen=screen;
        this.player = player;
        BodyDef top = new BodyDef();
        top.type = BodyDef.BodyType.StaticBody;
        top.position.set(0, 1.2f*Gdx.graphics.getHeight()/100f);
        body = world.createBody(top);
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(100f, 0.01f);
        FixtureDef polyfixture = new FixtureDef();
        polyfixture.shape = poly;
        polyfixture.friction=0.8f;
        polyfixture.restitution=0f;
        body.createFixture(polyfixture).setUserData("boundtop");
        if(game.prefs.getInteger("currlevel") == 0 == true){
            topbg = new Texture("topbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 1 == true){
            topbg = new Texture("topbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 2 == true){
            topbg = new Texture("topbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 3 == true){
            topbg = new Texture("topbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 4 == true){
            topbg = new Texture("topbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 5 == true){
            topbg = new Texture("topbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 6 == true){
            topbg = new Texture("topbgL6.PNG");
        }
        topbgs = new Sprite(topbg, 0, 0, topbg.getWidth(), topbg.getHeight());
        topbgs.setSize(topbg.getWidth()*((float) Gdx.graphics.getWidth()/1920f),topbg.getHeight()*((float) Gdx.graphics.getHeight()/1080f));
        topbgs.setAlpha(0.6f);
    }
    public void update(float dt) {
        topbgs.setPosition(0, Gdx.graphics.getHeight()/2 + 100*body.getPosition().y -100*screen.cam.position.y);
        if(player.body.getLinearVelocity().x > 0){
            if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (topbgs.getWidth() / 2) / gravtry2.PPM)) {
                body.setTransform(screen.cam.position.x + screen.port.getWorldWidth() / 2 + Gdx.graphics.getHeight()/200f, 1.2f*Gdx.graphics.getHeight()/100f, 0);
            }
            body.setLinearDamping(1);
        }
        else{
            if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (topbgs.getWidth() / 2) / gravtry2.PPM)) {
                body.setTransform(screen.cam.position.x + screen.port.getWorldWidth() / 2 + Gdx.graphics.getHeight()/200f, 1.2f*Gdx.graphics.getHeight()/100f, 0);
            }
        }
    }

    public void draw(Batch batch){
        super.draw(batch);
    }
}