package com.subash.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subash.game.state.MenuState;
import com.subash.game.state.StateManager;

public class FlappyBird extends ApplicationAdapter {
  public static final int WIDTH = 480;
  public static final int HEIGHT = 800;

  public static final String TITLE = "Flappy Bird";

  private StateManager stateManager;
  private SpriteBatch batch;

  @Override
  public void create () {
    batch = new SpriteBatch();
    stateManager = new StateManager();
    Gdx.gl.glClearColor(1, 0, 0, 1);
    stateManager.push(new MenuState(stateManager));
  }

  @Override
  public void render () {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stateManager.update(Gdx.graphics.getDeltaTime());
    stateManager.render(batch);
  }

  @Override
  public void dispose () {
    batch.dispose();
  }
}
