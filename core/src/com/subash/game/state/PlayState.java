package com.subash.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.subash.game.FlappyBird;
import com.subash.game.sprite.Bird;
import com.subash.game.sprite.Tube;

public class PlayState extends State {

  private final static int TUBE_SPACING = 125;
  private static final int TUBE_COUNT = 4;

  private Bird bird;
  private Array<Tube> tubes;
  private Texture background;

  public PlayState(StateManager stateManager) {
    super(stateManager);

    bird = new Bird(50, 100);

    tubes = new Array<Tube>();

    for (int i = 1; i <= TUBE_COUNT; i++) {
      tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
    }

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

    camera.position.x = bird.getPosition().x + 80;

    for (Tube tube : tubes) {
      if (tubeIsOutOfViewport(tube)) {
        tube.reposition(
          tube.getTopTubePos().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT)
        );
      }
    }

    camera.update();
  }

  @Override
  public void render(SpriteBatch batch) {
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    batch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
    batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);

    for (Tube tube : tubes) {
      batch.draw(tube.getTopTube(), tube.getTopTubePos().x, tube.getTopTubePos().y);
      batch.draw(tube.getBottomTube(), tube.getBottomTubePos().x, tube.getBottomTubePos().y);
    }

    batch.end();
  }

  @Override
  public void dispose() {
    bird.dispose();
  }

  /**
   * Check if tube is out of viewport
   */
  private boolean tubeIsOutOfViewport(Tube tube) {
    return camera.position.x - (camera.viewportWidth / 2 ) >
      tube.getTopTubePos().x + tube.getTopTube().getWidth();
  }
}
