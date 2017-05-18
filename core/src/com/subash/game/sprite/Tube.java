package com.subash.game.sprite;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Tube implements Disposable {

  public static final int TUBE_WIDTH = 52;

  private static final int FLUCTUATION = 130;
  private static final int TUBE_GAP = 100;
  private static final int LOWEST_OPENING = 120;

  private Texture topTube, bottomTube;
  private Vector2 topTubePos, bottomTubePos;

  private Random rand;

  public Tube(int x) {
    topTube = new Texture("toptube.png");
    bottomTube = new Texture("bottomTube.png");
    rand = new Random();

    topTubePos = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
    bottomTubePos = new Vector2(x, topTubePos.y - TUBE_GAP - bottomTube.getHeight());
  }

  /**
   * @return the topTube
   */
  public Texture getTopTube() {
    return topTube;
  }

  /**
   * @return the bottomTube
   */
  public Texture getBottomTube() {
    return bottomTube;
  }

  /**
   * @return the topTubePos
   */
  public Vector2 getTopTubePos() {
    return topTubePos;
  }

  /**
   * @return the bottomTubePos
   */
  public Vector2 getBottomTubePos() {
    return bottomTubePos;
  }

  /**
   * Reposition the tubes.
   * As the bird moves forward, add new tubes to the viewport
   *
   * @param x Horizontal coordinate
   */
  public void reposition(float x) {
    topTubePos.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
    bottomTubePos.set(x, topTubePos.y - TUBE_GAP - bottomTube.getHeight());
  }

  @Override
  public void dispose() {
    topTube.dispose();
    bottomTube.dispose();
  }
}
