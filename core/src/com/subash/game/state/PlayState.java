package com.subash.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.subash.game.FlappyBird;
import com.subash.game.sprite.Bird;
import com.subash.game.sprite.Tube;

public class PlayState extends State {

  private Bird bird;
  private Tube tube;
  private Texture background;

  public PlayState(StateManager stateManager) {
    super(stateManager);

    bird = new Bird(50, 100);
    tube = new Tube(100);

    background = new Texture("bg.png");

    camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
  }

  @Override
  protected void handleInput() {
    if (Gdx.input.justTouched()) {
      bird.jump();
    }
  }

  @Override
  public void update(float deltaTime) {
    handleInput();
    bird.update(deltaTime);
  }

  @Override
  public void render(SpriteBatch batch) {
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    batch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
    batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
    batch.draw(tube.getTopTube(), tube.getTopTubePos().x, tube.getTopTubePos().y);
    batch.draw(tube.getBottomTube(), tube.getBottomTubePos().x, tube.getBottomTubePos().y);

    batch.end();
  }

  @Override
  public void dispose() {
    bird.dispose();
  }
}
