package com.mygdx.gravtry2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.GL20;
import java.util.Random;
import box2dLight.ConeLight;
import box2dLight.RayHandler;

public class Playscreen implements Screen {
    public TextureAtlas getAtlas() {
        return atlas;
    }

    //      SOUND EFFECTS
    public Sound antigravsound;
    public Sound enemysound;
    public Sound lifesound;
    public Sound slowdownsound;
    public Sound speedupsound;

    private Wall walls;

    private MenuScreen menuScreen;
    public gravtry2 game;
    public OrthographicCamera cam;
    public Viewport port;
    private World world;
    private Hud hud;
    private Replayscreen replayscreen;
    public E1 obj1;
    public E2 obj2;
    public int lives = 7;
    public int coins = 0;
    private float elapsedtime2 = 0f;
    public int hudtimer = 0;
    private int boundtoptime = 0;
    private int boundbottime = 0;
    private int E1time = 0;
    private Texture antigravswipe;
    private Texture antigravswipe1;
    private Sprite antigravswipes;
    private Sprite antigravswipe1s;
    public boolean speedupreposition = false;
    public boolean slowdownreposition = false;
    public boolean antigravreposition = false;
    public boolean lifereposition = false;
    public boolean antigravactive = false;
    public float speedchangevel = 12;

    public boolean wall = false;
    public int walltime = 0;


    int i;int j;int k;int c;
    public float x5=0,x1=0,x2=0,x3=0,x4=0;
    public float y5=0, y1=0, y2=0, y3=0, y4=0;

    private RayHandler rayHandler;
    private ConeLight coneLight;
    private ConeLight cone2Light;
    private RayHandler cone2LightrayHandler;
    private Texture follow;
    private Texture speedupswipe;
    private Sprite speedupswipes;
    private boolean speedupswipeboolean;
    private Texture slowdownswipe;
    private Sprite slowdownswipes;
    private boolean slowdownswipeboolean;
////POWERUPS
    public float invincibilitytimer = 0;
    public boolean invincibilityboolean = false;
    public speedup speedup;
    public slowdown slowdown;
    public life life;
    public antigrav antigrav;
    public boundtop boundtop;
    public boundbot boundbot;
    private player player;
    public int antigravcounter = 0;
    private float elapsedtime = 0f;
    private int kfast;
    public int revtime;
    private int kslow;
    private int sound,kanti,kanti2 = 0;


    public boolean forward = true;
    Random rand = new Random();


    //TEXTUREPACKER
    public TextureAtlas atlas;

