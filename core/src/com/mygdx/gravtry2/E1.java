package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.gravtry2.Playscreen;
import java.util.Random;


public class E1 extends Sprite {


    public Sprite getEnemy1s() {
        return enemy1s;
    }

    public Body body;
    private World world;
    public Playscreen screen;
    public player player;
    private Sprite enemy1s;
    private gravtry2 game;
    private int radius = 45;
    private int e1 = 400;
    private float border = 10;


    private float k = 7; //GRAVITY EFFECT///////////////////////////////////////////////////////////


    public Body getBody() {
        return body;
    }

    public E1(World world, Playscreen screen, player player, gravtry2 game) {
        this.game = game;
        this.world = world;
        this.screen = screen;
        this.player = player;
        makeObj();
        player.body.applyForceToCenter(getGravityVector(),true);

        if(game.prefs.getInteger("currlevel") == 0 || game.prefs.getInteger("currlevel") == 1 || game.prefs.getInteger("currlevel") == 2){
            enemy1s = new Sprite(screen.getAtlas().findRegion("EN1L0").getTexture(), 480, 80, 90, 90);
            enemy1s.setSize(90*((float) Gdx.graphics.getWidth()/1920f),90*((float) Gdx.graphics.getHeight()/1080f));}
        if(game.prefs.getInteger("currlevel") == 3 || game.prefs.getInteger("currlevel") == 4){
            enemy1s = new Sprite(screen.getAtlas().findRegion("EN1L1").getTexture(), 570, 80, 90, 90);
            enemy1s.setSize(90*((float) Gdx.graphics.getWidth()/1920f),90*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 5){
            enemy1s = new Sprite(screen.getAtlas().findRegion("EN1L5").getTexture(), 861, 80, 111, 111);
            enemy1s.setSize(90*((float) Gdx.graphics.getWidth()/1920f),90*((float) Gdx.graphics.getHeight()/1080f));
        }
        if(game.prefs.getInteger("currlevel") == 6){
            enemy1s = new Sprite(screen.getAtlas().findRegion("EN1L6").getTexture(), 750, 80, 111, 111);
            enemy1s.setSize(90*((float) Gdx.graphics.getWidth()/1920f),90*((float) Gdx.graphics.getHeight()/1080f));
        }
        enemy1s.setPosition(5000,5000);
    }

    public void update(float dt) {
        if(screen.hudtimer > e1) {
            enemy1s.setPosition(Gdx.graphics.getWidth() / 2 - 100 * screen.cam.position.x + body.getPosition().x * 100 - enemy1s.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * body.getPosition().y - 100 * screen.cam.position.y - enemy1s.getHeight() / 2);
            if (player.body.getLinearVelocity().x > 0) {
                if ((screen.cam.position.x - screen.port.getWorldWidth() / 2 > body.getPosition().x + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y - screen.port.getWorldHeight() / 2 - border > body.getPosition().y + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y + screen.port.getWorldHeight() / 2 + border < body.getPosition().y - (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM)) {
                    body.setLinearVelocity(0, 0);
                    body.setTransform((screen.cam.position.x + screen.port.getWorldWidth() / 2 + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM), randInt(0, Gdx.graphics.getHeight() / 100f), 0);
                }
            } else {
                if ((screen.cam.position.x + screen.port.getWorldWidth() / 2 < body.getPosition().x + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y - screen.port.getWorldHeight() / 2 - border > body.getPosition().y + (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM) || (screen.cam.position.y + screen.port.getWorldHeight() / 2 + border < body.getPosition().y - (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM)) {
                    body.setLinearVelocity(0, 0);
                    body.setTransform((screen.cam.position.x - screen.port.getWorldWidth() / 2 - (radius * ((float) Gdx.graphics.getWidth() / 1920f)) / gravtry2.PPM), randInt(0, Gdx.graphics.getHeight() / 100f), 0);
                }
            }
            world.clearForces();
            player.body.applyForceToCenter(getGravityVector(), true);
            player.body.applyForceToCenter(screen.obj2.getGravityVector(), true);
            body.setLinearDamping(1);
        }
    }

    public void makeObj() {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(4000, 40000);
        body = world.createBody(def);
        FixtureDef fdef = new FixtureDef();
        fdef.restitution = 0f;
        CircleShape circle = new CircleShape();
        circle.setRadius(radius*((float) Gdx.graphics.getWidth()/1920f)/ gravtry2.PPM);
        fdef.shape = circle;
        body.createFixture(fdef).setUserData("E1");
    }

    public void draw(Batch batch) {
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
