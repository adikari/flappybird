package com.subash.game.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subash.game.FlappyBird;

public class MenuState extends State {

  private Texture background, playButton;

  public MenuState(StateManager stateManager) {
    super(stateManager);

    background = new Texture("bg.png");
    playButton = new Texture("playbtn.png");
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
    batch.begin();

    batch.draw(background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);

    batch.draw(
      playButton,
      (FlappyBird.WIDTH / 2) - playButton.getWidth() / 2,
      FlappyBird.HEIGHT / 2
    );

    batch.end();
  }

  @Override
  public void dispose() {
    background.dispose();
    playButton.dispose();
  }
}
