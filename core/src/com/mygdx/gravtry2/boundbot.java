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
//////////////////////////////////////////DONE//////////////////////////////////////////////////////
public class boundbot extends Sprite {
    public Sprite getBotbgs() {
        return botbgs;
    }

    public Body body;
    private World world;
    public Playscreen screen;
    public player player;
    private Texture botbg;
    private Sprite botbgs;
    private gravtry2 game;
    public boundbot(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world=world;
        this.screen=screen;
        this.player = player;
        BodyDef bot = new BodyDef();
        bot.type = BodyDef.BodyType.StaticBody;
        bot.position.set(0, 0);
        body = world.createBody(bot);
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(100, 0.01f);
        FixtureDef polyfixture = new FixtureDef();
        polyfixture.shape = poly;
        polyfixture.friction=0.8f;
        polyfixture.restitution=0f;
        body.createFixture(polyfixture).setUserData("boundbot");
        if(game.prefs.getInteger("currlevel") == 0 == true){
            botbg = new Texture("botbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 1 == true){
            botbg = new Texture("botbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 2 == true){
            botbg = new Texture("botbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 3 == true){
            botbg = new Texture("botbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 4 == true){
            botbg = new Texture("botbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 5 == true){
            botbg = new Texture("botbgL0.png");
        }
        if(game.prefs.getInteger("currlevel") == 6 == true){
            botbg = new Texture("botbgL6.PNG");
        }
        botbgs = new Sprite(botbg, 0, 0, botbg.getWidth(), botbg.getHeight());
        botbgs.setSize(botbg.getWidth()*((float) Gdx.graphics.getWidth()/1920f),botbg.getHeight()*((float) Gdx.graphics.getHeight()/1080f));
        botbgs.setAlpha(0.6f);
    }
    public void update(float dt){
        botbgs.setPosition(0, Gdx.graphics.getHeight()/2 + 100*body.getPosition().y -100*screen.cam.position.y-botbgs.getHeight());
        if(player.body.getLinearVelocity().x > 0){
            if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + Gdx.graphics.getWidth()/200f)) {
                body.setTransform(screen.cam.position.x + screen.port.getWorldWidth() / 2 + Gdx.graphics.getHeight()/200f, 0, 0);
            }
            body.setLinearDamping(1);
        }
        else{
            if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + + Gdx.graphics.getWidth()/200f)) {
                body.setTransform(screen.cam.position.x + screen.port.getWorldWidth() / 2 + Gdx.graphics.getHeight()/200f, 0, 0);
            }
        }
    }

    public void draw(Batch batch){
        super.draw(batch);
    }
}