    public Playscreen(gravtry2 game) {
        this.game = game;
        cam = new OrthographicCamera();
        atlas = new TextureAtlas("pack.txt");
        port = new FitViewport(Gdx.graphics.getWidth() / gravtry2.PPM, Gdx.graphics.getHeight() / gravtry2.PPM, cam);
        cam.position.set((port.getWorldWidth() / 2), (port.getWorldHeight() / 2), 0);
        world = new World(new Vector2(0, 0), true);
        if(game.prefs.getInteger("currsprite") == 1) {
            follow = new Texture(Gdx.files.internal("follow1.png"));
        }
        if(game.prefs.getInteger("currsprite") == 2) {
            follow = new Texture(Gdx.files.internal("follow2.png"));
        }
        if(game.prefs.getInteger("currsprite") == 3) {
            follow = new Texture(Gdx.files.internal("follow3.png"));
        }
        if(game.prefs.getInteger("currsprite") == 4) {
            follow = new Texture(Gdx.files.internal("follow4.png"));
        }
        if(game.prefs.getInteger("currsprite") == 5) {
            follow = new Texture(Gdx.files.internal("follow5.png"));
        }
        if(game.prefs.getInteger("currsprite") == 6) {
            follow = new Texture(Gdx.files.internal("follow6.png"));
        }
        if(game.prefs.getInteger("currsprite") == 7) {
            follow = new Texture(Gdx.files.internal("follow7.png"));
        }
        if(game.prefs.getInteger("currsprite") == 8) {
            follow = new Texture(Gdx.files.internal("follow8.png"));
        }
        if(game.prefs.getInteger("currsprite") == 9) {
            follow = new Texture(Gdx.files.internal("follow9.png"));
        }
        i = 0;
        j = 0;
        k = 0;
        c = i -1;
        if (game.prefs.getInteger("sound") == 1) {
            antigravsound = Gdx.audio.newSound(Gdx.files.internal("antigrav.wav"));
            enemysound = Gdx.audio.newSound(Gdx.files.internal("enemy.wav"));
            lifesound = Gdx.audio.newSound(Gdx.files.internal("life.wav"));
            slowdownsound = Gdx.audio.newSound(Gdx.files.internal("slowdown.wav"));
            speedupsound = Gdx.audio.newSound(Gdx.files.internal("speedup.wav"));
        }
        sound = game.prefs.getInteger("sound");
        speedupswipe = new Texture("speedupswipe.PNG");
        antigravswipe = new Texture("antigravswipe.PNG");
        antigravswipe1 = new Texture("antigravswipe.PNG");
        slowdownswipe = new Texture("slowdownswipe.PNG");
        antigravswipes = new Sprite(antigravswipe, antigravswipe.getWidth(), antigravswipe.getHeight());
        antigravswipes.setSize(antigravswipe.getWidth()*(Gdx.graphics.getWidth()/1920f),antigravswipe.getHeight()*(Gdx.graphics.getHeight()/1080f));
        antigravswipe1s = new Sprite(antigravswipe,antigravswipe.getWidth(), antigravswipe.getHeight());
        antigravswipe1s.setSize(antigravswipe.getWidth()*Gdx.graphics.getWidth()/1920f,antigravswipe.getHeight()*Gdx.graphics.getHeight()/1080f);
        slowdownswipes = new Sprite(slowdownswipe,slowdownswipe.getWidth(), slowdownswipe.getHeight());
        slowdownswipes.setSize(slowdownswipe.getWidth()*Gdx.graphics.getWidth()/1920f, slowdownswipe.getHeight()*Gdx.graphics.getHeight()/1080f);
        speedupswipes = new Sprite(speedupswipe,speedupswipe.getWidth(), speedupswipe.getHeight());
        speedupswipes.setSize(speedupswipe.getWidth()*Gdx.graphics.getWidth()/1920f, speedupswipe.getHeight()*Gdx.graphics.getHeight()/1080f);
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fa = contact.getFixtureA();
                Fixture fb = contact.getFixtureB();
                if(((fa.getUserData() == "speedup")&&(fb.getUserData() =="Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="speedup"))){
                    speedupreposition = true;
                    speedchangevel = player.defaultvelocity + 10*(Gdx.graphics.getHeight()/1080f);
                    speedupswipeboolean = true;
                    kfast = 0;
                    if(sound==1){
                    speedupsound.play(0.1f);
                    }
                    }
                if(((fa.getUserData() == "slowdown")&&(fb.getUserData() =="Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="slowdown"))){
                    slowdownreposition = true;
                    speedchangevel = player.defaultvelocity - 10*(Gdx.graphics.getHeight()/1080f);
                    slowdownswipeboolean = true;
                    kslow = 0;
                    if(sound==1) {
                        slowdownsound.play(0.1f);
                    }
                }
                if(((fa.getUserData()=="Player"&&((fb.getUserData()=="E1")||(fb.getUserData()=="E2"))))){
                    if (sound == 1) {
                        enemysound.play(0.1f);
                    }
                    if(invincibilityboolean == false){lives -= 1;}
                    invincibilityboolean = true;
                }
                if(((fb.getUserData()=="Player"&&((fa.getUserData()=="E1")||(fa.getUserData()=="E2"))))){
                    enemysound.play(0.1f);

                    if(invincibilityboolean == false){lives -= 1;}
                    invincibilityboolean = true;
                }
                if(((fa.getUserData() == "life") && (fb.getUserData() == "Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="life"))){
                    lifereposition = true;
                    lives += 1;
                    if(sound == 1) {
                        lifesound.play(0.1f);
                    }
                }
                if(((fa.getUserData() == "antigrav") && (fb.getUserData() == "Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="antigrav"))){
                    antigravreposition = true;
                    antigravsound.play(0.1f);
                    antigravactive = true;
                    kanti = 0;
                    }
                if(((fa.getUserData() == "Player")&&(fb.getUserData()=="wall"))||((fb.getUserData() =="Player")&&(fa.getUserData()=="wall"))) {
                    wall = true;
                    forward = !forward;
                }
                if(((fa.getUserData() == "boundtop") && (fb.getUserData() == "Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="boundtop"))) {
                    boundtop.getTopbgs().setAlpha(1);
                }
                if(((fa.getUserData() == "boundbot") && (fb.getUserData() == "Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="boundbot"))) {
                    boundbot.getBotbgs().setAlpha(1f);
                }
                }

            @Override
            public void endContact(Contact contact) {
                Fixture fa = contact.getFixtureA();
                Fixture fb = contact.getFixtureB();
                if(((fa.getUserData() == "boundtop") && (fb.getUserData() == "Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="boundtop"))) {
                    boundtop.getTopbgs().setAlpha(0.6f);
                }
                if(((fa.getUserData() == "boundbot") && (fb.getUserData() == "Player"))||((fa.getUserData() == "Player")&&(fb.getUserData()=="boundbot"))) {
                    boundbot.getBotbgs().setAlpha(0.6f);
                }
            }
            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {            }
            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
                Fixture fa = contact.getFixtureA();
                Fixture fb = contact.getFixtureB();
                if(((fa.getUserData()=="Player"&&((fb.getUserData()=="E1")||(fb.getUserData()=="E2"))))){
                    E1time++;
                    if(E1time > 200){
                        lives -= 1;
                        E1time = 0;
                    }
                }
                if(((fb.getUserData()=="Player"&&((fa.getUserData()=="E1")||(fa.getUserData()=="E2"))))){
                    E1time++;
                    if(E1time > 200){
                        lives -= 1;
                        E1time = 0;
                    }
                }
                if(((fa.getUserData() == "Player")&&(fb.getUserData()=="boundbot"))||((fb.getUserData() =="Player")&&(fa.getUserData()=="boundbot"))) {
                    boundbottime++;
                    if(boundbottime > 200){
                        lives -= 1;
                        boundbottime = 0;
                    }
                }
                if(((fa.getUserData() == "Player")&&(fb.getUserData()=="boundtop"))||((fb.getUserData() =="Player")&&(fa.getUserData()=="boundtop"))) {
                    boundtoptime++;
                    if(boundtoptime > 200){
                        lives -= 1;
                        boundtoptime = 0;
                    }
                }
            }
        });
        player = new player(world, this, game);
        obj1 = new E1(world, this, player, game);
        obj2 = new E2(world, this, player, game);
        speedup = new speedup(world, this, player, game);
        slowdown = new slowdown(world, this, player, game);
        life = new life(world, this, player, game);
        antigrav = new antigrav(world, this, player, game);
        boundtop = new boundtop(world, this, player, game);
        boundbot = new boundbot(world, this, player, game);
        menuScreen = new MenuScreen(game);
        walls =  new Wall(world, this, player, game);

        cone2LightrayHandler = new RayHandler(world);
        cone2LightrayHandler.setAmbientLight(0.9f);
        cone2Light = new ConeLight(cone2LightrayHandler, 150, Color.BLACK, 15, 5.2f * ((float) Gdx.graphics.getWidth() / 1920f), 5f * ((float) Gdx.graphics.getHeight() / 1080f), 0, 50);
        cone2Light.setSoftnessLength(0.2f);
        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(1f);
        coneLight = new ConeLight(rayHandler, 150, Color.BLACK, 20, 5.2f * ((float) Gdx.graphics.getWidth() / 1920f), 5f * ((float) Gdx.graphics.getHeight() / 1080f), 0, 35);
        replayscreen = new Replayscreen(game);
        hud = new Hud(game.batch);
    }

    public void update(float dt) {
        hud.life = lives;
        hud.coins = coins;
        hud.score = hudtimer;
        if(wall == true) {
            walltime++;
            if (walltime > 8) {
                wall = false;
                walltime = 0;
            }
            else {
            }
            }
        revtime++;
        world.step(1 / 60f, 6, 2);
        if(invincibilityboolean == true){        invincibilitytimer += dt;  }
        if(invincibilitytimer > 2.5f){
            invincibilityboolean = false;
            invincibilitytimer = 0f;
        }
        if(hudtimer < 2600){
        elapsedtime2 = 0f;}
            if(hudtimer > 2600){
            if(rand.nextInt(50) > 25){
                if(elapsedtime2<0.8f){
                    elapsedtime2 += 0.6*dt;
                    rayHandler.setAmbientLight(1-elapsedtime2);
                }
            }
        }
        if(hudtimer > 4000){
            rayHandler.setAmbientLight(1);
        }
        if(hudtimer < 6000 && hudtimer > 4000){
            elapsedtime2 = 0f;}
        if(hudtimer > 6000){
            if(rand.nextInt(50) > 25){
                if(elapsedtime2<0.8f){
                    elapsedtime2 += 0.6*dt;
                    rayHandler.setAmbientLight(1-elapsedtime2);
                }
            }
        }
        if(hudtimer > 10000){
            rayHandler.setAmbientLight(1);
        }
        if(hudtimer < 15000 && hudtimer > 10000){
            elapsedtime2 = 0f;}
        if(hudtimer > 15000){
            if(rand.nextInt(50) > 25){
                if(elapsedtime2<0.8f){
                    elapsedtime2 += 0.6*dt;
                    rayHandler.setAmbientLight(1-elapsedtime2);
                }
            }
        }
        if(hudtimer > 18000){
            rayHandler.setAmbientLight(1);
        }

        speedupswipes.setPosition(15*kfast++ , 0);
        slowdownswipes.setPosition(Gdx.graphics.getHeight() - 15*kslow++, 0);
        antigravswipes.setPosition(0,15*kanti++);
        antigravswipe1s.setPosition(0,kanti2-=20);

        if(lives == 0){
            game.prefs.putInteger("coins", game.prefs.getInteger("coins", 0)+hudtimer);
            game.prefs.putInteger("currscore", hudtimer);
            game.prefs.flush();
            if(hudtimer > game.prefs.getInteger("score", 0)){
                    game.prefs.putInteger("score", hudtimer);
                    game.prefs.flush();
            }
                game.setScreen(new Replayscreen(game));
                this.dispose();
        }
        if(game.prefs.getInteger("shadows") == 1) {
            cone2LightrayHandler.update();
            cone2LightrayHandler.setCombinedMatrix(cam.combined);
            cone2Light.setPosition((player.body.getPosition().x), player.body.getPosition().y);
            if (player.body.getLinearVelocity().x < 0) {
                cone2Light.setDirection(180-player.body.getLinearVelocity().y);
            }
            if (player.body.getLinearVelocity().x > 0) {
                cone2Light.setDirection(player.body.getLinearVelocity().y);
            }
        }
        rayHandler.update();
        rayHandler.setCombinedMatrix(cam.combined);
        coneLight.setPosition(player.body.getPosition().x, player.body.getPosition().y);
        if(player.body.getLinearVelocity().x<0){
            coneLight.setDirection(180-player.body.getLinearVelocity().y);
        }
        if(player.body.getLinearVelocity().x>0){
        coneLight.setDirection(player.body.getLinearVelocity().y);}

        cam.position.set((player.body.getPosition().x + 4f * ((float) Gdx.graphics.getWidth() / 1920f)), player.body.getPosition().y, 0);

        cam.update();
        obj1.update(dt);
        obj2.update(dt);
        speedup.update(dt);
            slowdown.update(dt);
            life.update(dt);

        antigrav.update(dt);
        if(antigravactive == false){
        handleInput(dt);
            antigravcounter=0;
        }
        if(antigravactive == true){
            if(antigravcounter<300){
            handleInput2(dt);
            }
            if(antigravcounter >= 300){
                antigravactive = false;
                kanti2 = Gdx.graphics.getHeight();
                handleInput(dt);
            }
        }

        walls.update(dt);
        player.update(dt);
        hud.update(dt);
        if(k%8==0){
            if(player.body.getLinearVelocity().x>0) {
                hudtimer += player.body.getLinearVelocity().x / 2;
            }
            else{
                hudtimer += -1*player.body.getLinearVelocity().x / 2;
            }
            if(i==5){
                i = 0;
            }
            if(i == 0){
                x1 = player.body.getPosition().x;
                y1 = player.body.getPosition().y;
            }
            if(i == 1){
                x2 = player.body.getPosition().x;
                y2 = player.body.getPosition().y;
            }
            if(i == 2){
                x3 = player.body.getPosition().x;
                y3 = player.body.getPosition().y;
            }
            if(i == 3){
                x4 = player.body.getPosition().x;
                y4 = player.body.getPosition().y;
            }
            if(i == 4){
                x5 = player.body.getPosition().x;
                y5 = player.body.getPosition().y;
            }
            i++;}
        k++;
        boundtop.update(dt);
        boundbot.update(dt);
    }
    public void handleInput(float dt) {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getY() / gravtry2.PPM >= port.getWorldHeight() / 2) {
                world.clearForces();
                player.body.applyForceToCenter(0,-48*Gdx.graphics.getHeight()/1080f, true);
                player.body.applyForceToCenter(obj1.getGravityVector(), true);
                player.body.applyForceToCenter(obj2.getGravityVector(), true);
            }
            if (Gdx.input.getY() / gravtry2.PPM < port.getWorldHeight() / 2) {
                world.clearForces();
                player.body.applyForceToCenter(0, 48*Gdx.graphics.getHeight()/1080f, true);
                player.body.applyForceToCenter(obj1.getGravityVector(), true);
                player.body.applyForceToCenter(obj2.getGravityVector(), true);
            }
        }
    }
    public void handleInput2(float dt) {
        antigravcounter++;
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getY() / gravtry2.PPM >= port.getWorldHeight() / 2) {
                world.clearForces();
                player.body.applyForceToCenter(0, 48*Gdx.graphics.getHeight()/1080f, true);
                player.body.applyForceToCenter(obj1.getGravityVector(), true);
                player.body.applyForceToCenter(obj2.getGravityVector(), true);
            }
            if (Gdx.input.getY() / gravtry2.PPM < port.getWorldHeight() / 2) {
                world.clearForces();
                player.body.applyForceToCenter(0,-48*Gdx.graphics.getHeight()/1080f, true);
                player.body.applyForceToCenter(obj1.getGravityVector(), true);
                player.body.applyForceToCenter(obj2.getGravityVector(), true);
            }
        }
    }
    @Override
    public void show() {    }
    @Override
    public void render(float delta) {
        elapsedtime += Gdx.graphics.getDeltaTime();
        update(delta);
        if (game.prefs.getInteger("currlevel") == 0) {
                Gdx.gl.glClearColor(69f / 255f, 83f / 255f, 154f / 255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 1) {
            Gdx.gl.glClearColor(140f/255f, 213f/255f, 255f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 2) {
            Gdx.gl.glClearColor(151f/255f, 137f/255f, 204f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 3) {
            Gdx.gl.glClearColor(225f/255f, 178f/255f, 111f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 4) {
            Gdx.gl.glClearColor(112f/255f, 228f/255f, 204f/255f, 1f);

        }
        if (game.prefs.getInteger("currlevel") == 5) {
            Gdx.gl.glClearColor(233f/255f, 233f/255f, 233f/255f, 1f);
        }
        if (game.prefs.getInteger("currlevel") == 6) {
        Gdx.gl.glClearColor(0,0,0,1f);
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        if(player.body.getLinearVelocity().x>0) {
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x1 * 100 - player.getSprite().getWidth() / 2 - 25,
                    Gdx.graphics.getHeight() / 2 + 100 * y1 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x2 * 100 - player.getSprite().getWidth() / 2 - 25,
                    Gdx.graphics.getHeight() / 2 + 100 * y2 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x3 * 100 - player.getSprite().getWidth() / 2 - 25,
                    Gdx.graphics.getHeight() / 2 + 100 * y3 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x4 * 100 - player.getSprite().getWidth() / 2 - 25,
                    Gdx.graphics.getHeight() / 2 + 100 * y4 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x5 * 100 - player.getSprite().getWidth() / 2 - 25,
                    Gdx.graphics.getHeight() / 2 + 100 * y5 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
        }
        else{
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x1 * 100 - player.getSprite().getWidth() / 2 + 10 ,
                    Gdx.graphics.getHeight() / 2 + 100 * y1 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x2 * 100 - player.getSprite().getWidth() / 2 + 10,
                    Gdx.graphics.getHeight() / 2 + 100 * y2 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x3 * 100 - player.getSprite().getWidth() / 2 + 10,
                    Gdx.graphics.getHeight() / 2 + 100 * y3 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x4 * 100 - player.getSprite().getWidth() / 2 + 10,
                    Gdx.graphics.getHeight() / 2 + 100 * y4 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
            game.batch.draw(follow,
                    Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + x5 * 100 - player.getSprite().getWidth() / 2 + 10,
                    Gdx.graphics.getHeight() / 2 + 100 * y5 - 100 * cam.position.y - 30 / 2, 30*Gdx.graphics.getHeight()/1080f,  30*Gdx.graphics.getHeight()/1080f);
        }
            obj2.getEnemy2s().draw(game.batch);
            game.batch.draw((TextureRegion) obj2.getAnimation().getKeyFrame(elapsedtime, true), Gdx.graphics.getWidth() / 2 - 100 * cam.position.x + obj2.body.getPosition().x * 100 - obj2.getEnemy2s().getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100 * obj2.body.getPosition().y - 100 * cam.position.y - obj2.getEnemy2s().getHeight() / 2, 90 * ((float) Gdx.graphics.getWidth() / 1920f), 90 * ((float) Gdx.graphics.getWidth() / 1920f));
        obj1.getEnemy1s().draw(game.batch);
        player.getSprite().draw(game.batch);
        walls.getwalls().draw(game.batch);
        life.getLifes().draw(game.batch);
        speedup.getSpeedups().draw(game.batch);
        slowdown.getSlowdowns().draw(game.batch);
        antigrav.getAntigravs().draw(game.batch);
        if(speedupswipeboolean == true){
        speedupswipes.draw(game.batch);}
        if(slowdownswipeboolean == true){
            slowdownswipes.draw(game.batch);}
        boundtop.getTopbgs().draw(game.batch);
        boundbot.getBotbgs().draw(game.batch);
        if(antigravactive==true){
            antigravswipes.draw(game.batch);
        }
        if(antigravactive==false){
            antigravswipe1s.draw(game.batch);
        }
        game.batch.end();
        rayHandler.render();
        if(game.prefs.getInteger("shadows") == 1) {
            cone2LightrayHandler.render();
        }
        game.batch.setProjectionMatrix(Hud.stage.getCamera().combined);
        Hud.stage.draw();
        hud.scorelabel.setText(String.format("%06d", hudtimer));
        hud.lifelabel.setText(String.format("%02d", lives));

    }
    @Override
    public void resize(int width, int height) {
        port.update(width, height);
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
        rayHandler.dispose();
        follow.dispose();
        speedupswipe.dispose();
        hud.dispose();
        slowdownswipe.dispose();
        antigravsound.dispose();enemysound.dispose();lifesound.dispose();slowdownsound.dispose();speedupsound.dispose();
        atlas.dispose();
    }
}
