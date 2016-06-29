package org.academiadecodigo.bootcamp.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.flappy.Flappy;

/**
 * Created by codecadet on 28/06/16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(background, 0, 0, Flappy.WIDTH, Flappy.HEIGHT);
        sb.draw(playBtn, Flappy.WIDTH / 2 - playBtn.getWidth() /2, Flappy.HEIGHT / 2);
        sb.end();
    }

    public void dispose(){
        background.dispose();
        playBtn.dispose();
    }
}
