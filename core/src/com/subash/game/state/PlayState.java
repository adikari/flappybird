package com.subash.game.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subash.game.FlappyBird;

public class PlayState extends State {

  private Texture bird;

  public PlayState(StateManager stateManager) {
    super(stateManager);
    bird = new Texture("bird.png");

    camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
  }

  @Override
  protected void handleInput() {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(float deltaTime) {
    // TODO Auto-generated method stub

  }

  @Override
  public void render(SpriteBatch batch) {
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    batch.draw(bird, 50, 50);
    batch.end();
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }
}
