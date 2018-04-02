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


public class slowdown extends Sprite {
    public Sprite getSlowdowns() {
        return slowdowns;
    }

    public Body body;
    private World world;
    public Playscreen screen;
    private int slowdowntimer;
    public player player;
  //  private Texture slowdown;
    private Rectangle rectangle;
    private Sprite slowdowns;
    private gravtry2 game;
    private float posY;
    private int posX;
    Random rand = new Random();




    public slowdown(World world, Playscreen screen, player player, gravtry2 game){
        this.game = game;
        this.world = world;
        this.screen = screen;
        this.player = player;
        /*
        if(game.prefs.getInteger("currlevel") == 0 == true){
            slowdown = new Texture("slowdownL0.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 1 == true){
            slowdown = new Texture("slowdownL0.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 2 == true){
            slowdown = new Texture("slowdownL0.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 3 == true){
            slowdown = new Texture("slowdownL1.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 4 == true){
            slowdown = new Texture("slowdownL1.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 5 == true){
            slowdown = new Texture("slowdownL1.PNG");
        }
        if(game.prefs.getInteger("currlevel") == 6 == true){
            slowdown = new Texture("slowdownL1.PNG");
        }
        */
        if(game.prefs.getInteger("currlevel") == 0 || game.prefs.getInteger("currlevel") == 1 || game.prefs.getInteger("currlevel") == 2){
            slowdowns = new Sprite(screen.getAtlas().findRegion("slowdownL0").getTexture(), 80, 80, 80, 80);
            slowdowns.setSize(80*((float) Gdx.graphics.getWidth()/1920f),80*((float) Gdx.graphics.getHeight()/1080f));}
        if(game.prefs.getInteger("currlevel") == 3 || game.prefs.getInteger("currlevel") == 4 || game.prefs.getInteger("currlevel") == 5){
            slowdowns = new Sprite(screen.getAtlas().findRegion("slowdownL1").getTexture(), 1882, 0, 80, 80);
            slowdowns.setSize(80*((float) Gdx.graphics.getWidth()/1920f),80*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 6){
            slowdowns = new Sprite(screen.getAtlas().findRegion("slowdownL6").getTexture(), 1482, 0, 80, 80);
            slowdowns.setSize(80*((float) Gdx.graphics.getWidth()/1920f),80*((float) Gdx.graphics.getHeight()/1080f));
        }
        makeObj();
        slowdowns.setPosition(4000,2000);

    }
    public void makeObj(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0, 13400);
        body = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(slowdowns.getWidth()/200, slowdowns.getHeight()/200);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        Fixture fixture = body.createFixture(fdef);
        fixture.setSensor(true);
        fixture.setUserData("slowdown");
        shape.dispose();
    }
    public void update(float dt) {
        if (screen.hudtimer > slowdowntimer) {
            slowdowns.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - slowdowns.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - slowdowns.getHeight() / 2);
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (slowdowns.getWidth() / 2) / gravtry2.PPM) || screen.slowdownreposition) {
                    posX = (int) (screen.cam.position.x + screen.port.getWorldWidth() / 2 + rand.nextInt(150));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.slowdownreposition = false;
                }
                body.setLinearDamping(1);
            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (slowdowns.getWidth() / 2) / gravtry2.PPM) || screen.slowdownreposition) {
                    posX = (int) (screen.cam.position.x - screen.port.getWorldWidth() / 2 - rand.nextInt(150));
                    posY = rand.nextInt(1000) / 100f;
                    body.setTransform(posX, Gdx.graphics.getHeight() / (posY * gravtry2.PPM), 0);
                    screen.slowdownreposition = false;
                }
            }
            slowdowns.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - slowdowns.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - slowdowns.getHeight() / 2);
        }
    }
    public void draw(Batch batch){super.draw(batch);}


}
