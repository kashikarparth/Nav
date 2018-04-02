package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.gravtry2.Playscreen;

import java.util.Random;

/**
 * Created by Parth on 2/20/2017.
 */

public class E2 extends Sprite {
    public Animation getAnimation() {
        return animation;
    }

    public Sprite getEnemy2s() {
        return enemy2s;
    }

    public Body body;
    private World world;
    public Playscreen screen;
    public player player;
    private int radius = 45;
    private float k = 7; //GRAVITY EFFECT///////////////////////////////////////////////////////////
    private float border = 10;
    private int e2 = 600;

    private Texture enemy2;
    private gravtry2 game;
    private Sprite enemy2s;
    private TextureAtlas textureAtlas;
    private Animation animation;
    Random rand = new Random();


    public E2(World world, Playscreen screen, player player, gravtry2 game) {
        this.game = game;
        this.world=world;
        this.screen=screen;
        this.player = player;
        makeObj();
        player.body.applyForceToCenter(getGravityVector(),true);

        if(game.prefs.getInteger("currlevel") == 0 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL1.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }
        if(game.prefs.getInteger("currlevel") == 1 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL1.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }
        if(game.prefs.getInteger("currlevel") == 2 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL1.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }
        if(game.prefs.getInteger("currlevel") == 3 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL0.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }
        if(game.prefs.getInteger("currlevel") == 4 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL0.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }
        if(game.prefs.getInteger("currlevel") == 5 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL5.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }
        if(game.prefs.getInteger("currlevel") == 6 == true){
            textureAtlas = new TextureAtlas(Gdx.files.internal("obj2animL6.txt"));
            animation = new Animation(1f/20f, textureAtlas.getRegions());
        }


        enemy2 = new Texture("en2.PNG");
        enemy2s = new Sprite(enemy2, 0,  0, 90,90);
        enemy2s.setSize(90*((float) Gdx.graphics.getWidth()/1920f),90*((float) Gdx.graphics.getWidth()/1920f));
        enemy2s.setPosition(4000,50000);

    }
    public void update(float dt) {
        if(screen.hudtimer > e2) {
            enemy2s.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - enemy2s.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - enemy2s.getHeight() / 2);
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y - screen.port.getWorldHeight() / 2 - border > body.getPosition().y + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y + screen.port.getWorldHeight() / 2 + border < body.getPosition().y - (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM)) {
                    body.setLinearVelocity(0, 0);
                    if (player.body.getLinearVelocity().x > 0) {
                        body.setLinearVelocity(-rand.nextInt(22), -rand.nextInt(22));
                    }
                    if (player.body.getLinearVelocity().x < 0) {
                        body.setLinearVelocity(rand.nextInt(22), rand.nextInt(22));
                    }
                    body.setTransform((screen.cam.position.x + screen.port.getWorldWidth() / 2 + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM), randInt(0, Gdx.graphics.getHeight() / 100f), 0);
                }
            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y - screen.port.getWorldHeight() / 2 - border > body.getPosition().y + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y + screen.port.getWorldHeight() / 2 + border < body.getPosition().y - (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM)) {
                    body.setLinearVelocity(0, 0);
                    if (player.body.getLinearVelocity().x > 0) {
                        body.setLinearVelocity(-rand.nextInt(15), -rand.nextInt(15));
                    }
                    if (player.body.getLinearVelocity().x < 0) {
                        body.setLinearVelocity(rand.nextInt(15), rand.nextInt(15));
                    }
                    body.setTransform((screen.cam.position.x - screen.port.getWorldWidth() / 2 - (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM), randInt(0, Gdx.graphics.getHeight() / 100f), 0);
                }
            }

            world.clearForces();

            player.body.applyForceToCenter(getGravityVector(), true);
            player.body.applyForceToCenter(screen.obj1.getGravityVector(), true);
            body.setLinearDamping(1);
        }
    }


    public void makeObj(){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0, 1110);
        body = world.createBody(def);
        FixtureDef fdef = new FixtureDef();
        fdef.restitution = 0.4f;
        CircleShape circle = new CircleShape();
        circle.setRadius(radius*((float) Gdx.graphics.getWidth()/1920f)/ gravtry2.PPM);
        fdef.shape=circle;
        body.createFixture(fdef).setUserData("E2");
    }

    public void draw(Batch batch){

        super.draw(batch);
    }
    public Vector2 getGravityVector() {
        float sin = (body.getPosition().y - player.body.getPosition().y) / HypotPower();
        return new Vector2(0f, (float) (k*1.2*sin/ gravtry2.PPM));
    }
    public float HypotPower(){
        return (float) Math.pow(Math.pow((body.getPosition().y - player.body.getPosition().y)/ gravtry2.PPM,2) +Math.pow((body.getPosition().x - player.body.getPosition().x)/ gravtry2.PPM,2),(0.66));
    }
    public static float randInt(float min, float max) {

        Random rand = new Random();

        float result = rand.nextFloat() * (max - min) + min;

        return result;

    }

}
