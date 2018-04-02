package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;


public class player extends Sprite {

    public Sprite getSprite() {
        return sprite;
    }

    public Body body;
    private gravtry2 game;
    private World world;
    public Playscreen screen;
    public int r = 0;
    private player player;
    public Vector2 velocity;
    private Sprite sprite;
    public float defaultvelocity = 8*(Gdx.graphics.getHeight()/1080f); //CHANGE IN PLAYSCREEN TOO////////////////

    public Body getBody() {
        return body;
    }

    public float getDefaultvelocity() {
        return defaultvelocity;
    }

    public player (World world, Playscreen screen, gravtry2 game) {
        this.world=world;
        this.screen=screen;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0, (240f*Gdx.graphics.getHeight()/1080f)/ gravtry2.PPM);
        body = world.createBody(def);
        FixtureDef fdef = new FixtureDef();
        CircleShape circle = new CircleShape();
        circle.setRadius(40*((float) Gdx.graphics.getHeight()/1080f)/ gravtry2.PPM);
        fdef.shape=circle;
        fdef.restitution = 0f;
        fdef.friction = 1f;
        body.createFixture(fdef).setUserData("Player");
        body.setLinearVelocity(0,0);
        if(game.prefs.getInteger("currsprite")==1) {
            if (game.prefs.getInteger("currlevel") == 6) {
                sprite = new Sprite(screen.getAtlas().findRegion("r1w").getTexture(), 1402, 0, 80, 80);
                sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
                sprite.setAlpha(0.8f);
            } else {
                sprite = new Sprite(screen.getAtlas().findRegion("r1b").getTexture(), 602, 0, 80, 80);
                sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
                sprite.setAlpha(0.8f);
            }
        }
        if(game.prefs.getInteger("currsprite")==2) {
            if (game.prefs.getInteger("currlevel") == 6) {
                sprite = new Sprite(screen.getAtlas().findRegion("r2w").getTexture(), 922, 0, 80, 80);
                sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
            } else {
                sprite = new Sprite(screen.getAtlas().findRegion("r2b").getTexture(), 1322, 0, 80, 80);
                sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
            }
        }
        if(game.prefs.getInteger("currsprite")==3) {
            sprite = new Sprite(screen.getAtlas().findRegion("r3b").getTexture(), 522, 0, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        if(game.prefs.getInteger("currsprite")==4) {
            sprite = new Sprite(screen.getAtlas().findRegion("r4w").getTexture(), 1162, 0, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        if(game.prefs.getInteger("currsprite")==5) {
            sprite = new Sprite(screen.getAtlas().findRegion("r5w").getTexture(), 1082, 0, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        if(game.prefs.getInteger("currsprite")==6) {
            sprite = new Sprite(screen.getAtlas().findRegion("r6b").getTexture(), 682, 0, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        if(game.prefs.getInteger("currsprite")==7) {
            sprite = new Sprite(screen.getAtlas().findRegion("r7b").getTexture(), 762, 0, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        if(game.prefs.getInteger("currsprite")==8) {
            sprite = new Sprite(screen.getAtlas().findRegion("r8b").getTexture(), 0, 80, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        if(game.prefs.getInteger("currsprite")==9) {
            sprite = new Sprite(screen.getAtlas().findRegion("r9b").getTexture(), 240, 80, 80, 80);
            sprite.setSize(80 * ((float) Gdx.graphics.getHeight() / 1080f), 80 * ((float) Gdx.graphics.getHeight() / 1080f));
        }
        sprite.setOriginCenter();
        sprite.setPosition(Gdx.graphics.getWidth()/2f - 40*((float) Gdx.graphics.getWidth()/1920f) - 400*((float) Gdx.graphics.getWidth()/1920f), 500f*((float) Gdx.graphics.getHeight()/1080f));
    }
    public void update(float dt){
        r++;
        body.setLinearVelocity(screen.speedchangevel, body.getLinearVelocity().y);

        if(screen.forward == true){
            defaultvelocity = 12*(Gdx.graphics.getHeight()/1080f);
        }
        if(screen.forward == false){
            defaultvelocity = -12*(Gdx.graphics.getHeight()/1080f);
        }

        if(body.getLinearVelocity().x>0){
        sprite.setRotation(-9*r);}
    else{sprite.setRotation(9*r);}

        if(screen.wall == true){
            if (body.getLinearVelocity().x >= defaultvelocity) {
                screen.speedchangevel -= 5f;
            }
            if (body.getLinearVelocity().x < defaultvelocity) {
                screen.speedchangevel += 5f;
            }
        }
        if(screen.wall == false){
            if (body.getLinearVelocity().x >= defaultvelocity) {
                screen.speedchangevel -= 0.05f;
            }
            if (body.getLinearVelocity().x < defaultvelocity) {
                screen.speedchangevel += 0.05f;
            }
        }

    }


    public void draw(Batch batch){

        super.draw(batch);
    }

}
