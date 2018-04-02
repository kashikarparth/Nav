package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Parth on 3/27/2017.
 */

public class orbit extends Sprite {
    float f1= (1408f/1920f)* Gdx.graphics.getWidth();
    float f2 = ((1080f-445f)/1080f)*Gdx.graphics.getHeight();
    public Body body;
    private Texture orbit;
    private World world;
    private Sprite sprite;
    public orbit(World world){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(f1,f2);
        body = world.createBody(bdef);
        this.world = world;
        FixtureDef fdef = new FixtureDef();
        CircleShape circle = new CircleShape();
        circle.setRadius(72*((float) Gdx.graphics.getWidth()/1920f)/ gravtry2.PPM);
        fdef.shape=circle;
        body.createFixture(fdef);
        body.setLinearVelocity(0,0);
        orbit = new Texture("orbit.PNG");
        sprite = new Sprite(orbit);
        sprite.setPosition(body.getPosition().x*gravtry2.PPM,body.getPosition().y*gravtry2.PPM);
    }
    public void update(float dt){

    }
    public void draw(Batch batch){

        super.draw(batch);
    }

}
