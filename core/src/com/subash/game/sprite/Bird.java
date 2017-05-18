package com.subash.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class Bird implements Disposable {
  private static final int GRAVITY = -15;

  private Vector3 position, velocity;
  private Texture texture;

  public Bird(int x, int y) {
    position = new Vector3(x, y, 0);
    velocity = new Vector3(0, 0, 0);
    texture = new Texture("bird.png");
  }

  /**
   * @return the position
   */
  public Vector3 getPosition() {
    return position;
  }

  /**
   * @return the bird texture
   */
  public Texture getTexture() {
    return texture;
  }

  public void update(float deltaTime) {
    if (position.y > 0) {
      velocity.add(0, GRAVITY, 0);
    }

    velocity.scl(deltaTime);

    position.add(0, velocity.y, 0);
    velocity.scl(1 / deltaTime);

    if (position.y < 0) {
      position.y = 0;
    }
  }

  public void jump() {
    velocity.y = 250;
  }

  @Override
  public void dispose() {
    texture.dispose();
  }
}
