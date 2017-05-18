package com.subash.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public abstract class State implements Disposable {

  protected OrthographicCamera camera;
  protected Vector3 mouse;
  protected StateManager stateManager;

  public State(StateManager stateManager) {
    camera = new OrthographicCamera();
    mouse = new Vector3();
    this.stateManager = stateManager;
  }

  /**
   * Handle input in the state
   */
  protected abstract void handleInput();

  /**
   * Update the variables in the game
   *
   * @param deltaTime Difference between two frames
   */
  public abstract void update(float deltaTime);

  /**
   * Render the sprite batch in the current viewport
   *
   * @param batch Sprite to render
   */
  public abstract void render(SpriteBatch batch);
}
